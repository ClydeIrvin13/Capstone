/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;


import Connection.DatabaseConnection;
import Model.ModelEnroll;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luniz
 */
public class ServiceEnroll {
    public List<ModelEnroll> getAll2() throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select * from enrollment_table join student_table on enrollment_table.ID_num = student_table.ID_num join "
                    + "subject_table on enrollment_table.course_code = subject_table.course_code order by schoolyear");
            r = p.executeQuery();
            List<ModelEnroll> list = new ArrayList<>();
            while (r.next()) {
                int enrollment_no = r.getInt("enrollment_no");
                String course_code = r.getString("course_code");
                String desc_title = r.getString("desc_title");
                String units = r.getString("units");
                String semester= r.getString("semester");
                String schoolyear = r.getString("schoolyear");
                list.add(new ModelEnroll(enrollment_no, course_code,desc_title, units, semester, schoolyear));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }
    
    public List<ModelEnroll> search2(String search) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select Lname, Fname, Mname, Course, enrollment_table.ID_num, enrollment_no, enrollment_table.course_code, subject_table.desc_title, subject_table.units, semester, schoolyear from enrollment_table join student_table on enrollment_table.ID_num = student_table.ID_num join "
                    + "subject_table on enrollment_table.course_code = subject_table.course_code where student_table.ID_num like ? ORDER BY schoolyear DESC, semester DESC, enrollment_table.course_code ASC");
            p.setString(1, "%" + search + "%");
            r = p.executeQuery();
            List<ModelEnroll> list = new ArrayList<>();
            while (r.next()) {
                int enrollment_no = r.getInt("enrollment_no");
                String ID_num = r.getString("ID_num");
                String course_code = r.getString("course_code");
                String desc_title = r.getString("desc_title");
                String units = r.getString("units");
                String semester= r.getString("semester");
                String schoolyear = r.getString("schoolyear");
      
                list.add(new ModelEnroll(enrollment_no, course_code,desc_title, units, semester, schoolyear));
                
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }
    
    
    public void create2(ModelEnroll data) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("INSERT INTO enrollment_table (ID_num, course_code, semester, schoolyear) VALUES (?, ?, ?, ?)");
            p.setString(1, data.getID_num());
            p.setString(2, data.getCourse_code());
            p.setString(3, data.getSemester());
            p.setString(4, data.getSchoolyear());
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
    }
    
     
    
     public void edit2(ModelEnroll data) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("update enrollment_table set semester=?, schoolyear=? where enrollment_no=?");
           
            p.setString(1, data.getSemester());
            p.setString(2, data.getSchoolyear());
            p.setInt(3, data.getEnrollment_no());
            

            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
        
        
    }
     
     public void delete2(int enrollment_no) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("delete from enrollment_table where enrollment_no=?");
           
            p.setInt(1, enrollment_no);
            
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
        
        
    }
}

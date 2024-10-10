/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;


import Connection.DatabaseConnection;
import Model.ModelStudent;
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
public class ServiceStudent {
    
    public List<ModelStudent> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select * from student_table order by Lname");
            r = p.executeQuery();
            List<ModelStudent> list = new ArrayList<>();
            while (r.next()) {
                String ID_num = r.getString("ID_num");
                String Lname = r.getString("Lname");
                String Fname = r.getString("Fname");
                String Mname = r.getString("Mname");
                String course = r.getString("course");
                String Major = r.getString("major");
                
                list.add(new ModelStudent(ID_num, Lname, Fname, Mname, course, Major));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }
    
    public List<ModelStudent> search(String search) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select * from student_table where (ID_num like ? or Lname like ? or Fname like ? or Mname like ? or course like ? or major like ?) order by Lname");
            p.setString(1, "%" + search + "%");
            p.setString(2, "%" + search + "%");
            p.setString(3, "%" + search + "%");
            p.setString(4, "%" + search + "%");
            p.setString(5, "%" + search + "%");
            p.setString(6, "%" + search + "%");
            
            
            r = p.executeQuery();
            List<ModelStudent> list = new ArrayList<>();
            while (r.next()) {
                String ID_num = r.getString("ID_num");
                String Lname = r.getString("Lname");
                String Fname = r.getString("Fname");
                String Mname = r.getString("Mname");
                String course = r.getString("course");
                String Major = r.getString("major");
                
                list.add(new ModelStudent(ID_num, Lname, Fname, Mname, course, Major));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }
    
    
    public void create(ModelStudent data) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("insert into student_table (ID_num, Lname, Fname, Mname, course, major) values (?,?,?,?,?,?)");
            p.setString(1, data.getID_num());
            p.setString(2, data.getLname());
            p.setString(3, data.getFname());
            p.setString(4, data.getMname());
            p.setString(5, data.setCourse());
            p.setString(6, data.getMajor());
            p.execute();
            
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
    }
    
     
    
     public void edit(ModelStudent data) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("update student_table set Lname=?, Fname=?, Mname=?, course=?, major=? where ID_num=?");
           
            p.setString(1, data.getLname());
            p.setString(2, data.getFname());
            p.setString(3, data.getMname());
            p.setString(4, data.setCourse());
            p.setString(5, data.getMajor());
            p.setString(6, data.getID_num());
            
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
        
        
    }
     
     public void delete(String ID_num) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("delete from student_table where ID_num=?");
           
            p.setString(1, ID_num);
            
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
        
        
    }
    
    
}

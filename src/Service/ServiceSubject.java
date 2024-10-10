/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connection.DatabaseConnection;
import Model.ModelSubject;
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
public class ServiceSubject {

    public List<ModelSubject> getAll1() throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("SELECT * FROM subject_table ORDER BY course_code ASC");
            r = p.executeQuery();
            List<ModelSubject> list = new ArrayList<>();
            while (r.next()) {
                String Course_code = r.getString("course_code");
                String Desc_title = r.getString("desc_title");
                String Units = r.getString("units");
                list.add(new ModelSubject(Course_code, Desc_title, Units));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }

    public List<ModelSubject> search1(String search) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select * from subject_table where (course_code like ? or desc_title like ?) order by course_code");
            p.setString(1, "%" + search + "%");
            p.setString(2, "%" + search + "%");

            r = p.executeQuery();
            List<ModelSubject> list = new ArrayList<>();
            while (r.next()) {
                String Course_code = r.getString("course_code");
                String Desc_title = r.getString("desc_title");
                String Units = r.getString("units");
                list.add(new ModelSubject(Course_code, Desc_title, Units));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }

    public void create1(ModelSubject data) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("insert into subject_table (course_code, desc_title, units) values (?,?,?)");
            p.setString(1, data.getCourse_code());
            p.setString(2, data.getDesc_title());
            p.setString(3, data.getUnits());
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
    }

    public void edit1(ModelSubject data) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("update subject_table set  desc_title=?, units=? where course_code=?");

            p.setString(1, data.getDesc_title());
            p.setString(2, data.getUnits());
            p.setString(3, data.getCourse_code());

            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }

    }

    public void delete1(String course_code) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("delete from subject_table where course_code=?");

            p.setString(1, course_code);

            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }

    }

}

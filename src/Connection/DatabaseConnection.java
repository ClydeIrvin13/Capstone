/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author luniz
 */
public class DatabaseConnection {
       private static DatabaseConnection instance;
    private String databaseFilePath = "C:\\Users\\luniz\\OneDrive\\Documents\\capstone_db_beta.db";  // Path to your SQLite database file

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {
        // Load the SQLite JDBC driver
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection createConnection() throws SQLException {
        // SQLite connection string
        String url = "jdbc:sqlite:" + databaseFilePath;

        // Create and return the connection
        return DriverManager.getConnection(url);
    }

    public void close(AutoCloseable... close) throws SQLException {
        try {
            for (AutoCloseable c : close) {
                if (c != null) {
                    c.close();
                }
            }
        } catch (Exception e) {
            throw new SQLException("Error on closing", e);
        }
    }
}

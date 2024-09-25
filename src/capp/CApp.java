
package capp;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CApp {

    //Connection Method to SQLITE
    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:cTest.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
    
    
    public static void main(String[] args) throws SQLException {
        
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        
        System.out.print("Enter First Name: ");
        String fname = sc.next();
        
        System.out.print("Enter Last Name: ");
        String lname = sc.next();
        
        System.out.print("Enter Email: ");
        String email = sc.next();
        
        System.out.print("Enter Status: ");
        String stat = sc.next();
        
        
        String sql = "INSERT INTO Students (s_ID, s_FirstName, s_LastName, s_Email, s_Status) VALUES (?, ?, ?, ?, ?)";

        
        try{
            Connection con = connectDB();
            PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                pst.setString(2, fname);
                pst.setString(3, lname);
                pst.setString(4, email);
                pst.setString(5, stat);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                
        
        }catch(SQLException ex){
            System.out.println("Connection Error: "+ ex.getMessage());
        };
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JClasses;

import MyProject.Categories;
import MyProject.Pending_Borrow_List;
import static MyProject.SignIN.url;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public class Borrow {
    
    int found;
    int student_id;
    int bk_id;
    String borrow_date;
    String return_date;
    String brw_type;
    int pending_borrowed = 0;
    int total_borrowed = 0;
    
    public void search_info_of_received(int brw_id) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Borrow where brw_id = '"+ brw_id +"' and brw_type = 'Received'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            found = 0;
            while (res.next()) {
                found = 1;
                student_id = res.getInt("student_id");
                bk_id = res.getInt("bk_id");
                borrow_date = res.getDate("borrow_date").toString();
                return_date = res.getDate("return_date").toString();
                brw_type = res.getString("brw_type");
        
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pending_Borrow_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void search_info_of_pending(int brw_id) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Borrow where brw_id = '"+ brw_id +"' and brw_type = 'Pending'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            found = 0;
            while (res.next()) {
                found = 1;
                student_id = res.getInt("student_id");
                bk_id = res.getInt("bk_id");
                borrow_date = res.getDate("borrow_date").toString();
                brw_type = res.getString("brw_type");
        
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pending_Borrow_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void pending_borrow_of_a_student(int Student_id) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT student_id, COUNT(*) AS Total_pending_borrowed_books FROM Borrow WHERE student_id = '"+ Student_id +"' and brw_type = 'Pending' GROUP BY student_id";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            pending_borrowed = 0;
            while (res.next()) {
                pending_borrowed = res.getInt("Total_pending_borrowed_books");
            } 
        } catch (SQLException e) {}
    }
    
    
    public void total_borrow_of_a_student(int Student_id) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT student_id, COUNT(*) AS Total_borrowed_books FROM Borrow WHERE student_id = '"+ Student_id +"' GROUP BY student_id";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            total_borrowed = 0;
            while (res.next()) {
                total_borrowed = res.getInt("Total_borrowed_books");
            } 
        } catch (SQLException e) {}
    }
    
    
    public void insert_into_borrow(int student_id, int bk_id, String borrow_date){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "INSERT INTO Borrow (student_id, bk_id, borrow_date, return_date, brw_type) VALUES ('"+ student_id +"', '"+ bk_id +"', '"+ borrow_date +"', NULL , 'Pending')";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

        } catch (SQLException e) {System.out.println(e);} catch (ClassNotFoundException ex) {     
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
  
        }
    }
    
    
    public void update_into_borrow(int brw_id, String return_date){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "UPDATE Borrow SET return_date = '"+ return_date +"', brw_type = 'Received' WHERE brw_id = '"+ brw_id +"'";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

        } catch (SQLException e) {System.out.println(e);} catch (ClassNotFoundException ex) {     
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
  
        }
    }

    public int getFound() {
        return found;
    }    
    
    public int getPending_borrowed() {
        return pending_borrowed;
    }

    public int getTotal_borrowed() {
        return total_borrowed;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getBk_id() {
        return bk_id;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public String getBrw_type() {
        return brw_type;
    }
    
}

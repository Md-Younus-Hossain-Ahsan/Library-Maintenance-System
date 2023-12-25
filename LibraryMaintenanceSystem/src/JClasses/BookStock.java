/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JClasses;

import MyProject.Categories;
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

public class BookStock {
    
    
    int quantity = 0;
    int borrowed = 0;
    
    public void quantity_from_bk_id(int bk_id) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Book_stock where bk_id = '"+ bk_id +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                quantity = res.getInt("total");
                borrowed = res.getInt("borrowed");                
            } 
        } catch (SQLException e) {}
    }
    
    
    public void insert_into_book_stock(int bk_id, int quantity){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "INSERT INTO Book_stock (bk_id, total, borrowed) VALUES ('"+ bk_id +"', '"+ quantity +"', 0)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

        } catch (SQLException e) {System.out.println(e);} catch (ClassNotFoundException ex) {     
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void increase_the_amount_of_borrowed_book(int bk_id){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            quantity_from_bk_id(bk_id);
            String sql = "UPDATE Book_stock SET borrowed = '" + ++borrowed + "' WHERE bk_id = '" + bk_id + "'";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

        } catch (SQLException e) {System.out.println(e);} catch (ClassNotFoundException ex) {     
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrease_the_amount_of_borrowed_book(int bk_id){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            quantity_from_bk_id(bk_id);
            String sql = "UPDATE Book_stock SET borrowed = '" + --borrowed + "' WHERE bk_id = '" + bk_id + "'";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

        } catch (SQLException e) {System.out.println(e);} catch (ClassNotFoundException ex) {     
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public int getAvailable() {
        return quantity - borrowed;
    }

}

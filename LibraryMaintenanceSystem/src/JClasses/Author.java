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

public class Author {
    
    int found = 0;
    int auth_id = 0;
    String auth_name;
    
    public void author_search(String name) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Author where name = '"+ name +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            found = 0;
            while (res.next()) {
                found = 1;
            } 
        } catch (SQLException e) {}
    }
    
    
    public void id_from_name(String name) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Author where name = '"+ name +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                auth_id = res.getInt("auth_id");
            } 
        } catch (SQLException e) {}
    }
    
    
    public void name_from_id(int id) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Author where auth_id = '"+ id +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                auth_name = res.getString("name");
            } 
        } catch (SQLException e) {}
    }
    
    
    public void insert(String name){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "INSERT INTO Author (name) VALUES ('"+ name +"')";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

        } catch (SQLException e) {System.out.println(e);} catch (ClassNotFoundException ex) {     
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public int getFound() {
        return found;
    }

    public int getAuth_id() {
        return auth_id;
    }

    public String getAuth_name() {
        return auth_name;
    }

}

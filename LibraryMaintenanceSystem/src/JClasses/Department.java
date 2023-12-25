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
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public class Department {
    
    int found = 0;
    int dept_id = 0;
    String dept_name = null;
    
    public void name_search(String name) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Department where name = '"+ name +"'";
            
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
            
            String sql = "SELECT * FROM Department where name = '"+ name +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                dept_id = res.getInt("dept_id");
            } 
        } catch (SQLException e) {}
    }
    
    
    public void name_from_id(int id) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Department where dept_id = '"+ id +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                dept_name = res.getString("name");
            } 
        } catch (SQLException e) {}
    }
    
    
    public void insert(String name){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

            String sql = "INSERT INTO Department (name) VALUES ('"+ name +"')";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Added !"); 

        } catch (SQLException e) {System.out.println(e);} catch (ClassNotFoundException ex) {     
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public int getFound() {
        return found;
    }

    public int getDept_id() {
        return dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }
    
}

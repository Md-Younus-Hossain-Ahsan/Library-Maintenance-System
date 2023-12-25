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

public class Category {
    
    int found = 0;
    int dept_id = 0;
    int ctg_id = 0;
    String category;
    String dept_name;
    
    
    public void name_search(String name) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Category where name = '"+ name +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            found = 0;
            while (res.next()) {
                found = 1;
            } 
        } catch (SQLException e) {}
    }
    
    
    public void name_from_id(int id) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Category where ctg_id = '"+ id +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                category = res.getString("name");
            } 
        } catch (SQLException e) {}
    }
    
    
    public void ctg_id_from_dept_name(String dept_name, String category) throws ClassNotFoundException{
        
        Department department = new Department();
        department.id_from_name(dept_name);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Category where dept_id = '"+ department.getDept_id() +"' and name = '"+ category +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                ctg_id = res.getInt("ctg_id");
            } 
        } catch (SQLException e) {}
    }
    
    
    public void dept_name_from_ctg_id(int ctg_id) throws ClassNotFoundException{
        
        Department department = new Department();
                
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Category where ctg_id = '"+ ctg_id +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                department.name_from_id(res.getInt("dept_id"));
                dept_name = department.getDept_name();
            } 
        } catch (SQLException e) {}
    }
    
    
    public void insert(String name, String dept_name){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            Department department = new Department();
            department.id_from_name(dept_name);
            dept_id = department.getDept_id();
            
            String sql = "INSERT INTO Category (name, dept_id) VALUES ('"+ name +"', '"+ dept_id +"')";

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

    public int getCtg_id() {
        return ctg_id;
    }

    public String getCategory() {
        return category;
    }

    public String getDept_name() {
        return dept_name;
    }
    
}

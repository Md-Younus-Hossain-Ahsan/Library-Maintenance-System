/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JClasses;

import static MyProject.SignIN.url;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public class Student {
    
    int found = 0;
    String student_name;
    String gender;
    String mobile_number;
    String email;
    byte[] profile_pic;
    
    public void id_search(int student_id) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Student where student_id = '"+ student_id +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            found = 0;
            while (res.next()) {
                found = 1;
            } 
        } catch (SQLException e) {}
    }
    

    public void Student_Info(int student_id) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Student where student_id = '"+ student_id +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while (res.next()) {
                student_name = res.getString("name");
                gender = res.getString("gender");
                mobile_number = res.getString("mobile_number");
                email = res.getString("email"); 
                profile_pic = res.getBytes("profile_pic");
                
            } 
        } catch (SQLException e) {}
    }
    

    public int getFound() {
        return found;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getProfile_pic() {
        return profile_pic;
    }
    
}

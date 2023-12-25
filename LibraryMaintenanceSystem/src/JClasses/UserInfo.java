/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JClasses;

import static MyProject.SignIN.url;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public class UserInfo {
    
    String username;
    String name;
    String password;
    String email;
    String gender;
    String mobile_number;
    
    
    public void search() throws ClassNotFoundException {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM User_Info WHERE user_id = 100001";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                
                username = res.getString("username");
                name = res.getString("name");
                password = res.getString("password");
                email = res.getString("email");
                gender = res.getString("gender");
                mobile_number = res.getString("mobile_number");
                
            } 
        } catch (SQLException e) {
        }
        
    }
    
    
    public void User_Info_Updation(int user_id, String Name, String Username, String Password, String Email, String Gender, String MobileNumber) throws ClassNotFoundException, FileNotFoundException {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

            String sql = "update User_Info SET username = '"+ Username +"', name = '"+ Name +"', password = '"+ Password +"', email = '"+ Email +"', gender = '"+ Gender +"', mobile_number = '"+ MobileNumber +"' WHERE user_id = '"+ user_id +"'";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

        } catch (SQLException e) {System.out.println(e);}   
    }
    

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile_number() {
        return mobile_number;
    }    
    
}

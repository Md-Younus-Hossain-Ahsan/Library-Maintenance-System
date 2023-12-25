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
import java.util.Date;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public class Book {
    
    int found = 0;
    int last_id = 10000;
    String book_name;
    String author_name;
    String department_name;
    String category_name;
    String edition;
    Date released_date;
    byte[] CoverPic;
    
    public void id_search(int bk_id)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Book where bk_id = '"+ bk_id +"'";
                            
            PreparedStatement pst = con.prepareStatement(sql);    
            
            ResultSet res = pst.executeQuery();
            found = 0;
            while (res.next()) {
                found = 1;
            } 
            
        } catch (SQLException | ClassNotFoundException e) {
        }
    }
    
    
    public void All_the_information_of_a_book(int bk_id)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Book where bk_id = '"+ bk_id +"'";
                            
            PreparedStatement pst = con.prepareStatement(sql);    
            
            ResultSet res = pst.executeQuery();
                            
            while (res.next()) {
                
                Author author = new Author();
                BookStock bookStock = new BookStock();
                Category category = new Category();
                
                author.name_from_id(res.getInt("auth_id"));
                bookStock.quantity_from_bk_id(res.getInt("bk_id"));
                category.name_from_id(res.getInt("ctg_id"));
                category.dept_name_from_ctg_id(res.getInt("ctg_id"));
                                
                book_name = res.getString("name");
                author_name = author.getAuth_name();
                department_name = category.getDept_name();
                category_name = category.getCategory();
                edition = res.getString("edition");
                released_date = res.getDate("released_date");
                CoverPic = res.getBytes("cover_pic");
                
            }
            
        } catch (SQLException | ClassNotFoundException e) {
        }
    }
    
    
    public void last_id_search() throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Book";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            last_id = 10000;
            while (res.next()) {
                last_id = res.getInt("bk_id");
            } 
        } catch (SQLException e) {}
    }
    
    
    public void book_search(String name, int ctg_id, int auth_id) throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Book where name = '"+ name +"' and ctg_id = '"+ ctg_id +"' and auth_id = '"+ auth_id +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            found = 0;
            while (res.next()) {
                found = 1;
            } 
        } catch (SQLException e) {}
    }


    public int getFound() {
        return found;
    }

    public int getLast_id() {
        return ++last_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getEdition() {
        return edition;
    }

    public Date getReleased_date() {
        return released_date;
    }

    public byte[] getCoverPic() {
        return CoverPic;
    }

}

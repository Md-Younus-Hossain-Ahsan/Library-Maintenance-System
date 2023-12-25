/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JClasses;

import com.email.durgesh.Email;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public class BorrowingConfirmation {
    
    int Student_id;
    String Student_Name = "";
    String Student_Email = "";
    public static String Verification_Code = "";
    private String EmailID;
    private String EmailPassword;
 
    
    public void Set()
    {
        this.EmailID = MyProject.SignIN.EmailID;
        this.EmailPassword = MyProject.SignIN.EmailPassword;
    }
    
    public void Find_Recipient(int Student_id) throws ClassNotFoundException{
        
        Student student = new Student();        
        student.Student_Info(Student_id);
        
        this.Student_id = Student_id;
        Student_Name = student.getStudent_name();
        Student_Email = student.getEmail();
        
    }
    
    public void Code_Send(int bk_id, String return_date) throws UnsupportedEncodingException
    {   
        Book book = new Book();
        book.All_the_information_of_a_book(bk_id);
        
        try{
            Email email = new Email(EmailID, EmailPassword);

            email.setFrom(EmailID, "Library Maintenance System");

            email.setSubject("Book borrowing information.");

            String studentEmailContent = "<h3>Dear " + Student_Name + " (ID: " + Student_id + "),</h3>"
                    + "<h4>You have borrowed a book:</h4>"
                    + "<ul>"
                    + "<li>Name: " + book.getBook_name() + "</li>"
                    + "<li>Author: " + book.getAuthor_name() + "</li>"
                    + "<li>Department: " + book.getDepartment_name() + "</li>"
                    + "<li>Category: " + book.getCategory_name() + "</li>"
                    + "<li>Edition: " + book.getEdition() + "</li>"
                    + "<li>Released Date: " + book.getReleased_date() + "</li>"
                    + "</ul>"
                    + "<h4>You have to return this book to your library within the next 7 days from today by " + return_date + ".<br></h4>"
                    + "<h4>Thank You.</h4>";

            email.setContent(studentEmailContent, "text/html");
            
            //email.setContent("<h2>Dear " + Student_Name + " (ID: " + Student_id + "),</h2>" + "\nYou have borrowed a book:" + "\nName: " + book.getBook_name() + "\nAuthor: " + book.getAuthor_name() + "\nDepartment: " + book.getDepartment_name() + "\nCategory: " + book.getCategory_name() + "\nEdition: " + book.getEdition() + "\nReleased Date: " + book.getReleased_date() + "\n\nYou have to return this book to your library within the next 7 days from today by " + return_date + ".\nThank You.", "text/html");

            email.addRecipient(Student_Email);

            email.send();
           

        }catch(MessagingException e)
        {
            JOptionPane.showMessageDialog(null, "Enter a valid Email address !");
        }
    }
        
}

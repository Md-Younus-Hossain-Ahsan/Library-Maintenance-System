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

public class WelcomeMessage {
    
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
    
    public void Code_Send() throws UnsupportedEncodingException
    {   
        
        try{
            Email email = new Email(EmailID, EmailPassword);

            email.setFrom(EmailID, "Library Maintenance System");

            email.setSubject("Welcome to our library.");

            String studentEmailContent = "<h3>Dear " + Student_Name + " (ID: " + Student_id + "),</h3>"
                    + "A warm welcome to our library community! We're thrilled to have you on board, and we hope your time here is filled with enriching literary adventures.<br><br>"
                    + "Just a quick reminder about our borrowing policy: feel free to borrow up to three books at a time. We encourage you to explore our diverse collection to your heart's content. Remember to return your borrowed books within the next 7 days to ensure that others can also enjoy the wonders of our library.<br><br>"
                    + "If you have any questions, need recommendations, or just want to say hello, our staff is here to help. We want your experience with us to be as enjoyable as possible.<br><br>"
                    + "Once again, welcome to the library family! Happy reading!";

            email.setContent(studentEmailContent, "text/html");
            
            email.addRecipient(Student_Email);

            email.send();
           
        }catch(MessagingException e)
        {
            JOptionPane.showMessageDialog(null, "Enter a valid Email address !");
        }
    }
        
}

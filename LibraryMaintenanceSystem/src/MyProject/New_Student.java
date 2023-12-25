package MyProject;

import JClasses.*;
import static MyProject.SignIN.url;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.util.logging.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public final class New_Student extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    String Path = null;
    String From = null;
    
    public New_Student(String From) throws ClassNotFoundException {
        
        initComponents();
        this.From = From; 
    }

    private New_Student() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void Reset() throws ClassNotFoundException
    {        
        student_id.setText(null);
        name.setText(null);
        gender.setSelectedIndex(0);
        mobile_number.setText(null);
        email.setText(null);
        img_path.setText(null);
        profile_pic.setIcon(null);
    }
    
    
    public void Welcome_Message_Send() throws ClassNotFoundException, UnsupportedEncodingException
    {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.Set();
        welcomeMessage.Find_Recipient(Integer.parseInt(student_id.getText()));
        welcomeMessage.Code_Send();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator10 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        img_path = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        profile_pic = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        student_id = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        mobile_number = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        Upload = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator10.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 370, 10));

        jSeparator12.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 370, 10));

        jSeparator13.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 210, 10));

        jSeparator14.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 130, 10));

        jSeparator15.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 240, 10));

        img_path.setEditable(false);
        img_path.setBackground(new java.awt.Color(253, 229, 210));
        img_path.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        img_path.setBorder(null);
        img_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                img_pathKeyTyped(evt);
            }
        });
        getContentPane().add(img_path, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 530, 20));

        jSeparator16.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator16.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 530, 10));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Path");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        profile_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/student icon.png"))); // NOI18N
        profile_pic.setToolTipText("Image size: 136*172 px (JPG)");
        profile_pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        profile_pic.setPreferredSize(new java.awt.Dimension(136, 172));
        getContentPane().add(profile_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 138, 172));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Gender");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 70, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Student ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        student_id.setBackground(new java.awt.Color(253, 229, 210));
        student_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        student_id.setBorder(null);
        student_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                student_idKeyTyped(evt);
            }
        });
        getContentPane().add(student_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 240, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Email");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 90, -1));

        email.setBackground(new java.awt.Color(253, 229, 210));
        email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        email.setText("@gmail.com");
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 370, 20));

        mobile_number.setBackground(new java.awt.Color(253, 229, 210));
        mobile_number.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mobile_number.setBorder(null);
        mobile_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile_numberActionPerformed(evt);
            }
        });
        getContentPane().add(mobile_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 210, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 300, -1));

        name.setBackground(new java.awt.Color(253, 229, 210));
        name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        name.setBorder(null);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 370, 20));

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/book icon.gif"))); // NOI18N
        jLabel2.setText(" Add a Student ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 90));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Mobile Number");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 140, -1));

        gender.setBackground(new java.awt.Color(253, 229, 210));
        gender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        gender.setBorder(null);
        getContentPane().add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 130, 20));

        Upload.setBackground(new java.awt.Color(253, 229, 210));
        Upload.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Upload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/upload icon.png"))); // NOI18N
        Upload.setText("Upload");
        Upload.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Upload.setContentAreaFilled(false);
        Upload.setOpaque(true);
        Upload.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UploadMouseMoved(evt);
            }
        });
        Upload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UploadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UploadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UploadMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UploadMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UploadMouseReleased(evt);
            }
        });
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });
        getContentPane().add(Upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 138, 40));

        Back.setBackground(new java.awt.Color(253, 229, 210));
        Back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Back.setText("Back");
        Back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Back.setContentAreaFilled(false);
        Back.setOpaque(true);
        Back.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BackMouseMoved(evt);
            }
        });
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BackMouseReleased(evt);
            }
        });
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 100, 35));

        Add.setBackground(new java.awt.Color(253, 229, 210));
        Add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Add.setText("Add");
        Add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Add.setContentAreaFilled(false);
        Add.setOpaque(true);
        Add.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AddMouseMoved(evt);
            }
        });
        Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AddMouseReleased(evt);
            }
        });
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 100, 35));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg.png"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void mobile_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobile_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile_numberActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void student_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_student_idKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_student_idKeyTyped

    private void img_pathKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_img_pathKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_img_pathKeyTyped

    private void UploadMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseMoved
        Upload.setCursor(SignIN.cursor);
    }//GEN-LAST:event_UploadMouseMoved

    private void UploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseClicked
        Upload.setBackground(new Color(255,255,0).brighter());
        Upload.setForeground(Color.WHITE);
    }//GEN-LAST:event_UploadMouseClicked

    private void UploadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseEntered
        Upload.setBackground(new Color(253,229,196).brighter());
        Upload.setForeground(Color.BLACK);
    }//GEN-LAST:event_UploadMouseEntered

    private void UploadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseExited
        Upload.setBackground(new Color(253,229,210));
        Upload.setForeground(Color.BLACK);
    }//GEN-LAST:event_UploadMouseExited

    private void UploadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMousePressed
        Upload.setBackground(new Color(255,255,100).brighter());
        Upload.setForeground(Color.BLACK);
    }//GEN-LAST:event_UploadMousePressed

    private void UploadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseReleased
        Upload.setBackground(new Color(253,229,210));
        Upload.setForeground(Color.BLACK);
    }//GEN-LAST:event_UploadMouseReleased

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadActionPerformed

        Path = null;
        img_path.setText(Path);
        profile_pic.setIcon(null);
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        profile_pic.setIcon(new ImageIcon(f.toString()));
        Path = f.getAbsolutePath();
        img_path.setText(Path);
        try {
            BufferedImage bi = ImageIO.read(new File(Path));
            Image img = bi.getScaledInstance(136, 172, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            profile_pic.setIcon(icon);

        } catch (IOException | NullPointerException ex) {
            Logger.getLogger(New_Student.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_UploadActionPerformed

    private void BackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseMoved
        Back.setCursor(SignIN.cursor);
    }//GEN-LAST:event_BackMouseMoved

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        Back.setBackground(new Color(255,255,0).brighter());
        Back.setForeground(Color.WHITE);
    }//GEN-LAST:event_BackMouseClicked

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        Back.setBackground(new Color(253,229,196).brighter());
        Back.setForeground(Color.BLACK);
    }//GEN-LAST:event_BackMouseEntered

    private void BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseExited
        Back.setBackground(new Color(253,229,210));
        Back.setForeground(Color.BLACK);
    }//GEN-LAST:event_BackMouseExited

    private void BackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMousePressed
        Back.setBackground(new Color(255,255,100).brighter());
        Back.setForeground(Color.BLACK);
    }//GEN-LAST:event_BackMousePressed

    private void BackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseReleased
        Back.setBackground(new Color(253,229,210));
        Back.setForeground(Color.BLACK);
    }//GEN-LAST:event_BackMouseReleased

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void AddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseMoved
        Add.setCursor(SignIN.cursor);
    }//GEN-LAST:event_AddMouseMoved

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseClicked
        Add.setBackground(new Color(255,255,0).brighter());
        Add.setForeground(Color.WHITE);
    }//GEN-LAST:event_AddMouseClicked

    private void AddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseEntered
        Add.setBackground(new Color(253,229,196).brighter());
        Add.setForeground(Color.BLACK);
    }//GEN-LAST:event_AddMouseEntered

    private void AddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseExited
        Add.setBackground(new Color(253,229,210));
        Add.setForeground(Color.BLACK);
    }//GEN-LAST:event_AddMouseExited

    private void AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMousePressed
        Add.setBackground(new Color(255,255,100).brighter());
        Add.setForeground(Color.BLACK);
    }//GEN-LAST:event_AddMousePressed

    private void AddMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseReleased
        Add.setBackground(new Color(253,229,210));
        Add.setForeground(Color.BLACK);
    }//GEN-LAST:event_AddMouseReleased

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed

        if(student_id.getText().trim().equals("") || name.getText().trim().equals("") || mobile_number.getText().trim().equals("") || email.getText().trim().equals("") || img_path.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Enter all the information !!!");
        }
        else
        {
            Student student = new Student();
            try {
                student.id_search(Integer.parseInt(student_id.getText()));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(New_Student.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(student.getFound() == 1)
            JOptionPane.showMessageDialog(null, "This id exists !!!");
            else
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                    String sql = "INSERT INTO Student (student_id, name, gender, mobile_number, email, profile_pic) VALUES ('"+ Integer.parseInt(student_id.getText()) +"', '"+ name.getText() +"', '"+ gender.getSelectedItem() +"', '"+ mobile_number.getText() +"', '"+ email.getText() +"', ?)";
                    PreparedStatement pst = con.prepareStatement(sql);

                    InputStream is = new FileInputStream(new File(Path));

                    pst.setBlob(1, is);

                    pst.executeUpdate();

                    if(From.equals("Borrowing Book"))
                    {
                        try {
                            new Borrowing_Book(Integer.parseInt(student_id.getText())).setVisible(true);
                        } catch (ClassNotFoundException ex) {}
                        dispose();
                    }

                    Welcome_Message_Send();
                    JOptionPane.showMessageDialog(null, "Added !!!");
                    Reset();

                } catch (FileNotFoundException | ClassNotFoundException | SQLException | NullPointerException e) {JOptionPane.showMessageDialog(null, "Enter all the information !!!");} catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(New_Student.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_AddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new New_Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Back;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JButton Upload;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JTextField img_path;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JTextField mobile_number;
    private javax.swing.JTextField name;
    private javax.swing.JLabel profile_pic;
    private javax.swing.JTextField student_id;
    // End of variables declaration//GEN-END:variables

    private String getString(String fromInput) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void TicketGenerate(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getText(String format) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
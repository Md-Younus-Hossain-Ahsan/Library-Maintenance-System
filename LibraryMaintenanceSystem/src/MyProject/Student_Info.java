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

public final class Student_Info extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    String Path = null;
    private ImageIcon format = null;
    
    public Student_Info() throws ClassNotFoundException {
        
        initComponents();
    }
    
    
    public void Reset() throws ClassNotFoundException
    {        
        name.setText(null);
        gender.setSelectedIndex(0);
        mobile_number.setText(null);
        email.setText(null);
        img_path.setText(null);
        profile_pic.setIcon(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Add_a_new = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        img_path = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        profile_pic = new javax.swing.JLabel();
        Upload = new javax.swing.JButton();
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
        Back = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add_a_new.setBackground(new java.awt.Color(253, 229, 210));
        Add_a_new.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Add_a_new.setText("Add a new");
        Add_a_new.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Add_a_new.setContentAreaFilled(false);
        Add_a_new.setOpaque(true);
        Add_a_new.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Add_a_newMouseMoved(evt);
            }
        });
        Add_a_new.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_a_newMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Add_a_newMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Add_a_newMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Add_a_newMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Add_a_newMouseReleased(evt);
            }
        });
        Add_a_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_a_newActionPerformed(evt);
            }
        });
        getContentPane().add(Add_a_new, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 100, 30));

        Search.setBackground(new java.awt.Color(253, 229, 210));
        Search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Search.setText("Search");
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Search.setContentAreaFilled(false);
        Search.setOpaque(true);
        Search.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SearchMouseMoved(evt);
            }
        });
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SearchMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SearchMouseReleased(evt);
            }
        });
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 100, 30));

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
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 110, 10));

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
        profile_pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        profile_pic.setPreferredSize(new java.awt.Dimension(136, 172));
        getContentPane().add(profile_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 138, 172));

        Upload.setBackground(new java.awt.Color(232, 245, 253));
        Upload.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Upload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/upload icon.png"))); // NOI18N
        Upload.setText("Upload");
        Upload.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
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

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Gender");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 70, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Student ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        student_id.setBackground(new java.awt.Color(253, 229, 210));
        student_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        student_id.setBorder(null);
        student_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                student_idMouseClicked(evt);
            }
        });
        student_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                student_idKeyTyped(evt);
            }
        });
        getContentPane().add(student_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 110, 20));

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
        jLabel2.setText(" Student Information ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 90));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Mobile Number");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 140, -1));

        gender.setBackground(new java.awt.Color(253, 229, 210));
        gender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        gender.setBorder(null);
        getContentPane().add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 130, 20));

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

        Reset.setBackground(new java.awt.Color(253, 229, 210));
        Reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Reset.setText("Reset");
        Reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Reset.setContentAreaFilled(false);
        Reset.setOpaque(true);
        Reset.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ResetMouseMoved(evt);
            }
        });
        Reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ResetMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetMouseReleased(evt);
            }
        });
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        getContentPane().add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 100, 35));

        Update.setBackground(new java.awt.Color(253, 229, 210));
        Update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Update.setText("Update");
        Update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Update.setContentAreaFilled(false);
        Update.setOpaque(true);
        Update.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UpdateMouseMoved(evt);
            }
        });
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateMouseReleased(evt);
            }
        });
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        getContentPane().add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 100, 35));

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

    private void UploadMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseMoved
        Upload.setCursor(SignIN.cursor);
    }//GEN-LAST:event_UploadMouseMoved

    private void UploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseClicked
        Upload.setBackground(new Color(0,0,255).brighter());
        Upload.setForeground(Color.WHITE);
    }//GEN-LAST:event_UploadMouseClicked

    private void UploadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseEntered
        Upload.setBackground(new Color(0,153,255).brighter());
        Upload.setForeground(Color.BLACK);
    }//GEN-LAST:event_UploadMouseEntered

    private void UploadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseExited
        Upload.setBackground(new Color(232,245,253));
        Upload.setForeground(Color.BLACK);
    }//GEN-LAST:event_UploadMouseExited

    private void UploadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMousePressed
        Upload.setBackground(new Color(0,0,255).brighter());
        Upload.setForeground(Color.WHITE);
    }//GEN-LAST:event_UploadMousePressed

    private void UploadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseReleased
        Upload.setBackground(new Color(232,245,253));
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
            Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_UploadActionPerformed

    private void student_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_student_idKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_student_idKeyTyped

    private void img_pathKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_img_pathKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_img_pathKeyTyped

    private void student_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_idMouseClicked
        try {
            Reset();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_student_idMouseClicked

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

    private void ResetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseMoved
        Reset.setCursor(SignIN.cursor);
    }//GEN-LAST:event_ResetMouseMoved

    private void ResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseClicked
        Reset.setBackground(new Color(255,255,0).brighter());
        Reset.setForeground(Color.WHITE);
    }//GEN-LAST:event_ResetMouseClicked

    private void ResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseEntered
        Reset.setBackground(new Color(253,229,196).brighter());
        Reset.setForeground(Color.BLACK);
    }//GEN-LAST:event_ResetMouseEntered

    private void ResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseExited
        Reset.setBackground(new Color(253,229,210));
        Reset.setForeground(Color.BLACK);
    }//GEN-LAST:event_ResetMouseExited

    private void ResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMousePressed
        Reset.setBackground(new Color(255,255,100).brighter());
        Reset.setForeground(Color.BLACK);
    }//GEN-LAST:event_ResetMousePressed

    private void ResetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseReleased
        Reset.setBackground(new Color(253,229,210));
        Reset.setForeground(Color.BLACK);
    }//GEN-LAST:event_ResetMouseReleased

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        
        student_id.setText(null);        
        try {
            Reset();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_ResetActionPerformed

    private void UpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseMoved
        Update.setCursor(SignIN.cursor);
    }//GEN-LAST:event_UpdateMouseMoved

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        Update.setBackground(new Color(255,255,0).brighter());
        Update.setForeground(Color.WHITE);
    }//GEN-LAST:event_UpdateMouseClicked

    private void UpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseEntered
        Update.setBackground(new Color(253,229,196).brighter());
        Update.setForeground(Color.BLACK);
    }//GEN-LAST:event_UpdateMouseEntered

    private void UpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseExited
        Update.setBackground(new Color(253,229,210));
        Update.setForeground(Color.BLACK);
    }//GEN-LAST:event_UpdateMouseExited

    private void UpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMousePressed
        Update.setBackground(new Color(255,255,100).brighter());
        Update.setForeground(Color.BLACK);
    }//GEN-LAST:event_UpdateMousePressed

    private void UpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseReleased
        Update.setBackground(new Color(253,229,210));
        Update.setForeground(Color.BLACK);
    }//GEN-LAST:event_UpdateMouseReleased

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        
        if(student_id.getText().trim().equals("") || name.getText().trim().equals("") || mobile_number.getText().trim().equals("") || email.getText().trim().equals("") || img_path.getText().trim().equals("")){  
            JOptionPane.showMessageDialog(null, "Enter all the information !!!");
        }
        else
        {   
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = "UPDATE Student SET name = '" + name.getText() + "', gender = '" + gender.getSelectedItem() + "', mobile_number = '" + mobile_number.getText() + "', email = '" + email.getText() + "', profile_pic = ? WHERE student_id = " + Integer.parseInt(student_id.getText());
                PreparedStatement pst = con.prepareStatement(sql);

                InputStream is = new FileInputStream(new File(Path));
                
                pst.setBlob(1, is);

                pst.executeUpdate(); 
                
                JOptionPane.showMessageDialog(null, "Updated !!!");
                student_id.setText(null);        
                Reset();

            } catch (FileNotFoundException | ClassNotFoundException | SQLException | NullPointerException e) {JOptionPane.showMessageDialog(null, "Enter all the information !!!");}

        }
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void SearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseMoved
        Search.setCursor(SignIN.cursor);
    }//GEN-LAST:event_SearchMouseMoved

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        Search.setBackground(new Color(255,255,0).brighter());
        Search.setForeground(Color.WHITE);
    }//GEN-LAST:event_SearchMouseClicked

    private void SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseEntered
        Search.setBackground(new Color(253,229,196).brighter());
        Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_SearchMouseEntered

    private void SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseExited
        Search.setBackground(new Color(253,229,210));
        Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_SearchMouseExited

    private void SearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMousePressed
        Search.setBackground(new Color(255,255,100).brighter());
        Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_SearchMousePressed

    private void SearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseReleased
        Search.setBackground(new Color(253,229,210));
        Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_SearchMouseReleased

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed

        if(student_id.getText().trim().equals("")){  
            JOptionPane.showMessageDialog(null, "Enter all the information !!!");
        }
        else{
            
            try {
                Student student = new Student();
                student.Student_Info(Integer.parseInt(student_id.getText()));
                
                name.setText(student.getStudent_name());
                gender.setSelectedItem(student.getGender());
                mobile_number.setText(student.getMobile_number());
                email.setText(student.getEmail());
                
                format = new ImageIcon(student.getProfile_pic());
                profile_pic.setIcon(format);
                
                if(name.getText().trim().equals("") && mobile_number.getText().trim().equals("") && email.getText().trim().equals("")){  
                    JOptionPane.showMessageDialog(null, "Not found !!!");
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_SearchActionPerformed

    private void Add_a_newMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_a_newMouseMoved
        Add_a_new.setCursor(SignIN.cursor);
    }//GEN-LAST:event_Add_a_newMouseMoved

    private void Add_a_newMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_a_newMouseClicked
        Add_a_new.setBackground(new Color(255,255,0).brighter());
        Add_a_new.setForeground(Color.WHITE);
    }//GEN-LAST:event_Add_a_newMouseClicked

    private void Add_a_newMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_a_newMouseEntered
        Add_a_new.setBackground(new Color(253,229,196).brighter());
        Add_a_new.setForeground(Color.BLACK);
    }//GEN-LAST:event_Add_a_newMouseEntered

    private void Add_a_newMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_a_newMouseExited
        Add_a_new.setBackground(new Color(253,229,210));
        Add_a_new.setForeground(Color.BLACK);
    }//GEN-LAST:event_Add_a_newMouseExited

    private void Add_a_newMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_a_newMousePressed
        Add_a_new.setBackground(new Color(255,255,100).brighter());
        Add_a_new.setForeground(Color.BLACK);
    }//GEN-LAST:event_Add_a_newMousePressed

    private void Add_a_newMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_a_newMouseReleased
        Add_a_new.setBackground(new Color(253,229,210));
        Add_a_new.setForeground(Color.BLACK);
    }//GEN-LAST:event_Add_a_newMouseReleased

    private void Add_a_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_a_newActionPerformed

        try {
            new New_Student("Student Info").setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        
    }//GEN-LAST:event_Add_a_newActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Student_Info().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Student_Info.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_a_new;
    private javax.swing.JButton Back;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JButton Reset;
    private javax.swing.JButton Search;
    private javax.swing.JButton Update;
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
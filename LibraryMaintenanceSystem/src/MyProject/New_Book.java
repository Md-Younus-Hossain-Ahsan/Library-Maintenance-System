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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.util.logging.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public final class New_Book extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    String Path = null;
    private DefaultListModel mod1, mod2;
    
    public New_Book() throws ClassNotFoundException {
        
        initComponents();
        Book book = new Book();
        book.last_id_search();
        bk_id.setText(Integer.toString(book.getLast_id()));
        For_Viewing_Searching_Suggestions();
        
    }
    
    
    public void Categories_View() throws ClassNotFoundException
    {
        Department department = new Department();
        department.id_from_name(department_name.getText());
        category_list.removeAllItems();
        category_list.addItem("<<Select>>");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT DISTINCT name FROM Category WHERE dept_id = '"+ department.getDept_id() +"' ORDER BY name ASC";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                category_list.addItem(res.getString("name"));                
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
        }
        
    }
    
    
    public void For_Viewing_Searching_Suggestions()
    {
        Dept_PopupMenu.add(Dept_Panel);
        mod1 = new DefaultListModel();
        Dept_View.setModel(mod1);
        
        Auth_PopupMenu.add(Auth_Panel);
        mod2 = new DefaultListModel();
        Auth_View.setModel(mod2);
        
    }
    
    
    public void Reset() throws ClassNotFoundException
    {
        Book book = new Book();
        book.last_id_search();
        
        bk_id.setText(Integer.toString(book.getLast_id()));
        book_name.setText(null);
        author_name.setText(null);
        edition.setText("Not specified");
        department_name.setText(null);
        category_list.removeAllItems();
        category_list.addItem("<<Select>>");
        released_date.setDate(null);
        img_path.setText(null);
        quantity.setText(null);
        profile_pic.setIcon(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dept_Panel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Dept_View = new javax.swing.JList<>();
        Dept_PopupMenu = new javax.swing.JPopupMenu();
        Auth_Panel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Auth_View = new javax.swing.JList<>();
        Auth_PopupMenu = new javax.swing.JPopupMenu();
        jLabel20 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        category_list = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        img_path = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        profile_pic = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bk_id = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        edition = new javax.swing.JTextField();
        author_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        book_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        released_date = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        department_name = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Upload = new javax.swing.JButton();
        Info_Icon = new javax.swing.JLabel();

        Dept_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Dept_ViewMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Dept_View);

        javax.swing.GroupLayout Dept_PanelLayout = new javax.swing.GroupLayout(Dept_Panel);
        Dept_Panel.setLayout(Dept_PanelLayout);
        Dept_PanelLayout.setHorizontalGroup(
            Dept_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Dept_PanelLayout.setVerticalGroup(
            Dept_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Dept_PopupMenu.setFocusable(false);

        Auth_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Auth_ViewMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Auth_View);

        javax.swing.GroupLayout Auth_PanelLayout = new javax.swing.GroupLayout(Auth_Panel);
        Auth_Panel.setLayout(Auth_PanelLayout);
        Auth_PanelLayout.setHorizontalGroup(
            Auth_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Auth_PanelLayout.setVerticalGroup(
            Auth_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Auth_PopupMenu.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("pieces");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 40, -1));

        quantity.setBackground(new java.awt.Color(253, 229, 210));
        quantity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        quantity.setBorder(null);
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityKeyTyped(evt);
            }
        });
        getContentPane().add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 120, 20));

        jSeparator14.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 170, 10));

        category_list.setBackground(new java.awt.Color(253, 229, 210));
        category_list.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        category_list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select>>" }));
        category_list.setBorder(null);
        getContentPane().add(category_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 170, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Category");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 140, -1));

        jSeparator17.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator17.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 170, 10));

        jSeparator10.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 370, 10));

        jSeparator12.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 170, 10));

        jSeparator13.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 170, 10));

        jSeparator15.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 170, 10));

        img_path.setEditable(false);
        img_path.setBackground(new java.awt.Color(253, 229, 210));
        img_path.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        img_path.setBorder(null);
        img_path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                img_pathKeyTyped(evt);
            }
        });
        getContentPane().add(img_path, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 330, 20));

        jSeparator16.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator16.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 330, 10));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Image Path");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        profile_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/book.gif"))); // NOI18N
        profile_pic.setToolTipText("Image size: 136*172 px (JPG)");
        profile_pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        profile_pic.setPreferredSize(new java.awt.Dimension(136, 172));
        getContentPane().add(profile_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 138, 172));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Book ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        bk_id.setEditable(false);
        bk_id.setBackground(new java.awt.Color(253, 229, 210));
        bk_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bk_id.setBorder(null);
        bk_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bk_idKeyTyped(evt);
            }
        });
        getContentPane().add(bk_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 170, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Edition");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 90, -1));

        edition.setBackground(new java.awt.Color(253, 229, 210));
        edition.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        edition.setText("Not specified");
        edition.setBorder(null);
        edition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editionMouseClicked(evt);
            }
        });
        edition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editionActionPerformed(evt);
            }
        });
        getContentPane().add(edition, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 170, 20));

        author_name.setBackground(new java.awt.Color(253, 229, 210));
        author_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        author_name.setBorder(null);
        author_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                author_nameActionPerformed(evt);
            }
        });
        author_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                author_nameKeyReleased(evt);
            }
        });
        getContentPane().add(author_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 170, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 300, -1));

        book_name.setBackground(new java.awt.Color(253, 229, 210));
        book_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        book_name.setBorder(null);
        book_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_nameActionPerformed(evt);
            }
        });
        getContentPane().add(book_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 370, 20));

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/book icon.gif"))); // NOI18N
        jLabel2.setText(" Add a new Book ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 90));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Author");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 140, -1));

        released_date.setBackground(new java.awt.Color(232, 245, 253));
        released_date.setDateFormatString("d MMM y");
        released_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(released_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 170, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Released Date");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 160, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Department");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 90, -1));

        department_name.setBackground(new java.awt.Color(253, 229, 210));
        department_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        department_name.setBorder(null);
        department_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_nameActionPerformed(evt);
            }
        });
        department_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                department_nameKeyReleased(evt);
            }
        });
        getContentPane().add(department_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 170, 20));

        jSeparator18.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator18.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 170, 10));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Quantity");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 90, -1));

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

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg.png"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void editionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editionActionPerformed

    private void author_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_author_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_author_nameActionPerformed

    private void book_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_nameActionPerformed

    private void bk_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bk_idKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_bk_idKeyTyped

    private void img_pathKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_img_pathKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_img_pathKeyTyped

    private void department_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_nameActionPerformed

    private void Dept_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Dept_ViewMouseClicked
        department_name.setText(Dept_View.getSelectedValue());
        Dept_PopupMenu.hide();
        
        try {
            Categories_View();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(New_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Dept_ViewMouseClicked

    private void department_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_department_nameKeyReleased
        
        Dept_PopupMenu.show();
        
        if(!department_name.getText().trim().equals(""))
        {
            mod1.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT DISTINCT name FROM Department WHERE name LIKE '" + department_name.getText() + "%' ORDER BY name ASC";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod1.addElement(res.getString("name"));
                } 
            } catch (SQLException | ClassNotFoundException e) { }
            
            try {
                Categories_View();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(New_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Dept_PopupMenu.show(department_name, 0, department_name.getHeight());
            
        }
        
    }//GEN-LAST:event_department_nameKeyReleased

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        
    }//GEN-LAST:event_quantityKeyReleased

    private void quantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_quantityKeyTyped

    private void editionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editionMouseClicked
        edition.setText("");
    }//GEN-LAST:event_editionMouseClicked

    private void Auth_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Auth_ViewMouseClicked
        author_name.setText(Auth_View.getSelectedValue());
        Auth_PopupMenu.hide();
    }//GEN-LAST:event_Auth_ViewMouseClicked

    private void author_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_author_nameKeyReleased
        
        Auth_PopupMenu.show();
        
        if(!author_name.getText().trim().equals(""))
        {
            mod2.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT DISTINCT name FROM Author WHERE name LIKE '" + author_name.getText() + "%' ORDER BY name ASC";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod2.addElement(res.getString("name"));
                } 
            } catch (SQLException | ClassNotFoundException e) { }
            
            try {
                Categories_View();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(New_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Auth_PopupMenu.show(author_name, 0, author_name.getHeight());
        }
    }//GEN-LAST:event_author_nameKeyReleased

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
                
        if(book_name.getText().trim().equals("") || author_name.getText().trim().equals("") || edition.getText().trim().equals("") || department_name.getText().trim().equals("") || category_list.getSelectedItem().equals("<<Select>>") || released_date.getDate() == null || img_path.getText().trim().equals("") || quantity.getText().trim().equals("")){  
            JOptionPane.showMessageDialog(null, "Enter all the information !!!");
        }
        else
        {
            Author author = new Author();
            Book book = new Book();
            BookStock bookStock = new BookStock();
            Category category = new Category();
            
            try {
                category.ctg_id_from_dept_name(department_name.getText(), (String) category_list.getSelectedItem());
            
                int ctg_id = category.getCtg_id();
                
                author.author_search(author_name.getText());
                
                if(author.getFound() == 0)
                    author.insert(author_name.getText());
                
                author.id_from_name(author_name.getText());
                
                int auth_id = author.getAuth_id();
                
                book.book_search(book_name.getText(), ctg_id, auth_id);
                
                if(book.getFound() != 0)
                    JOptionPane.showMessageDialog(null, "This book already exists !!!");
                else
                {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                        String sql = "INSERT INTO Book (name, ctg_id, auth_id, edition, released_date, cover_pic) VALUES (?, ?, ?, ?, ?, ?)";        
                        PreparedStatement pst = con.prepareStatement(sql);

                        InputStream is = new FileInputStream(new File(Path));
                        
                        pst.setString(1, book_name.getText());
                        pst.setInt(2, ctg_id);
                        pst.setInt(3, auth_id);
                        pst.setString(4, edition.getText());
                        
                        java.util.Date javaDate = released_date.getDate();
                        java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
                        pst.setDate(5, sqlDate);                        
                        pst.setBlob(6, is);
                        
                        pst.executeUpdate(); 
                        
                        bookStock.insert_into_book_stock(Integer.parseInt(bk_id.getText()), Integer.parseInt(quantity.getText()));
                        
                        JOptionPane.showMessageDialog(null, "Added !!!");
                        Reset();
                        
                    }catch (ClassNotFoundException | SQLException | FileNotFoundException ex) {
                            Logger.getLogger(New_Book.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(New_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_AddActionPerformed

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
            Logger.getLogger(New_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_UploadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new New_Book().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(New_Book.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JPanel Auth_Panel;
    private javax.swing.JPopupMenu Auth_PopupMenu;
    private javax.swing.JList<String> Auth_View;
    private javax.swing.JButton Back;
    private javax.swing.JPanel Dept_Panel;
    private javax.swing.JPopupMenu Dept_PopupMenu;
    private javax.swing.JList<String> Dept_View;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JButton Upload;
    private javax.swing.JTextField author_name;
    private javax.swing.JTextField bk_id;
    private javax.swing.JTextField book_name;
    private javax.swing.JComboBox<String> category_list;
    private javax.swing.JTextField department_name;
    private javax.swing.JTextField edition;
    private javax.swing.JTextField img_path;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JLabel profile_pic;
    private javax.swing.JTextField quantity;
    private com.toedter.calendar.JDateChooser released_date;
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
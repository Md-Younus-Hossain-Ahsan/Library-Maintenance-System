package MyProject;

import JClasses.Category;
import JClasses.Department;
import static MyProject.SignIN.url;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.logging.*;
import javax.swing.table.*;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public final class Categories extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
                
    int dept_id = 0;
    
    public Categories() {
        
        initComponents();        
        All_View();
        All_Departments();
    }
    
    
    public void All_View(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql;
            
            if(department_list.getSelectedItem().equals("<<All view>>"))
                sql = "SELECT * FROM Category";
            else
                sql = "SELECT * FROM Category WHERE dept_id = '"+ dept_id +"'";
                
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            All_Categories.setModel(new DefaultTableModel(null, new String[] {"Ctg ID","Name","Department"}));
            
            while (res.next()) {
                
                Department department = new Department();
                department.name_from_id(res.getInt("dept_id"));
                                
                String tbData[] = {Integer.toString(res.getInt("ctg_id")),
                                    res.getString("name"),
                                    department.getDept_name()};

                DefaultTableModel tbModel = (DefaultTableModel) All_Categories.getModel();
                tbModel.addRow(tbData);
        
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void All_Departments(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Department";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
                department_list.addItem(res.getString("name"));                
            
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Add = new javax.swing.JButton();
        department_list = new javax.swing.JComboBox<>();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        All_Categories = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ctg_name = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add.setBackground(new java.awt.Color(253, 229, 210));
        Add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Add.setText("Add a new");
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
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 110, 30));

        department_list.setBackground(new java.awt.Color(253, 229, 210));
        department_list.setEditable(true);
        department_list.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        department_list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<All view>>" }));
        department_list.setBorder(null);
        department_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_listActionPerformed(evt);
            }
        });
        getContentPane().add(department_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 170, 20));

        jSeparator14.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 170, 10));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Department");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 100, -1));

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/book icon.gif"))); // NOI18N
        jLabel2.setText(" Categories ");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 100));

        jSeparator12.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 180, 10));

        All_Categories.setBackground(new java.awt.Color(253, 229, 210));
        All_Categories.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        All_Categories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ctg ID", "Name", "Department"
            }
        ));
        All_Categories.setToolTipText("");
        All_Categories.setName(""); // NOI18N
        All_Categories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                All_CategoriesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(All_Categories);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 500, 190));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Name of the category");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        ctg_name.setBackground(new java.awt.Color(253, 229, 210));
        ctg_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ctg_name.setToolTipText("");
        ctg_name.setBorder(null);
        ctg_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ctg_nameMouseClicked(evt);
            }
        });
        ctg_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctg_nameActionPerformed(evt);
            }
        });
        getContentPane().add(ctg_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 180, 20));

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 100, 35));

        Info_Icon.setBackground(new java.awt.Color(253, 229, 210));
        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg.png"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void All_CategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_CategoriesMouseClicked
                    
    }//GEN-LAST:event_All_CategoriesMouseClicked
    
    
    private void ctg_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctg_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctg_nameActionPerformed

    private void ctg_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctg_nameMouseClicked
        
    }//GEN-LAST:event_ctg_nameMouseClicked

    private void department_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_listActionPerformed
        
        Department department = new Department();
        try {
            department.id_from_name((String) department_list.getSelectedItem());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
        dept_id = department.getDept_id();
        All_View();
        
    }//GEN-LAST:event_department_listActionPerformed

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
          
        if(ctg_name.getText().isEmpty() || department_list.getSelectedItem().equals("<<All view>>"))
        {
            JOptionPane.showMessageDialog(null, "Enter all the information !!!");
        }
        else
        {
            Category category = new Category();
            try {
                category.name_search(ctg_name.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(category.getFound() == 1)
                JOptionPane.showMessageDialog(null, "All ready exists !");
            else
            {
                category.insert(ctg_name.getText(), (String) department_list.getSelectedItem());
                All_View();
                ctg_name.setText("");
                department_list.setSelectedItem("<<All view>>");
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
                new Categories().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTable All_Categories;
    private javax.swing.JButton Back;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JTextField ctg_name;
    private javax.swing.JComboBox<String> department_list;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator14;
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
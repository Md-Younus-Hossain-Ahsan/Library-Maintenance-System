package MyProject;

import JClasses.*;
import static MyProject.SignIN.url;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.*;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public final class Book_List extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    private ImageIcon format = null;
    private DefaultListModel mod1, mod2, mod3, mod4;
    
    public Book_List() throws ClassNotFoundException {
        
        initComponents();
        All_View();
        For_Viewing_Searching_Suggestions();
        
    }
    
    
    public void For_Viewing_Searching_Suggestions()
    {
        Book_Name_PopupMenu.add(Book_Name_Panel);
        mod1 = new DefaultListModel();
        Book_Name_View.setModel(mod1);
                
        Auth_PopupMenu.add(Auth_Panel);
        mod2 = new DefaultListModel();
        Auth_View.setModel(mod2);
                
        Dept_PopupMenu.add(Dept_Panel);
        mod3 = new DefaultListModel();
        Dept_View.setModel(mod3);
        
        Ctg_PopupMenu.add(Ctg_Panel);
        mod4 = new DefaultListModel();
        Ctg_View.setModel(mod4);
        
    }
    
    
    public void All_View()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Book";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            Book_List.setModel(new DefaultTableModel(null, new String[] {"Book ID","Name","Author","Category","Department"}));

            while (res.next()) {

                Author author = new Author();
                Category category = new Category();
                
                author.name_from_id(res.getInt("auth_id"));
                category.name_from_id(res.getInt("ctg_id"));
                category.dept_name_from_ctg_id(res.getInt("ctg_id"));
                
                String tbData[] = {Integer.toString(res.getInt("bk_id")),
                                   res.getString("name"),
                                   author.getAuth_name(),
                                   category.getCategory(),
                                   category.getDept_name()};

                DefaultTableModel tbModel = (DefaultTableModel) Book_List.getModel();
                tbModel.addRow(tbData);
            }
        } catch (SQLException | ClassNotFoundException e) { }
    }
    
    
    public void Reset()
    {
        bk_id.setText("");
        book_name.setText("");
        author_name.setText("");
        department_name.setText("");
        category_name.setText("");
        edition.setText("");
        quantity.setText("");
        profile_pic.setIcon(null);
        released_date.setText("");
        
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Book_Name_Panel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Book_Name_View = new javax.swing.JList<>();
        Book_Name_PopupMenu = new javax.swing.JPopupMenu();
        Auth_Panel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Auth_View = new javax.swing.JList<>();
        Auth_PopupMenu = new javax.swing.JPopupMenu();
        Dept_Panel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Dept_View = new javax.swing.JList<>();
        Dept_PopupMenu = new javax.swing.JPopupMenu();
        Ctg_Panel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Ctg_View = new javax.swing.JList<>();
        Ctg_PopupMenu = new javax.swing.JPopupMenu();
        jLabel20 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        category_name = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        profile_pic = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bk_id = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        released_date = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        edition = new javax.swing.JTextField();
        author_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        book_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        department_name = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        All_Info_View = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Book_List = new javax.swing.JTable();
        Info_Icon = new javax.swing.JLabel();

        Book_Name_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Book_Name_ViewMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(Book_Name_View);

        javax.swing.GroupLayout Book_Name_PanelLayout = new javax.swing.GroupLayout(Book_Name_Panel);
        Book_Name_Panel.setLayout(Book_Name_PanelLayout);
        Book_Name_PanelLayout.setHorizontalGroup(
            Book_Name_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
        Book_Name_PanelLayout.setVerticalGroup(
            Book_Name_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Book_Name_PopupMenu.setFocusable(false);

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

        Ctg_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ctg_ViewMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(Ctg_View);

        javax.swing.GroupLayout Ctg_PanelLayout = new javax.swing.GroupLayout(Ctg_Panel);
        Ctg_Panel.setLayout(Ctg_PanelLayout);
        Ctg_PanelLayout.setHorizontalGroup(
            Ctg_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Ctg_PanelLayout.setVerticalGroup(
            Ctg_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Ctg_PopupMenu.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("pieces");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 50, -1));

        quantity.setEditable(false);
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
        getContentPane().add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 120, 20));

        category_name.setBackground(new java.awt.Color(253, 229, 210));
        category_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        category_name.setBorder(null);
        category_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                category_nameMouseClicked(evt);
            }
        });
        category_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category_nameActionPerformed(evt);
            }
        });
        category_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                category_nameKeyReleased(evt);
            }
        });
        getContentPane().add(category_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 170, 20));

        jSeparator14.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 170, 10));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Category");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 140, -1));

        jSeparator17.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator17.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 170, 10));

        jSeparator10.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 360, 10));

        jSeparator12.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 170, 10));

        jSeparator13.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 170, 10));

        jSeparator15.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 170, 10));

        profile_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/book.gif"))); // NOI18N
        profile_pic.setToolTipText("Image size: 136*172 px (JPG)");
        profile_pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        profile_pic.setPreferredSize(new java.awt.Dimension(136, 172));
        getContentPane().add(profile_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 97, 138, 172));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Book ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        bk_id.setBackground(new java.awt.Color(253, 229, 210));
        bk_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bk_id.setBorder(null);
        bk_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bk_idMouseClicked(evt);
            }
        });
        bk_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bk_idKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bk_idKeyTyped(evt);
            }
        });
        getContentPane().add(bk_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 170, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Edition");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 90, -1));

        released_date.setEditable(false);
        released_date.setBackground(new java.awt.Color(253, 229, 210));
        released_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        released_date.setBorder(null);
        released_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                released_dateMouseClicked(evt);
            }
        });
        released_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                released_dateActionPerformed(evt);
            }
        });
        getContentPane().add(released_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 170, 20));

        jSeparator16.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator16.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 170, 10));

        edition.setEditable(false);
        edition.setBackground(new java.awt.Color(253, 229, 210));
        edition.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        getContentPane().add(edition, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 170, 20));

        author_name.setBackground(new java.awt.Color(253, 229, 210));
        author_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        author_name.setBorder(null);
        author_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                author_nameMouseClicked(evt);
            }
        });
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
        getContentPane().add(author_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 170, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 180, -1));

        book_name.setBackground(new java.awt.Color(253, 229, 210));
        book_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        book_name.setBorder(null);
        book_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_nameMouseClicked(evt);
            }
        });
        book_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_nameActionPerformed(evt);
            }
        });
        book_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                book_nameKeyReleased(evt);
            }
        });
        getContentPane().add(book_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 360, 20));

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/book icon.gif"))); // NOI18N
        jLabel2.setText(" Book List ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 90));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Author");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 140, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Released Date");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 160, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Department");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 90, -1));

        department_name.setBackground(new java.awt.Color(253, 229, 210));
        department_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        department_name.setBorder(null);
        department_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                department_nameMouseClicked(evt);
            }
        });
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
        getContentPane().add(department_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 170, 20));

        jSeparator18.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator18.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 170, 10));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Quantity");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 90, -1));

        All_Info_View.setBackground(new java.awt.Color(253, 229, 210));
        All_Info_View.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        All_Info_View.setText("All View");
        All_Info_View.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        All_Info_View.setContentAreaFilled(false);
        All_Info_View.setOpaque(true);
        All_Info_View.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                All_Info_ViewMouseMoved(evt);
            }
        });
        All_Info_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                All_Info_ViewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                All_Info_ViewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                All_Info_ViewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                All_Info_ViewMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                All_Info_ViewMouseReleased(evt);
            }
        });
        All_Info_View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                All_Info_ViewActionPerformed(evt);
            }
        });
        getContentPane().add(All_Info_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, 100, 30));

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
        getContentPane().add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, 100, 30));

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, 100, 35));

        Book_List.setBackground(new java.awt.Color(253, 229, 210));
        Book_List.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Book_List.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Category", "Department"
            }
        ));
        Book_List.setToolTipText("");
        Book_List.setName(""); // NOI18N
        Book_List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Book_ListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Book_List);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 840, 260));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg.png"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 625));

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

    private void department_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_nameActionPerformed

    private void Dept_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Dept_ViewMouseClicked
        department_name.setText(Dept_View.getSelectedValue());
        Dept_PopupMenu.hide();
    }//GEN-LAST:event_Dept_ViewMouseClicked

    private void department_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_department_nameKeyReleased
        
        Dept_PopupMenu.show();
        
        if(!department_name.getText().trim().equals(""))
        {
            mod3.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                
                String sql1 = "SELECT DISTINCT name FROM Department WHERE name LIKE '" + department_name.getText() + "%' ORDER BY name ASC";
                String sql2 = "SELECT B.bk_id, B.name AS book_name, A.name AS author_name, C.name AS category_name, D.name AS department_name FROM Book B JOIN Author A ON B.auth_id = A.auth_id JOIN Category C ON B.ctg_id = C.ctg_id JOIN Department D ON C.dept_id = D.dept_id WHERE D.name LIKE '" + department_name.getText() +"%'";

                PreparedStatement pst1 = con.prepareStatement(sql1); 
                PreparedStatement pst2 = con.prepareStatement(sql2);
                
                ResultSet res1 = pst1.executeQuery();
                ResultSet res2 = pst2.executeQuery();
                
                while (res1.next()) {   
                    mod3.addElement(res1.getString("name"));
                }
                
                Book_List.setModel(new DefaultTableModel(null, new String[] {"Book ID","Name","Author","Category","Department"}));

                while (res2.next()) {

                    String tbData[] = {Integer.toString(res2.getInt("B.bk_id")),
                                       res2.getString("book_name"),
                                       res2.getString("author_name"),
                                       res2.getString("category_name"),
                                       res2.getString("department_name")};

                    DefaultTableModel tbModel = (DefaultTableModel) Book_List.getModel();
                    tbModel.addRow(tbData);
                }
            } catch (SQLException | ClassNotFoundException e) { } 
            
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
                String sql1 = "SELECT DISTINCT name FROM Author WHERE name LIKE '" + author_name.getText() + "%' ORDER BY name ASC";
                String sql2 = "SELECT B.bk_id, B.name AS book_name, A.name AS author_name, C.name AS category_name, D.name AS department_name FROM Book B JOIN Author A ON B.auth_id = A.auth_id JOIN Category C ON B.ctg_id = C.ctg_id JOIN Department D ON C.dept_id = D.dept_id WHERE A.name LIKE '" + author_name.getText() + "%'";
                
                PreparedStatement pst1 = con.prepareStatement(sql1); 
                PreparedStatement pst2 = con.prepareStatement(sql2); 
                
                ResultSet res1 = pst1.executeQuery();
                ResultSet res2 = pst2.executeQuery();
                
                while (res1.next()) {   
                    mod2.addElement(res1.getString("name"));
                } 
                
                Book_List.setModel(new DefaultTableModel(null, new String[] {"Book ID","Name","Author","Category","Department"}));

                while (res2.next()) {

                    String tbData[] = {Integer.toString(res2.getInt("B.bk_id")),
                                       res2.getString("book_name"),
                                       res2.getString("author_name"),
                                       res2.getString("category_name"),
                                       res2.getString("department_name")};

                    DefaultTableModel tbModel = (DefaultTableModel) Book_List.getModel();
                    tbModel.addRow(tbData);
                }
                
            } catch (SQLException | ClassNotFoundException e) { }
                        
            Auth_PopupMenu.show(author_name, 0, author_name.getHeight());
        }

    }//GEN-LAST:event_author_nameKeyReleased

    private void All_Info_ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_Info_ViewMouseMoved
        All_Info_View.setCursor(SignIN.cursor);
    }//GEN-LAST:event_All_Info_ViewMouseMoved

    private void All_Info_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_Info_ViewMouseClicked
        All_Info_View.setBackground(new Color(255,255,0).brighter());
        All_Info_View.setForeground(Color.WHITE);
    }//GEN-LAST:event_All_Info_ViewMouseClicked

    private void All_Info_ViewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_Info_ViewMouseEntered
        All_Info_View.setBackground(new Color(253,229,196).brighter());
        All_Info_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_Info_ViewMouseEntered

    private void All_Info_ViewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_Info_ViewMouseExited
        All_Info_View.setBackground(new Color(253,229,210));
        All_Info_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_Info_ViewMouseExited

    private void All_Info_ViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_Info_ViewMousePressed
        All_Info_View.setBackground(new Color(255,255,100).brighter());
        All_Info_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_Info_ViewMousePressed

    private void All_Info_ViewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_Info_ViewMouseReleased
        All_Info_View.setBackground(new Color(253,229,210));
        All_Info_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_Info_ViewMouseReleased

    private void All_Info_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_Info_ViewActionPerformed
        All_View();
        Reset();
    }//GEN-LAST:event_All_Info_ViewActionPerformed

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
        All_View();
        Reset();
    }//GEN-LAST:event_ResetActionPerformed

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

    private void Book_ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Book_ListMouseClicked
        
        Book book = new Book();
        BookStock bookStock = new BookStock();
        
        int i = Book_List.getSelectedRow();
        TableModel model = Book_List.getModel();
                
        bk_id.setText((String) model.getValueAt(i, 0));
        book_name.setText((String) model.getValueAt(i, 1));
        author_name.setText((String) model.getValueAt(i, 2));
        category_name.setText((String) model.getValueAt(i, 3));        
        department_name.setText((String) model.getValueAt(i, 4));
        
        book.All_the_information_of_a_book(Integer.parseInt((String) model.getValueAt(i, 0)));
        try {
            bookStock.quantity_from_bk_id(Integer.parseInt((String) model.getValueAt(i, 0)));
        } catch (ClassNotFoundException ex) {}
        
        format = new ImageIcon(book.getCoverPic());
        profile_pic.setIcon(format);
        edition.setText(book.getEdition());
        quantity.setText(Integer.toString(bookStock.getQuantity()));
        released_date.setText(book.getReleased_date().toString());
                
    }//GEN-LAST:event_Book_ListMouseClicked

    private void bk_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bk_idKeyReleased
        
        if(!bk_id.getText().trim().equals(""))
        {
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT * FROM Book WHERE bk_id LIKE '" + bk_id.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                
                Book_List.setModel(new DefaultTableModel(null, new String[] {"Book ID","Name","Author","Category","Department"}));
            
                while (res.next()) {
                    
                    Author author = new Author();
                    Category category = new Category();
                    
                    author.name_from_id(res.getInt("auth_id"));
                    category.name_from_id(res.getInt("ctg_id"));
                    category.dept_name_from_ctg_id(res.getInt("ctg_id"));
                    
                    String tbData[] = {Integer.toString(res.getInt("bk_id")),
                                       res.getString("name"),
                                       author.getAuth_name(),
                                       category.getCategory(),
                                       category.getDept_name()};

                    DefaultTableModel tbModel = (DefaultTableModel) Book_List.getModel();
                    tbModel.addRow(tbData);
                }
            } catch (SQLException | ClassNotFoundException e) { }            
        }
        
    }//GEN-LAST:event_bk_idKeyReleased

    private void book_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_book_nameKeyReleased
        
        Book_Name_PopupMenu.show();
        
        if(!book_name.getText().trim().equals(""))
        {
            
            mod1.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT * FROM Book WHERE name LIKE '" + book_name.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                
                Book_List.setModel(new DefaultTableModel(null, new String[] {"Book ID","Name","Author","Category","Department"}));
            
                while (res.next()) {
                    
                    Author author = new Author();
                    Category category = new Category();
                    
                    author.name_from_id(res.getInt("auth_id"));
                    category.name_from_id(res.getInt("ctg_id"));
                    category.dept_name_from_ctg_id(res.getInt("ctg_id"));
                    
                    mod1.addElement(res.getString("name"));
                    String tbData[] = {Integer.toString(res.getInt("bk_id")),
                                       res.getString("name"),
                                       author.getAuth_name(),
                                       category.getCategory(),
                                       category.getDept_name()};

                    DefaultTableModel tbModel = (DefaultTableModel) Book_List.getModel();
                    tbModel.addRow(tbData);
                }
            } catch (SQLException | ClassNotFoundException e) { } 
            
            Book_Name_PopupMenu.show(book_name, 0, book_name.getHeight());
                    
        }
        
    }//GEN-LAST:event_book_nameKeyReleased

    private void Book_Name_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Book_Name_ViewMouseClicked
        book_name.setText(Book_Name_View.getSelectedValue());
        Book_Name_PopupMenu.hide();
    }//GEN-LAST:event_Book_Name_ViewMouseClicked

    private void bk_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bk_idMouseClicked
        bk_id.setText("");
        Reset();
    }//GEN-LAST:event_bk_idMouseClicked

    private void book_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_nameMouseClicked
        book_name.setText("");
        Reset();
    }//GEN-LAST:event_book_nameMouseClicked

    private void author_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_author_nameMouseClicked
        author_name.setText("");
        Reset();
    }//GEN-LAST:event_author_nameMouseClicked

    private void department_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_department_nameMouseClicked
        department_name.setText("");
        Reset();
    }//GEN-LAST:event_department_nameMouseClicked

    private void released_dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_released_dateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_released_dateMouseClicked

    private void released_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_released_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_released_dateActionPerformed

    private void category_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_category_nameMouseClicked
        category_name.setText("");
        Reset();
    }//GEN-LAST:event_category_nameMouseClicked

    private void category_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_category_nameActionPerformed

    private void category_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_category_nameKeyReleased
        
        Ctg_PopupMenu.show();
        
        if(!category_name.getText().trim().equals(""))
        {
            mod4.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                
                String sql1 = "SELECT DISTINCT name FROM Category WHERE name LIKE '" + category_name.getText() + "%' ORDER BY name ASC";
                String sql2 = "SELECT B.bk_id, B.name AS book_name, A.name AS author_name, C.name AS category_name, D.name AS department_name FROM Book B JOIN Author A ON B.auth_id = A.auth_id JOIN Category C ON B.ctg_id = C.ctg_id JOIN Department D ON C.dept_id = D.dept_id WHERE C.name LIKE '" + category_name.getText() +"%'";

                PreparedStatement pst1 = con.prepareStatement(sql1); 
                PreparedStatement pst2 = con.prepareStatement(sql2);
                
                ResultSet res1 = pst1.executeQuery();
                ResultSet res2 = pst2.executeQuery();
                
                while (res1.next()) {   
                    mod4.addElement(res1.getString("name"));
                }
                
                Book_List.setModel(new DefaultTableModel(null, new String[] {"Book ID","Name","Author","Category","Department"}));

                while (res2.next()) {

                    String tbData[] = {Integer.toString(res2.getInt("B.bk_id")),
                                       res2.getString("book_name"),
                                       res2.getString("author_name"),
                                       res2.getString("category_name"),
                                       res2.getString("department_name")};

                    DefaultTableModel tbModel = (DefaultTableModel) Book_List.getModel();
                    tbModel.addRow(tbData);
                }
            } catch (SQLException | ClassNotFoundException e) { } 
            
            Ctg_PopupMenu.show(category_name, 0, category_name.getHeight());
            
        }
        
    }//GEN-LAST:event_category_nameKeyReleased

    private void Ctg_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ctg_ViewMouseClicked
        category_name.setText(Ctg_View.getSelectedValue());
        Ctg_PopupMenu.hide();
    }//GEN-LAST:event_Ctg_ViewMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Book_List().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Book_List.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton All_Info_View;
    private javax.swing.JPanel Auth_Panel;
    private javax.swing.JPopupMenu Auth_PopupMenu;
    private javax.swing.JList<String> Auth_View;
    private javax.swing.JButton Back;
    private javax.swing.JTable Book_List;
    private javax.swing.JPanel Book_Name_Panel;
    private javax.swing.JPopupMenu Book_Name_PopupMenu;
    private javax.swing.JList<String> Book_Name_View;
    private javax.swing.JPanel Ctg_Panel;
    private javax.swing.JPopupMenu Ctg_PopupMenu;
    private javax.swing.JList<String> Ctg_View;
    private javax.swing.JPanel Dept_Panel;
    private javax.swing.JPopupMenu Dept_PopupMenu;
    private javax.swing.JList<String> Dept_View;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JButton Reset;
    private javax.swing.JTextField author_name;
    private javax.swing.JTextField bk_id;
    private javax.swing.JTextField book_name;
    private javax.swing.JTextField category_name;
    private javax.swing.JTextField department_name;
    private javax.swing.JTextField edition;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
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
    private javax.swing.JTextField released_date;
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
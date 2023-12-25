package MyProject;

import JClasses.Book;
import JClasses.BookStock;
import JClasses.Borrow;
import JClasses.Student;
import static MyProject.SignIN.url;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public final class Received_Borrow_List extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
                
    private ImageIcon format = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
    
    public Received_Borrow_List() {
        
        initComponents();  
        All_View();
        
        LocalDate currentDate = LocalDate.now();
        LocalDate before_7_days = currentDate.minusDays(7);
        
        java.util.Date todayDate = java.sql.Date.valueOf(currentDate);
        java.util.Date lastDate = java.sql.Date.valueOf(before_7_days);

        date1.setDate(lastDate);
        date2.setDate(todayDate);
                
    }    
    
    
    public void All_View(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Borrow where brw_type = 'Received'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            
            ResultSet res = pst.executeQuery();
            
            Borrow_List.setModel(new DefaultTableModel(null, new String[] {"Borrow ID","Student ID","Book ID","Borrow Date","Return Date"}));
            
            while (res.next()) {
                
                String tbData[] = {Integer.toString(res.getInt("brw_id")),
                                   Integer.toString(res.getInt("student_id")),
                                   Integer.toString(res.getInt("bk_id")),
                                   res.getDate("borrow_date").toString(),
                                   res.getDate("return_date").toString()};

                DefaultTableModel tbModel = (DefaultTableModel) Borrow_List.getModel();
                tbModel.addRow(tbData);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {}
    }
    
    
    public void All_View_from_dates(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Borrow where brw_type = 'Received' and borrow_date >= '"+ sdf.format(date1.getDate()) +"' and borrow_date <= '"+ sdf.format(date2.getDate()) +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
                        
            ResultSet res = pst.executeQuery();
            
            Borrow_List.setModel(new DefaultTableModel(null, new String[] {"Borrow ID","Student ID","Book ID","Borrow Date","Return Date"}));
        
            while (res.next()) {
                
                String tbData[] = {Integer.toString(res.getInt("brw_id")),
                                   Integer.toString(res.getInt("student_id")),
                                   Integer.toString(res.getInt("bk_id")),
                                   res.getDate("borrow_date").toString(),
                                   res.getDate("return_date").toString()};

                DefaultTableModel tbModel = (DefaultTableModel) Borrow_List.getModel();
                tbModel.addRow(tbData);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {}
    }
    
    
    public void Borrow_list_View_from_student_id(int student_id){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Borrow where brw_type = 'Received' and student_id = '"+ student_id +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            
            ResultSet res = pst.executeQuery();
            
            Borrow_List.setModel(new DefaultTableModel(null, new String[] {"Borrow ID","Student ID","Book ID","Borrow Date","Return Date"}));
            
            while (res.next()) {
                
                String tbData[] = {Integer.toString(res.getInt("brw_id")),
                                   Integer.toString(res.getInt("student_id")),
                                   Integer.toString(res.getInt("bk_id")),
                                   res.getDate("borrow_date").toString(),
                                   res.getDate("return_date").toString()};

                DefaultTableModel tbModel = (DefaultTableModel) Borrow_List.getModel();
                tbModel.addRow(tbData);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {}
    }
    
    
    public void Search_Student_Info(int Student_id) throws ClassNotFoundException
    {
        Student student = new Student();
        student.Student_Info(Integer.parseInt(student_id.getText()));
        
        student_name.setText(student.getStudent_name());
        gender.setText(student.getGender());
        mobile_number.setText(student.getMobile_number());
        email.setText(student.getEmail());

        format = new ImageIcon(student.getProfile_pic());
        profile_pic.setIcon(format);
        
        Borrowed_Book_Info(Integer.parseInt(student_id.getText()));
        
    }
    
    
    public void Search_Book_Info() throws ClassNotFoundException
    {
        Book book = new Book();
        BookStock bookStock = new BookStock();

        try {
            bookStock.quantity_from_bk_id(Integer.parseInt(bk_id.getText()));
        } catch (ClassNotFoundException ex) {}
        
        book.All_the_information_of_a_book(Integer.parseInt(bk_id.getText()));

        book_name.setText(book.getBook_name());
        author_name.setText(book.getAuthor_name());
        department_name.setText(book.getDepartment_name());
        category_name.setText(book.getCategory_name());
        edition.setText(book.getEdition());
        released_date.setText(book.getReleased_date().toString());
        
        format = new ImageIcon(book.getCoverPic());
        cover_pic.setIcon(format);
        
    }
    
    
    public void Reset_the_Student_Info()
    {
        student_name.setText("");
        gender.setText("");
        email.setText("");
        mobile_number.setText("");
        pending_borrowed.setText("");
        total_borrowed.setText(""); 
        profile_pic.setIcon(null);
    }
    
    
    public void Reset_the_Book_Info()
    {
        bk_id.setText("");
        book_name.setText("");
        author_name.setText("");
        department_name.setText("");
        category_name.setText("");
        released_date.setText("");    
        edition.setText("");
        borrow_date.setText("");
        return_date.setText("");     
        cover_pic.setIcon(null);
    }
    
    
    public void Reset_All()
    {
        student_id.setText("");
        brw_id.setText("");
        date1.setDate(null);
        date2.setDate(null);
        All_View();
        Reset_the_Student_Info();
        Reset_the_Book_Info();
    }
        
    
    public void Borrowed_Book_Info(int Student_id) throws ClassNotFoundException
    {
        Borrow borrow = new Borrow();
        borrow.pending_borrow_of_a_student(Student_id);
        borrow.total_borrow_of_a_student(Student_id);
        pending_borrowed.setText(Integer.toString(borrow.getPending_borrowed()));
        total_borrowed.setText(Integer.toString(borrow.getTotal_borrowed()));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Borrow_ID_Search = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        return_date = new javax.swing.JTextField();
        jSeparator27 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        Borrow_List = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        brw_id = new javax.swing.JTextField();
        Search_within_dates = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        student_id = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        profile_pic = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        student_name = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        gender = new javax.swing.JTextField();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        mobile_number = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jlevel1111 = new javax.swing.JLabel();
        pending_borrowed = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jlevel1112 = new javax.swing.JLabel();
        total_borrowed = new javax.swing.JTextField();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        book_name = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        author_name = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        edition = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        department_name = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        category_name = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        released_date = new javax.swing.JTextField();
        jSeparator22 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        borrow_date = new javax.swing.JTextField();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        bk_id = new javax.swing.JTextField();
        jSeparator23 = new javax.swing.JSeparator();
        cover_pic = new javax.swing.JLabel();
        Student_ID_Search = new javax.swing.JButton();
        date1 = new com.toedter.calendar.JDateChooser();
        date2 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Reset = new javax.swing.JButton();
        All_View = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Borrow_ID_Search.setBackground(new java.awt.Color(253, 229, 210));
        Borrow_ID_Search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Borrow_ID_Search.setText("Search");
        Borrow_ID_Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Borrow_ID_Search.setContentAreaFilled(false);
        Borrow_ID_Search.setOpaque(true);
        Borrow_ID_Search.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Borrow_ID_SearchMouseMoved(evt);
            }
        });
        Borrow_ID_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Borrow_ID_SearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Borrow_ID_SearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Borrow_ID_SearchMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Borrow_ID_SearchMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Borrow_ID_SearchMouseReleased(evt);
            }
        });
        Borrow_ID_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrow_ID_SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Borrow_ID_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 100, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Return Date");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 290, 160, -1));

        return_date.setEditable(false);
        return_date.setBackground(new java.awt.Color(253, 229, 210));
        return_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        return_date.setBorder(null);
        return_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_dateActionPerformed(evt);
            }
        });
        return_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                return_dateKeyReleased(evt);
            }
        });
        getContentPane().add(return_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 310, 170, 20));

        jSeparator27.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator27.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 330, 170, 10));

        jSeparator12.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 170, 10));

        Borrow_List.setBackground(new java.awt.Color(253, 229, 210));
        Borrow_List.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Borrow_List.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Borrow ID", "Student ID", "Book ID", "Borrow Date", "Return Date"
            }
        ));
        Borrow_List.setToolTipText("");
        Borrow_List.setName(""); // NOI18N
        Borrow_List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Borrow_ListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Borrow_List);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 1250, 210));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Borrow ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        brw_id.setBackground(new java.awt.Color(253, 229, 210));
        brw_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        brw_id.setToolTipText("");
        brw_id.setBorder(null);
        brw_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brw_idMouseClicked(evt);
            }
        });
        brw_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brw_idActionPerformed(evt);
            }
        });
        brw_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                brw_idKeyTyped(evt);
            }
        });
        getContentPane().add(brw_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 170, 20));

        Search_within_dates.setBackground(new java.awt.Color(253, 229, 210));
        Search_within_dates.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Search_within_dates.setText("Search");
        Search_within_dates.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Search_within_dates.setContentAreaFilled(false);
        Search_within_dates.setOpaque(true);
        Search_within_dates.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Search_within_datesMouseMoved(evt);
            }
        });
        Search_within_dates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Search_within_datesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Search_within_datesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Search_within_datesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Search_within_datesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Search_within_datesMouseReleased(evt);
            }
        });
        Search_within_dates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_within_datesActionPerformed(evt);
            }
        });
        getContentPane().add(Search_within_dates, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Student ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        student_id.setBackground(new java.awt.Color(253, 229, 210));
        student_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        student_id.setToolTipText("");
        student_id.setBorder(null);
        student_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                student_idMouseClicked(evt);
            }
        });
        student_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_idActionPerformed(evt);
            }
        });
        student_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                student_idKeyTyped(evt);
            }
        });
        getContentPane().add(student_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 170, 20));

        jSeparator13.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 170, 10));

        profile_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/student icon.png"))); // NOI18N
        profile_pic.setToolTipText("Image size: 136*172 px (JPG)");
        profile_pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        profile_pic.setPreferredSize(new java.awt.Dimension(136, 172));
        getContentPane().add(profile_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 138, 172));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Student Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 90, -1));

        student_name.setEditable(false);
        student_name.setBackground(new java.awt.Color(253, 229, 210));
        student_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        student_name.setBorder(null);
        student_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_nameActionPerformed(evt);
            }
        });
        getContentPane().add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 190, 20));

        jSeparator10.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 190, 10));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Email");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 90, -1));

        email.setEditable(false);
        email.setBackground(new java.awt.Color(253, 229, 210));
        email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 190, 20));

        jSeparator14.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 190, 10));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Gender");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 90, -1));

        gender.setEditable(false);
        gender.setBackground(new java.awt.Color(253, 229, 210));
        gender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gender.setBorder(null);
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        getContentPane().add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 150, 20));

        jSeparator25.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator25.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 150, 10));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Mobile Number");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 150, -1));

        mobile_number.setEditable(false);
        mobile_number.setBackground(new java.awt.Color(253, 229, 210));
        mobile_number.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mobile_number.setBorder(null);
        mobile_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile_numberActionPerformed(evt);
            }
        });
        getContentPane().add(mobile_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 150, 20));

        jSeparator15.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 150, 10));

        jlevel1111.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlevel1111.setText("Pending Borrowed");
        getContentPane().add(jlevel1111, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 140, -1));

        pending_borrowed.setEditable(false);
        pending_borrowed.setBackground(new java.awt.Color(253, 229, 210));
        pending_borrowed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pending_borrowed.setBorder(null);
        pending_borrowed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pending_borrowedActionPerformed(evt);
            }
        });
        getContentPane().add(pending_borrowed, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 190, 20));

        jSeparator16.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator16.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 190, 10));

        jlevel1112.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlevel1112.setText("Total Borrowed");
        getContentPane().add(jlevel1112, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 140, -1));

        total_borrowed.setEditable(false);
        total_borrowed.setBackground(new java.awt.Color(253, 229, 210));
        total_borrowed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total_borrowed.setBorder(null);
        total_borrowed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_borrowedActionPerformed(evt);
            }
        });
        getContentPane().add(total_borrowed, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 150, 20));

        jSeparator26.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator26.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 150, 10));

        jSeparator11.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator11.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 190, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 180, -1));

        book_name.setEditable(false);
        book_name.setBackground(new java.awt.Color(253, 229, 210));
        book_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        book_name.setBorder(null);
        book_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_nameActionPerformed(evt);
            }
        });
        getContentPane().add(book_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, 170, 20));

        jSeparator17.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator17.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, 170, 10));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Author");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 170, 140, -1));

        author_name.setEditable(false);
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
        getContentPane().add(author_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 190, 170, 20));

        jSeparator18.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator18.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 210, 170, 10));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Edition");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 90, -1));

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
        getContentPane().add(edition, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, 170, 20));

        jSeparator19.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator19.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 170, 10));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Department");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 90, -1));

        department_name.setEditable(false);
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
        getContentPane().add(department_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 170, 20));

        jSeparator20.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator20.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 170, 10));

        category_name.setEditable(false);
        category_name.setBackground(new java.awt.Color(253, 229, 210));
        category_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        category_name.setBorder(null);
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
        getContentPane().add(category_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 170, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Category");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 90, -1));

        jSeparator21.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator21.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 170, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Released Date");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 230, 160, -1));

        released_date.setEditable(false);
        released_date.setBackground(new java.awt.Color(253, 229, 210));
        released_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        released_date.setBorder(null);
        released_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                released_dateActionPerformed(evt);
            }
        });
        released_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                released_dateKeyReleased(evt);
            }
        });
        getContentPane().add(released_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 250, 170, 20));

        jSeparator22.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator22.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, 170, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Borrow Date");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 160, -1));

        borrow_date.setEditable(false);
        borrow_date.setBackground(new java.awt.Color(253, 229, 210));
        borrow_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        borrow_date.setBorder(null);
        borrow_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrow_dateActionPerformed(evt);
            }
        });
        borrow_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                borrow_dateKeyReleased(evt);
            }
        });
        getContentPane().add(borrow_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 310, 170, 20));

        jSeparator24.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator24.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 170, 10));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Book ID");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, -1, -1));

        bk_id.setEditable(false);
        bk_id.setBackground(new java.awt.Color(253, 229, 210));
        bk_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bk_id.setBorder(null);
        bk_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bk_idMouseClicked(evt);
            }
        });
        bk_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bk_idKeyTyped(evt);
            }
        });
        getContentPane().add(bk_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 170, 20));

        jSeparator23.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator23.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 170, 10));

        cover_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/book.gif"))); // NOI18N
        cover_pic.setToolTipText("Image size: 136*172 px (JPG)");
        cover_pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        cover_pic.setPreferredSize(new java.awt.Dimension(136, 172));
        getContentPane().add(cover_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 170, 138, 172));

        Student_ID_Search.setBackground(new java.awt.Color(253, 229, 210));
        Student_ID_Search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Student_ID_Search.setText("Search");
        Student_ID_Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Student_ID_Search.setContentAreaFilled(false);
        Student_ID_Search.setOpaque(true);
        Student_ID_Search.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Student_ID_SearchMouseMoved(evt);
            }
        });
        Student_ID_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Student_ID_SearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Student_ID_SearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Student_ID_SearchMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Student_ID_SearchMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Student_ID_SearchMouseReleased(evt);
            }
        });
        Student_ID_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Student_ID_SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Student_ID_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 100, 30));

        date1.setBackground(new java.awt.Color(253, 229, 210));
        date1.setDateFormatString("yyyy-MM-dd");
        date1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, 130, 25));

        date2.setBackground(new java.awt.Color(253, 229, 210));
        date2.setDateFormatString("yyyy-MM-dd");
        date2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 130, 25));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("To : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 130, 50, 25));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("From : ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 50, 25));

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/book icon.gif"))); // NOI18N
        jLabel2.setText(" Received Borrow List ");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 100));

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
        getContentPane().add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 110, 120, 30));

        All_View.setBackground(new java.awt.Color(253, 229, 210));
        All_View.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        All_View.setText("All View");
        All_View.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        All_View.setContentAreaFilled(false);
        All_View.setOpaque(true);
        All_View.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                All_ViewMouseMoved(evt);
            }
        });
        All_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                All_ViewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                All_ViewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                All_ViewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                All_ViewMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                All_ViewMouseReleased(evt);
            }
        });
        All_View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                All_ViewActionPerformed(evt);
            }
        });
        getContentPane().add(All_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 120, 30));

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 605, 100, 35));

        Info_Icon.setBackground(new java.awt.Color(253, 229, 210));
        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg.png"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Borrow_ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Borrow_ListMouseClicked

        Borrow borrow = new Borrow();
        int i = Borrow_List.getSelectedRow();
        TableModel model = Borrow_List.getModel();
                
        brw_id.setText((String) model.getValueAt(i, 0));
        student_id.setText((String) model.getValueAt(i, 1));
        bk_id.setText((String) model.getValueAt(i, 2));
                
        try {
            borrow.search_info_of_received(Integer.parseInt((String) model.getValueAt(i, 0)));
            Search_Student_Info(Integer.parseInt((String) model.getValueAt(i, 1)));
            Search_Book_Info();
        } catch (ClassNotFoundException ex) {}
        
        borrow_date.setText((String) model.getValueAt(i, 3));
        return_date.setText((String) model.getValueAt(i, 4));
        
    }//GEN-LAST:event_Borrow_ListMouseClicked
    
    
    private void brw_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brw_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brw_idActionPerformed

    private void brw_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brw_idMouseClicked
        Reset_All();
    }//GEN-LAST:event_brw_idMouseClicked

    private void Borrow_ID_SearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Borrow_ID_SearchMouseMoved
        Borrow_ID_Search.setCursor(SignIN.cursor);
    }//GEN-LAST:event_Borrow_ID_SearchMouseMoved

    private void Borrow_ID_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Borrow_ID_SearchMouseClicked
        Borrow_ID_Search.setBackground(new Color(255,255,0).brighter());
        Borrow_ID_Search.setForeground(Color.WHITE);
    }//GEN-LAST:event_Borrow_ID_SearchMouseClicked

    private void Borrow_ID_SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Borrow_ID_SearchMouseEntered
        Borrow_ID_Search.setBackground(new Color(253,229,196).brighter());
        Borrow_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Borrow_ID_SearchMouseEntered

    private void Borrow_ID_SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Borrow_ID_SearchMouseExited
        Borrow_ID_Search.setBackground(new Color(253,229,210));
        Borrow_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Borrow_ID_SearchMouseExited

    private void Borrow_ID_SearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Borrow_ID_SearchMousePressed
        Borrow_ID_Search.setBackground(new Color(255,255,100).brighter());
        Borrow_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Borrow_ID_SearchMousePressed

    private void Borrow_ID_SearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Borrow_ID_SearchMouseReleased
        Borrow_ID_Search.setBackground(new Color(253,229,210));
        Borrow_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Borrow_ID_SearchMouseReleased

    private void Borrow_ID_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrow_ID_SearchActionPerformed
        
        if(brw_id.getText().trim().equals("")){  
            JOptionPane.showMessageDialog(null, "Enter all the information !!!");
        }
        else{
            
            Borrow borrow = new Borrow();
            try {
                borrow.search_info_of_received(Integer.parseInt(brw_id.getText()));
            } catch (ClassNotFoundException ex) {}
            
            if(borrow.getFound() == 0){  
                JOptionPane.showMessageDialog(null, "Not found !!!");
            }
            else
            {
                try {
                    
                    student_id.setText(Integer.toString(borrow.getStudent_id()));
                    Search_Student_Info(borrow.getStudent_id());      

                    bk_id.setText(Integer.toString(borrow.getBk_id()));            
                    Search_Book_Info();
                    
                    Borrow_List.setModel(new DefaultTableModel(null, new String[] {"Borrow ID","Student ID","Book ID","Borrow Date","Return Date"}));
                    
                    borrow.search_info_of_received(Integer.parseInt(brw_id.getText()));
                    String tbData[] = {brw_id.getText(),
                                       Integer.toString(borrow.getStudent_id()),
                                       Integer.toString(borrow.getBk_id()),
                                       borrow.getBorrow_date(),
                                       borrow.getReturn_date()};

                    DefaultTableModel tbModel = (DefaultTableModel) Borrow_List.getModel();
                    tbModel.addRow(tbData);
                    
                    borrow_date.setText(borrow.getBorrow_date());
                    return_date.setText(borrow.getReturn_date());
                    date1.setDate(null);
                    date2.setDate(null);   
                } catch (ClassNotFoundException ex) {}
            }            
        }
        
    }//GEN-LAST:event_Borrow_ID_SearchActionPerformed

    private void student_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_idMouseClicked
        Reset_All();
    }//GEN-LAST:event_student_idMouseClicked

    private void student_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_idActionPerformed

    private void Student_ID_SearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Student_ID_SearchMouseMoved
        Student_ID_Search.setCursor(SignIN.cursor);
    }//GEN-LAST:event_Student_ID_SearchMouseMoved

    private void Student_ID_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Student_ID_SearchMouseClicked
        Student_ID_Search.setBackground(new Color(255,255,0).brighter());
        Student_ID_Search.setForeground(Color.WHITE);
    }//GEN-LAST:event_Student_ID_SearchMouseClicked

    private void Student_ID_SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Student_ID_SearchMouseEntered
        Student_ID_Search.setBackground(new Color(253,229,196).brighter());
        Student_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Student_ID_SearchMouseEntered

    private void Student_ID_SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Student_ID_SearchMouseExited
        Student_ID_Search.setBackground(new Color(253,229,210));
        Student_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Student_ID_SearchMouseExited

    private void Student_ID_SearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Student_ID_SearchMousePressed
        Student_ID_Search.setBackground(new Color(255,255,100).brighter());
        Student_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Student_ID_SearchMousePressed

    private void Student_ID_SearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Student_ID_SearchMouseReleased
        Student_ID_Search.setBackground(new Color(253,229,210));
        Student_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Student_ID_SearchMouseReleased

    private void Student_ID_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Student_ID_SearchActionPerformed

        if(student_id.getText().trim().equals("")){  
            JOptionPane.showMessageDialog(null, "Enter all the information !!!");
        }
        else{
            Student student = new Student();
            try {
                student.id_search(Integer.parseInt(student_id.getText()));
            } catch (ClassNotFoundException ex) {}
                        
            if(student.getFound() == 0){  
                JOptionPane.showMessageDialog(null, "Not found !!!");
            }
            else
            {
                try {
                    Search_Student_Info(Integer.parseInt(student_id.getText()));
                    Borrow_list_View_from_student_id(Integer.parseInt(student_id.getText()));
                    brw_id.setText("");
                    date1.setDate(null);
                    date2.setDate(null);        
                    Reset_the_Book_Info();
                } catch (ClassNotFoundException ex) {}
            }            
        }
        
    }//GEN-LAST:event_Student_ID_SearchActionPerformed

    private void student_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_nameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void mobile_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobile_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile_numberActionPerformed

    private void pending_borrowedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pending_borrowedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pending_borrowedActionPerformed

    private void total_borrowedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_borrowedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_borrowedActionPerformed

    private void book_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_nameActionPerformed

    private void author_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_author_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_author_nameActionPerformed

    private void author_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_author_nameKeyReleased
        
    }//GEN-LAST:event_author_nameKeyReleased

    private void editionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editionMouseClicked
        edition.setText("");
    }//GEN-LAST:event_editionMouseClicked

    private void editionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editionActionPerformed

    private void department_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_nameActionPerformed

    private void department_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_department_nameKeyReleased
        
    }//GEN-LAST:event_department_nameKeyReleased

    private void category_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_category_nameActionPerformed

    private void category_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_category_nameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_category_nameKeyReleased

    private void released_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_released_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_released_dateActionPerformed

    private void released_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_released_dateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_released_dateKeyReleased

    private void bk_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bk_idMouseClicked
        
    }//GEN-LAST:event_bk_idMouseClicked

    private void bk_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bk_idKeyTyped
        
    }//GEN-LAST:event_bk_idKeyTyped

    private void brw_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brw_idKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_brw_idKeyTyped

    private void student_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_student_idKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_student_idKeyTyped

    private void Search_within_datesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_within_datesMouseMoved
        Search_within_dates.setCursor(SignIN.cursor);
    }//GEN-LAST:event_Search_within_datesMouseMoved

    private void Search_within_datesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_within_datesMouseClicked
        Search_within_dates.setBackground(new Color(255,255,0).brighter());
        Search_within_dates.setForeground(Color.WHITE);
    }//GEN-LAST:event_Search_within_datesMouseClicked

    private void Search_within_datesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_within_datesMouseEntered
        Search_within_dates.setBackground(new Color(253,229,196).brighter());
        Search_within_dates.setForeground(Color.BLACK);
    }//GEN-LAST:event_Search_within_datesMouseEntered

    private void Search_within_datesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_within_datesMouseExited
        Search_within_dates.setBackground(new Color(253,229,210));
        Search_within_dates.setForeground(Color.BLACK);
    }//GEN-LAST:event_Search_within_datesMouseExited

    private void Search_within_datesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_within_datesMousePressed
        Search_within_dates.setBackground(new Color(255,255,100).brighter());
        Search_within_dates.setForeground(Color.BLACK);
    }//GEN-LAST:event_Search_within_datesMousePressed

    private void Search_within_datesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_within_datesMouseReleased
        Search_within_dates.setBackground(new Color(253,229,210));
        Search_within_dates.setForeground(Color.BLACK);
    }//GEN-LAST:event_Search_within_datesMouseReleased

    private void Search_within_datesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_within_datesActionPerformed
        
        try{
            String From = sdf.format(date1.getDate());
            String To = sdf.format(date2.getDate());

            if(!From.equals(null) && !To.equals(null))
            {
                All_View_from_dates();
                student_id.setText(null);
                brw_id.setText(null);
                Reset_the_Student_Info();
                Reset_the_Book_Info();
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Invalid !!!");}
        
    }//GEN-LAST:event_Search_within_datesActionPerformed

    private void borrow_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_borrow_dateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_borrow_dateKeyReleased

    private void borrow_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrow_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_borrow_dateActionPerformed

    private void return_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_return_dateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_return_dateKeyReleased

    private void return_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_return_dateActionPerformed

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
        Reset_All();
    }//GEN-LAST:event_ResetActionPerformed

    private void All_ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseMoved
        All_View.setCursor(SignIN.cursor);
    }//GEN-LAST:event_All_ViewMouseMoved

    private void All_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseClicked
        All_View.setBackground(new Color(255,255,0).brighter());
        All_View.setForeground(Color.WHITE);
    }//GEN-LAST:event_All_ViewMouseClicked

    private void All_ViewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseEntered
        All_View.setBackground(new Color(253,229,196).brighter());
        All_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_ViewMouseEntered

    private void All_ViewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseExited
        All_View.setBackground(new Color(253,229,210));
        All_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_ViewMouseExited

    private void All_ViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMousePressed
        All_View.setBackground(new Color(255,255,100).brighter());
        All_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_ViewMousePressed

    private void All_ViewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseReleased
        All_View.setBackground(new Color(253,229,210));
        All_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_ViewMouseReleased

    private void All_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_ViewActionPerformed
        All_View();
        Reset_All();
    }//GEN-LAST:event_All_ViewActionPerformed

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Received_Borrow_List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton All_View;
    private javax.swing.JButton Back;
    private javax.swing.JButton Borrow_ID_Search;
    private javax.swing.JTable Borrow_List;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JButton Reset;
    private javax.swing.JButton Search_within_dates;
    private javax.swing.JButton Student_ID_Search;
    private javax.swing.JTextField author_name;
    private javax.swing.JTextField bk_id;
    private javax.swing.JTextField book_name;
    private javax.swing.JTextField borrow_date;
    private javax.swing.JTextField brw_id;
    private javax.swing.JTextField category_name;
    private javax.swing.JLabel cover_pic;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JTextField department_name;
    private javax.swing.JTextField edition;
    private javax.swing.JTextField email;
    private javax.swing.JTextField gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JLabel jlevel1111;
    private javax.swing.JLabel jlevel1112;
    private javax.swing.JTextField mobile_number;
    private javax.swing.JTextField pending_borrowed;
    private javax.swing.JLabel profile_pic;
    private javax.swing.JTextField released_date;
    private javax.swing.JTextField return_date;
    private javax.swing.JTextField student_id;
    private javax.swing.JTextField student_name;
    private javax.swing.JTextField total_borrowed;
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

    private java.util.Date dateToUtilDate(LocalDate today) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
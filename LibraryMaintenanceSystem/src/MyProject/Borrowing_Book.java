package MyProject;

import JClasses.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.*;
import java.util.logging.*;

/**
 *
 * @author Md. Younus Hosssain Ahsan
 */

public final class Borrowing_Book extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    String Path = null;
    private ImageIcon format = null;
    String Borrow_Date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public Borrowing_Book() throws ClassNotFoundException {
        
        initComponents();
        returnDate();
    }
    
    
    public Borrowing_Book(int Student_id) throws ClassNotFoundException {
        
        initComponents();
        Search_Student_Info(Student_id);
        returnDate();        
    }
    
    
    public void returnDate()
    {
        LocalDate currentDate = LocalDate.now();
        LocalDate dateAfterSevenDays = currentDate.plusDays(7);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return_date.setText(dateAfterSevenDays.format(formatter));
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Borrowing_Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        book.All_the_information_of_a_book(Integer.parseInt(bk_id.getText()));

        book_name.setText(book.getBook_name());
        author_name.setText(book.getAuthor_name());
        department_name.setText(book.getDepartment_name());
        category_name.setText(book.getCategory_name());
        edition.setText(book.getEdition());
        released_date.setText(book.getReleased_date().toString());
        quantity.setText(Integer.toString(bookStock.getQuantity()));
        available.setText(Integer.toString(bookStock.getAvailable()));
        
        format = new ImageIcon(book.getCoverPic());
        cover_pic.setIcon(format);

        availability.setText("*** For this book, less than or equal to " + Integer.toString((int) (bookStock.getQuantity()*0.5)) + " pieces of books can't be borrowed.");
        
    }
    
    
    public void Borrowed_Book_Info(int Student_id) throws ClassNotFoundException
    {
        Borrow borrow = new Borrow();
        borrow.pending_borrow_of_a_student(Student_id);
        borrow.total_borrow_of_a_student(Student_id);
        pending_borrowed.setText(Integer.toString(borrow.getPending_borrowed()));
        total_borrowed.setText(Integer.toString(borrow.getTotal_borrowed()));
    }
    
    
    public void Reset_Student_Info() throws ClassNotFoundException
    {        
        student_id.setText(null);
        student_name.setText(null);
        gender.setText(null);
        email.setText(null);
        mobile_number.setText(null);
        pending_borrowed.setText(null);
        total_borrowed.setText(null);
        profile_pic.setIcon(null);
    }
    
    
    public void Reset_Book_Info() throws ClassNotFoundException
    {        
        bk_id.setText(null);
        book_name.setText(null);
        author_name.setText(null);
        department_name.setText(null);
        category_name.setText(null);
        edition.setText(null);
        released_date.setText(null);
        quantity.setText(null);
        available.setText(null);
        availability.setText(null);
        cover_pic.setIcon(null);
    }
    
    
    public void Borrowing_Confirmation_Send() throws ClassNotFoundException, UnsupportedEncodingException
    {
        BorrowingConfirmation borrowingConfirmation = new BorrowingConfirmation();
        borrowingConfirmation.Set();
        borrowingConfirmation.Find_Recipient(Integer.parseInt(student_id.getText()));
        borrowingConfirmation.Code_Send(Integer.parseInt(bk_id.getText()), return_date.getText());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Student_ID_Search = new javax.swing.JButton();
        Add_a_new = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        total_borrowed = new javax.swing.JTextField();
        jlevel1112 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        return_date = new javax.swing.JTextField();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        pending_borrowed = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        released_date = new javax.swing.JTextField();
        jSeparator22 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        available = new javax.swing.JTextField();
        jSeparator23 = new javax.swing.JSeparator();
        category_name = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        gender = new javax.swing.JTextField();
        profile_pic = new javax.swing.JLabel();
        jlevel1111 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        student_id = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        mobile_number = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        student_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cover_pic = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bk_id = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        author_name = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        book_name = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        department_name = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        edition = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Book_ID_Search = new javax.swing.JButton();
        availability = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        Reset = new javax.swing.JButton();
        Confirm = new javax.swing.JButton();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(Student_ID_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 100, 30));

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
        getContentPane().add(Add_a_new, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 110, 110, 30));

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 625, 100, 35));

        jSeparator10.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 190, 10));

        jSeparator12.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 190, 10));

        jSeparator14.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 150, 10));

        total_borrowed.setEditable(false);
        total_borrowed.setBackground(new java.awt.Color(253, 229, 210));
        total_borrowed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total_borrowed.setBorder(null);
        total_borrowed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_borrowedActionPerformed(evt);
            }
        });
        getContentPane().add(total_borrowed, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 170, 20));

        jlevel1112.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlevel1112.setText("Total Borrowed");
        getContentPane().add(jlevel1112, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 140, -1));

        jSeparator26.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator26.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 170, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Return Date");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, 160, -1));

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
        getContentPane().add(return_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 170, 20));

        jSeparator24.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator24.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, 170, 10));

        jSeparator15.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 190, 10));

        pending_borrowed.setEditable(false);
        pending_borrowed.setBackground(new java.awt.Color(253, 229, 210));
        pending_borrowed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pending_borrowed.setBorder(null);
        pending_borrowed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pending_borrowedActionPerformed(evt);
            }
        });
        getContentPane().add(pending_borrowed, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 180, 170, 20));

        jSeparator16.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator16.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 200, 170, 10));

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
        getContentPane().add(released_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 170, 20));

        jSeparator22.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator22.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 170, 10));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Available");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 90, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("pieces");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 50, -1));

        available.setEditable(false);
        available.setBackground(new java.awt.Color(253, 229, 210));
        available.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        available.setBorder(null);
        available.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableActionPerformed(evt);
            }
        });
        available.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                availableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                availableKeyTyped(evt);
            }
        });
        getContentPane().add(available, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 120, 20));

        jSeparator23.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator23.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 170, 10));

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
        getContentPane().add(category_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 170, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Category");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 90, -1));

        jSeparator21.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator21.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 170, 10));

        gender.setEditable(false);
        gender.setBackground(new java.awt.Color(253, 229, 210));
        gender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gender.setBorder(null);
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        getContentPane().add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 150, 20));

        profile_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/student icon.png"))); // NOI18N
        profile_pic.setToolTipText("Image size: 136*172 px (JPG)");
        profile_pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        profile_pic.setPreferredSize(new java.awt.Dimension(136, 172));
        getContentPane().add(profile_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 138, 172));

        jlevel1111.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlevel1111.setText("Pending Borrowed");
        getContentPane().add(jlevel1111, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 160, 140, -1));

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
        getContentPane().add(student_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 190, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Email");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 90, -1));

        email.setEditable(false);
        email.setBackground(new java.awt.Color(253, 229, 210));
        email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 190, 20));

        mobile_number.setEditable(false);
        mobile_number.setBackground(new java.awt.Color(253, 229, 210));
        mobile_number.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mobile_number.setBorder(null);
        mobile_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile_numberActionPerformed(evt);
            }
        });
        getContentPane().add(mobile_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 150, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 90, -1));

        student_name.setEditable(false);
        student_name.setBackground(new java.awt.Color(253, 229, 210));
        student_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        student_name.setBorder(null);
        student_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_nameActionPerformed(evt);
            }
        });
        getContentPane().add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 190, 20));

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/book icon.gif"))); // NOI18N
        jLabel2.setText(" Borrow Books ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 808, 90));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Mobile Number");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 150, -1));

        cover_pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/book.gif"))); // NOI18N
        cover_pic.setToolTipText("Image size: 136*172 px (JPG)");
        cover_pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        cover_pic.setPreferredSize(new java.awt.Dimension(136, 172));
        getContentPane().add(cover_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 138, 172));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Book ID");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

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
        getContentPane().add(bk_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 170, 20));

        jSeparator17.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator17.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 170, 10));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Author");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 140, -1));

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
        getContentPane().add(author_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 170, 20));

        jSeparator13.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 170, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 180, -1));

        book_name.setEditable(false);
        book_name.setBackground(new java.awt.Color(253, 229, 210));
        book_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        book_name.setBorder(null);
        book_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_nameActionPerformed(evt);
            }
        });
        getContentPane().add(book_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 170, 20));

        jSeparator11.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator11.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 170, 10));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Department");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 90, -1));

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
        getContentPane().add(department_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 170, 20));

        jSeparator18.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator18.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 170, 10));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Edition");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 90, -1));

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
        getContentPane().add(edition, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 170, 20));

        jSeparator19.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator19.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 170, 10));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Quantity (total)");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 140, -1));

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
        getContentPane().add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 120, 20));

        jSeparator20.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator20.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 170, 10));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("pieces");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 50, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Released Date");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 160, -1));

        Book_ID_Search.setBackground(new java.awt.Color(253, 229, 210));
        Book_ID_Search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Book_ID_Search.setText("Search");
        Book_ID_Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Book_ID_Search.setContentAreaFilled(false);
        Book_ID_Search.setOpaque(true);
        Book_ID_Search.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Book_ID_SearchMouseMoved(evt);
            }
        });
        Book_ID_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Book_ID_SearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Book_ID_SearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Book_ID_SearchMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Book_ID_SearchMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Book_ID_SearchMouseReleased(evt);
            }
        });
        Book_ID_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Book_ID_SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Book_ID_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 100, 30));

        availability.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        availability.setForeground(new java.awt.Color(102, 0, 0));
        getContentPane().add(availability, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 550, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("*** The borrowed book must be returned within one week of the borrowed date.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 550, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("*** Any book having less than or equal to 50% of the total available can't be borrowed.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 550, 20));

        jSeparator25.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator25.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 150, 10));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Gender");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 90, -1));

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
        getContentPane().add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 625, 100, 35));

        Confirm.setBackground(new java.awt.Color(253, 229, 210));
        Confirm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Confirm.setText("Confirm");
        Confirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        Confirm.setContentAreaFilled(false);
        Confirm.setOpaque(true);
        Confirm.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ConfirmMouseMoved(evt);
            }
        });
        Confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ConfirmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ConfirmMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ConfirmMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ConfirmMouseReleased(evt);
            }
        });
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(Confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 625, 100, 35));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg.png"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 808, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void mobile_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobile_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile_numberActionPerformed

    private void student_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_nameActionPerformed

    private void student_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_student_idKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_student_idKeyTyped

    private void student_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_idMouseClicked
        try {
            Reset_Student_Info();
        } catch (ClassNotFoundException ex) {}
    }//GEN-LAST:event_student_idMouseClicked

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void bk_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bk_idKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_bk_idKeyTyped

    private void author_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_author_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_author_nameActionPerformed

    private void author_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_author_nameKeyReleased
        
    }//GEN-LAST:event_author_nameKeyReleased

    private void book_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_book_nameActionPerformed

    private void department_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_nameActionPerformed

    private void department_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_department_nameKeyReleased
        
    }//GEN-LAST:event_department_nameKeyReleased

    private void editionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editionMouseClicked
        edition.setText("");
    }//GEN-LAST:event_editionMouseClicked

    private void editionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editionActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased

    }//GEN-LAST:event_quantityKeyReleased

    private void quantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
        evt.consume();
    }//GEN-LAST:event_quantityKeyTyped

    private void Book_ID_SearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Book_ID_SearchMouseMoved
        Book_ID_Search.setCursor(SignIN.cursor);
    }//GEN-LAST:event_Book_ID_SearchMouseMoved

    private void Book_ID_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Book_ID_SearchMouseClicked
        Book_ID_Search.setBackground(new Color(255,255,0).brighter());
        Book_ID_Search.setForeground(Color.WHITE);
    }//GEN-LAST:event_Book_ID_SearchMouseClicked

    private void Book_ID_SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Book_ID_SearchMouseEntered
        Book_ID_Search.setBackground(new Color(253,229,196).brighter());
        Book_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Book_ID_SearchMouseEntered

    private void Book_ID_SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Book_ID_SearchMouseExited
        Book_ID_Search.setBackground(new Color(253,229,210));
        Book_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Book_ID_SearchMouseExited

    private void Book_ID_SearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Book_ID_SearchMousePressed
        Book_ID_Search.setBackground(new Color(255,255,100).brighter());
        Book_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Book_ID_SearchMousePressed

    private void Book_ID_SearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Book_ID_SearchMouseReleased
        Book_ID_Search.setBackground(new Color(253,229,210));
        Book_ID_Search.setForeground(Color.BLACK);
    }//GEN-LAST:event_Book_ID_SearchMouseReleased

    private void Book_ID_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Book_ID_SearchActionPerformed
        
        if(bk_id.getText().trim().equals(""))
        {JOptionPane.showMessageDialog(null, "Enter the book id !!!");}
        else
        {
            Book book = new Book();
            book.id_search(Integer.parseInt(bk_id.getText()));
            
            if(book.getFound() == 0)
            {JOptionPane.showMessageDialog(null, "Not found !!!");}
            else
            {
                try {
                    Search_Book_Info();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Borrowing_Book.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_Book_ID_SearchActionPerformed

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

    private void availableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_availableActionPerformed

    private void availableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_availableKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_availableKeyReleased

    private void availableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_availableKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_availableKeyTyped

    private void return_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_return_dateActionPerformed

    private void return_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_return_dateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_return_dateKeyReleased

    private void pending_borrowedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pending_borrowedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pending_borrowedActionPerformed

    private void bk_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bk_idMouseClicked
        try {
            Reset_Book_Info();
        } catch (ClassNotFoundException ex) {}
    }//GEN-LAST:event_bk_idMouseClicked

    private void total_borrowedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_borrowedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_borrowedActionPerformed

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
            JOptionPane.showMessageDialog(null, "Enter the student id !!!");
        }
        else{
            
            Student student = new Student();
            try {
                student.id_search(Integer.parseInt(student_id.getText()));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Borrowing_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(student.getFound() == 0)
            {JOptionPane.showMessageDialog(null, "Not found !!!");}
            else
            {
                try {
                    Search_Student_Info(Integer.parseInt(student_id.getText()));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Borrowing_Book.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }//GEN-LAST:event_Student_ID_SearchActionPerformed

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
            new New_Student("Borrowing Book").setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_Add_a_newActionPerformed

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
        try {
            Reset_Student_Info();
            Reset_Book_Info();
        } catch (ClassNotFoundException ex) {}
    }//GEN-LAST:event_ResetActionPerformed

    private void ConfirmMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseMoved
        Confirm.setCursor(SignIN.cursor);
    }//GEN-LAST:event_ConfirmMouseMoved

    private void ConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseClicked
        Confirm.setBackground(new Color(255,255,0).brighter());
        Confirm.setForeground(Color.WHITE);
    }//GEN-LAST:event_ConfirmMouseClicked

    private void ConfirmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseEntered
        Confirm.setBackground(new Color(253,229,196).brighter());
        Confirm.setForeground(Color.BLACK);
    }//GEN-LAST:event_ConfirmMouseEntered

    private void ConfirmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseExited
        Confirm.setBackground(new Color(253,229,210));
        Confirm.setForeground(Color.BLACK);
    }//GEN-LAST:event_ConfirmMouseExited

    private void ConfirmMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMousePressed
        Confirm.setBackground(new Color(255,255,100).brighter());
        Confirm.setForeground(Color.BLACK);
    }//GEN-LAST:event_ConfirmMousePressed

    private void ConfirmMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseReleased
        Confirm.setBackground(new Color(253,229,210));
        Confirm.setForeground(Color.BLACK);
    }//GEN-LAST:event_ConfirmMouseReleased

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
            
        if(student_id.getText().trim().equals("") && bk_id.getText().trim().equals("")){  
            JOptionPane.showMessageDialog(null, "Enter all the information !!!");
        }
        else if(student_id.getText().trim().equals("") || student_name.getText().trim().equals("")){  
            JOptionPane.showMessageDialog(null, "Enter the student info !!!");
        }
        else if(bk_id.getText().trim().equals("") || book_name.getText().trim().equals("")){  
            JOptionPane.showMessageDialog(null, "Select a book !!!");
        }
        else if(Integer.parseInt(pending_borrowed.getText()) == 3)
        {
            JOptionPane.showMessageDialog(null, "More than three books can't be borrowed !!!");
        }
        else
        {
            BookStock bookStock = new BookStock();
            Borrow borrow = new Borrow();
            Date CurrentDate = new Date();
            Borrow_Date = sdf.format(CurrentDate);
            
            try {                 
                bookStock.quantity_from_bk_id(Integer.parseInt(bk_id.getText()));
                
                if(Integer.parseInt(available.getText()) > (int) (bookStock.getQuantity()*0.5))
                {
                    borrow.insert_into_borrow(Integer.parseInt(student_id.getText()), Integer.parseInt(bk_id.getText()), Borrow_Date);
                    bookStock.increase_the_amount_of_borrowed_book(Integer.parseInt(bk_id.getText()));
                    
                    Borrowing_Confirmation_Send();
                    Borrowed_Book_Info(Integer.parseInt(student_id.getText()));
                    Reset_Book_Info();
                    JOptionPane.showMessageDialog(null, "Succesfully done !!!"); 
                }
                else
                   JOptionPane.showMessageDialog(null, "Insufficient amount books to borrow !!!"); 
            
            } catch (ClassNotFoundException ex) {} catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Borrowing_Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_ConfirmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Borrowing_Book().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Borrowing_Book.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_a_new;
    private javax.swing.JButton Back;
    private javax.swing.JButton Book_ID_Search;
    private javax.swing.JButton Confirm;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JButton Reset;
    private javax.swing.JButton Student_ID_Search;
    private javax.swing.JTextField author_name;
    private javax.swing.JLabel availability;
    private javax.swing.JTextField available;
    private javax.swing.JTextField bk_id;
    private javax.swing.JTextField book_name;
    private javax.swing.JTextField category_name;
    private javax.swing.JLabel cover_pic;
    private javax.swing.JTextField department_name;
    private javax.swing.JTextField edition;
    private javax.swing.JTextField email;
    private javax.swing.JTextField gender;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JLabel jlevel1111;
    private javax.swing.JLabel jlevel1112;
    private javax.swing.JTextField mobile_number;
    private javax.swing.JTextField pending_borrowed;
    private javax.swing.JLabel profile_pic;
    private javax.swing.JTextField quantity;
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
}
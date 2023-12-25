create database library_maintenance_system



CREATE TABLE User_Info (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    mobile_number VARCHAR(15) NOT NULL,
	profile_pic BLOB
) AUTO_INCREMENT = 100001;



CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    mobile_number VARCHAR(15) NOT NULL,
	email VARCHAR(100) NOT NULL,
	profile_pic BLOB
);



CREATE TABLE Department (
    dept_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL
) AUTO_INCREMENT = 101;



CREATE TABLE Category (
    ctg_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES Department(dept_id)
) AUTO_INCREMENT = 1001;



CREATE TABLE Author (
    auth_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
) AUTO_INCREMENT = 101;



CREATE TABLE Book (
    bk_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	ctg_id INT,
	auth_id INT,
    edition VARCHAR(50) NOT NULL,
    released_date DATE,
	cover_pic BLOB,
	FOREIGN KEY (ctg_id) REFERENCES Category(ctg_id),
	FOREIGN KEY (auth_id) REFERENCES Author(auth_id)
) AUTO_INCREMENT = 10001;



CREATE TABLE Book_stock (
    bk_id INT,
	total INT,
	borrowed INT,
	FOREIGN KEY (bk_id) REFERENCES Book(bk_id)
);



CREATE TABLE Borrow (
    brw_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,    
    bk_id INT,
    borrow_date DATE,
    return_date DATE,
    brw_type VARCHAR(20) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES Student(student_id),    
    FOREIGN KEY (bk_id) REFERENCES Book(bk_id)
) AUTO_INCREMENT = 101;


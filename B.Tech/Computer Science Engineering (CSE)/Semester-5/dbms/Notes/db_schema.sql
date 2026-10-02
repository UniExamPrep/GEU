CREATE DATABASE IF NOT EXISTS dbms_lab;
USE dbms_lab;
DROP TABLE IF EXISTS register;
DROP TABLE IF EXISTS program;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS salary_audit;
DROP TABLE IF EXISTS bills;
DROP TABLE IF EXISTS tests;
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS wards;
DROP TABLE IF EXISTS consultants;
DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS employee_department;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS employee;
CREATE TABLE wards(
  ward_id INT PRIMARY KEY AUTO_INCREMENT,
  ward_name VARCHAR(100) NOT NULL,
  ward_type VARCHAR(50)
);
CREATE TABLE doctors(
  doctor_id INT PRIMARY KEY AUTO_INCREMENT,
  doctor_name VARCHAR(100) NOT NULL,
  specialty VARCHAR(100)
);
CREATE TABLE consultants(
  consultant_id INT PRIMARY KEY AUTO_INCREMENT,
  consultant_name VARCHAR(100) NOT NULL,
  specialty VARCHAR(100)
);
CREATE TABLE patients(
  patient_id INT PRIMARY KEY AUTO_INCREMENT,
  patient_name VARCHAR(100) NOT NULL,
  age INT,
  gender VARCHAR(10),
  address VARCHAR(255),
  contact VARCHAR(50),
  ward_id INT,
  consultant_id INT,
  lead_consultant_id INT,
  FOREIGN KEY (ward_id) REFERENCES wards(ward_id) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (consultant_id) REFERENCES consultants(consultant_id) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (lead_consultant_id) REFERENCES consultants(consultant_id) ON DELETE SET NULL ON UPDATE CASCADE
);
CREATE TABLE tests(
  test_id INT PRIMARY KEY AUTO_INCREMENT,
  patient_id INT,
  test_name VARCHAR(100),
  test_date DATE,
  result VARCHAR(255),
  FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE bills(
  bill_id INT PRIMARY KEY AUTO_INCREMENT,
  patient_id INT,
  amount DECIMAL(10,2) DEFAULT 0,
  bill_date DATE,
  FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE employee(
  emp_id INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  department VARCHAR(100),
  age INT CHECK (age>18),
  salary DECIMAL(12,2),
  city VARCHAR(100)
);
CREATE TABLE department(
  dept_id INT PRIMARY KEY,
  dept_name VARCHAR(100) UNIQUE NOT NULL
);
CREATE TABLE employee_department(
  emp_id INT,
  dept_id INT,
  PRIMARY KEY(emp_id,dept_id),
  FOREIGN KEY(emp_id) REFERENCES employee(emp_id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY(dept_id) REFERENCES department(dept_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE customer(
  customer_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  age INT,
  address VARCHAR(255),
  city VARCHAR(100)
);
CREATE TABLE orders(
  order_id INT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT,
  order_date DATE,
  order_city VARCHAR(100),
  FOREIGN KEY(customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE student(
  roll_no INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  city VARCHAR(100)
);
CREATE TABLE program(
  program_id INT PRIMARY KEY,
  program_name VARCHAR(100) NOT NULL,
  fee DECIMAL(12,2) CHECK (fee>=10000),
  department VARCHAR(100)
);
CREATE TABLE register(
  program_id INT,
  roll_no INT,
  PRIMARY KEY(program_id,roll_no),
  FOREIGN KEY(program_id) REFERENCES program(program_id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY(roll_no) REFERENCES student(roll_no) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE salary_audit(
  audit_id INT PRIMARY KEY AUTO_INCREMENT,
  emp_id INT,
  old_salary DECIMAL(12,2),
  new_salary DECIMAL(12,2),
  diff DECIMAL(12,2),
  changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

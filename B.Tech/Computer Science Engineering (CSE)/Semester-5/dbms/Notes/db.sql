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
TRUNCATE TABLE wards;
TRUNCATE TABLE doctors;
TRUNCATE TABLE consultants;
TRUNCATE TABLE patients;
TRUNCATE TABLE tests;
TRUNCATE TABLE bills;
TRUNCATE TABLE employee;
TRUNCATE TABLE department;
TRUNCATE TABLE employee_department;
TRUNCATE TABLE customer;
TRUNCATE TABLE orders;
TRUNCATE TABLE student;
TRUNCATE TABLE program;
TRUNCATE TABLE register;
TRUNCATE TABLE salary_audit;
INSERT INTO wards(ward_name,ward_type) VALUES('General Ward','General'),('Emergency Ward','Emergency'),('Pediatrics','Specific');
INSERT INTO doctors(doctor_name,specialty) VALUES('Dr A Sharma','Cardiology'),('Dr B Singh','Orthopedics'),('Dr C Rao','Pediatrics');
INSERT INTO consultants(consultant_name,specialty) VALUES('Dr X Verma','Cardiology'),('Dr Y Gupta','General Medicine');
INSERT INTO patients(patient_name,age,gender,address,contact,ward_id,consultant_id,lead_consultant_id) VALUES('Amit Kumar',30,'M','Delhi','9999999999',1,1,1),('Neha Gupta',22,'F','Pune','8888888888',2,2,2),('Rohit Sen',45,'M','Delhi','7777777777',1,1,2);
INSERT INTO tests(patient_id,test_name,test_date,result) VALUES(1,'Blood Test','2025-12-01','Normal'),(1,'X-Ray','2025-12-02','Clear'),(2,'MRI','2025-12-03','Findings');
INSERT INTO bills(patient_id,amount,bill_date) VALUES(1,1500.00,'2025-12-05'),(2,2500.00,'2025-12-06');
INSERT INTO employee(emp_id,name,department,age,salary,city) VALUES(2001,'aditya', 'Finance',22,55000,'Delhi'),(2002,'harsh', 'CSE',28,30000,'Pune'),(2003,'ayush', 'CSE',26,18000,'Delhi'),(2004,'raj', 'HR',35,45000,'Pune'),(2005,'sam', 'Finance',22,60000,'Delhi');
INSERT INTO department(dept_id,dept_name) VALUES(1,'CSE'),(2,'Finance'),(3,'HR');
INSERT INTO employee_department(emp_id,dept_id) VALUES(2002,1),(2003,1),(2001,2),(2005,2),(2004,3);
INSERT INTO customer(name,age,address,city) VALUES('Karan',30,'Delhi street','Delhi'),('Priya',25,'Pune lane','Pune'),('Sameer',28,'Mumbai road','Mumbai');
INSERT INTO orders(customer_id,order_date,order_city) VALUES(1,'2025-12-10','Delhi'),(2,'2025-12-11','Pune');
INSERT INTO student(roll_no,name,city) VALUES(101,'Ritu','Delhi'),(102,'Aman','Pune'),(103,'Sneha','Delhi');
INSERT INTO program(program_id,program_name,fee,department) VALUES(1,'MCA',30000,'CSE'),(2,'BSc',15000,'Science');
INSERT INTO register(program_id,roll_no) VALUES(1,101),(1,102);
DROP USER IF EXISTS 'labuser'@'localhost';
CREATE USER 'labuser'@'localhost' IDENTIFIED BY 'labpass';
GRANT SELECT,INSERT,UPDATE,DELETE ON dbms_lab.* TO 'labuser'@'localhost';
REVOKE INSERT ON dbms_lab.* FROM 'labuser'@'localhost';
DELIMITER //
CREATE TRIGGER before_employee_insert BEFORE INSERT ON employee FOR EACH ROW
BEGIN
  SET NEW.name = UPPER(NEW.name);
END;//
CREATE TRIGGER before_employee_update BEFORE UPDATE ON employee FOR EACH ROW
BEGIN
  SET NEW.name = UPPER(NEW.name);
END;//
CREATE TRIGGER after_employee_change AFTER UPDATE ON employee FOR EACH ROW
BEGIN
  INSERT INTO salary_audit(emp_id,old_salary,new_salary,diff) VALUES(NEW.emp_id,IFNULL(OLD.salary,0),NEW.salary,NEW.salary-IFNULL(OLD.salary,0));
END;//
CREATE TRIGGER after_employee_insert AFTER INSERT ON employee FOR EACH ROW
BEGIN
  INSERT INTO salary_audit(emp_id,old_salary,new_salary,diff) VALUES(NEW.emp_id,0,NEW.salary,NEW.salary);
END;//
CREATE TRIGGER after_employee_delete AFTER DELETE ON employee FOR EACH ROW
BEGIN
  INSERT INTO salary_audit(emp_id,old_salary,new_salary,diff) VALUES(OLD.emp_id,OLD.salary,0,-OLD.salary);
END;//
DELIMITER ;
START TRANSACTION;
INSERT INTO employee(emp_id,name,department,age,salary,city) VALUES(2010,'temp1','Temp',29,12000,'Bengaluru'),(2011,'temp2','Temp',31,13000,'Bengaluru'),(2012,'temp3','Temp',27,11000,'Bengaluru'),(2013,'temp4','Temp',26,14000,'Bengaluru'),(2014,'temp5','Temp',28,15000,'Bengaluru');
ROLLBACK;
ALTER TABLE employee ADD COLUMN status VARCHAR(20) DEFAULT 'active';
ALTER TABLE employee ADD UNIQUE KEY unique_emp_name (name);
INSERT INTO employee(emp_id,name,department,age,salary,city,status) VALUES(3001,'haj','CSE',24,16000,'Delhi','active') ON DUPLICATE KEY UPDATE name=VALUES(name);
SELECT COUNT(*) AS total_employees FROM employee;
SELECT * FROM employee WHERE age=22;
SELECT emp_id,name,department FROM employee WHERE salary>=50000;
SELECT name AS "Full Name" FROM employee WHERE department='Finance' AND age=22;
SELECT DISTINCT department FROM employee;
SELECT MAX(salary) AS max_salary, MIN(salary) AS min_salary FROM employee;
SELECT SUM(salary) AS total_salary, AVG(salary) AS avg_salary FROM employee;
SELECT * FROM employee e1 WHERE EXISTS (SELECT 1 FROM employee e2 WHERE e2.salary=e1.salary AND e2.emp_id<>e1.emp_id);
SELECT name FROM employee ORDER BY salary ASC;
SELECT name,salary FROM employee WHERE salary>=10000 AND age>25 ORDER BY department;
SELECT * FROM employee WHERE city IN ('Delhi','Pune');
SELECT name,department FROM employee WHERE emp_id BETWEEN 2001 AND 2005;
SELECT name FROM employee WHERE city IN (SELECT city FROM employee GROUP BY city HAVING COUNT(*)>1);
SELECT * FROM employee WHERE city = ALL (SELECT city FROM employee);
SELECT * FROM employee WHERE city = ANY (SELECT city FROM employee);
SELECT EXISTS(SELECT 1 FROM employee WHERE city='Delhi') AS any_delhi_exists;
SELECT * FROM employee WHERE department='CSE';
SELECT name FROM employee WHERE name LIKE 'ay%';
SELECT name,department FROM employee WHERE name LIKE '%sh';
SELECT name,department FROM employee WHERE city LIKE 'D%' OR city LIKE '%h';
SELECT * FROM employee WHERE salary>15000 AND name LIKE 'h%';
SELECT name FROM employee WHERE CHAR_LENGTH(name)=3;
SELECT name,city FROM employee WHERE CHAR_LENGTH(name)>=5;
CREATE TABLE employee_join_temp AS SELECT e.emp_id,e.name,e.department,e.age,e.salary,e.city,d.dept_name FROM employee e LEFT JOIN department d ON e.department=d.dept_name;
SELECT ejt.name,ejt.dept_name FROM employee ejt JOIN department d ON ejt.department=d.dept_name;
SELECT name FROM employee WHERE emp_id NOT IN (SELECT emp_id FROM employee_department);
SELECT ej.name, d.dept_name FROM employee ej LEFT JOIN department d ON ej.department=d.dept_name WHERE ej.salary>25000;
SELECT d.dept_name, COUNT(DISTINCT p.program_id) AS projects_managed, COUNT(DISTINCT ed.emp_id) AS employees_assigned FROM department d LEFT JOIN program p ON d.dept_name=p.department LEFT JOIN employee_department ed ON ed.dept_id=d.dept_id GROUP BY d.dept_name;
SELECT customer.name AS destination FROM customer INNER JOIN orders o ON customer.customer_id=o.customer_id;
SELECT * FROM customer CROSS JOIN orders;
SELECT customer.name,orders.order_id FROM customer JOIN orders ON customer.customer_id=orders.customer_id WHERE customer.city=orders.order_city;
SELECT s.name, r.program_id FROM student s JOIN register r ON s.roll_no=r.roll_no WHERE r.program_id=(SELECT program_id FROM program WHERE program_name='MCA' LIMIT 1);
SELECT DISTINCT s.* FROM student s JOIN register r ON s.roll_no=r.roll_no;
SELECT * FROM program WHERE fee > (SELECT AVG(fee) FROM program);
SELECT s.name FROM student s JOIN register r ON s.roll_no=r.roll_no JOIN program p ON p.program_id=r.program_id WHERE p.fee<30000;
SELECT * FROM student WHERE roll_no NOT IN (SELECT roll_no FROM register);
SELECT program.program_name FROM program JOIN register r ON program.program_id=r.program_id GROUP BY program.program_id ORDER BY COUNT(r.roll_no) DESC LIMIT 1;
SELECT program.program_name FROM program LEFT JOIN register r ON program.program_id=r.program_id GROUP BY program.program_id ORDER BY COUNT(r.roll_no) ASC LIMIT 1;
SELECT DISTINCT salary FROM employee ORDER BY salary ASC LIMIT 1,1;
SELECT MIN(salary) FROM employee WHERE salary>(SELECT MIN(salary) FROM employee);
SELECT * FROM (
  SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk FROM employee
) t WHERE rnk=3;
SELECT name,salary FROM employee e1 WHERE salary > (SELECT AVG(salary) FROM employee e2 WHERE e2.department=e1.department);
SELECT e1.name FROM employee e1 JOIN employee e2 ON e1.department=e2.department WHERE e1.salary < e2.salary;
SELECT e1.name FROM employee e1 JOIN employee e2 ON e1.department=e2.department WHERE e1.age>e2.age;
INSERT INTO employee(emp_id,name,department,age,salary,city) VALUES(4001,'trial','Temp',29,20000,'Delhi') ON DUPLICATE KEY UPDATE name=VALUES(name);
UPDATE employee SET salary=salary+1000 WHERE emp_id=4001;
DELETE FROM employee WHERE emp_id=4001;
SELECT * FROM salary_audit ORDER BY changed_at DESC;
SELECT * FROM wards;
SELECT * FROM doctors;
SELECT * FROM patients;
SELECT * FROM tests;
SELECT * FROM bills;
SELECT * FROM program;
SELECT * FROM register;

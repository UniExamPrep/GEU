CREATE DATABASE EmployeeDB;
USE EmployeeDB;
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Department VARCHAR(50),
    Age INT CHECK (Age > 18),
    Salary DECIMAL(10,2),
    City VARCHAR(50)
);
INSERT INTO Employee VALUES 
(1, 'John Smith', 'Finance', 25, 55000.00, 'New York'),
(2, 'Sarah Johnson', 'IT', 28, 65000.00, 'Los Angeles'),
(3, 'Michael Brown', 'Finance', 22, 50000.00, 'Chicago'),
(4, 'Emily Davis', 'HR', 30, 58000.00, 'Houston'),
(5, 'Robert Wilson', 'IT', 35, 75000.00, 'Phoenix'),
(6, 'Lisa Anderson', 'Finance', 22, 52000.00, 'Philadelphia'),
(7, 'David Taylor', 'Marketing', 26, 60000.00, 'San Antonio'),
(8, 'Jennifer Martinez', 'IT', 29, 68000.00, 'San Diego'),
(9, 'Christopher Garcia', 'Finance', 24, 54000.00, 'Dallas'),
(10, 'Amanda Rodriguez', 'HR', 32, 62000.00, 'San Jose'),
(11, 'James Lee', 'Marketing', 27, 59000.00, 'Austin'),
(12, 'Michelle White', 'IT', 31, 72000.00, 'Jacksonville'),
(13, 'Daniel Harris', 'Finance', 23, 51000.00, 'Fort Worth'),
(14, 'Ashley Clark', 'HR', 28, 60000.00, 'Columbus'),
(15, 'Matthew Lewis', 'Marketing', 33, 64000.00, 'Charlotte'),
(16, 'Jessica Walker', 'IT', 26, 66000.00, 'Seattle'),
(17, 'Andrew Hall', 'Finance', 22, 50000.00, 'Denver'),
(18, 'Samantha Young', 'HR', 29, 61000.00, 'Washington'),
(19, 'Kevin King', 'Marketing', 34, 67000.00, 'Boston'),
(20, 'Nicole Wright', 'IT', 25, 63000.00, 'El Paso');
SELECT COUNT(*) AS TotalEmployees FROM Employee;
SELECT * FROM Employee WHERE Age = 22;
SELECT EmployeeID, Name, Department FROM Employee WHERE Salary >= 50000;
SELECT Name AS "Full Name" FROM Employee WHERE Department = 'Finance' AND Age = 22;
SELECT DISTINCT Department FROM Employee;

CREATE DATABASE CompanyDB;
USE CompanyDB;

CREATE USER 'testuser'@'localhost' IDENTIFIED BY 'password123';
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'adminpass';

GRANT SELECT, INSERT, UPDATE ON CompanyDB.* TO 'testuser'@'localhost';
GRANT ALL PRIVILEGES ON CompanyDB.* TO 'admin'@'localhost';

SHOW GRANTS FOR 'testuser'@'localhost';
SHOW GRANTS FOR 'admin'@'localhost';

REVOKE UPDATE ON CompanyDB.* FROM 'testuser'@'localhost';
REVOKE ALL PRIVILEGES ON CompanyDB.* FROM 'admin'@'localhost';

CREATE TABLE Departments (
    DeptID INT PRIMARY KEY,
    DeptName VARCHAR(50) NOT NULL,
    Location VARCHAR(100),
    Budget DECIMAL(12,2)
);

CREATE TABLE Employees (
    EmpID INT PRIMARY KEY,
    EmpName VARCHAR(100) NOT NULL,
    Department VARCHAR(50),
    Salary DECIMAL(10,2),
    HireDate DATE
);

CREATE TABLE Projects (
    ProjectID INT PRIMARY KEY,
    ProjectName VARCHAR(100) NOT NULL,
    StartDate DATE,
    EndDate DATE,
    Budget DECIMAL(12,2)
);

CREATE TABLE Assignments (
    AssignmentID INT PRIMARY KEY,
    EmpID INT,
    ProjectID INT,
    Role VARCHAR(50),
    FOREIGN KEY (EmpID) REFERENCES Employees(EmpID),
    FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID)
);

CREATE TABLE Salaries (
    SalaryID INT PRIMARY KEY,
    EmpID INT,
    Amount DECIMAL(10,2),
    PayDate DATE,
    FOREIGN KEY (EmpID) REFERENCES Employees(EmpID)
);

START TRANSACTION;

INSERT INTO Departments VALUES 
(1, 'IT', 'Building A', 500000.00),
(2, 'HR', 'Building B', 200000.00),
(3, 'Finance', 'Building C', 300000.00),
(4, 'Marketing', 'Building D', 400000.00),
(5, 'Operations', 'Building E', 350000.00);

INSERT INTO Employees VALUES 
(101, 'John Doe', 'IT', 75000.00, '2023-01-15'),
(102, 'Jane Smith', 'HR', 65000.00, '2023-02-20'),
(103, 'Mike Johnson', 'Finance', 70000.00, '2023-03-10'),
(104, 'Sarah Wilson', 'Marketing', 68000.00, '2023-04-05'),
(105, 'David Brown', 'Operations', 72000.00, '2023-05-12');

INSERT INTO Projects VALUES 
(201, 'Website Redesign', '2024-01-01', '2024-06-30', 100000.00),
(202, 'HR System Upgrade', '2024-02-01', '2024-08-31', 150000.00),
(203, 'Financial Analysis Tool', '2024-03-01', '2024-09-30', 200000.00),
(204, 'Marketing Campaign', '2024-04-01', '2024-07-31', 120000.00),
(205, 'Operations Optimization', '2024-05-01', '2024-10-31', 180000.00);

INSERT INTO Assignments VALUES 
(301, 101, 201, 'Lead Developer'),
(302, 102, 202, 'Project Manager'),
(303, 103, 203, 'Financial Analyst'),
(304, 104, 204, 'Marketing Specialist'),
(305, 105, 205, 'Operations Manager');

INSERT INTO Salaries VALUES 
(401, 101, 75000.00, '2024-01-31'),
(402, 102, 65000.00, '2024-01-31'),
(403, 103, 70000.00, '2024-01-31'),
(404, 104, 68000.00, '2024-01-31'),
(405, 105, 72000.00, '2024-01-31');

ROLLBACK;

CREATE TABLE TestConstraints (
    ID INT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Age INT CHECK (Age > 18),
    Email VARCHAR(100) UNIQUE,
    Salary DECIMAL(10,2) DEFAULT 50000.00,
    Department VARCHAR(50) DEFAULT 'General'
);

INSERT INTO TestConstraints VALUES 
(1, 'Alice Johnson', 25, 'alice@company.com', 60000.00, 'IT'),
(2, 'Bob Smith', 30, 'bob@company.com', 55000.00, 'HR'),
(3, 'Carol Brown', 22, 'carol@company.com', 52000.00, 'Finance'),
(4, 'David Wilson', 28, 'david@company.com', 58000.00, 'Marketing'),
(5, 'Eva Davis', 35, 'eva@company.com', 65000.00, 'Operations');

INSERT INTO TestConstraints (ID, Name, Age, Email) VALUES 
(6, 'Frank Miller', 26, 'frank@company.com');

INSERT INTO TestConstraints (ID, Name, Age, Email, Salary) VALUES 
(7, 'Grace Taylor', 24, 'grace@company.com', 48000.00);

INSERT INTO TestConstraints VALUES 
(8, NULL, 27, 'test@company.com', 50000.00, 'IT');

INSERT INTO TestConstraints VALUES 
(9, 'John Doe', 19, 'alice@company.com', 50000.00, 'IT');

INSERT INTO TestConstraints VALUES 
(10, 'Jane Smith', 15, 'jane@company.com', 50000.00, 'HR');

ALTER TABLE TestConstraints ADD CONSTRAINT PK_TestConstraints PRIMARY KEY (ID);

INSERT INTO TestConstraints VALUES 
(1, 'Duplicate ID', 25, 'duplicate@company.com', 50000.00, 'IT');

DROP TABLE TestConstraints;
DROP TABLE Salaries;
DROP TABLE Assignments;
DROP TABLE Projects;
DROP TABLE Employees;
DROP TABLE Departments;
DROP USER 'testuser'@'localhost';
DROP USER 'admin'@'localhost';
DROP DATABASE CompanyDB;

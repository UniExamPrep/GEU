CREATE DATABASE HospitalDB;
USE HospitalDB;

CREATE TABLE Wards (
    WardID INT PRIMARY KEY,
    WardName VARCHAR(50) NOT NULL,
    WardType VARCHAR(30),
    Capacity INT,
    FloorNumber INT
);

CREATE TABLE Doctors (
    DoctorID INT PRIMARY KEY,
    DoctorName VARCHAR(100) NOT NULL,
    Specialization VARCHAR(50),
    Experience INT,
    Phone VARCHAR(15),
    Email VARCHAR(100)
);

CREATE TABLE Patients (
    PatientID INT PRIMARY KEY,
    PatientName VARCHAR(100) NOT NULL,
    Age INT,
    Gender VARCHAR(10),
    Phone VARCHAR(15),
    Address VARCHAR(200),
    WardID INT,
    DoctorID INT,
    FOREIGN KEY (WardID) REFERENCES Wards(WardID),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
);

CREATE TABLE Bills (
    BillID INT PRIMARY KEY,
    PatientID INT,
    DoctorID INT,
    BillDate DATE,
    TotalAmount DECIMAL(10,2),
    PaymentStatus VARCHAR(20),
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
);

CREATE TABLE MedicalRecords (
    RecordID INT PRIMARY KEY,
    PatientID INT,
    DoctorID INT,
    Diagnosis VARCHAR(200),
    Treatment VARCHAR(200),
    RecordDate DATE,
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
);

INSERT INTO Wards VALUES 
(1, 'General Ward A', 'General', 20, 1),
(2, 'ICU Ward', 'Intensive Care', 8, 2),
(3, 'Pediatric Ward', 'Pediatric', 15, 1),
(4, 'Cardiology Ward', 'Cardiology', 12, 3),
(5, 'Emergency Ward', 'Emergency', 10, 1);

INSERT INTO Doctors VALUES 
(101, 'Dr. John Smith', 'Cardiology', 15, '555-0101', 'john.smith@hospital.com'),
(102, 'Dr. Sarah Johnson', 'Pediatrics', 10, '555-0102', 'sarah.johnson@hospital.com'),
(103, 'Dr. Michael Brown', 'General Medicine', 20, '555-0103', 'michael.brown@hospital.com'),
(104, 'Dr. Emily Davis', 'Neurology', 12, '555-0104', 'emily.davis@hospital.com'),
(105, 'Dr. Robert Wilson', 'Emergency Medicine', 8, '555-0105', 'robert.wilson@hospital.com');

INSERT INTO Patients VALUES 
(1001, 'Alice Johnson', 35, 'Female', '555-1001', '123 Main St', 1, 103),
(1002, 'Bob Smith', 28, 'Male', '555-1002', '456 Oak Ave', 2, 101),
(1003, 'Carol Brown', 45, 'Female', '555-1003', '789 Pine Rd', 3, 102),
(1004, 'David Wilson', 52, 'Male', '555-1004', '321 Elm St', 4, 101),
(1005, 'Eva Davis', 30, 'Female', '555-1005', '654 Maple Dr', 1, 103),
(1006, 'Frank Miller', 67, 'Male', '555-1006', '987 Cedar Ln', 2, 104),
(1007, 'Grace Taylor', 25, 'Female', '555-1007', '147 Birch St', 3, 102),
(1008, 'Henry Anderson', 40, 'Male', '555-1008', '258 Spruce Ave', 5, 105);

INSERT INTO Bills VALUES 
(2001, 1001, 103, '2024-01-15', 2500.00, 'Paid'),
(2002, 1002, 101, '2024-01-16', 4500.00, 'Pending'),
(2003, 1003, 102, '2024-01-17', 1800.00, 'Paid'),
(2004, 1004, 101, '2024-01-18', 3200.00, 'Paid'),
(2005, 1005, 103, '2024-01-19', 2100.00, 'Pending'),
(2006, 1006, 104, '2024-01-20', 5500.00, 'Paid'),
(2007, 1007, 102, '2024-01-21', 1600.00, 'Paid'),
(2008, 1008, 105, '2024-01-22', 2800.00, 'Pending');

INSERT INTO MedicalRecords VALUES 
(3001, 1001, 103, 'Common Cold', 'Rest and medication', '2024-01-15'),
(3002, 1002, 101, 'Heart Condition', 'Cardiac monitoring', '2024-01-16'),
(3003, 1003, 102, 'Childhood Fever', 'Antibiotics and rest', '2024-01-17'),
(3004, 1004, 101, 'Hypertension', 'Blood pressure medication', '2024-01-18'),
(3005, 1005, 103, 'Stomach Infection', 'Antibiotics', '2024-01-19'),
(3006, 1006, 104, 'Neurological Disorder', 'Specialized treatment', '2024-01-20'),
(3007, 1007, 102, 'Viral Infection', 'Symptomatic treatment', '2024-01-21'),
(3008, 1008, 105, 'Emergency Trauma', 'Emergency surgery', '2024-01-22');

ALTER TABLE Wards ADD COLUMN WardManager VARCHAR(100);
ALTER TABLE Doctors ADD COLUMN Salary DECIMAL(10,2);
ALTER TABLE Patients ADD COLUMN AdmissionDate DATE;
ALTER TABLE Bills ADD COLUMN DueDate DATE;

UPDATE Wards SET WardManager = 'Nurse Mary' WHERE WardID = 1;
UPDATE Wards SET WardManager = 'Nurse John' WHERE WardID = 2;
UPDATE Wards SET WardManager = 'Nurse Lisa' WHERE WardID = 3;
UPDATE Wards SET WardManager = 'Nurse Tom' WHERE WardID = 4;
UPDATE Wards SET WardManager = 'Nurse Kate' WHERE WardID = 5;

UPDATE Doctors SET Salary = 120000.00 WHERE DoctorID = 101;
UPDATE Doctors SET Salary = 110000.00 WHERE DoctorID = 102;
UPDATE Doctors SET Salary = 130000.00 WHERE DoctorID = 103;
UPDATE Doctors SET Salary = 125000.00 WHERE DoctorID = 104;
UPDATE Doctors SET Salary = 115000.00 WHERE DoctorID = 105;

UPDATE Patients SET AdmissionDate = '2024-01-15' WHERE PatientID = 1001;
UPDATE Patients SET AdmissionDate = '2024-01-16' WHERE PatientID = 1002;
UPDATE Patients SET AdmissionDate = '2024-01-17' WHERE PatientID = 1003;
UPDATE Patients SET AdmissionDate = '2024-01-18' WHERE PatientID = 1004;
UPDATE Patients SET AdmissionDate = '2024-01-19' WHERE PatientID = 1005;
UPDATE Patients SET AdmissionDate = '2024-01-20' WHERE PatientID = 1006;
UPDATE Patients SET AdmissionDate = '2024-01-21' WHERE PatientID = 1007;
UPDATE Patients SET AdmissionDate = '2024-01-22' WHERE PatientID = 1008;

UPDATE Bills SET DueDate = '2024-02-15' WHERE BillID = 2001;
UPDATE Bills SET DueDate = '2024-02-16' WHERE BillID = 2002;
UPDATE Bills SET DueDate = '2024-02-17' WHERE BillID = 2003;
UPDATE Bills SET DueDate = '2024-02-18' WHERE BillID = 2004;
UPDATE Bills SET DueDate = '2024-02-19' WHERE BillID = 2005;
UPDATE Bills SET DueDate = '2024-02-20' WHERE BillID = 2006;
UPDATE Bills SET DueDate = '2024-02-21' WHERE BillID = 2007;
UPDATE Bills SET DueDate = '2024-02-22' WHERE BillID = 2008;

DELETE FROM MedicalRecords WHERE RecordDate < '2024-01-18';
DELETE FROM Bills WHERE PaymentStatus = 'Pending' AND TotalAmount < 2000.00;

DROP TABLE MedicalRecords;
DROP TABLE Bills;
DROP TABLE Patients;
DROP TABLE Doctors;
DROP TABLE Wards;
DROP DATABASE HospitalDB;

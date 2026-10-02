# DBMS-MID

## Database Management Systems - Mid Term Project

This repository contains SQL solutions for DBMS mid-term examination questions covering ER modeling, database operations, user management, and query processing.

## 📋 Questions & Solutions

### Question 1: Hospital Database ER Model
**File:** [Q1.sql](./Q1.sql)

**Requirements:**
- Create a scenario-based ER model with Hospital entities (Wards, Patients, Doctors, Bills, etc.)
- Convert ER model into tables with minimum 5 entities
- Insert random data in all tables
- Update tables using ALTER commands
- Apply DELETE and DROP commands

**Solution includes:**
- ✅ 5 entities: Wards, Doctors, Patients, Bills, MedicalRecords
- ✅ Proper foreign key relationships
- ✅ Sample data insertion (8 patients, 5 doctors, 5 wards, 8 bills, 8 medical records)
- ✅ ALTER operations (added WardManager, Salary, AdmissionDate, DueDate columns)
- ✅ UPDATE operations with conditions
- ✅ DELETE operations with date and payment status conditions
- ✅ DROP operations for all tables and database

### Question 2: User Management & Constraints
**File:** [Q2.sql](./Q2.sql)

**Requirements:**
- Create users and provide GRANT privileges, then REVOKE them
- Insert 5 records and apply rollback
- Add DEFAULT, CHECK, UNIQUE, and NOT NULL constraints
- Insert NULL values and check results
- Add duplicate values and test primary key constraints

**Solution includes:**
- ✅ User creation ('testuser', 'admin') with different privilege levels
- ✅ GRANT/REVOKE operations demonstration
- ✅ Transaction with rollback (5 records inserted then rolled back)
- ✅ Constraint testing:
  - DEFAULT constraint (automatic salary/department assignment)
  - NOT NULL constraint (rejects NULL names)
  - UNIQUE constraint (rejects duplicate emails)
  - CHECK constraint (rejects age ≤ 18)
  - PRIMARY KEY constraint (rejects duplicate IDs)

### Question 3: Employee Queries
**File:** [Q3.sql](./Q3.sql)

**Requirements:**
- Create Employee table with constraints (Age > 18)
- Display total number of employees
- Retrieve employees with age = 22
- Fetch employee details with salary >= 50000
- Print "Full Name" for Finance department employees aged 22
- Print distinct department names

**Solution includes:**
- ✅ Employee table with proper constraints
- ✅ 20 employee records with varied data
- ✅ Query results:
  - Total employees: 20
  - Employees aged 22: 3 (Michael Brown, Lisa Anderson, Andrew Hall)
  - All employees have salary ≥ 50000
  - Finance employees aged 22: 3 employees
  - Distinct departments: 4 (Finance, IT, HR, Marketing)

## 🚀 How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/AdityaPandey-DEV/DBMS-MID.git
   cd DBMS-MID
   ```

2. **Execute SQL files:**
   ```bash
   # For MySQL
   mysql -u username -p < Q1.sql
   mysql -u username -p < Q2.sql
   mysql -u username -p < Q3.sql
   ```

3. **Or run individual queries:**
   - Copy and paste each file content into your MySQL client
   - Each file is self-contained and can be run independently

## 📊 Database Schemas

### Hospital Database (Q1)
- **Wards**: WardID (PK), WardName, WardType, Capacity, FloorNumber, WardManager
- **Doctors**: DoctorID (PK), DoctorName, Specialization, Experience, Phone, Email, Salary
- **Patients**: PatientID (PK), PatientName, Age, Gender, Phone, Address, WardID (FK), DoctorID (FK), AdmissionDate
- **Bills**: BillID (PK), PatientID (FK), DoctorID (FK), BillDate, TotalAmount, PaymentStatus, DueDate
- **MedicalRecords**: RecordID (PK), PatientID (FK), DoctorID (FK), Diagnosis, Treatment, RecordDate

### Company Database (Q2)
- **Departments**: DeptID (PK), DeptName, Location, Budget
- **Employees**: EmpID (PK), EmpName, Department, Salary, HireDate
- **Projects**: ProjectID (PK), ProjectName, StartDate, EndDate, Budget
- **Assignments**: AssignmentID (PK), EmpID (FK), ProjectID (FK), Role
- **Salaries**: SalaryID (PK), EmpID (FK), Amount, PayDate
- **TestConstraints**: ID (PK), Name (NOT NULL), Age (CHECK > 18), Email (UNIQUE), Salary (DEFAULT), Department (DEFAULT)

### Employee Database (Q3)
- **Employee**: EmployeeID (PK), Name (NOT NULL), Department, Age (CHECK > 18), Salary, City

## 🛠️ Technologies Used
- **Database:** MySQL 9.4.0
- **Language:** SQL
- **Features Demonstrated:**
  - ER Modeling
  - DDL (CREATE, ALTER, DROP)
  - DML (INSERT, UPDATE, DELETE)
  - DCL (GRANT, REVOKE)
  - TCL (COMMIT, ROLLBACK)
  - Constraints (PRIMARY KEY, FOREIGN KEY, CHECK, UNIQUE, NOT NULL, DEFAULT)
  - Queries (SELECT with WHERE, DISTINCT, COUNT, aliases)

## 📝 Author
**Aditya Pandey**  
GitHub: [@AdityaPandey-DEV](https://github.com/AdityaPandey-DEV)

## 📄 License
This project is created for educational purposes as part of DBMS mid-term examination.

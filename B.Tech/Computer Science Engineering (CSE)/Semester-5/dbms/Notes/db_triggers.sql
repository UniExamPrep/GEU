USE dbms_lab;
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
  INSERT INTO salary_audit(emp_id,old_salary,new_salary,diff) VALUES(NEW.emp_id,IFNULL(OLD.salary,0),NEW.salary-IFNULL(OLD.salary,0)+IFNULL(OLD.salary,0),NEW.salary-IFNULL(OLD.salary,0));
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

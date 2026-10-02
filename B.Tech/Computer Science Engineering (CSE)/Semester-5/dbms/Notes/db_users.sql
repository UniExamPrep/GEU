USE dbms_lab;
DROP USER IF EXISTS 'labuser'@'localhost';
CREATE USER 'labuser'@'localhost' IDENTIFIED BY 'labpass';
GRANT SELECT,INSERT,UPDATE,DELETE ON dbms_lab.* TO 'labuser'@'localhost';
REVOKE INSERT ON dbms_lab.* FROM 'labuser'@'localhost';

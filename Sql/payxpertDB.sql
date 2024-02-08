CREATE DATABASE PAYXPERTDB;
USE PAYXPERTDB;

-- DROP TABLE EMPLOYEE
CREATE TABLE EMPLOYEE (
	EmployeeID INT AUTO_INCREMENT PRIMARY KEY, 
    FirstName VARCHAR(20) NOT NULL, 
    LastName VARCHAR(20), 
    DateOfBirth DATE, 
    Gender VARCHAR(10), 
    Email VARCHAR(30), 
    PhoneNumber VARCHAR(30), 
    Address VARCHAR(100), 
    Positions VARCHAR(30), 
    JoiningDate DATE, 
    TerminationDate DATE
);


-- DROP TABLE PAYROLL

CREATE TABLE PAYROLL (
	PayrollID INT AUTO_INCREMENT PRIMARY KEY, 
	EmployeeID INT, 
    FOREIGN KEY (EmployeeID) REFERENCES EMPLOYEE (EmployeeID),
    PayPeriodStartDate DATE, 
    PayPeriodEndDate DATE, 
    BasicSalary DECIMAL(10,2), 
    OvertimePay DECIMAL(10,2), 
    Deductions DECIMAL(10,2),
    GrossSalary DECIMAL(10,2),
    NetSalary DECIMAL(10,2)
);


-- DROP TABLE TAX

CREATE TABLE TAX (
	TaxID INT AUTO_INCREMENT PRIMARY KEY, 
    EmployeeID INT, 
    FOREIGN KEY (EmployeeID) REFERENCES EMPLOYEE (EmployeeID),
    TaxYear YEAR, 
    TaxableIncome DECIMAL(10,2), 
    TaxAmount DECIMAL(10,2)
);


-- DROP TABLE FINANCIALRECORD

CREATE TABLE FINANCIALRECORD (
	RecordID INT AUTO_INCREMENT PRIMARY KEY, 
    EmployeeID INT, 
    FOREIGN KEY (EmployeeID) REFERENCES EMPLOYEE (EmployeeID),
    RecordDate DATE, 
    Descriptions VARCHAR(50),
    Amount DECIMAL(10,2), 
    RecordType VARCHAR(50)
);



/*----------------------------------INSERTING THE EMPLOYEE TABLE------------------------------------------*/

ALTER TABLE EMPLOYEE AUTO_INCREMENT = 1001;

INSERT INTO EMPLOYEE (FirstName, LastName, DateOfBirth, Gender, Email, PhoneNumber, Address, Positions, JoiningDate) 
VALUES ('Adam', 'Zampa', '1990-05-23', 'Male', 'adamzam@gmail.com', '9283746590', '123 West Cross Street, Madurai', 'Jr.Developer', '2010-06-12');

INSERT INTO EMPLOYEE (FirstName, LastName, DateOfBirth, Gender, Email, PhoneNumber, Address, Positions, JoiningDate) 
VALUES 
	('BEN','TENISON','1995-01-21', 'Male','benten@gmail.com','8523741227', '11-C Teachers colony, Dindigul', 'Sr.Developer', '2016-05-01'), 
	('DARK','DEVIL','2001-11-19','Male','darkdev@gmail.com','8123564395','26 East Cross street, Chennai','Tech.Support','2023-04-21'),
	('SLIM','SHADY','2001-12-05','Male','slimsha@gmail.com','6752138733','12 Pine Street, Chennai', 'Jr.Developer', '2022-07-11'),
	('JOKER','ALAN','1999-07-15','Male','alabjok@gmail.com','8145236880','6th Express Streeet, Chennai','Manager','2023-08-18'),
	('LEO','DAS','1994-06-21','Male','leodas@gmail.com','6573428916','142 Coast Road, Trichy','HR','2015-06-23'),
	('VIKRAM','RATHORE','1965-10-11','Male','vikram@gmail.com','7531538566','17 ANC Road,Dindigul','Mangaer','2010-11-19'),
	('SCARLET','JOHN','1977-03-31','Female','scarj@gmail.com','9154332675','81 ABCD Street, Theni','Developer','2014-10-12'),
	('AMY','JACKSON','2000-07-25','Female','amyjack@gmail.com','6543287851','94 Fast food Street, Coimbatore','Trainee','2023-12-07'),
	('MIKE','JON','1998-05-04','Male','mikejon@gmail.com','9099675220','32 Temple Street, Madurai','Devloper','2020-06-09');



/* -------------------------------------INSERTING THE PAYROLL TABLE--------------------------------------------*/    

ALTER TABLE payroll auto_increment = 101;

-- TRIGGER FOR UPDATING THE NET and GROSS SALARY
-- DROP TRIGGER updateNetSalary;
   delimiter //
    CREATE TRIGGER updateNetSalary
    BEFORE INSERT ON Payroll
    FOR EACH ROW
    BEGIN
		SET new.GrossSalary = new.BasicSalary + new.OvertimePay;
		SET new.NetSalary = new.BasicSalary + new.OvertimePay - new.Deductions;
    END //
    delimiter ;
    
INSERT INTO Payroll (EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, Deductions) VALUES
    (1001, '2010-07-12', '2010-07-12', 15000.00, 200.00, 300.00);

INSERT INTO Payroll (EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, Deductions) VALUES
    (1002, '2016-06-01', '2016-06-15', 25000.00, 500.00, 700.00),
    (1003, '2023-05-21', '2023-05-26', 20000.00, 300.00, 500.00),
    (1004, '2022-08-11', '2022-08-19', 17000.00, 100.00, 230.00),
    (1005, '2023-09-18', '2023-09-25', 34000.00, 1000.00, 700.00),
    (1006, '2015-07-23', '2015-07-30', 71000.00, 2200.00, 1300.00),
    (1007, '2010-12-19', '2010-12-23', 45000.00, 1100.00, 900.00),
    (1008, '2014-12-12', '2014-11-20', 38000.00, 1400.00, 1000.00),
    (1009, '2024-01-07', '2024-01-17', 24000.00, 2200.00, 750.00),
    (1010, '2020-07-09', '2020-07-15', 29000.00, 1450.00, 325.00);

-- Trigger for calculating the tax
-- DROP TRIGGER CalculateTax
DELIMITER //
CREATE TRIGGER CalculateTax
after INSERT ON payroll
FOR EACH ROW
BEGIN
	-- DECLARE GrossSalary DECIMAL(10,2);
    declare taxableIncome decimal(10,2);
    DECLARE taxAmount DECIMAL(10,2);
    declare ta decimal(10,2);
    
    set taxableIncome = new.GrossSalary *12 -500000;
    if taxableIncome<0 then
		set ta =0;
    else
		set ta = taxableIncome;
	end if;
    set taxAmount = ta * 0.1;
    insert into tax (EmployeeID,TaxYear,TaxableIncome,TaxAmount)
    values (new.EmployeeID,year(new.PayPeriodStartDate),ta,taxAmount);
END//
DELIMITER ;    

/*----------------------------------------INSERTING THE TAX TABLE---------------------------------------------*/

ALTER TABLE TAX AUTO_INCREMENT = 4321;
INSERT INTO TAX (EmployeeID,TaxYear,TaxableIncome, TaxAmount) 
VALUES 
	(1001,2010,0.00,0.00),
	(1002,2016,0.00,0.00),
    (1003,2023,0.00,0.00),
    (1004,2022,0.00,0.00),
    (1005,2023,0.00,0.00),
    (1006,2015,362800.00,36280.00),
    (1007,2010,42400.00,4240.00),
    (1008,2014,0.00,0.00),
    (1009,2024,0.00,0.00),
    (1010,2020,0.00,0.00);



/*------------------------------------INSERTING FINANCIAL RECORDS-------------------------------------------*/

ALTER TABLE financialrecord AUTO_INCREMENT = 201;
INSERT INTO financialrecord (EmployeeID, RecordDate, Descriptions, Amount, RecordType) 
VALUES 
	(1001,'2010-07-10' ,'Basic Salary' ,15000 ,'Income'),
    (1002,'2016-06-10' ,'Overtime Pay' ,500 ,'Income'),
    (1003,'2023-05-25' ,'Travel Expense' ,1000 ,'Expense'),
    (1004,'2022-08-20' ,'Basic Salary' ,17000 ,'Income'),
    (1005,'2023-09-23' ,'Deduction' ,700 ,'Expense'),
    (1006,'2016-05-14' ,'Paying Tax' ,36280 ,'Tax Payment'),
    (1007,'2011-06-23' ,'Paying Tax' ,4240 ,'Tax Payment'),
    (1008,'2014-12-21' ,'Overtime Pay' ,1400 ,'Income'),
    (1009,'2024-01-17' ,'Travel Expense' ,500 ,'Expense'),
    (1010,'2020-07-19' ,'Travel Expense' ,2000 ,'Expense');








-- Create the database 'dbJDBC'
create database dbJDBC

--Switch to 'dbJDBC' database
use dbJDBC

--Create the table Employees
create table Employees
(
eNo int primary key,
eName varchar(30),
eMail varchar(30)
)

--Insert some records in the Employees table
insert into Employees values(1,'Ankur','onlyankur@gmail.com')
insert into Employees values(2,'Praveen','onlypraveen@gmail.com')
insert into Employees values(3,'Prashant','onlyprashant@gmail.com')

-- Query the dbJDBC.dbo.Employees table
select * from dbJDBC.dbo.Employees

-- Delete all the records from the Employees table
truncate table dbJDBC.dbo.Employees
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

-- Create a procedure which accepts input and output parameters in 'dbJDBC' database
create procedure dbo.usp_dbJDBC_Employees_SQLServer
(
@eNo int  ,
@eName varchar(30),
@eMail varchar(30),
@outputMessage varchar(50) output
)
as
begin -- #1

update dbo.employees set eName=@eName, eMail=@eMail where eNo=@eNo


		if(@@error<>0) 
		begin 
			set @outputMessage='ERROR: Error in updating value in Employee table'
			return
		end
		else
		begin
			set @outputMessage='SUCESS: Value updated in Employee table'
		end
	
end
--------------------------------------------------------
--Execute the procedure
declare @outputMessage varchar(50)
exec dbJdbc.dbo.usp_dbJDBC_Employees_SQLServer
1,'Ankur','onlyankur@gmail.com',
@outputMessage  output

select @outputMessage as 'Output Message'
--------------------------------------------------------
-- Drop the procedure
drop procedure dbJDBC.dbo.usp_dbJDBC_Employee_SQLServer
--------------------------------------------------------


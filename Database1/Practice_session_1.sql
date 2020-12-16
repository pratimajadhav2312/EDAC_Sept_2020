select schema();
use assignment_6;
CREATE TABLE EmployeeDetails (Empid int primary key,FullName varchar(100),Managerld int,DateofJoining Date,City varchar(30));
-- alter table EmployeeDetails add constraint  fk_p foreign key(Managerld) references EmployeeDetails(Managerld);
INSERT INTO EmployeeDetails values(121,'pJohn snow',321,'2014/01/31','Toronto');
INSERT INTO EmployeeDetails values(321,'Waiter white',986,'2015/01/30','California'),(421,'Kuldeep rana',876,'2016/11/27','New Delhi');

show tables;
drop table EmployeeDetails;
select * from EmployeeDetails;
drop table EmployeeSalary ;

create table EmployeeSalary (empid int,project varchar(10),salary int,variable int,constraint f_emp_id foreign key (empid) references EmployeeDetails(empid) );
insert into EmployeeSalary (empid,project,salary,variable) values (121,'P1',8000,500);
insert into EmployeeSalary (empid,project,salary,variable) values (321,'P2',10000,1000),(421,'P1',12000,0);

-- Que1
select empid,fullname from EmployeeDetails where managerid=986;
select empid from employeesalary where salary between 9000 and 15000;
select * from employeedetails where city = 'california' or managerld=321;
select * from employeesalary where not project ='p1';
select salary+variable as total_salary from employeesalary;
select * from employeedetails where fullname regexp '^[hn]';
select * from employeedetails where fullname like '__hn%';
SELECT FullName
FROM EmployeeDetails
WHERE FullName LIKE '__hn%';


 use data_base;
 create table Customer (Id Int primary key auto_Increment,First_Name Varchar(100),Last_Name varchar(100),Country Varchar(100),Credit_limit float);
select empid ,'ACTIVE' AS STATUS ,emp_id*3.14 as me , upper(ename) from emp;

 delimiter $$
 create procedure cust (IN f_name varchar(100),IN L_Name varchar(100),IN COUNTRY VARCHAR(100),IN CRED_LIMIT FLOAT)
 begin
 insert into Customer (First_Name ,Last_Name ,Country ,Credit_limit) values (f_name,L_Name,COUNTRY,CRED_LIMIT);
 end$$
 
 drop procedure Cust;
 
 SET @f_name="Anne   ";
 SET @L_NAME="Harris  ";
 SET @COUNTRY="USA ";
 SET @CRED_LIMIT=158367.00;
 
 call cust(@f_name,@l_name,@country,@cred_limit);
 
 select * from Customer;
 
 truncate table Customer;

 SELECT ID,CONCAT(FIRST_NAME," ", LAST_NAME) AS FULLNAME,LENGTH(CONCAT(FIRST_NAME,LAST_NAME)) AS LENGTHNAME
  FROM CUSTOMER WHERE (LENGTH(CONCAT(FIRST_NAME,LAST_NAME)))<50 ORDER BY LENGTH(CONCAT(FIRST_NAME,LAST_NAME)) ASC, 
  CONCAT(UPPER(TRIM(FIRST_NAME)),UPPER(TRIM(LAST_NAME))) ASC,ID ASC;
 
 
-- --------------------------------------------------------

create table Student1 (ID INT,NAME VARCHAR(100),SCORE FLOAT) ;
 
 INSERT INTO STUDENT1 VALUES (1,"BOB",50.0),(2,"JOHN",65.5),(3,"HARRY",45),(4,"DIICK",85),(5,"DEV",25),(6,"SID",98),(7,"TOM",90),(8,"JULIA",70.5),(9,"ERICA",81),(10,"JERRY",85);
 

 select * from student1; 
 select ID , NAME FROM STUDENT1 ORDER BY SCORE DESC LIMIT 3,NAME DESC,ID ASC;
 select ID,NAME FROM STUDENT1 ORDER BY SCORE DESC,ID ASC,ID ASC LIMIT 3 ;
 
 
 
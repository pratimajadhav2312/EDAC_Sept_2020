use assignment_6;

-- question 1
delimiter $$
create function fun1(var int) returns int
begin
declare res int default 1;
fact:loop
if(var=0)then
return res;
leave fact;
end if;
set res=res*var;
set var=var-1;
end loop;
end$$


select fun1(4);

-- question 2

delimiter $$
create function is_prime3(var int) returns varchar(30)
begin
declare i int default 2;
declare flag int default 1;

while(i < var/2) do
if(var%i = 0) then
set flag=0;
end if;
set i=i+1;
end while;
if (flag=1)then
return 'prime';
else
return 'not prime';
end if;
end$$

select is_prime3(9);

drop function is_prime2;

-- question 3

delimiter $$
create function convertion1(inches int) returns varchar(30)
begin
declare x int default 0;
declare res varchar(30) default '';
declare yard,foot,inch int;
set x= inches/12;
set yard=x/3;
set foot=x mod 3;
set inch=inch mod 12;
set res = concat(yard, ' yrad', foot ,' foot',inch , ' inch');
return  res;
end $$

select convertion1(124) as result;

drop function convertion1;



-- question 4

Create table EMP ( EMPNO numeric(4) not null, ENAME varchar(30) not null, JOB varchar(10), MGR numeric(4), HIREDATE date, SAL numeric(7,2), DEPTNO numeric(2) ); 

Insert into EMP (EMPNO ,ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO ) values(1000,  'Manish' , 'SALESMAN', 1003,  '2020-02-18', 600,  30) ;
Insert into EMP (EMPNO ,ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO ) values(1001,  'Manoj' , 'SALESMAN', 1003,  '2018-02-18', 600,  30) ;
Insert into EMP (EMPNO ,ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO ) values(1002 , 'Ashish', 'SALESMAN',1003 , '2013-02-18',  750,  30 );
Insert into EMP (EMPNO ,ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO ) values(1004,  'Rekha', 'ANALYST', 1006 , '2001-02-18', 3000,  10);
Insert into EMP (EMPNO ,ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO ) values(1005 , 'Sachin', 'ANALYST', 1006 ,  '2019-02-18', 3000, 10 );
Insert into EMP (EMPNO ,ENAME, JOB, MGR, HIREDATE, SAL, DEPTNO ) values(1006,  'Pooja',  'MANAGER'  ,     null    , '2000-02-18' ,6000, 10 );

Create table dept (dno numeric(4) not null, dname varchar(10) not null,area varchar(30));

Insert into dept(dno,dname,area) values(10,'Store','Mumbai');
Insert into dept(dno,dname,area) values(20,'Purchase','Mumbai');
Insert into dept(dno,dname,area) values(30,'Store', 'Delhi');
Insert into dept(dno,dname,area) values(40,'Marketing','Pune');
Insert into dept(dno,dname,area) values(50,'Finance','Delhi');
Insert into dept(dno,dname,area) values(60,'Accounts','Mumbai');


delimiter $$
create function fun_sal(dno int) returns varchar(30)
begin
update emp set sal=sal+(sal*(10/100)) where deptno=dno;
return 'done'; 
end$$

select fun_sal(30);
drop function fun_sal;
select * from emp;


-- question 5
delimiter $$
create function user_annual_comp(p_eno int ,p_comp int) returns int
begin
declare annual_comp int default 0; 
set annual_comp=((select sal from emp where empno=p_eno)+p_comp)*12;
return annual_comp; 
end$$
-- drop function user_annual_comp;
select user_annual_comp(1004,100);

-- question 6
delimiter $$
create procedure USER_QUERY_EMP(in p_myeno int,out p_mysal int, out p_myjob varchar(30) )
begin
if(p_myeno = ( select empno from emp where empno=p_myeno))then
select sal,job into p_mysal,p_myjob  from emp where empno=p_myeno;
else
select "empno does not exist";
end if;
end$$
drop procedure USER_QUERY_EMP;


call USER_QUERY_EMP(1000,@psal,@pjob);

select @psal as salary,@pjob as job;

-- question 7

delimiter $$
create procedure string_out(inout str1 varchar(30))
begin

if(str1='' || isnull(str1))then
select 'not valid';
else
select reverse(str1);
end if;
end$$

drop procedure string_out;

set @str1=null;
call string_out(@str1);

-- question 8
delimiter $$
create procedure tabledetails ()
begin
-- select * from information_schema.tables;
select * from emp;
end$$
drop procedure tabledetails;
call tabledetails();


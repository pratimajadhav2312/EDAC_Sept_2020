-- select schema();
-- show tables;
-- show databases;
use assignment_6;

-- cursors and handlers
-- desc emp;
-- question 1
delimiter $$
create procedure disp_name_sal()
begin
declare finished int  default 0;
declare emp_name varchar(30);
declare emp_sal int ;

declare sa_cur cursor for select ename , sal from emp;
declare continue handler for not found set finished=1;

open sa_cur;
 getnasa : loop
 fetch sa_cur into emp_name,emp_sal;
  
 if finished=1 then
 leave getnasa;
 end if;
select ename,sal from emp where ename=emp_name;
 end loop;
 close sa_cur;
end$$

call disp_name_sal();
select * from emp;
drop procedure disp_name_sal;

-- question 2
delimiter $$
create procedure top_five ()
begin
declare eid int;
declare enm varchar(30);
declare esal int;
declare done int default 0;
declare rowcount int default 0;
declare cur cursor for select empno,ename, sal from emp order by sal desc limit 5; 
 declare continue handler for not found set rowcount=1;
open cur;
getsal: loop
fetch cur into eid,enm,esal;
if(rowcount=1)then
leave getsal;
end if;
select empno,ename,sal from emp where empno=eid; 
end loop;
end$$

call top_five();

--  by sal desc limit 5
-- if(rowcount=5)then
-- drop procedure top_five;

select * from emp;
-- alter table emp add column last_name varchar(30);

-- update emp set last_name='kale' where empno=1000;
-- update emp set last_name='lele' where empno=1001;
-- update emp set last_name='pile' where empno=1002;
-- update emp set last_name='hile' where empno=1003;
 -- update emp set last_name='tule' where empno=1004;
-- update emp set last_name='mule' where empno=1005;


-- question 3
delimiter $$
create procedure fname_lname()
begin
declare f_na varchar(30);
declare l_na varchar(30);
-- declare no1 int default 0 ;
declare cur cursor for select ename,last_name from emp;
-- declare exit handler for not found select 'done with execution';
open cur;

fetch cur into f_na,l_na;
select ename,last_name from emp ;

end$$

call fname_lname();
-- drop procedure fname_lname;

select * from emp;

-- Question 4
delimiter $$
create procedure emp_data ()
begin
declare name1 varchar(100);
declare done int default 0;
declare cur cursor for select ename from emp ;
declare continue handler for not found set done=1;
open cur;
st:loop
fetch cur into name1;
if(name1='Manoj')then
select * from emp where ename=name1;
leave st;
end if;

end loop;
end$$

drop procedure emp_data;

call emp_data();

-- Question 5

delimiter $$
create procedure salgreat()
begin
declare eid int;
declare sal1 int;

declare cur cursor for select empno,sal from emp;
declare continue handler for sqlexception select 'done with excution' as message;
open cur;
st:loop
fetch cur into eid,sal1;
 -- if(sal1<2000.00)then
delete from emp where empno=eid;
 -- end if;

end$$

call salgreat();
drop procedure salgreat;
select * from emp;
desc emp;
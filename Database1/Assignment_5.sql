use data_base;

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

-- Question 1
delimiter $$
create procedure Calculator(in var1 int,in var2 int)
begin
declare sum,sub,mul int;
declare divi float;
set sum = var1+var2;
select sum;
set sub = var1-var2;
select sub;
set mul = var1*var2;
select mul;
set divi = var1/var2;
select  divi;
end$$

call Calculator(10,20);

-- Question 2
delimiter $$
create procedure Reverse_String(in str1 varchar(20))
begin
select reverse(str1);
end$$

call Reverse_String('pratima');

-- Question 3
delimiter $$
create procedure emp_top_sal(in num int)
begin
select empno,ename,sal from emp order by sal desc limit num;
end $$

call emp_top_sal(5);


delimiter $$
         create procedure loop_ite()
         begin
         declare val int default 0;
         test_loop : LOOP
               if( val = 5)then
               iterate test_loop;
               end if;
                    set val =val +1;
                    select val;
  			if(val=10) then
 			 leave test_loop;
			end if;
			end loop;
            End $$   

call loop_ite();

-- question 4
delimiter $$
         create procedure create_table()
         begin
         create table emp_test (e_id int,e_name varchar(10),e_joing_date date );
		End $$ 
        
        call create_table();
        
        desc emp_test;


-- question 5

delimiter $$
         create procedure add_row(in deptno int,in dname varchar(30),in loc varchar(30))
         begin
         insert into department values (deptno,dname,loc);
		End $$ 
        
        call add_row(60,'education','pune');
        
        select * from department;
        
	-- question 6
    
    delimiter $$
         create procedure square_cube(in var int)
         begin
        declare num int default 0;
        declare cube1,square1 int;
        set num=var;
        select concat('num value is ',num);
        set cube1=var*var*var;
        select concat('cube value is ',cube1);
        set square1=var*var;
        select concat('square value is ',square1);
		End $$
        
    
        call square_cube(2);
        
        -- question 7
        
        
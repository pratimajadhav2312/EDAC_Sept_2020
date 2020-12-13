show databases;
select schema();

create table ord_master (ord_no int primary key,cust_cd varchar(10),status varchar(10));
insert into ord_master values (1,'C1','P');

create table ord_dtl (ord_no int ,prod_cd varchar(10),qty int,constraint fk_ord_id foreign key(ord_no) references ord_master(ord_no));
insert into ord_dtl values(1,'P1',100),(1,'P2',200);

create table prod_master (prod_cd varchar(30) primary key,prod_name varchar(30),qty_in_stock int,booked_qty int);
insert into prod_master values('P1','Floppies',10000,1000),('P2','Printers',5000,600),('P3','MODEMS',3000,200);

-- drop table ord_master;
-- drop table ord_dtl;
-- drop table prod_master;

-- question 1
delimiter $$
create trigger trig_que1 before insert on ord_dtl
for each row
begin
update prod_master set booked_qty=booked_qty+new.Qty where  prod_cd=new.prod_cd;
end $$

insert into ord_dtl values(1,'P3',100);

select * from ord_dtl;
select * from prod_master;

-- question 2
 delimiter $$
 create trigger trig_bef before delete on ord_dtl 
 for each row
 begin
 update prod_master set booked_qty=booked_qty-old.qty where prod_cd=old.prod_cd;
 end$$
 
 delete from ord_dtl where prod_cd='p3';
 
-- question 3

create table dept_sal(dept_no int,tota_salary int);
insert into dept_sal values(10,6500),(30,2145);

-- select * from emp;
-- select * from dept_sal;
-- desc emp;
-- select deptno,sum(sal)from emp group by deptno;

delimiter $$
create trigger add_emp after insert on emp
for each row
begin
update dept_sal set tota_salary=tota_salary+new.sal where dept_no=new.deptno;
end$$

insert into emp values (50,'pratima','sr.dev',1002,'2020-12-30',1200,30);

-- question 4

delimiter $$
create trigger del_emp before delete on emp
for each row
begin
update dept_sal set tota_salary=tota_salary-old.sal where dept_no=old.deptno;
end$$

delete from emp where empno=50;
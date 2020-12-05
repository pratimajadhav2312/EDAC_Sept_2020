package Project3;

import java.awt.List;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.xml.soap.Detail;



public class EmployeeDemo {

	public static void main(String[] args) 
	{
		
		System.out.println("**************EMPLOYEE RECORD SYSTEM************");
		
		
		Scanner sc=new Scanner(System.in);
	
		 int choice;
		 
		 EmployeeDetails ed=new EmployeeDetails();
		 EmployeeINOUT einout=new EmployeeINOUT();
		 Employee e1=new Employee();
		 
		 do
		 {
			 System.out.println();
			 System.out.println("**********************************************");
			 System.out.println();
			 
			 System.out.println("1. All employee deatails are");
			 System.out.println("2. Sorted Employee");
			 System.out.println("3. in and out time of employee");
			 System.out.println("4. Daily Record of Employee ");
			 System.out.println("5. All departments in Organizastion");
			 System.out.println("6. Get details of Highest paid employee ");
			 System.out.println("7. total number of employees in each department");
			 System.out.println("8. most working exeperienced Employee");
			 System.out.println("9. Add new Employee");
			 System.out.println("10. Remove employee from organization");
			 System.out.println("11. display details");
			
			 
			 System.out.println("-----------Enter choice : -----------");
			 
			 choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("***********Details of All Employee************");
				ed.adddetails();
				einout.displayNodeData();
				break;
				
			case 2:
				System.out.println("**********Sorted Employees***********");
				ed.SortedEmployee(); 
				break;
				
			case 3:
				ed.setEmployeeIn();
				System.out.println("**********working***********");
				ed.setEmployeeOut();
				break;
				
			case 4:
				System.out.println("*******Display Todays Report of Employee******");
				ed.record();
				break;
				
			case 5:
				System.out.println("**********List all Departments in organization ****************");
				ed.numberofDepartments();
				break;
				
			case 6:
				System.out.println("*******Highest paid employee*********");
				ed.HighestSal();
				break;
				
			case 7:
				System.out.println("*********Total number of employees in each department*********");
				ed.totalEmployee();
				break;
				
			case 8:
			   System.out.println("***********most working experienced employee*********");
			   ed.experience();
			break;
				
			case 9:
				System.out.println("**********Add new employee details************");
				ed.AddEmployee();
				break;
				
			case 10:
				System.out.println("Enter Id of employee to be deleted");
				int empid=sc.nextInt();
				ed.deleteEmp(empid);
				System.out.println("---------employee info deleted--------------");
				break;
				
			case 11:
				System.out.println("*******display all details of employee*****");
				einout.displayNodeData();
				break;
		
			}
		 }while(choice!=0);
		 System.out.println("************EXIT***********");
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}

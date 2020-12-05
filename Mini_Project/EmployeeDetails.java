package Project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;



public class EmployeeDetails 
{
	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	ArrayList<EmployeeINOUT> employeeList1 = new ArrayList<EmployeeINOUT>();
	
	Employee e=new Employee();

	EmployeeINOUT einout=new EmployeeINOUT();
	
	Scanner sc=new Scanner(System.in);
	
	void adddetails()
	{
		Employee e1=new Employee(111, "Pratima jadhav", 32, "Female", "HR", 2011, 25000.0);
		Employee e2=new Employee(122, "Ranbir singh", 25, "Male", "Sales And Marketing", 2015, 13500.0);
		Employee e3=new Employee(133, "Rohit Sharma", 29, "Male", "Infrastructure", 2012, 18000.0);
		Employee e4=new Employee(144, "Anuj Rahul", 28, "Male", "Product Development", 2014, 32500.0);
		Employee e5=new Employee(155, "Shubhangi Tarte", 27, "Female", "HR", 2013, 22700.0);
		
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);
		
		employeeList1.add(new EmployeeINOUT(111, "Pratima jadhav","00.00","00.00"));
		employeeList1.add(new EmployeeINOUT(122, "Ranbir singh", "00.00","00.00"));
		employeeList1.add(new EmployeeINOUT(133, "Rohit Sharma","00.00","00.00"));
		employeeList1.add(new EmployeeINOUT(144, "Anuj Rahul","00.00","00.00"));
		employeeList1.add(new EmployeeINOUT(155, "Shubhangi Tarte","00.00","00.00"));
		


	
		for(Employee e:employeeList)
		{
			einout.insertNode(e);
		}


	}

	
	int AddEmployee()
	{
		System.out.println("Generate Id : ");
		int id1=sc.nextInt();
		
		for(Employee e:employeeList)
		{
			if(e.id==id1)
			{
				System.out.println("This id is already exists, can't accept");
				return -1;
			}
		}
		sc.nextLine();
		System.out.println("Employee name : ");
		String name=sc.nextLine();
		
		
		System.out.println("Age : ");
		int age=sc.nextInt();
		
		sc.nextLine();
		System.out.println("Gender : ");
		String gender=sc.nextLine();
		
		System.out.println("Department : ");
		String dept=sc.nextLine();
		
		System.out.println("Joing year : ");
		int year=sc.nextInt();
		
		System.out.println("Allocated Salary : ");
		double sal=sc.nextDouble();
		
		Employee newEmp=new Employee(id1, name, age, gender, dept, year, sal);
		
		employeeList.add(newEmp);	
		einout.insertNode(newEmp);
		return id1;
	}
		

	
	void SortedEmployee()
	{
		Collections.sort(employeeList,new EmpNameCompare());
		
		for(Employee e:employeeList)
		{
			System.out.println(e);
		}
	}
	
	
	
	void record()
	{
			 for(EmployeeINOUT e:employeeList1)
			 {
				 e.dayRecord();
			 }
			 
	}
	
	void numberofDepartments()
	{
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
    
	}
	
	void HighestSal()
	{
		Optional<Employee> highestPaidEmployeeWrapper=
				employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
				         
				Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
				         
				System.out.println("Details Of Highest Paid Employee : ");
				         
				System.out.println("==================================");
				         
				System.out.println("ID : "+highestPaidEmployee.getId());
				         
				System.out.println("Name : "+highestPaidEmployee.getName());
				         
				System.out.println("Age : "+highestPaidEmployee.getAge());
				         
				System.out.println("Gender : "+highestPaidEmployee.getGender());
				         
				System.out.println("Department : "+highestPaidEmployee.getDepartment());
				         
				System.out.println("Year Of Joining : "+highestPaidEmployee.getYearOfJoining());
				         
				System.out.println("Salary : "+highestPaidEmployee.getSalary());
	}
	
	void totalEmployee()
	{
		Map<String, Long> employeeCountByDepartment=
				employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
				         
				Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();
				         
				for (Entry<String, Long> entry : entrySet)
				{
				    System.out.println(entry.getKey()+" : "+entry.getValue());
				}
	}
	
	public void experience()
	{
		Optional<Employee> seniorMostEmployeeWrapper=
				employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
				         
				Employee seniorMostEmployee = seniorMostEmployeeWrapper.get();
				         
				System.out.println("Senior Most Employee Details :");
				         
				System.out.println("----------------------------");
				         
				System.out.println("ID : "+seniorMostEmployee.getId());
				         
				System.out.println("Name : "+seniorMostEmployee.getName());
				         
				System.out.println("Age : "+seniorMostEmployee.getAge());
				         
				System.out.println("Gender : "+seniorMostEmployee.getGender());
				         
				System.out.println("Age : "+seniorMostEmployee.getDepartment());
				         
				System.out.println("Year Of Joinging : "+seniorMostEmployee.getYearOfJoining());
				         
				System.out.println("Salary : "+seniorMostEmployee.getSalary());
	}


	void setEmployeeIn()
	{
		for(EmployeeINOUT e:employeeList1)
		 {
			 System.out.print("In-time : "+e.name+" :");
		      e.setIntime();
		 }
	}
	
	void setEmployeeOut()
	{
		 
		 for(EmployeeINOUT e:employeeList1)
		 {
			 System.out.print("out-time : "+e.name +" :");
			 e.setouttime();
		 }
	}
	
	void deleteEmp(int id1)
	{
		for(Employee e:employeeList)
		{
			if(e.id==id1)
			{
				einout.deleteNode(e);
			}
		}
		
	}

}

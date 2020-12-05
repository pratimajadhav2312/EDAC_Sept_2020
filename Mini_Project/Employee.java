package Project3;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;



class EmpNameCompare implements Comparator<Employee>
{
	public int compare(Employee emp1,Employee emp2)
	{
		
		String name1=emp1.name;
		String name2=emp2.name;
		int res = name1.compareTo(name2);
		return res;
	}


}


public class Employee 
{
    int id;
     
    String name;
     
    int age;
     
    String gender;
     
    String department;
     
    int yearOfJoining;
     
    double salary;
    
    String inTime;
    
    String outTime;
    
    Employee ()
    {
    	
    }
     
    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
     
       
    }
    
    public Employee(int id, String name,String inTime,String outTime)
    {
    	
    }
    
    public String setIntime()
    {
    	return inTime;
    }
    
    public int getId() 
    {
        return id;
    }
     
    public String getName() 
    {
        return name;
    }
     
    public int getAge() 
    {
        return age;
    }
     
    public String getGender() 
    {
        return gender;
    }
     
    public String getDepartment() 
    {
        return department;
    }
     
    public int getYearOfJoining() 
    {
        return yearOfJoining;
    }
     
    public double getSalary() 
    {
        return salary;
    }
   
    public String toString() 
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }
    
  
    
    public boolean equals(Object obj)
	{
		Employee e=(Employee)obj;
		
		if(this.id==e.id && this.name.equals(e.name)&&this.age==e.age && this.gender.equals(e.gender)&& this.department==e.department && this.yearOfJoining==e.yearOfJoining && this.salary==e.salary)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int hashCode()
	{
		int num=31;
		int res=1;
		res=res*num+age;
		res=(int) (res*num+salary);
		res=res*num+name.hashCode();
		return res;
	}

	

    
}

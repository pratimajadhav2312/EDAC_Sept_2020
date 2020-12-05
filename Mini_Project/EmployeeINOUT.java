package Project3;
import java.util.Comparator;
import java.util.Scanner;

class Node
{
	Node next;
	Employee e;                    
	Node(Employee e1)
	{
		this.e=e1;
		next=null;
	}
}


public class EmployeeINOUT 
{
	static Node head;
	
	Scanner sc=new Scanner(System.in);
	
	int id;
	String name;
	String inTime;
	String outTime;
	double leave=10;
	
	EmployeeINOUT()
	{
		head=null;
	}
	
	EmployeeINOUT(int id,String name,String inTime,String outTime)
	{
		this.id=id;
		this.name=name;
		this.inTime=inTime;
		this.outTime=outTime;
	}
	
	public String setIntime()
	{
		String time=sc.nextLine();
		this.inTime=time;
		return inTime;
	}


	public String setouttime()
	{
		String time=sc.nextLine();
		this.outTime=time;
		return outTime;
	}
   
   public void dayRecord()
   {
	   double t1=Double.parseDouble(inTime);
	   double t2=Double.parseDouble(outTime);
	   
	   if(t1>10.00)
	   {
		   System.out.println(this.name +": ");
		   System.out.println( "Remark : ------Today you are late : Penalty ==> coffee treat from ur side------");
	   }
	   else
	   {
		   System.out.println(this.name +": ");
		   System.out.println( "Remark :  ------Thank you for being discipline : Appreciation---------");
	   }
	   
	   double diff=t1-t2;
	   double abdiff=Math.abs(diff);
	   
	   if(abdiff>=0 && abdiff<4)
	   {
		   
		  System.out.println( "addentance details : Absent  ||"); 
		  leave--;
		  remainingLeave();
	   }
	   else if(abdiff>=4 && abdiff<8)
	   {
		 
		   System.out.println("addentance details : Half-Day  ||");
		   leave=(leave/2)+((leave-1)/2);
		   remainingLeave();
	   }
	   else if(abdiff>=8)
	   {
		   System.out.println("addentance details : Present  ||");
		   remainingLeave();
	   }
	   
	  
   }
   
   void remainingLeave()
   {
	  System.out.println("Remaining leave:  Out of 10 leaves "+leave+" are remaining");
	  System.out.println();
	  System.out.println("********************************************");
	  
   }
 
  void insertNode(Employee e1)
  {
	  Node node=new Node(e1);
	  if(head==null)
		{
			head=node;
		}
		else
		{
			Node n=head;
			while(n.next!=null)
			{
				n=n.next;
			}
			n.next=node;

		}
  }
  
  void displayNodeData()
  {
	  Node n=head;
	   while(n.next!=null)
	   {
		   System.out.println(n.e);
		   n=n.next;
	   }
	   System.out.println(n.e);
  }
  
 
	  void deleteNode(Employee e1)
		{
			
			Node preptr,ptr;
			preptr=ptr=head;
			while(ptr.e!=e1 && ptr!=null)
			{
				preptr=ptr;
				ptr=ptr.next;
			}
			preptr.next=ptr.next;
		}
  
	  public String toString()
		{
			return "EmpId : "+id+" "+"Name : "+name+" "+"Intime : "+inTime+" "+"outTime :"+outTime;
			
		}
 
   
  
	


	
}

package question2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeList 
{
   EmployeeNode  head = null;
   
   public void addEmployee(String name, int salary, int age)
   {   
	   EmployeeNode employee =  new EmployeeNode(new Employee(name , salary, age));
	   
	   if(head == null)
	   {
		   head = employee;
	   }
	   else
	   {
		   sort(employee);
	   }
   }
   
   public void sort(EmployeeNode employee)
   {
	  EmployeeNode employeeNode = head;
	  while(employeeNode != null)
	  {
		  if(employeeNode.getEmployee().getSalary() == employee.getEmployee().getSalary() )
		  {
			  if(employeeNode.getEmployee().getAge() > employee.getEmployee().getAge())
			  {
				  if(employeeNode.previous == null)
				  {
					employeeNode.previous = employee;
					employee.next = employeeNode;
					head = employee;
				  }
				  else
				  {
				    employee.previous = employeeNode.previous;
				     employeeNode.previous = employee;
 				     employee.next = employeeNode;
				  }
 				  
				  
				  break;
			  }
		  }
		  else if(employeeNode.getEmployee().getSalary() < employee.getEmployee().getSalary())
		  {
			  if(employeeNode.previous == null)
			  {
				employeeNode.previous = employee;
				employee.next = employeeNode;
				head = employee;
			  }
			  else
			  {
			    employee.previous = employeeNode.previous;
			     employeeNode.previous = employee;
				     employee.next = employeeNode;
			  }
			  break;
		  }
		  
		
		  employeeNode = employee.next;
	  }
	  
   }
   
   public void showEmployee()
   {
	   EmployeeNode employee = head;
	   
	   while(employee != null)
	   {
		   System.out.println("Employee Name = " + employee.getEmployee().getName() + "\n Employee Salary = " + employee.getEmployee().getSalary() + "\n Employee age = " + employee.getEmployee().getAge());
		   employee = employee.next;
	   }
   }
   
   
   public static void main(String arg[])
   {
	   EmployeeList obj = new EmployeeList();
	   
		obj.addEmployee("devang1", 220001, 28);
		obj.addEmployee("devang2", 220002, 25);
		obj.addEmployee("devang3", 220003, 35);
		obj.addEmployee("devang4", 220003, 30);
		obj.addEmployee("devang5", 220005, 40);
		obj.addEmployee("devang6", 220006, 30);
		
		obj.showEmployee();
	
   }
}

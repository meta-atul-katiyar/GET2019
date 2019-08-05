package question2;

/**
 *Represent the employee.
 */
public class Employee 
{
	private int age;
    private String name;
    private int salary;  
    
    /**
     * Initialize the value of employee.
     * @param name
     * @param salary
     * @param dateOfBirth
     */
    public Employee(String name, int salary, int age)
    {
    	this.setAge(age);
    	this.setName(name);
    	this.setSalary(salary);
    }

    //Return the date of birth.
	public int getAge()
	{
		return age;
	}

	//Set the date of birth.
	public void setAge(int age) 
	{
		this.age = age;
	}

	//Return the name.
	public String getName() 
	{
		return name;
	}

	//Set the name.
	public void setName(String name) 
	{
		this.name = name;
	}

	//Return the salary.
	public int getSalary()
	{
		return salary;
	}

	//Set the salary.
	public void setSalary(int salary) 
	{
		this.salary = salary;
	}
}

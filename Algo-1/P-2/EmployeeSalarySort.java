
public class EmployeeSalarySort {
	EmployeeNode start = null;
	
	/**
	 * @param id
	 * @param name
	 * @param salary
	 * @param dob
	 * insert employees in list by insertion sort
	 */
	public void insert(int id, String name, int salary,  String dob){
		Employee newEmployee = new Employee(id, name, salary, dob);
		EmployeeNode newEmployeeNode = new EmployeeNode(newEmployee);
		if(start == null){
			start = newEmployeeNode;
		}
		else{
			EmployeeNode currNode = start;
			while(currNode.emp.getSalary() > newEmployeeNode.emp.getSalary()){
				if(currNode.next == null){break;}
				currNode = currNode.next;
			}
			if(currNode != null && currNode.emp.getSalary() == newEmployeeNode.emp.getSalary()){
				while(currNode.emp.getSalary() == newEmployeeNode.emp.getSalary() &&
						currNode.emp.getAge() > newEmployeeNode.emp.getAge()){ //if new employee is older
					System.out.println(currNode.emp.getSalary()+" "+newEmployeeNode.emp.getSalary());
					if(currNode.next == null){break;}
					currNode = currNode.next;
					System.out.println(currNode.emp.getSalary()+" "+newEmployeeNode.emp.getSalary());
				}
			}
			if(currNode.emp.getSalary() == newEmployeeNode.emp.getSalary()){
				if(currNode.emp.getAge() >= newEmployeeNode.emp.getAge()){
					newEmployeeNode.prev = currNode;
					newEmployeeNode.next = currNode.next;
					currNode.next = newEmployeeNode;
				}
				else{
					System.out.println(currNode.emp.getSalary()+" "+newEmployeeNode.emp.getSalary());
					newEmployeeNode.prev = currNode.prev;
					currNode.prev = newEmployeeNode;
					newEmployeeNode.next = currNode;
					newEmployeeNode.prev.next = newEmployeeNode;
				}
			}
			else if(currNode.emp.getSalary() > newEmployeeNode.emp.getSalary()){
				if(currNode.next == null){
					System.out.println(newEmployeeNode.emp.getSalary());
					newEmployeeNode.prev = currNode;
					currNode.next = newEmployeeNode;
				}
				else{
					newEmployeeNode.next = currNode.next;
					currNode.next = newEmployeeNode;
					newEmployeeNode.prev = currNode;
					newEmployeeNode.next.prev = newEmployeeNode;
				}
					
			}
			else{
				newEmployeeNode.prev = currNode.prev;
				currNode.prev = newEmployeeNode;
				newEmployeeNode.next = currNode;
				newEmployeeNode.prev.next = newEmployeeNode;
			}
		}
	}
	
	/**
	 * @param start
	 * print all the employees sorted by (salary(DESC)>age(ASC))
	 */
	public static void print(EmployeeNode start){
		EmployeeNode tempNode = start;
		while(tempNode != null){
			System.out.println(tempNode.emp.getSalary()+" "+ tempNode.emp.getAge());
			tempNode = tempNode.next;
			if(tempNode == null){
				break;
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		EmployeeSalarySort ess = new EmployeeSalarySort();
		
		ess.insert(1,"a", 16000, "1-2-1997");
		ess.insert(1,"a", 160, "1-2-1987");
		ess.insert(1,"a", 106, "1-2-1997");
		ess.insert(1,"a", 216, "1-2-1977");
		ess.insert(1,"a", 1, "1-2-1997");
		ess.insert(1,"a", 6, "1-2-1998");
		ess.insert(1,"a", 1600, "1-2-1996");
		ess.insert(1,"a", 1600, "1-2-1997");
		ess.insert(1,"a", 1060, "1-2-1995");
		ess.insert(1,"a", 15, "1-2-1997");
		print(ess.start);	
	}
}

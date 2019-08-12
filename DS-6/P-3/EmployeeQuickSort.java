
public class EmployeeQuickSort {
	EmployeeNode start = null, end = null;

	/**
	 * @param id
	 * @param name
	 * @param salary
	 * @param dob
	 *            insert employees in list by insertion sort
	 */
	public void insert(int id, String name, int salary, String dob) {
		Employee newEmployee = new Employee(id, name, salary, dob);
		EmployeeNode newEmployeeNode = new EmployeeNode(newEmployee);
		if (start == null) {
			start = newEmployeeNode;
			end = start;
		} else {
			EmployeeNode currNode = start;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = newEmployeeNode;
			end = newEmployeeNode;
		}
	}

	public EmployeeNode getEnd(EmployeeNode node) {
		while (node != null && node.next != null) {
			node = node.next;
		}
		return node;
	}

	@SuppressWarnings("null")
	public EmployeeNode partition(EmployeeNode low, EmployeeNode high){
		int x = high.emp.getSalary(); 
		EmployeeNode i = low.prev; 
		for(EmployeeNode j=low; j!=high; j=j.next){
			if(j.emp.getSalary() >= x){ 
	            i = (i==null) ? low : i.next;
	            //System.out.println(j.next.emp.getSalary());
	            int salary = i.emp.getSalary(),
	            		id = i.emp.getEmpId();
	            String name = i.emp.getName(),
	            		dob1 = i.emp.getdob();
	            i.emp.salary = j.emp.getSalary();
	            i.emp.dob = j.emp.getdob();
	            i.emp.empId = j.emp.getEmpId();
	            i.emp.name = j.emp.getName();
	            j.emp.salary = salary;
	            j.emp.dob = dob1;
	            j.emp.empId = id;
	            j.emp.name = name;
	        }
       }
    i = (i==null) ? low : i.next;  // Similar to i++ 
    //System.out.println(i.emp.getSalary());
    int temp = i.emp.getSalary(); 
    i.emp.salary = high.emp.getSalary(); 
    high.emp.salary = temp; 
    return i;
		
	}

	public void quickSortBySalary(EmployeeNode low, EmployeeNode high) {
		if(high!=null && low!=high && low!=high.next){ 
			EmployeeNode temp = partition(low,high); 
            quickSortBySalary(low,temp.prev); 
            quickSortBySalary(temp.next,high); 
            
            for(EmployeeNode j=low; j!=high; j=j.next){
            	if(j != high && j.next.emp.getSalary() == j.emp.getSalary()){
                	if(j.next.emp.getBirthYear() > j.emp.getBirthYear()){// && i.next == j){
                		int salary1 = j.next.emp.getSalary(),
                         		id1 = j.next.emp.getEmpId();
                         String name1 = j.next.emp.getName(),
                         		dob11 = j.next.emp.getdob();
                         
                         j.next.emp.salary = j.emp.getSalary();
                         j.next.emp.dob = j.emp.getdob();
                         j.next.emp.empId = j.emp.getEmpId();
                         j.next.emp.name = j.emp.getName();
                         
                         j.emp.salary = salary1;
                         j.emp.dob = dob11;
                         j.emp.empId = id1;
                         j.emp.name = name1;
                	}
            	}
            }
        } 
	}

	/**
	 * @param start
	 *            print all the employees sorted by (salary(DESC)>age(ASC))
	 */
	public static void print(EmployeeNode start) {
		EmployeeNode tempNode = start;
		while (tempNode != null) {
			System.out.println(tempNode.emp.getSalary() + " "
					+ tempNode.emp.getBirthYear());
			tempNode = tempNode.next;
			if (tempNode == null) {
				break;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		EmployeeQuickSort ess = new EmployeeQuickSort();

		ess.insert(1, "a", 16000, "1-2-1997");
		ess.insert(1, "a", 160, "1-2-1987");
		ess.insert(1, "a", 106, "1-2-1997");
		ess.insert(1, "a", 216, "1-2-1977");
		ess.insert(1, "a", 1, "1-2-1997");
		ess.insert(1, "a", 6, "1-2-1998");
		ess.insert(1, "a", 1600, "1-2-1997");
		ess.insert(1, "a", 1600, "1-2-1998");
		ess.insert(1, "a", 1060, "1-2-1995");
		ess.insert(1, "a", 1500, "1-2-1997");

		print(ess.start);
		ess.quickSortBySalary(ess.start, ess.end);
		print(ess.start);

	}
}

import java.util.*;


public class EmployNameSort{

	Set<Employ> employSet = new HashSet<Employ>();
	LinkedList<Employ> sortedEmpList = new LinkedList<Employ>();

	public void addToEmploy(int id, String name, String address){
		Employ employ = new Employ(id, name, address);
		employSet.add(employ);
	}

	public void sortByName(){
		int flag = 0;
		for(Employ emp : employSet){
			if(flag == 0){
				sortedEmpList.add(emp);
				flag = 1;
			}
			else{
				int index = 0;
				for(Employ sortedEmp : sortedEmpList){
					if(emp.getName().compareToIgnoreCase(sortedEmp.getName()) > 0){
						index++;
					}
				}
				sortedEmpList.add(index, emp);
			}
		}
	}
	
	public String[] sortedNames(){
		int empNum = sortedEmpList.size(), index = 0;
		String [] empNames = new String[empNum];
		for(Employ emp : this.sortedEmpList){
			empNames[index++] = emp.getName();
		}
		return empNames;
	}
	
	public static void main(String[]args){
		EmployNameSort ens = new EmployNameSort();
		ens.addToEmploy(14, "jvv vv", "asdfghj");
		ens.addToEmploy(2, "fvv vv", "asdfghj");
		ens.addToEmploy(5, "dvv vv", "asdfghj");
		ens.addToEmploy(11, "avd vv", "asdfghj");
		
		ens.sortByName();
		for(Employ emp: ens.sortedEmpList){
			System.out.println(emp.getName());
		}
		
	}
}

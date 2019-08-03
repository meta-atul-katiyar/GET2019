import java.util.*;


public class EmployNameSort{

	Set<Employ> employSet = new HashSet<Employ>();
	LinkedList<Employ> sortedEmpList = new LinkedList<Employ>();

	public void addToEmploy(String name, String address){
		Employ employ = new Employ(name, address);
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
	
	public static void main(String[]args){
		EmployNameSort ens = new EmployNameSort();
		ens.addToEmploy("jvv vv", "asdfghj");
		ens.addToEmploy("fvv vv", "asdfghj");
		ens.addToEmploy("dvv vv", "asdfghj");
		ens.addToEmploy("avd vv", "asdfghj");
		
		ens.sortByName();
		for(Employ emp: ens.sortedEmpList){
			System.out.println(emp.getName());
		}
		
	}
}
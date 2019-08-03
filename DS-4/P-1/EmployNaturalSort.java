
import java.util.*;

public class EmployNaturalSort{

	Set<Employ> employSet = new HashSet<Employ>();
	LinkedList<Employ> sortedEmpList = new LinkedList<Employ>();

	public void addToEmploy(int id, String name, String address){
		Employ employ = new Employ(id, name, address);
		employSet.add(employ);
	}

	public void sort(){
		int flag = 0;
		for(Employ emp : employSet){
			if(flag == 0){
				sortedEmpList.add(emp);
				flag = 1;
			}
			else{
				int index = 0;
				for(Employ sortedEmp : sortedEmpList){
					if(emp.getEmpId() > sortedEmp.getEmpId()){
						index++;
					}
				}
				sortedEmpList.add(index, emp);
			}
		}
	}
	
	public int[] sortedEmpID(){
		int empNum = sortedEmpList.size(), index = 0;
		int [] empID = new int[empNum];
		for(Employ emp : this.sortedEmpList){
			empID[index++] = emp.getEmpId();
		}
		return empID;
	}
	
	public static void main(String[]args){
		EmployNaturalSort ens = new EmployNaturalSort();
		ens.addToEmploy(14, "jvv vv", "asdfghj");
		ens.addToEmploy(2, "fvv vv", "asdfghj");
		ens.addToEmploy(5, "dvv vv", "asdfghj");
		ens.addToEmploy(11, "avd vv", "asdfghj");
		
		ens.sort();
		for(Employ emp: ens.sortedEmpList){
			System.out.println(emp.getName());
		}
		
	}
}

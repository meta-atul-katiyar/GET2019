
import java.util.*;

public class EmploySet{

	Set<Employ> employSet = new HashSet<Employ>();

	public void addToEmploy(int id, String name, String address){
		int flag = 0;
		for(Employ emp : employSet){
			if(emp.getEmpId() == id){
				flag = 1;
			}
		}
		if(flag == 0){
			Employ employ = new Employ(id, name, address);
			employSet.add(employ);
		}
	}
	
	public static void main(String[]args){
		EmploySet ens = new EmploySet();
		ens.addToEmploy(14, "jvv vv", "asdfghj");
		ens.addToEmploy(2, "fvv vv", "asdfghj");
		ens.addToEmploy(5, "dvv vv", "asdfghj");
		ens.addToEmploy(11, "avd vv", "asdfghj");
		ens.addToEmploy(14, "jvv vv", "asdfghj");
		
		for(Employ emp: ens.employSet){
			System.out.println(emp.getName());
		}
		
	}
}

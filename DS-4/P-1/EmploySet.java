
import java.util.Set;
import java.util.*;

public class EmploySet{

	Set<Employ> employSet = new HashSet<Employ>();

	public void addToEmploy(String name, String address){
		Employ employ = new Employ(name, address);
		employSet.add(employ);
	}
}

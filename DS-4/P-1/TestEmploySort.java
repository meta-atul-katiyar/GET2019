
import static org.junit.Assert.*;

import org.junit.Test;

public class TestEmploySort {
	private int[] expected1 = new int[]{
		2,5,11,14	
	};
	private String[] expected2 = {
			"avd vv", "dvv vv", "fvv vv", "jvv vv"
	};
	@Test
	public void testNatSort(){
		EmployNaturalSort ens = new EmployNaturalSort();
		ens.addToEmploy(14, "jvv vv", "asdfghj");
		ens.addToEmploy(2, "fvv vv", "asdfghj");
		ens.addToEmploy(5, "dvv vv", "asdfghj");
		ens.addToEmploy(11, "avd vv", "asdfghj");
		
		ens.sort();
		assertArrayEquals(expected1, ens.sortedEmpID());
	}
	
	public void testNameSort(){
		EmployNameSort ens = new EmployNameSort();
		ens.addToEmploy(14, "jvv vv", "asdfghj");
		ens.addToEmploy(2, "fvv vv", "asdfghj");
		ens.addToEmploy(5, "dvv vv", "asdfghj");
		ens.addToEmploy(11, "avd vv", "asdfghj");
		
		ens.sortByName();
		assertArrayEquals(expected2, ens.sortedNames());
	}
	
}


import static org.junit.Assert.*;
import org.junit.Test;

public class TestEmployee {

	private int[][] expected = new int[][]{
			{16000, 1997},
			{1600, 1997},
			{1600, 1996},
			{1060, 1995},
			{216, 1977},
			{160, 1987},
			{106, 1997},
			{15, 1997},
			{6, 1998},
			{1, 1997}
	};
	
	@Test
	public void testsorted(){
		int[][] input;
		int index = 0;
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
		
		input = new int[10][2];
		EmployeeNode tempNode = ess.start;
		while(tempNode != null){
			System.out.println(tempNode.emp.getSalary()+" "+ tempNode.emp.getAge());
			input[index][0] = tempNode.emp.getSalary();
			input[index++][1] = tempNode.emp.getAge();
			tempNode = tempNode.next;
			if(tempNode == null){
				break;
			}
		}
		System.out.println();
		
		assertArrayEquals(expected, input);
	}

}

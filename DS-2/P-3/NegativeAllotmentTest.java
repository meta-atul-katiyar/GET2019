import org.junit.Test;
import org.junit.Test;

public class NegativeAllotmentTest {
	 String stu = "C:\\Users\\Atul\\Downloads\\studentData.xls",
			 prog = "C:\\Users\\Atul\\Downloads\\programList.xl",
			 result = "C:\\Users\\Atul\\Downloads\\counselResult.xls";
	 
	 String stu1 = "C:\\Users\\Atul\\Downloads\\studentData.xl",
			 prog1 = "C:\\Users\\Atul\\Downloads\\programList.xls",
			 result1 = "C:\\Users\\Atul\\Downloads\\counselResult.xls";
	 
	
	
	@Test(expected = java.lang.Exception.class)
	 public void testOp1(){
		Counselling counselling = new Counselling(stu, prog, result);
		counselling.allotment();
	}
	
	@Test(expected = java.lang.Exception.class)
	 public void testOp2(){
		Counselling counselling = new Counselling(stu1, prog1, result1);
		counselling.allotment();
	}
}
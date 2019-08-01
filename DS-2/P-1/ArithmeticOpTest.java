import static org.junit.Assert.*;
import org.junit.Test;

public class ArithmeticOpTest {
	private String expected1 =  "28.08";
	private String expected2 =  "true";
	private String expected3 =  "true";
	private ArithmeticOpStack arithmeticOpStack;
	
	
	@Test
	 public void testOp1(){
		assertEquals(expected1, arithmeticOpStack.arithmeticOp("11 + 222 / 13")); 
	}
	
	@Test
	 public void testOp2(){
		assertEquals(expected2, arithmeticOpStack.arithmeticOp("(  ( 1 == 1 ) || ( 22  != 3 ) )")); 
	}
	
	@Test
	 public void testOp3(){
		assertEquals(expected3, arithmeticOpStack.arithmeticOp("(  ( 1 + 1 ) == ( 22  / 11 ) )")); 
	}
}

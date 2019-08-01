
import org.junit.Test;

public class NegativeArithmeticOpTest {
	private ArithmeticOpStack arithmeticOpStack;
	
	@Test(expected = AssertionError.class)
	 public void testOp1(){
		arithmeticOpStack.arithmeticOp("11 ` 222 / 13"); 
	}
	
	@Test(expected = AssertionError.class)
	 public void testOp2(){
		arithmeticOpStack.arithmeticOp("11 ++ 222 / 13"); 
	}
}

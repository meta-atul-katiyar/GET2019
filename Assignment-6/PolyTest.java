
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*; 

public class PolyTest {

	 private String expectedResult = "-37.5600";
	 private Poly poly;
	 
	 @Before
	 public void initialize() {
		String str = "-4*x*x-2*x-3"; 
		char[] charArray = str.toCharArray();
		poly = new Poly(charArray);
	 }
	 
	   @Test
	   public void testLCMHCF() {
		   System.out.println("ans: "+poly.evaluate((float)2.7));
	       assertEquals(expectedResult, 
	       poly.evaluate((float)2.7));
	   } 
}
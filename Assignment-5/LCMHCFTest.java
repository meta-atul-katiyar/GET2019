import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LCMHCFTest {
	 private int inputNumber1;
	 private int inputNumber2;
	 private int expectedResult;
	 private LCMHCF lcmHCF;
	 
	 @Before
	 public void initialize() {
		 lcmHCF = new LCMHCF();
	 }
	 
	 public LCMHCFTest(int inputNumber1, int inputNumber2, Integer expectedResult) {
	      this.inputNumber1 = inputNumber1;
	      this.inputNumber2 = inputNumber2;
	      this.expectedResult = expectedResult;
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
	         { 9,12, 36 },
	         { 10,4, 20 },
	         { 13,41, 533 },
	         { 10,49, 490 }
	      });
	   }
	   
	   @Test
	   public void testMaxMirror() {
		   System.out.print(inputNumber1+" and " + inputNumber2);
		   System.out.println();
	       assertEquals(expectedResult, 
	       lcmHCF.LCM(inputNumber1, inputNumber2));
	   } 
}
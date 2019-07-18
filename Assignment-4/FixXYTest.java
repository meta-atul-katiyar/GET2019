
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*; 
@RunWith(Parameterized.class)
public class FixXYTest {
	 private int inputNumber[];
	 private int[] expectedResult;
	 private ArrOperation arrOperation;
	 
	 @Before
	 public void initialize() {
		 arrOperation = new ArrOperation();
	 }
	 
	 public FixXYTest(int[] inputNumber, int[] expectedResult) {
	      this.inputNumber = inputNumber;
	      this.expectedResult = expectedResult;
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
	         {  new int[]{5, 4, 9, 4, 9, 5}, new int[]{9, 4, 5, 4, 5, 9}},
	         {  new int[]{1, 4, 1, 5}, new int[]{1, 4, 5, 1} },
	         {  new int[]{1, 4, 1, 5, 5, 4, 1}, new int[]{1, 4, 5, 1, 1, 4, 5} }
	      });
	   }
	   
	   @Test
	   public void testFixXY() {
		  for(int arr1 : inputNumber){
			  System.out.print(" " + arr1);
		  }
	      System.out.println();
	      for (int arr2 : arrOperation.fixXY((inputNumber), 4,5)){
	    	  System.out.print(" " + arr2);
	      }
	      System.out.println();
	      assertArrayEquals(expectedResult, 
	      arrOperation.fixXY((inputNumber), 4,5));
	   } 
}

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

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
	         {  new int[]{1, 4, 1, 5, 5, 4, 1}, new int[]{1, 4, 5, 1, 1, 4, 5} },
	         {  new int[]{1, 4, 5, 3, 5, 1}, new int[]{-1} },
	         {  new int[]{1, 5, 5, 1, 8, 9, 3, 2, 1}, new int[]{-1} }
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
	      assertEquals(expectedResult, 
	      arrOperation.fixXY((inputNumber), 4,5));
	   } 
}
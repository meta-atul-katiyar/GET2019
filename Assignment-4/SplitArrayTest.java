import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SplitArrayTest {
	 private int inputNumber[];
	 private int expectedResult;
	 private ArrOperation arrOperation;
	 
	 @Before
	 public void initialize() {
		 arrOperation = new ArrOperation();
	 }
	 
	 public SplitArrayTest(int[] inputNumber, Integer expectedResult) {
	      this.inputNumber = inputNumber;
	      this.expectedResult = expectedResult;
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
	         { new int[]{1, 1, 1, 2, 1}, 3 },
	         {  new int[]{2, 1, 1, 2, 1}, -1 },
	         {  new int[]{10, 10}, 1 },
	         {  new int[]{1, 4, 5, 3, 3, 5, 4, 1}, 4 },
	         {  new int[]{1, 2, 1, 8, 9, 3, 2, 1}, -1 }
	      });
	   }
	   
	   @Test
	   public void testSplitArray() {
		  for(int arr1 : inputNumber){
			  System.out.print(" " + arr1);
		  }
	      System.out.println();
	      assertEquals(expectedResult, 
	      arrOperation.splitArray(inputNumber));
	   } 
}

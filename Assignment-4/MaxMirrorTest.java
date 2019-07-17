import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaxMirrorTest {
	 private int inputNumber[];
	 private int expectedResult;
	 private ArrOperation arrOperation;
	 
	 @Before
	 public void initialize() {
		 arrOperation = new ArrOperation();
	 }
	 
	 public MaxMirrorTest(int[] inputNumber, Integer expectedResult) {
	      this.inputNumber = inputNumber;
	      this.expectedResult = expectedResult;
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
	         { new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3 },
	         {  new int[]{7, 1, 4, 9, 7, 4, 1}, 2 },
	         {  new int[]{1, 2, 1, 4}, 3 },
	         {  new int[]{1, 4, 5, 3, 5, 4, 1}, 7 },
	         {  new int[]{1, 2, 1, 8, 9, 3, 2, 1}, 3 }
	      });
	   }
	   
	   @Test
	   public void testMaxMirror() {
		  for(int arr1 : inputNumber){
			  System.out.print(" " + arr1);
		  }
	      System.out.println();
	      assertEquals(expectedResult, 
	      arrOperation.maxMirror(inputNumber));
	   } 
}

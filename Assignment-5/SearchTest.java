import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SearchTest {
	 private int inputNumber[];
	 private int findNum;
	 private int expectedResult;
	 private Search search;
	 
	 @Before
	 public void initialize() {
		 search = new Search();
	 }
	 
	 public SearchTest(int[] inputNumber, int findNum, Integer expectedResult) {
	      this.inputNumber = inputNumber;
	      this.findNum = findNum;
	      this.expectedResult = expectedResult;
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
	         { new int[]{1, 2, 3, 8, 9, 3, 2, 1},3, 2 },
	         {  new int[]{7, 1, 4, 9, 7, 4, 1},9, 3 },
	         {  new int[]{1, 2, 1, 4},1, 0 },
	         {  new int[]{1, 4, 5, 3, 5, 4, 1},3, 3 },
	         {  new int[]{1, 2, 1, 8, 9, 3, 2, 1},8, 3 }
	      });
	   }
	   
	   @Test
	   public void testMaxMirror() {
		  for(int arr1 : inputNumber){
			  System.out.print(" " + arr1);
		  }
	      System.out.println();
	      assertEquals(expectedResult, 
	      search.linearSearch(inputNumber, findNum, 0));
	   } 
}
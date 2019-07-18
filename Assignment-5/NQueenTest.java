import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NQueenTest {
	 private int inputNumber;
	 private boolean expectedResult;
	 private NQueens nQueens;
	 
	 @Before
	 public void initialize() {
		 nQueens = new NQueens();
	 }
	 
	 public NQueenTest(int inputNumber, boolean expectedResult) {
	      this.inputNumber = inputNumber;
	      this.expectedResult = expectedResult;
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
	    	 { 2, false},
	    	 { 3, false },
	         { 4, true },
	         { 5, true },
	         { 6, true },
	         { 7, true },
	         { 8, true },
	         { 9, true },
	      });
	   }
	   
	   @Test
	   public void testMaxMirror() {
		  System.out.println(" " + inputNumber);
		  int[][] board = nQueens.createBoard(inputNumber);
	      assertEquals(expectedResult, 
	      	nQueens.nQueen(board,0,inputNumber));
	   } 
}

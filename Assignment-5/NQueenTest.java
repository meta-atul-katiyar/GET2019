import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NQueenTest {
	private int startRow;
	private int boardDimension;
	private boolean expectedResult;
	private NQueens nQueens;
	 
	@Before
	public void initialize() {
		nQueens = new NQueens();
	}
	 
	public NQueenTest(int startRow, int boardDimension, boolean expectedResult) {
		this.startRow = startRow;
		this.boardDimension = boardDimension;
		this.expectedResult = expectedResult;
	}
	 
	@Parameterized.Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
	    	 { 0,2, false},
	    	 { 1,3, false },
	         { 2,4, true },
	         { 3,5, true },
	         { 4,6, true },
	         { 5,7, true },
	         { 6,8, true },
	         { 7,9, true },
	      });
	   }
	   
	   @Test
	   public void testMaxMirror() {
		  System.out.println(startRow+" " +boardDimension);
		  int[][] board = nQueens.createBoard(boardDimension);
	      assertEquals(expectedResult, 
	      	nQueens.nQueen(board,startRow,boardDimension));
	   } 
}

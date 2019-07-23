import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class MatrixMultiplyTest {
	private int[][] expected = new int[][] {{1,1,10},{4,4,12}};
	private SparseMatrices sparseMatrix1;
	private SparseMatrices sparseMatrix2;
	
	 @Before
	 public void initialize() {
		int[] row = new int[]   {0,1,4,3,4,5};
		int[] column = new int[]{0,1,0,3,4,5};
		int[] value = new int[] {1,2,3,4,5,6};
			
		int[] row1 = new int[]   {0,0,1,4,5,2};
		int[] column1 = new int[]{2,4,1,5,1,0};
		int[] value1 = new int[] {3,4,5,4,5,3};
		
		sparseMatrix1 = new SparseMatrices(row, column, value);
		sparseMatrix2 = new SparseMatrices(row1, column1, value1);
	 }
	 
	 @Test
	 public void testLCMHCF() {
		 //System.out.println("ans: "+poly.evaluate((float)2.7));
	     assertArrayEquals(expected, 
	    		 SparseMatrices.multiplyMatrices(sparseMatrix1, sparseMatrix2));
	   } 
}

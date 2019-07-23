import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class MatrixMultiplyTest {
	private int[][] expected = new int[][] {
			{1, 1, 10},
			{5, 1, 30},
			{4, 5, 20},
			{0, 2, 3},
			{0, 4, 4},
			{2, 0, 9}
			};
	private SparseMatrices sparseMatrix1;
	private SparseMatrices sparseMatrix2;
	
	 @Before
	 public void initialize() {
		 int[][] matrix = new int[][] {
					{0,0,1},
					{1,1,2},
					{2,2,3},
					{3,3,4},
					{4,4,5},
					{5,5,6}
			};
			int [][] matrix1 = new int[][]{
					{0,2,3},
					{0,4,4},
					{1,1,5},
					{4,5,4},
					{5,1,5},
					{2,0,3}
			};
		
		sparseMatrix1 = new SparseMatrices(matrix);
		sparseMatrix2 = new SparseMatrices(matrix1);
	 }
	 
	 @Test
	 public void testLCMHCF() {
	     assertArrayEquals(expected, 
	    		 SparseMatrices.multiplyMatrices(sparseMatrix1, sparseMatrix2));
	   } 
}

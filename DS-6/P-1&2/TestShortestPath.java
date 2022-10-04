import static org.junit.Assert.*;

import org.junit.Test;

public class TestShortestPath {

	String expected = "1-3-4-6-5";
	@Test
	public void testShort(){
		int[] verticesArray = new int[] { 1, 2, 3, 4, 5, 6 };
		UndirectedGraphImplement ugi = new UndirectedGraphImplement(verticesArray);
		int[][] verMat = new int[][] {
				{ 1, 2, 2 },
				{ 1, 3, 3 },
				{ 2, 3, 4 },
				// {3,3,6},
				{ 3, 4, 6 },
				{ 4, 5, 8 },
				{ 4, 6, 5 },
				{ 5, 5, 4 },
				{ 5, 6, 1 }
			};
		ugi.insertWeightInMat(verMat);
		ugi.shortestPath(1,5);
		assertEquals(expected, ugi.shortestPath(1,5));
	}
}

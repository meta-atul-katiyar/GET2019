
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestReachable {

	int[] expected = new int[]{1,2,4,5,6};
	Set<Integer> reachableVer = new HashSet<Integer>();
	@Test
	public void testConnected(){
		int[] verticesArray = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] output;
		int index = 0;
		
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
		reachableVer = ugi.reachable(3);
		output = new int[reachableVer.size()];
		for (int i : reachableVer)
			output[index++] = i;
		assertArrayEquals(expected, output);
	}
}

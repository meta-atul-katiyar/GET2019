import static org.junit.Assert.*;

import org.junit.Test;

public class TestVirat {

	private int[] expected1 =  new int[]{7,
			7,
			7,
			7,
			5,
			5,
			7,
			1,
			1,
			7,
			5,
			5,
			7,
			1,
			1
		};
	@Test
	 public void testVirat(){
		int[][] ba = new int[][]{
				{0,5},
				{1,15},
				{2,10},
				{3,8},
				{4,11},
				{5,16},
				{6,2},
				{7,19},
				{8,7},
				{9,6},
				{10,2},
				{11,4},
				{12,7}
		};
		ViratAndBowler vb = new ViratAndBowler(13,15,ba);
		assertArrayEquals(expected1, vb.bowlerOrder());
		
	}
}

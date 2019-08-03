import static org.junit.Assert.*;

import org.junit.Test;

public class TestUniqueCharCount {

	private int expected1 =  9;
	private int expected2 =  9;
	private int expected3 =  9;
	
	@Test
	public void testUniqueCharCount(){
		UniqueCharNum ucn = new UniqueCharNum();
		assertEquals(expected1, ucn.countUniqueChar("asdfghjk asdfghjk"));
		assertEquals(expected2, ucn.countUniqueChar("asdfghjk  asdfghjk"));
		assertEquals(expected3, ucn.countUniqueChar("asdfghjk asdfghjk"));
	}
}

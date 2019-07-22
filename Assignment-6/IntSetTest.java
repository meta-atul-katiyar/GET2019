
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*; 

public class IntSetTest {

	 private int[] expectedResult = (new int[]{1,2,3,4,5,6,11,16});
	 private IntSet intSet1;
	 private IntSet intSet2;
	 
	 @Before
	 public void initialize() {
		 intSet1 = new IntSet(new int[]{1,2,3,4,5,6});
		 intSet2 = new IntSet(new int[]{11,2,3,4,5,16});
	 }
	 
	   @Test
	   public void testLCMHCF() {
		   System.out.println("a");
	       assertArrayEquals(expectedResult, 
	       IntSet.union(intSet1, intSet2));
	   } 
}
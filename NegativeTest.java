import org.junit.Test;
import org.junit.Before;

public class NegativeTest {
	 private ArrOperation arrOperation;	 
	 @Before
	 public void initialize() {
		 arrOperation = new ArrOperation();
	 }
	 
	 @Test(expected = AssertionError.class)
	 public void maxMirrorAE() {
		 arrOperation.maxMirror(new int[]{});
	 }
	   
	 @Test(expected = AssertionError.class)
	 	public void countClumpsAE() { 
		arrOperation.countClumps(new int[]{});
	 }
	   
	 @Test(expected = AssertionError.class)
	 	public void fixXYAE() { 
		arrOperation.fixXY(new int[]{}, 0 , 0);
	 }
	   
	 @Test(expected = AssertionError.class)
	 	public void splitArrayAE() { 
		 arrOperation.splitArray(new int[]{});
	 }
}
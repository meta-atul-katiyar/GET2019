
import static org.junit.Assert.*;
import org.junit.Test;

public class MultivariateDegreeTest {
	private int expected = 8;
	private MultivariatePoly multivariatePoly;
	private MultivariatePoly.Degree multivariatePolyDegree;
	private MultivariatePoly.Coefficient multivariatePolymultivariatePoly;
	 
	 @Test 
	 public void testPolyDegree(){
		 MultivariatePoly multivariatePoly = new MultivariatePoly(4);
		 multivariatePoly.insert(multivariatePoly, -3, new int[]{2,2,0,0});
		 multivariatePoly.insert(multivariatePoly, 2,new int[]{2,2,2,2});
		 multivariatePoly.insert(multivariatePoly, -9,new int[]{2,0,2,0});
		 multivariatePoly.insert(multivariatePoly, 25, new int[]{0,0,0,0});
		 
		 assertEquals(expected,multivariatePoly.degreeOfPoly(multivariatePoly));
			
	 }
}

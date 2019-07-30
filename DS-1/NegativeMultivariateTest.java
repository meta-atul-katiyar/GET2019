
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class NegativeMultivariateTest {
	private MultivariatePoly.Degree multivariatePolyDegree;
	private MultivariatePoly.Coefficient multivariatePolymultivariatePoly;
	
	 @Test (expected = AssertionError.class)
	 public void testPolyDegree(){
		 MultivariatePoly multivariatePoly = new MultivariatePoly(4);
		 multivariatePoly.degreeOfPoly(multivariatePoly);
	 }
}

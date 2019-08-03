
import static org.junit.Assert.*;

import org.junit.Test;

public class TestMolecularMass {

	private int expected = 574;
	@Test
	public void testUniqueCharCount(){
		MolecularMass mm = new MolecularMass();
		assertEquals(expected, mm.molecularMass("(C(CO2)12(OH)2)"));
	}
}
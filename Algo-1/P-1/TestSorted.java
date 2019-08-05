
import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;

public class TestSorted {

	private String expected = "1:one	2:two	3:three	4:four	5:five	6:six	7:seven	8:eight	9:nine	10:ten	11:eleven	12:twelve	13:thirteen	14:fourteen	15:fifteen	16:sixteen	17:seventeen	";
	
	@Test
	public void testsorted(){
		String FILE_PATH = "C:\\Users\\Atul\\Downloads\\test.json";
		DictionaryImplement di = new DictionaryImplement();
		JSONArray jsonArr = di.readJsonFile(FILE_PATH);
		di.addJsonArray(jsonArr);
		assertEquals(expected, di.sorted());
	}

}

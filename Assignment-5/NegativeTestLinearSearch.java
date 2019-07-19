import org.junit.Test;
import org.junit.Before;

public class NegativeTestLinearSearch {
	 private Search search;	 
	 @Before
	 public void initialize() {
		 search = new Search();
	 }
	 
	 @Test(expected = ArrayIndexOutOfBoundsException.class)
	 public void linearSearchNullArray() {
		 search.linearSearch(new int[]{}, 1,1);
	 }
	 @Test(expected = ArrayIndexOutOfBoundsException.class)
	 public void linearSearchIndexNotFound() {
		 search.linearSearch(new int[]{2,3,4,5,6}, 1,1);
	 }
}


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class NegativeAddAnimalTest {
	private int expected1 = 0;
	private int expected2 = 0;
	private ZooManagementSystem zooManagementSystem;
	
	 @Before
	 public void initialize() {
		 
	 }
	 
	 @Test
	 public void testAddAnimal() {
		 zooManagementSystem.addToCategory();
		// if no zone is available
	     assertEquals(expected1, 
	    		 zooManagementSystem.addAnimal("Tiger", 4f, 50f, "Male"));
	     assertEquals(expected2, 
    		 zooManagementSystem.addAnimal("Parrot", 4f, 0.4f, "Male"));
   } 
}

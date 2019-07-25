import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class AddAnimalTest {
	private int expected1 = 120000;
	private int expected2 = 120001;
	private ZooManagementSystem zooManagementSystem;
	
	 @Before
	 public void initialize() {
		 
	 }
	 
	 @Test
	 public void testAddAnimal() {
		 zooManagementSystem.addToCategory();
		 zooManagementSystem.addZones(4, "Tiger");
		 zooManagementSystem.addCage(5, "Tiger");
		 
		 zooManagementSystem.addZones(4, "Parrot");
		 zooManagementSystem.addCage(5, "Parrot");
	     assertEquals(expected1, 
	    		 zooManagementSystem.addAnimal("Tiger", 4f, 50f, "Male"));
	     assertEquals(expected2, 
    		 zooManagementSystem.addAnimal("Parrot", 4f, 0.4f, "Male"));
   } 
}

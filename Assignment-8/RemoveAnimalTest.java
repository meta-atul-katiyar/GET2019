
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class RemoveAnimalTest {
	private int expected = 120001;
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
		 
		 zooManagementSystem.addAnimal("Tiger", 4f, 50f, "Male");
		 zooManagementSystem.addAnimal("Parrot", 4f, 0.4f, "Male");

	     assertEquals(expected, 
	    		 zooManagementSystem.removeAnimal("Parrot", 120001) );
   } 
}

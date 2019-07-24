import java.util.*;


public class Zone {
	private int id;
	private static int count = 0;
	static int cageNumber;
	
	private static LinkedList<Cage> cages = new LinkedList<Cage>();
	
	Zone(int cageNumber){
		this.id = 110000 + count++;
		this.cageNumber = cageNumber;
	}
	
	public void addCage(int capacity, String animalType){
		Cage cage = new Cage(capacity, animalType);
		cages.add(cage);
		this.cageNumber -= 1;
	}
	
	public int cageCapcity(String animalType){
		if(cages == null){
			addCage(4, animalType);
		}
		for(Cage cage : cages){
			if(cage.animalType == animalType && cage.capacity > 0){
				return cage.capacity;
			}
		}
		if(Zone.cageNumber > 0){
			addCage(4,animalType);
			return 4;
			//throw new AssertionError ("add new cage in the zone.");
		}
		return 0;
	}
}

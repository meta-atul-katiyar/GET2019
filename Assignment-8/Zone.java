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
	
	/**
	 * @param capacity
	 * @param animalType
	 * add cage to the cage list
	 */
	public void addCage(int capacity, String animalType){
		Cage cage = new Cage(capacity, animalType);
		cages.add(cage);
		this.cageNumber -= 1;
	}
	
	/**
	 * @param animalType
	 * @param id
	 * @return id of animal if added else return 0
	 */
	public int animalToCage(String animalType, int id){
		int flag = 0;
		for(Cage cage : cages){
			if(cage.animalType == animalType && cage.capacity > 0){
				cage.addAnimal(id);
				flag = 1;
				System.out.println("animal with id- "+id+" added to cage- "+cage.id);
				return id;
			}
		}
		if(Zone.cageNumber > 0 && flag == 0){
			throw new AssertionError ("add new cage in the zone.");
		}
		else if(Zone.cageNumber <= 0 && flag == 0){
			throw new AssertionError("no space in existing cages.");
		}
		return 0;
	}
	
	
	/**
	 * @param animalType
	 * @param id
	 * @return id if animal is removed else 0
	 */
	public int removeAnimal(String animalType, int id){
		for(Cage cage : cages){
			if(cage.animalType == animalType){
				for(int cageAnimalId : cage.animals){
					if(cageAnimalId == id){
						cage.animals.removeFirstOccurrence( id);
						return id;
					}
				}
			}
			
		}
		return 0;
	}
	
}

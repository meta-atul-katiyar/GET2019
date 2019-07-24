
public class Cage {
	int id;
	String animalType;
	static int capacity;
	static int count = 0;
	
	public Cage(int capacity, String animalType){
		this.id = 210000 + count++;
		this.capacity = capacity;
		this.animalType = animalType;
	}
	
}

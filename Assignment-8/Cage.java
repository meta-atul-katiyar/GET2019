import java.util.LinkedList;

public class Cage {
	int id;
	String animalType;
	static int capacity;
	static int count = 0;
	static LinkedList<Integer> animals = new LinkedList<Integer>();
	
	
	public Cage(int capacity, String animalType){
		this.id = 210000 + count++;
		this.capacity = capacity;
		this.animalType = animalType;
	}
	public void addAnimal(int id){
		this.animals.add(id);
		this.capacity -= 1;
	}
	
}

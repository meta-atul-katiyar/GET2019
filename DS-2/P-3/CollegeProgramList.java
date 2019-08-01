
public class CollegeProgramList {
	private String name;
	private int id;
	private int capacity;
	
	CollegeProgramList(String name, int id, int capacity){
		this.name = name;
		this.id = id;
		this.capacity  = capacity;
	}
	String getName(){
		return name;
	}
	int getId(){
		return id;
	}
	int getCapacity(){
		return capacity;
	}
	boolean reduceCapacity(){
		if(this.capacity > 0){
			this.capacity -= 1;
			return true;
		}
		return false;
	}
}

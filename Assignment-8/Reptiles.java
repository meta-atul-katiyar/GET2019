import java.util.List;

public abstract class Reptiles extends Animal {
	private static List<Zone> zones;
	
	Reptiles(float age, float weight, String gender) {
		super(age, weight, gender);
		
	}

	public void addZone(int capacity){
		Zone zone = new Zone(capacity);
		zones.add(zone);
	}
}

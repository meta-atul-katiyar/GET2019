import java.util.*;


public abstract class Mammals extends Animal {

	private static LinkedList<Zone> zones = new LinkedList<Zone>();
	private boolean haveWings;
	
	public static void addZones(int cageNumber){
		Zone zone = new Zone(cageNumber);
		zones.add(zone);
		
	}
	
	public Mammals( float age, float weight, String gender){
		super(age, weight, gender);
		haveWings = false;
		
	}
	
	public static int zoneCapacity(String animalType){
		if(zones == null){
			addZones(4);
		}
		for(Zone zone : zones){
			int num = zone.cageCapcity(animalType);
			if(num > 0){
				return num;
			}
		}
		return 0;
	}
	
	@Override
	public boolean isWarmBlooded() {
		return true;
	}

	@Override
	public boolean isColdBlooded() {
		return false;
	}

}
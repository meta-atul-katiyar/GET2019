import java.util.LinkedList;

public class ZooManagementSystem {
	String animalName;
	private static LinkedList<Zone>mammalsZones = new LinkedList<Zone>();
	private static LinkedList<Zone>reptilesZones = new LinkedList<Zone>();
	private static LinkedList<Zone>birdsZones = new LinkedList<Zone>();
	
	private static LinkedList<String>mammals = new LinkedList<String>();
	private static LinkedList<String>reptiles = new LinkedList<String>();
	private static LinkedList<String>birds = new LinkedList<String>();
	//list of objects of animals
	private static LinkedList<Tiger>tigerList = new LinkedList<Tiger>();
	private static LinkedList<Lion>lionList = new LinkedList<Lion>();
	private static LinkedList<Panther>pantherList = new LinkedList<Panther>();
	private static LinkedList<Elephant>elephantList = new LinkedList<Elephant>();
	private static LinkedList<Gorilla>gorillaList = new LinkedList<Gorilla>();
	private static LinkedList<Deer>deerList = new LinkedList<Deer>();
	private static LinkedList<Crocodile>crocodileList = new LinkedList<Crocodile>();
	private static LinkedList<Gharial>gharialList = new LinkedList<Gharial>();
	private static LinkedList<Peacock>peacockList = new LinkedList<Peacock>();
	private static LinkedList<Flamingo>flamingoList = new LinkedList<Flamingo>();
	private static LinkedList<Ostrich>ostrichList = new LinkedList<Ostrich>();
	private static LinkedList<Parrot>parrotList = new LinkedList<Parrot>();
	
	
	/**
	 * add animals to their category list
	 */
	public static void addToCategory(){
		mammals.add("Tiger");	mammals.add("Lion");	mammals.add("Elephant");
		mammals.add("Panther");	mammals.add("Gorilla");	mammals.add("Mithoon");
		mammals.add("Wolf");	mammals.add("Hyna");	mammals.add("Bear");
		mammals.add("Leopard");	mammals.add("Cheetah");	mammals.add("Blackbuck");
		mammals.add("Deer");
		
		reptiles.add("Crocodile");	reptiles.add("Turtle");	reptiles.add("Gharial");
		reptiles.add("Mongoose");
		
		birds.add("Peacock");	birds.add("Parrot");	birds.add("Emu");
		birds.add("Ostrich");	birds.add("Flamingo");
	}
	
	/**
	 * @param cageNumber
	 * @param animalType
	 */
	public static void addZones(int cageNumber, String animalType){
		String categoryType = identifyCategory(animalType);
		String zoneType = identifyZone(categoryType);
		Zone zone = new Zone(cageNumber);
		//zone.addCage(cageLimit, animalType);
		if(zoneType == "mammalsZones"){
			mammalsZones.add(zone);
		}
		else if(zoneType == "reptilesZones"){
			reptilesZones.add(zone);
		}
		else if(zoneType == "birdsZones"){
			birdsZones.add(zone);
		}
		else{
			System.out.println("this class is not defined.");
		}	
	}
	
	/**
	 * @param cageCapacity
	 * @param animalType
	 */
	public static void addCage(int cageCapacity, String animalType){
		String categoryType = identifyCategory(animalType);
		String zoneType = identifyZone(categoryType);
		switch (zoneType){
			case "mammalsZones":
				for(Zone zone: mammalsZones){
					if(zone.cageNumber > 0){
						zone.addCage(cageCapacity, animalType);
					}
				}
				break;
				
			case "reptilesZones":
				for(Zone zone: reptilesZones){
					if(zone.cageNumber > 0){
						zone.addCage(cageCapacity, animalType);
					}
				}
				break;
				
			case "birdsZones":
				for(Zone zone: birdsZones){
					if(zone.cageNumber > 0){
						zone.addCage(cageCapacity, animalType);
					}
				}
				break;
			
			default:
				throw new AssertionError("add a new zone.");
		}
		
	}
	
	/**
	 * @param animalType
	 * @param id
	 * @return id if animal is added else 0
	 */
	public static int addMammalsZone(String animalType, int id){
		for(Zone zone : mammalsZones){
			return zone.animalToCage(animalType, id);
		}
		return 0;
	}
	
	/**
	 * @param animalType
	 * @param id
	 * @return id if animal is added else 0
	 */
	public static int addReptilesZone(String animalType, int id){
		for(Zone zone : reptilesZones){
			return zone.animalToCage(animalType, id);
		}
		return 0;
	}
	
	/**
	 * @param animalType
	 * @param id
	 * @return id if animal is added else 0
	 */
	public static int addBirdsZone(String animalType, int id){
		for(Zone zone : birdsZones){
			return zone.animalToCage(animalType, id);
		}
		return 0;
	}
	
	/**
	 * @param animalType
	 * @param id
	 * @return id if animal is removed else 0
	 */
	public static int removeMammal(String animalType, int id){
		for(Zone zone : mammalsZones){
			return zone.removeAnimal(animalType, id);
		}
		return 0;
	}
	
	/**
	 * @param animalType
	 * @param id
	 * @return id if animal is removed else 0
	 */
	public static int removeReptile(String animalType, int id){
		for(Zone zone : reptilesZones){
			return zone.removeAnimal(animalType, id);
		}
		return 0;
	}
	
	/**
	 * @param animalType
	 * @param id
	 * @return id if animal is removed else 0
	 */
	public static int removeBird(String animalType, int id){
		for(Zone zone : birdsZones){
			return zone.removeAnimal(animalType, id);
		}
		return 0;
	}
	
	/**
	 * @param animalType
	 * @param id
	 * @return id if animal is removed else 0
	 */
	public static int removeAnimal(String animalType, int id){
		String categoryType = identifyCategory(animalType);
		String zoneType = identifyZone(categoryType);
		switch(zoneType){
			case "mammalsZones":
				 return removeMammal(animalType, id);
				
			case "reptilesZones":
				return removeReptile(animalType, id);
				
			case "birdsZones":
				return removeBird(animalType, id);
		}
		return 0;
			
	}
	
	
	/**
	 * @param animalType
	 * @return category Type
	 */
	public static String identifyCategory(String animalType){
		for(String reptilesName : reptiles){
			if(reptilesName == animalType){
				return "Reptile";
			}
		}
		for(String birdsName : birds){
			if(birdsName == animalType){
				return "Bird";
			}
		}
		for(String mammalsName : mammals){
			if(mammalsName == animalType){
				return "Mammal";
			}
		}
		throw new AssertionError("add this animal to the list.");
	}
	
	/**
	 * @param categoryType
	 * @return name of zone's list of given category
	 */
	public static String identifyZone(String categoryType){
		switch(categoryType){
			case "Mammal":
				return "mammalsZones";
				
			case "Reptile":
				return"reptilesZones";
				
			case "Bird":
				return "birdsZones";
				
			default:
				throw new AssertionError("Invalid Category Type.");
		}
	}
	
	/**
	 * @param animalType
	 * @param age
	 * @param weight
	 * @param gender
	 * @return id if animal is added else return 0
	 */
	public static int addAnimal(String animalType, float age, float weight, String gender){
			switch(animalType){
				case "Tiger":
					Tiger tiger = new Tiger(age, weight, gender);
					if(addMammalsZone("Tiger",tiger.getId()) > 0){
						tigerList.add(tiger);
						return tiger.getId();
					}
					return 0;
				
				case "Lion":
					Lion lion = new Lion(age, weight, gender);
					if(addMammalsZone("Lion",lion.getId()) > 0){
						lionList.add(lion);
						return lion.getId();
					}
					return 0;
				
				case "Elephant":
					Elephant elephant = new Elephant(age, weight, gender);
					if(addMammalsZone("Elephant",elephant.getId()) > 0){
						elephantList.add(elephant);
						return elephant.getId();
					}
					return 0;
				
				case "Panther":
					Panther panther = new Panther(age, weight, gender);
					if(addMammalsZone("Panther",panther.getId()) > 0){
						pantherList.add(panther);
					}
					return 0;
				
				case "Deer":
					Deer deer = new Deer(age, weight, gender);
					if(addMammalsZone("Deer",deer.getId()) > 0){
						deerList.add(deer);
					}
					return 0;
					
				case "Gorilla":
					Gorilla gorilla = new Gorilla(age, weight, gender);
					if(addMammalsZone("Gorilla",gorilla.getId()) > 0){
						gorillaList.add(gorilla);
					}
					return 0;
					
				case "Crocodile":
					Crocodile crocodile = new Crocodile(age, weight, gender);
					if(addReptilesZone("Crocodile",crocodile.getId()) > 0){
						crocodileList.add(crocodile);
					}
					return 0;
					
				case "Gharial":
					Gharial gharial = new Gharial(age, weight, gender);
					if(addReptilesZone("Gharial",gharial.getId())> 0){
						gharialList.add(gharial);
					}
					return 0;
					
				case "Flamingo":
					Flamingo flamingo = new Flamingo(age, weight, gender);
					if(addBirdsZone("Flamingo",flamingo.getId()) > 0){
						flamingoList.add(flamingo);
					}
					return 0;
					
				case "Peacock":
					Peacock peacock = new Peacock(age, weight, gender);
					if(addBirdsZone("Peacock",peacock.getId()) > 0){
						peacockList.add(peacock);
					}
					return 0;	
					
				case "Parrot":
					Parrot parrot = new Parrot(age, weight, gender);
					if(addBirdsZone("Parrot",parrot.getId()) > 0){
						parrotList.add(parrot);
					}
					return 0;
					
				case "Ostrich":
					Ostrich ostrich = new Ostrich(age, weight, gender);
					if(addBirdsZone("Ostrich",ostrich.getId()) > 0){
						ostrichList.add(ostrich);
					}
					return 0;				
			}
		return 0;
	}
	
	public static void main(String[] args){
		addToCategory();
		addZones(4, "Tiger");
		addCage(5, "Tiger");
		addCage(5, "Lion");
		
		System.out.println(addAnimal("Tiger",10,10,"Male"));
		System.out.println(addAnimal("Tiger",1,6,"Male"));
		System.out.println(addAnimal("Lion",10,10,"Male"));
		System.out.println(addAnimal("Parrot",3,2,"Female"));
		System.out.println( removeAnimal("Tiger", 120001));	
	}
}

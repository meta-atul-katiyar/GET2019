
public class ZooManagementSystem {
	String animalName;
	
	public static void addAnimal(String name){
		Tiger t1 = new Tiger(10f,10f,"Male");
		System.out.println(t1.admissionDate);
	}
	
	public static void main(String[] args){
		Mammals.addZones(4);
		addAnimal("tiger");
		
	}
}

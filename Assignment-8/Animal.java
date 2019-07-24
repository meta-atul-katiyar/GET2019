
import java.util.Date;
import java.util.List;

public abstract class Animal {

	private int id = 0;
	private String name = "";
	private float age = 0;
	private float weight = 0;
	private String gender = "";
	static int count = 0;
	int isAlive;
	Date admissionDate;

	Animal(float age, float weight, String gender) {
		this.id = 120000 + count++;
		this.age = age;
		this.weight = weight;
		this.gender = gender;
		Date date = new Date();
		admissionDate = date;
		
	}

	public abstract String getSound();

	public abstract boolean isWarmBlooded();

	public abstract boolean isColdBlooded();

	public abstract boolean hasFeathers();

	// getter and setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
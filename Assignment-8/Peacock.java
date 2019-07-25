
public class Peacock extends Birds{
	String foodHabit;
	Peacock(float age, float weight, String gender) {
		super(age, weight, gender);
		this.foodHabit = "Harbivorus";

	}
	@Override
	public String getSound() {
		return "PEACOCK";
	}

}

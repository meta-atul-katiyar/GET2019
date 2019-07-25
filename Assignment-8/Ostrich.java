
public class Ostrich extends Birds{
	String foodHabit;
	Ostrich(float age, float weight, String gender) {
		super(age, weight, gender);
		this.foodHabit = "Harbivorus";

	}
	@Override
	public String getSound() {
		return "OSTRICH";
	}

}

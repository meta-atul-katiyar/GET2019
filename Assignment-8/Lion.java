
public class Lion extends Mammals {
	String foodHabit;
	public Lion(float age, float weight, String gender) {
		super(age, weight, gender);
		this.foodHabit = "Carnivorus";
	}

	@Override
	public String getSound() {
		return null;
	}

	@Override
	public boolean hasFeathers() {
		return false;
	}

}

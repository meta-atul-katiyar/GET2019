
public class Crocodile extends Reptiles{
	String foodHabit;
	Crocodile(float age, float weight, String gender) {
		super(age, weight, gender);
		this.foodHabit = "Carnivorus";

	}

	@Override
	public String getSound() {
		return null;
	}

	@Override
	public boolean isWarmBlooded() {
		return false;
	}

	@Override
	public boolean isColdBlooded() {
		return false;
	}

	@Override
	public boolean hasFeathers() {
		return false;
	}

}

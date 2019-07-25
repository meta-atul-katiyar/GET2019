import java.util.List;

public abstract class Reptiles extends Animal {
	Reptiles(float age, float weight, String gender) {
		super(age, weight, gender);
		
	}
	@Override
	public boolean isWarmBlooded() {
		return false;
	}

	@Override
	public boolean isColdBlooded() {
		return true;
	}

}

import java.util.List;


public abstract class Birds extends Animal {
	Birds(float age, float weight, String gender) {
		super(age, weight, gender);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean isWarmBlooded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isColdBlooded() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean hasFeathers() {
		return true;
	}
}

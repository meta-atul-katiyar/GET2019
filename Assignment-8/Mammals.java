import java.util.*;

public abstract class Mammals extends Animal {

	private boolean haveWings;
	
	public Mammals( float age, float weight, String gender){
		super(age, weight, gender);
		haveWings = false;
		
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

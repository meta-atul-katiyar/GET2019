import java.util.Date;

public class Tiger extends Mammals{
	String foodHabit;
	
	Tiger(float age, float weight, String gender){
		super(age, weight, gender);
		this.foodHabit = "Carnivorus";
	}
	

	@Override
	public String getSound() {
		return "ROAR";
	}


	@Override
	public boolean hasFeathers() {
		return false;
	}

}

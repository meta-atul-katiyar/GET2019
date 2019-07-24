import java.util.Date;

public class Tiger extends Mammals{
	String foodHabit;
	int cageId;
	
	Tiger(float age, float weight, String gender){
		super(age, weight, gender);
		if(Mammals.zoneCapacity("Tiger") <= 0){
			throw new AssertionError("create new zone.");
		}
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

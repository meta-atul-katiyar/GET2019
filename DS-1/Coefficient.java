
public class Coefficient{
	int[] varPowArray;
	int coeffValue;
	Coefficient next;
	
	Coefficient (int[] data, int coeffValue){
		this.varPowArray = data;
		this.coeffValue = coeffValue;
		next = null;
	}
}

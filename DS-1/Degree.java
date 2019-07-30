
public class Degree{
	int data;
	Degree nextDegree;
	Coefficient nextCoeff;
	
	Degree (int data, Coefficient coefficientObject){
		this.data = data;
		nextCoeff = coefficientObject;
		nextDegree = null;
	}
}

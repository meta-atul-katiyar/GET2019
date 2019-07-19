
public class LCMHCF {
	//return HCF of Two numbers recursively
	public static int hcfLCMInput(int num1, int num2){
		if(num1==0 || num2==0){
			return 0;
		}
		else {
			return HCF(num1,num2);
		}
	}
	public static int HCF(int num1, int num2){
		if(num1<0 || num2<0){
			throw new AssertionError("number must be positive.");
		}
		if(num2 == 0){
			return num1;
		}
		int mod = num1%num2;
		return HCF(num2, mod);
	}
	// function internally for finding LCM
	public static int LCMInternal(int x,int y, int multipleOfLargest){
		if((multipleOfLargest % x == 0) && (multipleOfLargest % y == 0)){
			return multipleOfLargest;
		}
		return LCMInternal(x,y,x+multipleOfLargest);
	}
	// return LCM of Two numbers recursively
	public static int LCM(int x, int y){
		if(x>y){
			return LCMInternal(x,y,x);
		}
		else{
			return LCMInternal(y,x,y);
		}
	}
	
	public static void main(String[] args){
		System.out.print(LCM(40, 7));
	}
}

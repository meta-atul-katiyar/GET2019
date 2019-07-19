
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
	//run recurrsively
	public static int LCMInternal(int x,int y,int twiceOfLargest){
		if((twiceOfLargest % x == 0) && (twiceOfLargest % y == 0)){
			return twiceOfLargest;
		}
		return LCMInternal(x,y,++twiceOfLargest);
	}
	// return LCM of Two numbers recursively
	public static int LCM(int x, int y){
		if(x>y){
			if(x % y == 0){
				return x;
			}
			return LCMInternal(x,y,2*x);
		}
		else{
			if(y%x == 0){
				return y;
			}
			return LCMInternal(x,y,2*y);
		}
	}
	
	public static void main(String[] args){
		System.out.print(LCM(10, 4));
	}
}


public class LCMHCF {
	//return HCF of Two numbers recursively
	public static int HCF(int x, int y){
		if(y == 0){
			return x;
		}
		if(x > y){
			int diff = x-y;
			if(diff>y){
				return HCF(diff,y);
			}
			else{
				return HCF(y,diff);
			}
		}
		else{
			int diff = y-x;
			if(diff>y){
				return HCF(diff,x);
			}
			else{
				return HCF(x, diff);
			}
		}
	}
	// return LCM of Two numbers recursively
	public static int LCM(int x, int y){
		int hcf = HCF(x,y);
		return (x*y/hcf);
	}
	
	public static void main(String[] args){
		System.out.print(LCM(49,10));
	}
}

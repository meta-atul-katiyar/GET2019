
public class LCMHCF {
	//return HCF of Two numbers recursively
	public static int HCF(int x, int y){
		if(y==0){
			return x;
		}
		if(x>y){
			int mod = x%y;
			return lcm(y, mod);
		}
		else{
			int mod = y%x;
			return lcm(x,mod);
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

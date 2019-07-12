import java.util.*;

public class HexCalc {
	static int BASE = 16;
	private String text;
	private static String firstNum="";
	private static String secondNum="";
	private static char opSym;
	public static String getExpre(){
		Scanner in = new Scanner(System.in);
		String text=in.nextLine();    
		return text;
	}

	//extract operators and operands
	public static void extractOps(String text){
		int index = 0;
		for (int numChar = 0; numChar < text.length(); numChar++){
			if(text.charAt(numChar) != '+' && text.charAt(numChar) != '-'
				&& text.charAt(numChar) != '/' && text.charAt(numChar) != '*'
				&& text.charAt(numChar) != ' ' ){
			
				if(index ==0){
					firstNum+=text.charAt(numChar);
				}
				else{
					secondNum+=text.charAt(numChar);
				}
			}
			else{
				opSym = text.charAt(numChar);
				index+=1;
			}
		}
	}
	
	//hexadecimal to decimal
	public static int toDecimal (String num, int BASE){
		int decimal=0;
		for (int numCount = num.length()-1; numCount >= 0; numCount--){
			String hexCharS = "abcdef";
			String hexCharC = "ABCDEF";
			char tempChar = num.charAt(numCount);
			int indexS = hexCharS.indexOf(tempChar),
			indexC = hexCharC.indexOf(tempChar);
			int numIndex = (num.length() - numCount - 1);

			int basePower=1;
			for (int tempIdx = 0; tempIdx < numIndex; tempIdx++ ){
				basePower*=BASE;
			}

			if(indexS >= 0){
				decimal+=(indexS+10)*basePower;

			}
			else if(indexC >= 0){
				decimal+=(indexS+10)*basePower;
			}
			else{
				int tempNum;
				tempNum = Character.getNumericValue(num.charAt(numCount));
				decimal += tempNum * basePower;
			}
		}
		return decimal;
	}

	// decimal to hexadecimal
	public static String fromDecimal(int num, int BASE){
		String hexNum = "";
		
		if(num == 0 ){
			return "0";
		}
		else{
			int numByBase = num;
			while(numByBase > 0){
				int modNum;
				modNum = numByBase%BASE;
				if(modNum > 9){
					hexNum = Character.toString((char)(65+(modNum%10))) + hexNum;
				}
				else{
					hexNum = Integer.toString(modNum) + hexNum;
				}
				numByBase = numByBase/BASE;
				if(numByBase < BASE){
					if(numByBase >= 10){
						hexNum = Character.toString((char)(65+(numByBase%10))) + hexNum;
					}
					else if(numByBase < 10 && numByBase >= 0){
						hexNum = Integer.toString(numByBase) + hexNum;
					}
				}
				if(numByBase == 1){
					break;
				}
			}
		}
		return hexNum;
	}


	//add
	public static int addNum(int num1, int num2){
		return num1+num2;

	}

	//subtract
	public static int subtractNum(int num1, int num2){
		return num1-num2;

	}

	//divide
	public static int divideNum(int num1, int num2){
		return num1/num2;

	}

	//multiply
	public static int multiplyNum(int num1, int num2){
		return num1*num2;

	}

	
	//perform operation as per the operator in expression
	public static void performOp(int num1, int num2, char opSym){
		int answer = -1;
		switch (opSym){
			case '+':
				System.out.print("Addition: "+ fromDecimal(addNum(num1, num2), BASE));
				break;

			case '-':
				System.out.print("Subtraction: ");
				int sub = subtractNum(num1, num2);
				if(sub<0){
					sub *= -1;
					System.out.print("-"+fromDecimal(sub, BASE));
				}
				else{
					System.out.print(fromDecimal(subtractNum(num1, num2), BASE));
				}
				break;

			case '/':
				System.out.print("Division: "+ fromDecimal(divideNum(num1, num2), BASE));
				break;

			case '*':
				System.out.print("Multiplication: "+ fromDecimal(multiplyNum(num1, num2), BASE));
				break;

			default:
				System.out.println("incorrect operation.");
				break;
		}
		fromDecimal(answer, BASE);
	}

	// return true if both number equal
	public static boolean equalTo(String num1, String num2){
		int numEq1 = toDecimal(num1, BASE);
		int numEq2 = toDecimal(num2, BASE);
		if(numEq1 == numEq2){
			return true;
		}
		else{
			return false;
		}
	}
	
	// True if first number is greater
	public static boolean greaterThan(String num1, String num2){
		int numEq1 = toDecimal(num1, BASE);
		int numEq2 = toDecimal(num2, BASE);
		if(numEq1 > numEq2){
			return true;
		}
		else{
			return false;
		}	
	}
	
	// True if second number is greater
	public static boolean lessThan(String num1, String num2){
		int numEq1 = toDecimal(num1, BASE);
		int numEq2 = toDecimal(num2, BASE);
		if(numEq1 < numEq2){
			return true;
		}
		else{
			return false;
		}
	}
	
	// main method
	public static void main(String[] args) {
		System.out.println("enter your choice:");
		System.out.println("1. To per form +,-,*,/ on hex numbers.");
		System.out.println("2. To Decimal to hexadecimal.");
		System.out.println("3. To hexadecimal to decimal.");
		System.out.println("4. To comapre two hexadecimal numbers.");
		
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt(); 
		
		switch(choice){
		case 1 :
			System.out.print("enter the expression as (a+b): ");
			String expr;
			HexCalc obj = new HexCalc();
			expr = HexCalc.getExpre();
			obj.extractOps(expr);
			int num1, num2;
			num1 = toDecimal (obj.firstNum, BASE);
			num2 = toDecimal (obj.secondNum, BASE);
			performOp(num1,num2, opSym);
			break;
		
		case 2 :
			System.out.print("enter the decimal number: ");
			int uNum = in.nextInt(); 
			System.out.println("corresponding hexa: " + fromDecimal(uNum, BASE));
			break;
			
		case 3 :
			int hexToDeci;
			System.out.print("enter the hexadecimal number(like- 1ab2): ");
			String uText=getExpre();
			hexToDeci = toDecimal ( uText, BASE);
			System.out.println("the corresponding decimal: "+ hexToDeci);
			break;
			
		case 4 :
			System.out.println("enter both numbers in a  line with space:  ");
			String str = getExpre();
			extractOps(str);
			System.out.println("first number == second number: "+ equalTo(firstNum, secondNum));
			System.out.println("first number > second number: "+ greaterThan(firstNum, secondNum));
			System.out.println("first number < second number: "+ lessThan(firstNum, secondNum));
		}		
	}
}
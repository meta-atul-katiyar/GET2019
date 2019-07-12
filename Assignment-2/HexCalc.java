
import java.util.*;
import java.lang.*;

public class HexCalc {
	static int BASE = 16;
	//static Scanner in = new Scanner(System.in);

	private String text, firstNum, secondNum;
	private static char opSym;
	static LinkedList<String> numOne = new LinkedList<String>();
	static LinkedList<String> numTwo = new LinkedList<String>();

	public static String getExpre(){
		Scanner in = new Scanner(System.in);
		//System.out.print("enter the whole expression: ");
		String text=in.nextLine();    
		//System.out.println("Text is: "+text);
		return text;
	}

	//extract operators and operands
	public void extractOps(String text){
		int index=0;
		

		for (int numChar = 0; numChar < text.length(); numChar++){
			if(text.charAt(numChar) != '+' && text.charAt(numChar) != '-'
				&& text.charAt(numChar) != '/' && text.charAt(numChar) != '*'){
			
				if(index ==0){
					numOne.add(Character.toString(text.charAt(numChar)));
				}

				else{
					
					numTwo.add(Character.toString(text.charAt(numChar)));
				}
			}

			else{
				opSym = text.charAt(numChar);
				index = 1;
			}
		}
		//System.out.println(numTwo);

	}

/***
	//hexadecimal to decimal ------by string number
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
*/



	//hexadecimal to decimal ----by String-linked-list of number
	public static int toDecimal (LinkedList<String> num, int BASE){
		int decimal=0, numDigit = 0;
		String str = num.removeLast();
		while(str != null){
			String hexCharS = "abcdef";
			String hexCharC = "ABCDEF";
			//char tempChar = num.charAt(numCount);
			int indexS = hexCharS.indexOf(str),
			indexC = hexCharC.indexOf(str);
			//int numIndex = (num.length() - numCount - 1);

			int basePower=1;
			for (int tempIdx = 0; tempIdx < numDigit; tempIdx++ ){
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
				tempNum = Integer.parseInt(str);
				decimal += tempNum * basePower;
			}
			//System.out.println(str);

			// Exception-- java.util.NoSuchElementException
			try{
				str = num.removeLast();
			}
			catch(Exception e){
				break;
			}
			numDigit+=1;
		}
		return decimal;
	}



	// decimal to hexadecimal
	public static void fromDecimal(int num, int BASE){
		if(num == 0 ){
			System.out.println(0);
		}
		else{
			int numByBase = num;
			LinkedList<String> hexNum = new LinkedList<String>();
			while(numByBase > 0){
				int modNum;
				modNum = numByBase%BASE;
				if(modNum > 9){
					hexNum.addFirst(Character.toString((char)(65+(modNum%10))));
				}
				else{
					hexNum.addFirst(Integer.toString(modNum));
				}
				numByBase = numByBase/BASE;
				if(numByBase < BASE){
					if(numByBase >= 10){
						hexNum.addFirst(Character.toString((char)(65+(numByBase%10))));
					}
					else if(numByBase < 10 && numByBase > 0){
						//System.out.println(numByBase);
							String n = Integer.toString(numByBase);
							hexNum.addFirst(n);
					}
				}
			}
			for(String str : hexNum){
				System.out.print(str);
			}
			System.out.println();
		}
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

	
	//perform operation
	public static void performOp(int num1, int num2, char opSym){
		int answer = -1;
		switch (opSym){
			case '+':
				System.out.print("Addition: ");
				fromDecimal(addNum(num1, num2), BASE);
				
				break;

			case '-':
				System.out.print("Subtraction: ");
				int sub = subtractNum(num1, num2);
				if(sub<0){
					sub *= -1;
					System.out.print("-");
					fromDecimal(sub, BASE);
				}
				else{
					fromDecimal(subtractNum(num1, num2), BASE);
				}
				break;

			case '/':
				System.out.print("Division: ");
				fromDecimal(divideNum(num1, num2), BASE);
				
				break;

			case '*':
				System.out.print("Multiplication: ");
				fromDecimal(multiplyNum(num1, num2), BASE);
				
				break;

			default:
				System.out.println("incorrect operation.");
				break;
		}
		fromDecimal(answer, BASE);
	}


	public static boolean equalTo(String num1, String num2){
		//static LinkedList<String> tempNumOne = new LinkedList<String>();
		//static LinkedList<String> tempNumTwo = new LinkedList<String>();
		int numEq1 = toDecimal(strToLL(num1), BASE);
		int numEq2 = toDecimal(strToLL(num2), BASE);
		if(numEq1 == numEq2){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	public static boolean greaterThan(String num1, String num2){
		//static LinkedList<String> tempNumOne = new LinkedList<String>();
		//static LinkedList<String> tempNumTwo = new LinkedList<String>();
		int numEq1 = toDecimal(strToLL(num1), BASE);
		int numEq2 = toDecimal(strToLL(num2), BASE);
		if(numEq1 > numEq2){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	public static boolean lessThan(String num1, String num2){
		//static LinkedList<String> tempNumOne = new LinkedList<String>();
		//static LinkedList<String> tempNumTwo = new LinkedList<String>();
		int numEq1 = toDecimal(strToLL(num1), BASE);
		int numEq2 = toDecimal(strToLL(num2), BASE);
		if(numEq1 < numEq2){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	
	public static LinkedList<String> strToLL( String strText){
		String tempStr;   
		LinkedList<String> strList =  new LinkedList<String>();
		for (int count = strText.length()-1; count>=0; count--){
			tempStr = Character.toString(strText.charAt(count));
			strList.add(tempStr);
		}
		return strList;
	}

	public static void main(String[] args) {
	// TODO Auto-generated method stub

		
		//System.out.println(toDecimal(obj.numTwo,16));
		
		System.out.println("enter your choice:");
		System.out.println("1. To per form +,-,*,/ on hex numbers.");
		System.out.println("2. To Decimal to hexadecimal.");
		System.out.println("3. To hexadecimal to decimal.");
		System.out.println("4. To comapre two hexadecimal numbers.");
		
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt(); 
		//switch case
		switch(choice){
		
		case 1 :
			System.out.print("enter the expression as (a+b): ");
			String expr;
			HexCalc obj = new HexCalc();
			expr = HexCalc.getExpre();
			obj.extractOps(expr);
			int num1, num2;
			
			num1 = toDecimal (obj.numOne, BASE);
			num2 = toDecimal (obj.numTwo, BASE);
			performOp(num1,num2, opSym);
			
			break;
		
		case 2 :
			System.out.print("enter the decimal number: ");
			int uNum = in.nextInt(); 
			fromDecimal(uNum, BASE);
			break;
			
		case 3 :
			int hexToDeci;
			System.out.print("enter the hexadecimal number(like- 1ab2): ");
			String uText=getExpre();
			/**
			String tempStr;   
			
			LinkedList<String> uHexaNum =  new LinkedList<String>();
			for (int count = uText.length()-1; count>=0; count--){
				tempStr = Character.toString(uText.charAt(count));
				uHexaNum.add(tempStr);
			}
			*/
			
			hexToDeci = toDecimal ( strToLL(uText), BASE);
			System.out.println("the corresponding decimal: "+ hexToDeci);
			break;
			
		case 4 :
				System.out.println("enter number 1: ");
				String uStrNum1 = in.next();
				
				//Scanner in1 = new Scanner(System.in);
				System.out.println("enter number 2: ");
				String uStrNum2 = in.next();
			
			System.out.println("first number == second number: "+ equalTo(uStrNum1, uStrNum2));
			
			System.out.println("first number > second number: "+ greaterThan(uStrNum1, uStrNum2));
			
			System.out.println("first number < second number: "+ lessThan(uStrNum1, uStrNum2));
			
			
		}
		
	}
}
import java.text.DecimalFormat;

public class ArithmeticOpStack {
	static int opStack = 0, newOp = 0;
	static String op = "";
	private static DecimalFormat df = new DecimalFormat("0.00");
	static String[] opPre = new String[]{"(",")","!","*","/","+","-",
			"<","<=",">",">=","==","!=","||"};
	
	/**
	 * @param op
	 * @return index of opPre
	 */
	public static int operatorPreced(String op){
		int index = 0;
		for (; index < opPre.length; index++){
			if(opPre[index].equals(op)){
				opStack = index;
				break;
			}
		}
		return index;
	}
	
	/**
	 * @param infixExpr
	 * @return String in post fix notation
	 */
	public static String inToPost(String infixExpr){
		StackImplement stack = new StackImplement();
		String postFix = " ";
		for(int count = 0; count < infixExpr.length(); count++){
			if(infixExpr.charAt(count) == ' '){
				continue;
			}
			if((int)infixExpr.charAt(count) >=48 && (int)infixExpr.charAt(count) <=57){
				while((int)infixExpr.charAt(count) >=48 && (int)infixExpr.charAt(count) <=57){
					postFix += infixExpr.charAt(count++);
					if(count == infixExpr.length()){
						break;
					}
				}
				postFix += ' ';
			}
			else{
				while(count < infixExpr.length() && infixExpr.charAt(count) != ' '){
					op += infixExpr.charAt(count++);
				}
				if(stack.top == null ){
					stack.push(op);
					op = "";
				}
				else{
					newOp = operatorPreced(op);
					opStack = operatorPreced(stack.peep());
					if(opStack > newOp){
						if(op.equals(")")){
							while(!stack.peep().equals("(")){
								postFix += stack.pop()+' ';
							}
							stack.pop();
						}
						else{
							int index = count;
							while(index < infixExpr.length() && infixExpr.charAt(index) == ' '){
								index++;
								if(index == infixExpr.length()){
									break;
								}
							}
							while((index < infixExpr.length())&&(int)infixExpr.charAt(index) >=48 
									&& (int)infixExpr.charAt(index) <=57){
								postFix += infixExpr.charAt(index++);
							
								if(index == infixExpr.length()){
									break;
								}
							}
							postFix += ' ';
							if(op.equals("(")){
								stack.push(op);
								op = "";	
							}
							else{
								postFix += op;
								postFix += ' ';	
							}
							count = index;
						}	
					}
					else{
						if(!((stack.peep()).equals("("))){
							while(newOp <= operatorPreced(stack.peep())){
								postFix += (stack.pop())+" ";
								if(stack.top == null){
									break;
								}
							}
							
						}
						stack.push(op);
					}
					op = "";
				}
			}
		}
		while(stack.top != null){
			postFix += ' ';
			postFix+=stack.pop();
		}
		System.out.println("post fix: "+postFix);
		return postFix;
	}
	
	/**
	 * @param number
	 * @param op
	 * @return boolean value
	 * perform operation with boolean operators
	 */
	public static boolean boolOp(String[] number, String op){
		double [] num = new double[2];
		num[0] = Double.parseDouble(number[0]);
		num[1] = Double.parseDouble(number[1]);
		switch(op){
			case "<":
			if(num[0] < num[1]){
				return true;
			}
			return false;

		case "<=":
			if(num[0] <= num[1]){
				return true;
			}
			return false;

		case ">":
			if(num[0] > num[1]){
				return true;
			}
			return false;

		case ">=":
			if(num[0] >= num[1]){
				return true;
			}
			return false;

		case "==":
			if(num[0] == num[1]){
				return true;
			}
			return false;

		case "!=":
			if(num[0] != num[1]){
				return true;
			}
			return false;

		case "||":
			if(num[0] == 1 || num[1] == 1){
				return true;
			}
			return false;

		default:
			throw new AssertionError("invalid operator.");
		}
	}

	/**
	 * @param number
	 * @param op
	 * @return String result of arithmetic operations
	 */
	public static String arithOp(String[] number, String op){
		double [] num = new double[2];
		num[0] = Double.parseDouble(number[0]);
		num[1] = Double.parseDouble(number[1]);

		switch (op){
		case "+":
			return df.format(num[0]+num[1]);

		case "-":
			return df.format(num[0]-num[1]);

		case "/":
			if(num[1] == 0){
				throw new AssertionError("divide by 0.");
			}
			return df.format(num[0]/num[1]);

		case "*":
			return df.format(num[0]*num[1]);

		default:
			throw new AssertionError("invalid operator.");
		}
	}
	
	/**
	 * @param infixExpr
	 * @return Solution using Stack
	 */
	public static String arithmeticOp(String infixExpr){
		for(int count = 0; count < infixExpr.length(); count++){
			if((infixExpr.charAt(count) == ' ')){
				continue;
			}
			int ascii = (int)(infixExpr.charAt(count));
			if((ascii == 33 || ascii == 45) || (ascii > 39 && ascii < 44) ||(ascii > 46 && ascii <58)
					|| (ascii > 59 && ascii < 63) || (ascii == 124)){
				if(count >= 1){
					int prevCharInt =  (int)(infixExpr.charAt(count-1)),
							nextCharInt =  (int)(infixExpr.charAt(count));
					if(((prevCharInt > 41 && prevCharInt < 48)|| prevCharInt == 60
							|| prevCharInt == 62)&&(prevCharInt != 44 && prevCharInt!=46)){
						if(((nextCharInt > 41 && nextCharInt < 48)|| nextCharInt == 60
								|| nextCharInt == 62)&&(nextCharInt != 44 && nextCharInt!=46)){
							throw new AssertionError("invalid expression.");
						}
					}
				}
			}
			else{
				throw new AssertionError("invalid character.");
			}
		}
		
		String postFix = inToPost(infixExpr);
		StackImplement stack = new StackImplement();
		int flag = 0;
		for(int count=0; count < postFix.length(); count++){
			if(postFix.charAt(count) == ' '){
				continue;
			}
			if((int)postFix.charAt(count) >= 48 && (int)postFix.charAt(count) <= 57){
				String num = "";
				while((int)postFix.charAt(count) >= 48 && (int)postFix.charAt(count) <= 57){
					num+=postFix.charAt(count++);
					if(count == postFix.length()){
						break;
					}
				}
				stack.push(num);
			}
			else{
				while(postFix.charAt(count) == ' '){
					if(count < postFix.length()){
						count++;
					}
				}
				String op = "";
				while(postFix.charAt(count) != ' '){
					op+=postFix.charAt(count++);
					if(count == postFix.length()){
						break;
					}
				}
				if((op.equals("+") || op.equals("*")) || (op.equals("-") || op.equals("/"))){
					String [] number = new String[2];
					number[1] = stack.pop();
					number[0] = stack.pop();
					stack.push(arithOp(number, op));
				}
				else{
					flag = 1;
					String [] number = new String[2];
					number[1] = stack.pop();
					number[0] = stack.pop();
					if(boolOp(number, op)){
						stack.push("1");
					}
					else{
						stack.push("0");
					}
				}
			}
		}
		if(flag == 0){
			return stack.pop();
		}
		else{
			if(stack.pop().equals("1")){
				return "true";
			}
			return "false";
		}
	}
	
	public static void main(String[]args){
		String d = arithmeticOp("(  1 + ( 22  / 3 ) )");
		//String d = arithmeticOp("11 + 222 / 13 + 3 * 4");
		//String d = arithmeticOp("(  ( 1 + 1 ) != ( 22  / 11 ) )");
		System.out.println(d);
		
	}

}
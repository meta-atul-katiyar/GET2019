import java.util.*;



public class MolecularMass {
	
	HashMap<Character, Integer> elements = new HashMap<Character, Integer>();
	
	public boolean strValidate(String formula){
		for(int count = 0; count < formula.length(); count++){
			if(((int)formula.charAt(count) > 48 && (int)formula.charAt(count) <= 57) ||
					formula.charAt(count) == 'C' || formula.charAt(count) == 'O' ||
					formula.charAt(count) == 'H' || formula.charAt(count) == '(' ||
					formula.charAt(count) == ')'){
				
			}
			else{
				throw new AssertionError("invalid char");
			}
		}
		return true;
	}
	
	/**
	 * @param formula
	 * @return molecular mass
	 */
	public int molecularMass(String formula){
		strValidate(formula);
		elements.put('C', 12);
		elements.put('O', 16);
		elements.put('H', 1);
		StackImplement stack = new StackImplement();
		StackImplement stackSum = new StackImplement();
		
		for(int count = 0; count < formula.length()-1; count++){
			if(formula.charAt(count++) == '('){
				while(formula.charAt(count) != ')' && formula.charAt(count) != '('){
					int index = count+1;
					if((int)formula.charAt(index) > 48 && (int)formula.charAt(index) <= 57){
						String numeric = "";
						while((int)formula.charAt(index) > 48 && (int)formula.charAt(index) <= 57){
							numeric += formula.charAt(index++);
							if(index >= formula.length()){
								break;
							}
						}
						stack.push(Integer.parseInt(numeric) * elements.get(formula.charAt(count)));
					}
					else{
						stack.push(elements.get(formula.charAt(count)));
					}
					count = index;
				}
				if( count < formula.length() && formula.charAt(count) == ')'){
					int index = count+1;
					if(count == formula.length()-1){
						index = count;
					}
					if((int)formula.charAt(index) > 48 && (int)formula.charAt(index) <= 57){
						String numeric = "";
						while((int)formula.charAt(index) > 48 && (int)formula.charAt(index) <= 57){
							numeric += formula.charAt(index++);
							if(index >= formula.length()){
								break;
							}
						}
						int sum = 0;
						while(stack.top != null){
							sum += stack.pop();
						}
						stackSum.push(sum*Integer.parseInt(numeric));
					}
					else{
						int sum = 0;
						while(stack.top != null){
							sum += stack.pop();
						}
						stackSum.push(sum);
					}
					count = index;
				}
				else if(formula.charAt(count) == '('){
					int sum = 0;
					while(stack.top != null){
						sum += stack.pop();
					}
					stackSum.push(sum);
				}
				count--;
			}
		}
		int finalSum = 0;
		while(stackSum.top != null){
			finalSum += stackSum.pop();
		}
		return finalSum;
	}
	
	public static void main(String[]args){
		MolecularMass mm = new MolecularMass();
		System.out.println(mm.molecularMass("(C(CO2)12(OH)2)"));
	}
}

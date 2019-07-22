import java.util.*;

public final class Poly{
	final char[] singleVarPoly;

	public Poly(char[] array){
		int index = 0, arrayLength = array.length, flag = 0, var = 0;
		while(index < arrayLength-1){
			if(array[index] == '+' || array[index] == '-' || array[index] == '*' ||
				(array[index] >= 48 && array[index] <= 57)) {
				if(array[index] == '+' || array[index] == '-' || array[index] == '*'){
					if(array[index+1] == '+' || array[index+1] == '-' || array[index+1] == '*'){
						throw new AssertionError("Invalid polynomial.");
					}
				}
			}
			else if((array[index] >= 65 && array[index] <= 90) || (array[index] >= 97 && array[index] <= 122)){
				if(flag == 0){
					var = (int)array[index];
					flag = 1;
				}
				if(flag == 1 && array[index] != var){
					throw new AssertionError("enter single variable polynomial.");
				}
			}
			else {
				throw new AssertionError("unknown character in polynomial.");
			}
			index += 1;
		}
		this.singleVarPoly = array;
	}

	public String evaluatePoly(char[] arr, float x, int index, int singleVarPolyLength){
		int multiplier = 0;
		float answer = 0;
		while(index < singleVarPolyLength && arr[index] != '+' && arr[index] != '-'){
			if(index < singleVarPolyLength && (int)arr[index] >= 48 && (int)arr[index] <= 57){
				answer *= (multiplier++*10);
				answer += Character.getNumericValue(singleVarPoly[index++]);
			}
			else if (index < singleVarPolyLength-1 && arr[index] == '*'){
				index += 1;
			}
			else if (index < singleVarPolyLength){
				answer *= x;
				index += 1;
			}
		}
		if(index >= singleVarPolyLength-1){
		    return String.valueOf(answer);
		}
		if(arr[index] == '+'){
			return answer+"+"+evaluatePoly(arr, x, ++index, singleVarPolyLength);
		}
		else{
			return answer+"-"+evaluatePoly(arr, x, ++index, singleVarPolyLength);
		}
	}

	public String evaluate(float x){
		int index = 0;
		int singleVarPolyLength = singleVarPoly.length;
		
        String answer = evaluatePoly(this.singleVarPoly, x, index, singleVarPolyLength);
        System.out.println(answer);
        int indexAnswer = answer.length()-1;
        float finalAnswer = 0;
        String floatNum = "";
        while(indexAnswer >= -1){
            if(indexAnswer ==-1){
                finalAnswer += Float.valueOf(floatNum);
            } 
            else{
                if(answer.charAt(indexAnswer) != '+' && answer.charAt(indexAnswer) != '-'){
                	floatNum = answer.charAt(indexAnswer) + floatNum;
            	}    
            	else{
            	    if(answer.charAt(indexAnswer) == '+'){
            	        finalAnswer += Float.valueOf(floatNum);
            	        floatNum = "";
            	    }
            	    else if(answer.charAt(indexAnswer) == '-'){
            	        finalAnswer -= Float.valueOf(floatNum);
            	        floatNum = "";
            	    }
            	}    
            }
            indexAnswer -= 1;
        }
		return String.format("%.4f", finalAnswer);
	}

	public int degree(){
		int index = 0, degree = 0, singleVarPolyLength = singleVarPoly.length;
		while((index < singleVarPolyLength) && ((singleVarPoly[index] == '-') || (singleVarPoly[index] == '+')
				|| (singleVarPoly[index] >= 48 && singleVarPoly[index] <= 57) )) {
			index += 1;
		}
		while(index < singleVarPolyLength && (singleVarPoly[index] != '+' && singleVarPoly[index] != '-')){
			if(singleVarPoly[index] != '*'){
				degree += 1;
			}
			index += 1;
		}
		return degree;
	}
	
	private static int extractCoeffAndPower(char[] arr, int index, int singleVarPolyLength, HashMap<Integer, Integer> map,int sign){
		int multiplier = 0, answer = 0, degree = 0;
		
		while(index < singleVarPolyLength && arr[index] != '+' && arr[index] != '-'){
			if(index < singleVarPolyLength && arr[index] >= 48 && arr[index] <= 57){
				answer *= (multiplier++*10);
				answer += Character.getNumericValue(arr[index++]);
			}
			else if (index < singleVarPolyLength-1 && arr[index] == '*'){
				index += 1;
			}
			else if (index < singleVarPolyLength){
				
				degree+=1;
				
				index += 1;
			}
		}
		if(index >= singleVarPolyLength-1){
			map.put(degree,answer*sign);
			return 0;
		}
		if(arr[index] == '+'){
			map.put(degree,answer*sign);
			extractCoeffAndPower(arr, ++index, singleVarPolyLength, map,1);
		}
		else{
			if(index>0){
				map.put(degree,answer*sign);
			}
			extractCoeffAndPower(arr, ++index, singleVarPolyLength, map,-1);
		}
		return 0;
	}
	
	private static HashMap<Integer, Integer> polyArray(Poly p){
		HashMap<Integer, Integer> map = new HashMap<>(); 
		
		int index = 0;
		int p1Length = p.singleVarPoly.length;
		extractCoeffAndPower(p.singleVarPoly, index, p1Length, map,1);
		return map;
	}
	private static int checkNull(Integer i){
		if(i==null){
			return 0;
		}
		return (int)i;
	}
	public static void addPoly(Poly p1, Poly p2){
		
		HashMap<Integer, Integer> map1 = polyArray(p1), map2 = polyArray(p2);
		HashMap<Integer, Integer> newMap = new HashMap<>();
		int degree1 = p1.degree(), degree2 = p2.degree(), newDegree = 0;
		if(degree1 > degree2){
			newDegree = degree1;
		}
		else{
			newDegree = degree2;
		}
		int index = newDegree;
		while(index>=0){
			newMap.put(index, checkNull(map1.get(index))+checkNull(map2.get(index)));
			index -= 1;
		}
		for(int count = newDegree; count >= 0; count--){
			if(newMap.get(count)!=0){
				System.out.print(newMap.get(count)+"x^"+count);
			}
		}	
	}

	public static void multiplyPoly(Poly p1, Poly p2){
		HashMap<Integer, Integer> map1 = polyArray(p1), map2 = polyArray(p2);
		HashMap<Integer, Integer> newMap = new HashMap<>();
		int degree1 = p1.degree(), degree2 = p2.degree(), newDegree = 0;
		for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
			for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
				int key1 = entry1.getKey(), key2 =entry2.getKey(), value = entry1.getValue()*entry2.getValue(),key = key1+key2;
				if(newMap.get(key) == null){
					newMap.put(key, value);
				}
				else{
					newMap.replace(key, newMap.get(key)+value);
				}
			}
		}
		int newDegree1 = 0;
		for(Map.Entry<Integer, Integer> entry : newMap.entrySet()){
			if(newDegree1 < entry.getKey()){
				newDegree1 = entry.getKey();
			}
		}
		for(int count = newDegree1; count >= 0; count--){
			if(newMap.get(count)!=0){
				System.out.print("+("+newMap.get(count)+")*"+"x^"+count);
			}
		}
	}

	public static void main(String[] args){
		String str = "-4*x*x-2*x-3"; 
		char[] charArray = str.toCharArray();
		String str1 = "2*x-9"; 
		char[] charArray1 = str1.toCharArray();
		Poly p = new Poly(charArray);
		Poly p1 = new Poly(charArray1);
		multiplyPoly(p,p1);
		System.out.println(p.evaluate((float)2.7));
	}
}
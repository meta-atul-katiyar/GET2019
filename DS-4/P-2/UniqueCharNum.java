import java.util.*;

public class UniqueCharNum {

	HashMap<Character, Integer> uniqueCharMap = new HashMap<Character, Integer>();
	HashMap<String, Integer> uniqueCharCountMap = new HashMap<String, Integer>();
	
	/**
	 * @param str
	 * @return number of unique characters
	 */
	public int countUniqueChar(String str){
		int charCount = 0;
		if(uniqueCharCountMap.get(str) == null){
			for(int count = 0; count < str.length(); count++){
				if(uniqueCharMap.get(str.charAt(count)) == null){
					uniqueCharMap.put(str.charAt(count), 1);
				}
				else{
					uniqueCharMap.put(str.charAt(count), 0);
				}
			}
			for(int n : uniqueCharMap.values()){
				charCount += n;
			}
			uniqueCharCountMap.put(str, charCount);
			return charCount;
		}
		return uniqueCharCountMap.get(str);
	}
	
	public static void main(String[] args){
		UniqueCharNum ucn = new UniqueCharNum();
		System.out.println(ucn.countUniqueChar("asdfghjk asdfghjk"));
		System.out.println(ucn.countUniqueChar("asdfghjk  asdfghjk"));
		System.out.println(ucn.countUniqueChar("asdfghjk asdfghjk"));
		
	}
}

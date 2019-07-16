import java.util.*;

public class StringOperation {
	//return 1 if str1=str2, else 0
	public static int strComp(String str1, String str2){
		int flag = 0;
		if(str1.length() == str2.length()){
			for (int count = 0; count < str1.length(); count++){
				if(str1.charAt(count) != str2.charAt(count)){
					flag = 1;
					break;
				}
			}
			if(flag == 1){
				return 0;
			}
		}
		else{
			return 0;
		}
		return 1;
	}
	//reverse of string
	public static String strReverse(String str){
		String tempStr="";
		for (int count = str.length()-1; count >=0 ; count++){
			tempStr+=str.charAt(count);
		}
		return tempStr;
	}
	//Swap cases of string
	public static String switchCase(String str){
		String tempStr="";
		for (int count = 0; count < str.length() ; count++){
			char strChar = str.charAt(count);
			int num = (int)strChar;
			if(num > 96 && num < 123){			//handle lowercase
				tempStr += (char)(num-32);
			}
			else if (num > 64 && num < 91){		//handle uppercase
				tempStr += (char)(num + 32);
			}
			else{
				tempStr += (char)num;
			}
		}
		return tempStr;
	}
	//return largest words list
	public static String largestLastWord(String str){
		String word = "";
		int maxLength = 0;
		int flag = 0, flag1 = 0, flag2 = 0, idx = 0;
		LinkedList<String> words = new LinkedList<String>();
		String maxLenWord = null;
		while(str.charAt(idx) == ' '){
			idx+=1;
		}
		for(int count = idx; count < str.length(); count++){
			if(str.charAt(count) != ' '){    
            			word = word + str.charAt(count);    
          		}    
          		else{  
            			int wordLength = word.length();
            			if(wordLength >= maxLength){
            				maxLength = wordLength;
            				maxLenWord = word;
            			}       
            			word = "";    
          		} 
		}
		return maxLenWord;
	}

	public static void main(String[] args) {
		String uStr = "  Code, Compile, Run and Debug java program online.. Write your code in this editor and press button to exe.cute it.";
		System.out.println(largestLastWord(uStr+" "));
	}
}

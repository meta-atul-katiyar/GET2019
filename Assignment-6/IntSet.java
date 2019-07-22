import java.util.LinkedList;


public final class IntSet {
	private final int[] immutableArray;
	//initialize array, insert only unique values between 1 to 1000.
	public IntSet(int[] arr){
		int arrLength = arr.length, arrElementsLength = 0, arrCheck = 0;
		LinkedList<Integer> arrElements = new LinkedList<Integer>();
		for (int index = 0; index < arrLength; index++){
			if(arr[index] < 1 || arr[index] > 1000){
				throw new AssertionError("elements must be in 1 to 1000 only.");
			}
			int flag = 0;
			for(int num : arrElements){
				if(num == arr[index]){
					flag = 1;
					arrCheck = 1;
					break;
				}
			}
			if(flag == 0){
				arrElements.add(arr[index]);
				arrElementsLength += 1;
			}
		}
		if(arrCheck == 0){
			this.immutableArray = arr;
		}
		else{
			int[] tempArray = new int[arrElementsLength];
			int tempIndex = 0;
			for(int num : arrElements){
				tempArray[tempIndex++] = num;
			}
			this.immutableArray = tempArray;
		}
	}
	// checks if the given element is present in object's int set
	public boolean isMember(int x){
		for (int index = 0; index <= this.immutableArray.length; index++){
			if(x == this.immutableArray[index]){
				return true;
			}
		}
		return false;
	}
	// returns the size of array.
	public int size(){
		return this.immutableArray.length;
	}
	//check if the argument set is subset of the method calling object's set
	public boolean isSubSet(IntSet s){
		int subLength = s.size(), superLength = this.immutableArray.length;
		for(int subIndex = 0; subIndex < subLength; subIndex++){
			int tempSuperIndex = 0;
			for (int superIndex = 0; superIndex < superLength ; superIndex++){
				if(this.immutableArray[superIndex] == s.immutableArray[subIndex]){
					break;
				}
				tempSuperIndex = superIndex;
			}
			if(tempSuperIndex >= superLength){
				return false;
			}
		}
		return true;
	}
	//gives all other elements between 1 to 1000 except the given set elements
	public static int[] getComplement(IntSet s){
		int sLength = s.size();
		int[] complementArray = new int [1000 - sLength];
		int complementIndex = 0;
		for (int i =1; i <= 1000; i++){
			int number = 0, flag = 0;
			for (int index= 0; index < sLength; index++){
				number = i;
				if(s.immutableArray[index] == i){
					flag += 1;
					break;
				}
			}
			if(flag == 0){
				complementArray[complementIndex++] = number;
			}
		}
		return complementArray;
	}
	//perform union of the given sets
	public static int[] union(IntSet s1, IntSet s2){
		int s1Length = s1.size(), s2Length = s2.size(), unionLength = 0;
		LinkedList<Integer> unionElements = new LinkedList<Integer>();
		for (int indexS1 = 0; indexS1 < s1Length; indexS1++){
			unionElements.add(s1.immutableArray[indexS1]);
			unionLength += 1;
		}
		for (int indexS2 = 0; indexS2 < s2Length; indexS2++){
			int flag = 0;
			for(int num : unionElements){
				if(num == s2.immutableArray[indexS2]){
					flag = 1;
					break;
				}
			}
			if(flag == 0){
				unionElements.add(s2.immutableArray[indexS2]);
				unionLength += 1;
			}
		}
		int[] unitedArray = new int[unionLength];
		int index = 0;	
		for(int num : unionElements){
			unitedArray[index++] = num;
		}
		return unitedArray;
	}
	
	public static void main(String[] args){
		IntSet s1 = new IntSet(new int[] {1,2,3,4,5,6,7,8,9});
		IntSet s2 = new IntSet(new int[] {11,4,2,8,10});
		/*int[] array = getComplement(s2);
		for (int index = 0; index < array.length; index++){
			System.out.println(array[index]);
		}*/
		int [] array = union(s1,s2);
		for (int index = 0; index < array.length; index++){
			System.out.println(array[index]);
		}
	}
}

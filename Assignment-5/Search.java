
public class Search {
	//take array the number to search
	public static int linearSearch(int[] arr, int number){
		int arrLength = arr.length;
		return linearSearchInternal(arr, number, --arrLength);
	}
	// does internal linear search operation
	public static int linearSearchInternal(int[] arr, int number, int index){
		if(index == 0){
			throw new AssertionError("number not found.");
		}
		if(arr[index] == number){
			return (index);
		}
		return linearSearchInternal(arr, number, --index);
	}
	//binary search
	public static int binarySearch(int[] arr, int number, int start, int end){
		int mid = (end+start)/2;
		if(arr[mid] == number){
			return mid;
		}
		else if(arr[mid] > number){
			return (binarySearch(arr, number, start, mid));
		}
		else{
			return (binarySearch(arr, number, mid, end));
		}
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
		System.out.print(binarySearch(arr, 6, 0, 11));
	}
}

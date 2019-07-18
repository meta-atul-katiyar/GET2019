import java.util.Arrays;

public class Search {
	public static int linearSearch(int[] arr, int number, int index){
		if(arr[index] == number){
			return (index);
		}
		return linearSearch(arr, number, ++index);
	}
	
	public static int binarySearch(int[] arr, int number, int start, int end){
		int mid = end-start/2;
		if(arr[mid] == number){
			return mid;
		}
		else if(arr[mid] > number){
			return (binarySearch(Arrays.copyOfRange(arr, 0, mid), number, start, mid-1));
		}
		else{
			return (binarySearch(Arrays.copyOfRange(arr, mid, end), number, mid, end));
		}
	}
	
	public static void main(String[] args){
		int[] arr = {1,21,22,33,12,3,4,5,6,7,8,9,10};
		System.out.print(binarySearch(arr, 6, 0, 12 ));
	}
}

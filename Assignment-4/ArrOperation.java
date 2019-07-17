import java.util.*;

public class ArrOperation {
	
	//return largest mirror section
	public static int maxMirror(int[] arr){
		int arrLength = arr.length;
		int [] tempArray = new int [arrLength];
		int largestSection = 0, max = 0;
		for (int countForward = 0; countForward <= arrLength; countForward++){
			for (int countReverse = arrLength-1; countReverse >= 0; countReverse--){
				int index1 = countForward, index2 = countReverse;
				//count largest section
				while(index1 < arrLength && index2 >= 0 && arr[index1] == arr[index2]){
					largestSection += 1;
					index1+=1;
					index2-=1;
				}
				if(max < largestSection){
					max = largestSection;
					// terminate iteration when both ends reached
					if(index1 == arrLength && index2 == -1){
						countReverse = 0;
						countForward = arrLength;
					}
				}
				largestSection = 0;
			}
		}
		return max;
	}
	//return count of clumps input:array return:count of clumps
	public static int countClumps(int[] arr) {
		int arrLength = arr.length;
		if(arrLength == 0){
			throw new AssertionError("array is empty.");
		}
		int clumpsNum = 0;
		for (int count = 0; count < arrLength-1; count++){
			if(arr[count] == arr[count+1]){
				int fastForward = count+1;
				while(fastForward < arrLength-1 &&
						(arr[fastForward] == arr[fastForward+1])){
					fastForward += 1;
				}
				count = fastForward;
				clumpsNum += 1;
			}
		}
		return clumpsNum;
	}
	//return the same array by fixing X and Y
	public static int [] fixXY(int[] arr, int X, int Y){
		int arrLength = arr.length;
		int countX = 0, countY = 0;
		if(arrLength == 0){
			throw new AssertionError("array is empty.");
		}
		else{
			if(arr[arrLength -1] == X){
				throw new AssertionError("Last element of array is: "+ X);
			}
			int yIndex = -1, flag = 0;
			if(arr[0] == Y){
				yIndex = 0;
				countY +=1;
			}
			else{
				for(int count = 1; count < arrLength; count++){
					if(arr[count-1] != X && arr[count] == Y){
						yIndex = count;
						countY +=1;
						flag = 1;
						break;
					}
					if(arr[count] == Y){
						flag = 1;
					}
				}
				if(flag == 0){
					throw new AssertionError("no "+Y+" in the array.");
				}
			}
			for (int count = 0; count < arrLength-1; count++){
				if(arr[count] == X && arr[count+1] == X){
					throw new AssertionError("two "+X+" are together in the array.");
				}
				if(arr[count] == X && arr[count+1] != Y){
					if(yIndex == -1){
						throw new AssertionError("count of "+X+" and "+Y+" are unequal.");
					}
					int xIndex = count;
					countX += 1;
					if(yIndex > xIndex){
						for (int index = yIndex; index > xIndex+1; index--){
							if(arr[index-1] == X){
								index -= 1;
							}
							else{
								arr[index] = arr[index-1];
								arr[index-1] = Y;
							}
						}
						int tempYIndex = yIndex + 1;
						while((tempYIndex < arrLength && arr[tempYIndex] != Y) ||
								(arr[tempYIndex -1] == X && arr[tempYIndex] == Y)){
							tempYIndex +=1;
						}
						if(tempYIndex > yIndex){
							yIndex = tempYIndex;
							countY += 1;
						}
					}
					else{
						for (int index = yIndex; index <= xIndex+1; index++){
							int next = index+1;
							if(arr[index+1] == X){
								next += 1;
							}
							arr[index] = arr[next];
							arr[next] = Y;
							index = next;
						}
						int tempYIndex = yIndex + 1;
						while((tempYIndex < arrLength && arr[tempYIndex] != Y) ||
								(arr[tempYIndex -1] == X && arr[tempYIndex] == Y)){
							tempYIndex +=1;
						}
						if(tempYIndex > yIndex){
							yIndex = tempYIndex;
							countY += 1;
						}
					}
				}
			}
			if(countX > countY){
				throw new AssertionError("count of "+X+" and "+Y+" are unequal.");
			}
		}
		return arr;
	}

	//split array with equal sum
	public static int splitArray(int[] arr){
		int sum = 0, sumArray = 0;
		for (int num : arr){
			sum += num;
		}
		if(sum % 2 == 1){
			return -1;
		}
		else{
			for (int count = 0; count < arr.length; count++){
				sumArray += arr[count];
				sum -= arr[count];
				if(sumArray == sum){
					return (count+1);
				}
			}
		}	
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {5, 4, 9, 4, 9, 5};
		System.out.println(countClumps(arr));
		int[] fixedXY = fixXY((arr),4,5);
		for (int count = 0; count < fixedXY.length; count++){
			System.out.print(fixedXY[count]);
		}
		System.out.println();
		System.out.println(maxMirror(arr));
	}
}
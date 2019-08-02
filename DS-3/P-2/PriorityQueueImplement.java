
public class PriorityQueueImplement implements PriorityQueue{
	int [][] array;
	int N, start = 0, end = 0, flag = 0;
	PriorityQueueImplement(int n){
		N = n;
		array = new int[n][2];
	}

	public void insert(int[] num) {
		if(ifFull()){
			throw new AssertionError("queue is full.");
		}
		if(((end == start) && (end == 0)) && flag == 0){
			array[0] = num;
			flag = 1;
		}
		else if(flag == 1){
			int index = this.end++;
				while(index >= start && array[index][1] < num[1]){
					array[index+1] = array[index--];
				}
				array[index+1] = num;

		}
		
	}


	public int[] delete() {
		if(ifEmpty()){
			throw new AssertionError("queue is empty.");
		}
		int[] arr =  array[start]; 
		start+=1;
		
		return arr;
		
	}


	public boolean ifEmpty() {
		if((((end == start) && (end == 0)) && flag == 0)||
				(start > end)) {
			return true;
		}
		return false;
	}


	public boolean ifFull() {
		int endPoint = end+1;
		if((endPoint%N == start)){
			return true;
		}
		return false;
	}
	
	public void printArray(int[][] array){
		int length = array.length;
		for(int count = start; count < length; count++){
			System.out.println(array[count][0]+" "+array[count][1]);
		}
	}
	
	public static void main(String[]args){
		PriorityQueueImplement pQueue = new PriorityQueueImplement(5);
		pQueue.insert(new int[]{4,3});
		pQueue.insert(new int[]{5,6});
		pQueue.insert(new int[]{6,1});
		pQueue.insert(new int[]{7,2});
		pQueue.insert(new int[]{8,9});
		pQueue.delete();
		pQueue.printArray(pQueue.array);
		System.out.println(pQueue.ifEmpty());
	}

}

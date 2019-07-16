import java.util.*; 

// take input 2 space separated numbers first = init time, second = burst time
public class JobScheduler {
	static int numEntry = 4;
	static int prevCompTime = 0;
	static int [][] aBTime = new int[numEntry][2];
	static int [] compTime = new int[numEntry];
	static int [] waitTime = new int[numEntry];
	static int [] turnTime = new int[numEntry];
	
	public static int completionTime(int init, int bust, int prevCompTime){
		int compTime = 0;
		if (init > prevCompTime){
			compTime = bust+init;
		}
		else {
			compTime = bust+prevCompTime;
		}
		prevCompTime = compTime;
		return compTime;
	}
	
	public static int waitingTime(int init, int busTime, int comTime){
		return (comTime - busTime - init);
	}
	
	public static int turnAroundTime(int init, int comTime){
		return (comTime - init);
	}
	
	public static double avgWaitTime(int[] wait){
		double avg = 0;
		int waitLength = wait.length;
		for(int count = 0; count < wait.length; count++){
			avg+=wait[count];
		}
		return (avg/=waitLength);
	}
	
	public static int maxValue(int[] arr){
		int max = arr[0];
		for(int count = 0; count< arr.length; count++){
			if(max<arr[count]){
				max = arr[count];
			}
		}
		return max;
	}

	public static void main(String[] args){
		for (int count = 0; count < numEntry; count++){
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();   
			String[] numbers = input.split(" ");
			aBTime[count][0] = Integer.parseInt(numbers[0]);
			aBTime[count][1] = Integer.parseInt(numbers[1]);
			compTime[count] = completionTime(aBTime[count][0], aBTime[count][1], prevCompTime);
			prevCompTime = compTime[count];
			turnTime[count] = turnAroundTime(aBTime[count][0], compTime[count]);
			waitTime[count] = waitingTime(aBTime[count][0], aBTime[count][1], compTime[count]);
		}
	}
}


public class ViratAndBowler {
	private int bowlerNum;
	private int viratBowls;
	private int[][] bowlArray;
	
	ViratAndBowler(int bowlerNum, int viratBowls , int[][]bowlArray){
		this.bowlerNum = bowlerNum;
		this.viratBowls = viratBowls;
		this.bowlArray = bowlArray;
	}
	
	
	/**
	 * @param bArray
	 * @return max heap array
	 */
	public int[][] minHeapyfy(int[][]bArray){
		int arrLength = bArray.length;
		int hNum = (int)Math.log(arrLength);
		for(int heapyfyNum = 0; heapyfyNum <= arrLength- hNum; heapyfyNum++){
			for(int count = 0; count < arrLength-2; count++){
				if(bArray[count][1] < bArray[count+1][1]){
					int[] temp = bArray[count];
					bArray[count] = bArray[count+1];
					bArray[count+1] = temp;
				}
				if(bArray[count][1] < bArray[count+2][1]){
					int[] temp = bArray[count];
					bArray[count] = bArray[count+2];
					bArray[count+2] = temp;
				}
			}
		}
		return bArray;
	}
	
	/**
	 * @return order of bowlers
	 * 
	 */
	public int[] bowlerOrder(){
		int vBowls = this.viratBowls;
		int[] bowlerOrder = new int[vBowls];
		for(int index = 0; index< vBowls; index++){
			this.bowlArray = minHeapyfy(this.bowlArray);
			this.bowlArray[0][1]-=1;
			bowlerOrder[index] = bowlArray[0][0];
		}
		return bowlerOrder;
	}
	
	public static void main(String[]args){
		int[][] ba = new int[][]{
				{0,5},
				{1,15},
				{2,10},
				{3,8},
				{4,11},
				{5,16},
				{6,2},
				{7,19},
				{8,7},
				{9,6},
				{10,2},
				{11,4},
				{12,7}
		};
		ViratAndBowler vb = new ViratAndBowler(13,15,ba);
		int[] array = vb.bowlerOrder();
		
		for(int count = 0; count< 15; count++){
			System.out.println(array[count]);
		}
	}
}

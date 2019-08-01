public class QueueOp implements Queue{
	static int start = 0, end = 0, N;
	static int [] array;
	int flag =0;
	
	QueueOp(int n){
		if(n > 0){
			N = n;
			array = new int[n];
		}
	}
	@Override
	public void insert(int num){
		if(isFull()){
			throw new AssertionError("queue is full.");
		}
		if(((end == start) && (end == 0)) && flag == 0){
			array[0] = num;
			flag = 1;
		}
		else if(flag == 1){
			array[++end] = num;
		}
	}
	@Override
	public void delete(){
		
		if(isEmpty()){
			throw new AssertionError("queue is empty.");
		}
		start+=1;
	}
	@Override
	public boolean isEmpty(){
		if((((end == start) && (end == 0)) && flag == 0)||
				(start > end)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isFull(){
		int endPoint = end+1;
		if((endPoint%N == start)){
			return true;
		}
		return false;
	}
	
	public static void main(String[]args){
		QueueOp queue = new QueueOp(5);
		queue.insert(4);
		//queue.insert(4);
		//queue.insert(4);
		//queue.insert(4);
		//queue.insert(4);
		//queue.delete();
		System.out.println(queue.isEmpty());
	}

}

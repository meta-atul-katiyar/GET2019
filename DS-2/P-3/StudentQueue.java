
public class StudentQueue{
	static int start = 0, end = 0, N;
	static StudentList [] array;
	int flag =0;
	
	StudentQueue(int n){
		if(n > 0){
			N = n;
			array = new StudentList[n];
		}
	}
	public StudentList peep(){
		if(isEmpty()){
			throw new AssertionError("empty queue.");
		}
		return array[start];
	}

	public void insert(StudentList num){
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

	public void delete(){
		
		if(isEmpty()){
			throw new AssertionError("queue is empty.");
		}
		start+=1;
	}

	public boolean isEmpty(){
		if((((end == start) && (end == 0)) && flag == 0)||
				(start > end)) {
			return true;
		}
		return false;
	}

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

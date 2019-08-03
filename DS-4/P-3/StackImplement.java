
public class StackImplement implements Stack{
	Node top = null;

	public void push(int num) {
		Node newNode = new Node(num);
		newNode.next = top;
		top = newNode;
	}


	public int pop() {
		if(top == null){
			throw new AssertionError("empty stack.");
		}
		int num = top.data;
		top = top.next;
		return num;
	}

	
	public int peep() {
		if(top == null){
			throw new AssertionError("empty stack.");
		}
		return top.data;
	}

	public boolean isEmpty() {
		if(top == null){
			return true;
		}
		return false;
	}

}

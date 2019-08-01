
public class StackImplement implements Stack{
	Node top = null;
	
	@Override
	public void push(String num) {
		Node newNode = new Node(num);
		newNode.next = top;
		top = newNode;
	}

	@Override
	public String pop() {
		if(top == null){
			throw new AssertionError("empty stack.");
		}
		String num = top.data;
		top = top.next;
		return num;
	}

	
	public String peep() {
		if(top == null){
			throw new AssertionError("empty stack.");
		}
		return top.data;
	}
	@Override
	public boolean isEmpty() {
		if(top == null){
			return true;
		}
		return false;
	}
}

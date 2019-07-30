
public class LinkedList {

	Node start = null, end;
	
	// This inner class is made static so that main() can access it 
	static class Node{
		int data;
		Node next;
		
		Node (int data){
			this.data = data;
			next = null;
		}
	}
	
	public static LinkedList insert(LinkedList list, int data){
		Node newNode = new Node(data);
		if(list.start == null){
			list.start = newNode;
			list.end = newNode;
		}
		else{
			Node lastNode = list.end;
			lastNode.next = newNode;
			list.end = newNode;
		}
		return list;
	 }
	
	public static void printList(LinkedList list) {
		Node currNode = list.start;
		System.out.println("linked list:");
		while(currNode != null){
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.println();
	}
	
	public static LinkedList clockwiseRotation(LinkedList list, int L, int R, int N){
		if(N > R-L+1){
			N %= (R-L+1);
		}
		if(list == null){
			throw new AssertionError("enpty list.");
		}
		if(N <= 0){
			return list;
		}
		else{
			Node leftNode = list.start;
			int l = L;
			while(l-- > 2){
				leftNode = leftNode.next;
			}
			Node rightNode = leftNode;
			int r = R-L;
			while(r-- > 1){
				if(rightNode.next.next == null){
					throw new AssertionError("right element is not in list,");
				}
				rightNode = rightNode.next;
			}
			if(L == 1){
				Node currNode = list.start;
				list.start = rightNode.next;
				rightNode.next = rightNode.next.next;
				list.start.next = currNode;
			}
			else{
				Node currNode = leftNode.next;
				leftNode.next = rightNode.next;
				rightNode.next = rightNode.next.next;
				leftNode.next.next = currNode;
			}
		}
		return clockwiseRotation(list, L, R, --N);
	}
	
	public boolean loopInList(LinkedList list){
		Node singleStep = list.start,
				doubleStep = list.start.next;
		while(singleStep.data != doubleStep.data){
			if((singleStep.next == null || doubleStep.next == null) ||
					doubleStep.next.next == null){
				return false;
			}
			singleStep = singleStep.next;
			doubleStep = doubleStep.next.next;
		}
		return true;
	}
		
	
	public static void main(String[]args){
		LinkedList list = new LinkedList();
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		//list.end.next = list.start;
		
		printList(list);

		list = clockwiseRotation(list, 1, 6, 4);
		printList(list);
		
		System.out.println(list.loopInList(list));
	}
}


public class LinkedList {
	Node start = null, end;
	
	/**
	 * @param list
	 * @param data
	 * @return list with values inserted in it
	 */
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
	
	/**
	 * @param list
	 * print list on console
	 */
	public static void printList(LinkedList list) {
		Node currNode = list.start;
		System.out.println("linked list:");
		while(currNode != null){
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.println();
	}
	
	/**
	 * @param list
	 * @param L
	 * @param R
	 * @param N
	 * @return specified rotated list
	 */
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
	
	/**
	 * @param list
	 * @return true if loop exist else false
	 */
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
}

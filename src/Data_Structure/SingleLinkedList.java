package Data_Structure;

public class SingleLinkedList {
	private LinkedNode head;
	
	public static class LinkedNode{
		private int value;
		private LinkedNode next;
		LinkedNode(int value){
			this.value = value;
			this.next = null;
		}
	}
	public void displayLinked() {
		LinkedNode current = head;
		while(current != null) {
			System.out.print(current.value + "--->");
			current = current.next;
		}
		System.out.println("null");
	}
	public void insertAtFirst(int value) {
		LinkedNode newNode = new LinkedNode(value);
		if(head == null) {
			head = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
	}
	public void insertAtEnd(int value) {
		LinkedNode newNode = new LinkedNode(value);
		LinkedNode current = head;
		if(current == null) {
			head = newNode;
		}
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	public void insertAtFixedPosition(int value, int position) {
		LinkedNode newNode = new LinkedNode(value);
		LinkedNode current = head;
		LinkedNode previous = head;
		int count = 1;
		if(position == 1) {
			newNode.next = head;
			head = newNode;
		}else {
			while(current != null && count < position ) {
				count++;
				previous = current;
				current = current.next;
			}
			if(current != null) {
				previous.next = newNode;
				newNode.next = current;
			}else {
				System.out.println("Given position is not valid");
			}
		}
		
	}
	public void deleteNodeFromFirst() {
		head = head.next;
	}
	public void deleteNodeFromEnd() {
		LinkedNode current = head;
		LinkedNode previous = head;
		while(current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
	}
	
	public void deleteFromSpecificPosition(int position) {
		if(position == 1) {
			head = head.next;
		}else {
			LinkedNode current = head;
			LinkedNode previous = head;
			int count = 1;
			while(current != null && count < position) {
				count++;
				previous = current;
				current = current.next;
			}
			if(current != null) {
				previous.next = current.next;
			}else {
				System.out.println("Position not valid");
			}
		}
	}
	public int linkedListLength() {
	   LinkedNode current = head;
	   int count = 1 ;
	   if(current == null) {
		   return 0;
	   }else {
		   while(current.next != null) {
			   count++;
			   current = current.next;
		   }
		   return count;
	   }
	}
	//Find a key in the linked list
	public boolean findKey(int key) {
		LinkedNode current = head;
		if(current == null) {
			return false;
		}else {
			while(current != null) {
				if(current.value == key) {
					return true;
				}
				current = current.next;
			}
			return false;
		}
	}
	//find middle node in the list 
	public LinkedNode findMiddleNode() {
		LinkedNode slwPtr = head;
		LinkedNode fastPtr = head; 
		if(head == null) {
			return head;
		}else {
			while(fastPtr != null && fastPtr.next != null) {
				fastPtr = fastPtr.next.next; 
				slwPtr = slwPtr.next;
			}
			return slwPtr;
		}
	}
	// revesre given linked list
	public void reverseLinkedList() {
		LinkedNode current = head;
		LinkedNode previous = null;
		LinkedNode next = null;
		if(current == null ) {
			return;
		}else {
			while(current != null) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			head = previous;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		singleLinkedListOperations();

	}
	
	public static void singleLinkedListOperations() {
		SingleLinkedList sll = new SingleLinkedList();
		sll.head = new LinkedNode(10);
		LinkedNode second = new LinkedNode(2);
		LinkedNode third = new LinkedNode(3);
		LinkedNode four = new LinkedNode(5);
		sll.head.next = second;
		second.next = third;
		third.next = four;
		sll.insertAtFirst(14);
		sll.insertAtEnd(12);
		sll.insertAtFixedPosition(0,2);
		sll.displayLinked(); 
		System.out.println("middle node of the given List "+ sll.findMiddleNode().value);
		//System.out.println(6+" Key is present in the list "+ sll.findKey(6));
		//sll.deleteNodeFromFirst();
		//sll.deleteFromSpecificPosition(2);
		sll.reverseLinkedList();
		sll.displayLinked();
		//System.out.println("Linked List Length -->"+ sll.linkedListLength());
	}

}

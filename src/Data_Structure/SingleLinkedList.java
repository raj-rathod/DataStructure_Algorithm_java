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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		//sll.deleteNodeFromFirst();
		sll.deleteNodeFromEnd();
		sll.displayLinked();

	}

}
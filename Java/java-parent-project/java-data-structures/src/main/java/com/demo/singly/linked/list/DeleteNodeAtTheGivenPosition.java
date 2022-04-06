package com.demo.singly.linked.list;

public class DeleteNodeAtTheGivenPosition {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		deleteNodeAtThePosition(3);

	}
	
	static void populateData() {

		
		SinglyLinkedList.ListNode<Integer> headNode = new SinglyLinkedList.ListNode<>(10);
		SinglyLinkedList.ListNode<Integer> secondNode = new SinglyLinkedList.ListNode<>(12);
		SinglyLinkedList.ListNode<Integer> thirdNode = new SinglyLinkedList.ListNode<>(16);
		SinglyLinkedList.ListNode<Integer> fourthNode = new SinglyLinkedList.ListNode<>(16);
		
		singlyLinkedList.setHead(headNode);
		
		headNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		
	}

	static void deleteNodeAtThePosition(int position) {
		SinglyLinkedList.ListNode<Integer> head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode<Integer> previous = head;
		SinglyLinkedList.ListNode<Integer> current = head;
		int count = 1;
		while(count < position) {
			previous = current;
			current = current.getNext();
			count++;
		}
		SinglyLinkedList.ListNode<Integer> next = current.getNext();
		previous.setNext(next);
      
		
		System.out.println(singlyLinkedList);
	}
}

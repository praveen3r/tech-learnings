package com.demo.doubly.linked.list;

public class DeleteNodeAtTheGivenPosition {
	
	static DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		deleteNodeAtThePosition(3);

	}
	
	static void populateData() {

		
		DoublyLinkedList.ListNode<Integer> headNode = new DoublyLinkedList.ListNode<>(10);
		DoublyLinkedList.ListNode<Integer> secondNode = new DoublyLinkedList.ListNode<>(12);
		DoublyLinkedList.ListNode<Integer> thirdNode = new DoublyLinkedList.ListNode<>(16);
		DoublyLinkedList.ListNode<Integer> tailNode = new DoublyLinkedList.ListNode<>(18);

		doublyLinkedList.setHead(headNode);

		headNode.setNext(secondNode);

		secondNode.setPrev(headNode);
		secondNode.setNext(thirdNode);

		thirdNode.setPrev(secondNode);
		thirdNode.setNext(tailNode);

		tailNode.setPrev(thirdNode);
		doublyLinkedList.setTail(tailNode);
		
	}

	static void deleteNodeAtThePosition(int position) {
		DoublyLinkedList.ListNode<Integer> current = doublyLinkedList.getHead();
		int count = 1;
		while(count < position) {
			current = current.getNext();
			count++;
		}
		DoublyLinkedList.ListNode<Integer> previous = current.getPrev();
		DoublyLinkedList.ListNode<Integer> next = current.getNext();
		previous.setNext(next);
		next.setPrev(previous);
      
		
		System.out.println(doublyLinkedList);
	}
}

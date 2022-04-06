package com.demo.doubly.linked.list;

public class DeleteNodeWithTheGivenKey {
	
	static DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		deleteNodeWithGivenKey(12);

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

	static void deleteNodeWithGivenKey(int key) {
		DoublyLinkedList.ListNode<Integer> current = doublyLinkedList.getHead();
		
		while(current != null && key != current.getData()) {
			current = current.getNext();
		}
		if(current == null) return;
		
		DoublyLinkedList.ListNode<Integer> previous = current.getPrev();
		DoublyLinkedList.ListNode<Integer> next = current.getNext();
		
		previous.setNext(current.getNext());
		next.setPrev(previous);
      
		
		System.out.println(doublyLinkedList);
	}
}

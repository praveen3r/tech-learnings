package com.demo.singly.linked.list;

public class DeleteNodeAtTheLast {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		deleteNodeAtTheBeginning();

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

	static void deleteNodeAtTheBeginning() {
		SinglyLinkedList.ListNode<Integer> head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode<Integer> previous = head;
		SinglyLinkedList.ListNode<Integer> current = head;
		while(current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
		System.out.println(previous);
		previous.setNext(null);
      
		
		System.out.println(singlyLinkedList);
	}
}

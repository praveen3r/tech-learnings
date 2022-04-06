package com.demo.singly.linked.list;

public class RemoveDuplicate {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		findDuplicate();

	}
	
	static void populateData() {

		
		SinglyLinkedList.ListNode<Integer> headNode = new SinglyLinkedList.ListNode<>(10);
		SinglyLinkedList.ListNode<Integer> secondNode = new SinglyLinkedList.ListNode<>(10);
		SinglyLinkedList.ListNode<Integer> thirdNode = new SinglyLinkedList.ListNode<>(10);
		SinglyLinkedList.ListNode<Integer> fourthNode = new SinglyLinkedList.ListNode<>(11);
		SinglyLinkedList.ListNode<Integer> fifthNode = new SinglyLinkedList.ListNode<>(12);
		SinglyLinkedList.ListNode<Integer> sixthNode = new SinglyLinkedList.ListNode<>(12);
		
		singlyLinkedList.setHead(headNode);
		
		headNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		fourthNode.setNext(fifthNode);
		fifthNode.setNext(sixthNode);
		
	}

	static void findDuplicate() {
		SinglyLinkedList.ListNode<Integer> head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode<Integer> current = head;
		while(current != null && current.getNext()!=null) {
			if(current.getData() == current.getNext().getData()) {
				current.setNext(current.getNext().getNext());
			}else {
			current = current.getNext();
			}
		}
		System.out.println(singlyLinkedList);
	}
}

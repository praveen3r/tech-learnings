package com.demo.singly.linked.list;

public class DetectLoop {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		detectLoop();

	}
	
	static void populateData() {

		
		SinglyLinkedList.ListNode<Integer> headNode = new SinglyLinkedList.ListNode<>(10);
		SinglyLinkedList.ListNode<Integer> secondNode = new SinglyLinkedList.ListNode<>(12);
		SinglyLinkedList.ListNode<Integer> thirdNode = new SinglyLinkedList.ListNode<>(16);
		SinglyLinkedList.ListNode<Integer> fourthNode = new SinglyLinkedList.ListNode<>(16);
		SinglyLinkedList.ListNode<Integer> fifthNode = new SinglyLinkedList.ListNode<>(18);
		SinglyLinkedList.ListNode<Integer> sixthNode = new SinglyLinkedList.ListNode<>(20);
		SinglyLinkedList.ListNode<Integer> seventhNode = new SinglyLinkedList.ListNode<>(22);
		
		singlyLinkedList.setHead(headNode);
		
		headNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		fourthNode.setNext(fifthNode);
		fifthNode.setNext(sixthNode);
		sixthNode.setNext(seventhNode);
		seventhNode.setNext(fourthNode);
		
	}

	static void detectLoop() {
		SinglyLinkedList.ListNode<Integer> head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode<Integer> slowItr = head;
		SinglyLinkedList.ListNode<Integer> fastItr = head;
		while(fastItr!=null && fastItr.getNext()!=null) {
			slowItr = slowItr.getNext();
			fastItr = fastItr.getNext().getNext();
			if(slowItr == fastItr) {
				System.out.println("detected loop");
				return;
			}
		}
		System.out.println("end of method");
	}
}

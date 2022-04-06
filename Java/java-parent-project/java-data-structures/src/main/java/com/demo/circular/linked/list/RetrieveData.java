package com.demo.circular.linked.list;

public class RetrieveData {
	
	static CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();

	public static void main(String[] args) {
		populateData();
		displayData();

	}
	
	static void populateData() {

		
		CircularLinkedList.ListNode<Integer> firstNode = new CircularLinkedList.ListNode<>(10);
		CircularLinkedList.ListNode<Integer> secondNode = new CircularLinkedList.ListNode<>(12);
		CircularLinkedList.ListNode<Integer> thirdNode = new CircularLinkedList.ListNode<>(16);
		CircularLinkedList.ListNode<Integer> fourthNode = new CircularLinkedList.ListNode<>(18);
		
		firstNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		fourthNode.setNext(firstNode);
		
		circularLinkedList.setTail(fourthNode);
		
	}

	static void displayData() {
		CircularLinkedList.ListNode<Integer> last = circularLinkedList.getTail();
		CircularLinkedList.ListNode<Integer> current = last.getNext();
		
		while(current != last) {
			System.out.println("value is "+ current.getData());
			current = current.getNext();
		}
		System.out.println("value is "+ current.getData());
	}
}

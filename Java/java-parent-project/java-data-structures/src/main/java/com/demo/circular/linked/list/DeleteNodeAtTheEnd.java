package com.demo.circular.linked.list;

import com.demo.circular.linked.list.CircularLinkedList.ListNode;

public class DeleteNodeAtTheEnd {
	
	static CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		deleteNodeAtTheBeginning();

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

	static void deleteNodeAtTheBeginning() {
		
		CircularLinkedList.ListNode<Integer> last = circularLinkedList.getTail();
		CircularLinkedList.ListNode<Integer> current = last.getNext();
		CircularLinkedList.ListNode<Integer> prev = null;
		
		while(current != last) {
			prev = current;
			current = current.getNext();
		}

		prev.setNext(current.getNext());
		circularLinkedList.setTail(prev);
		current.setNext(null);
		
		System.out.println(circularLinkedList);
	}
}

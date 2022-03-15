package com.demo.singly.linked.list;

public class MergeTwoSortedList {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		
		SinglyLinkedList.ListNode<Integer> firstNode = new SinglyLinkedList.ListNode<>(1);
		SinglyLinkedList.ListNode<Integer> secondNode = new SinglyLinkedList.ListNode<>(4);
		SinglyLinkedList.ListNode<Integer> thirdNode = new SinglyLinkedList.ListNode<>(6);
		SinglyLinkedList.ListNode<Integer> fourthNode = new SinglyLinkedList.ListNode<>(7);
		
		SinglyLinkedList.ListNode<Integer> node1 = firstNode;
		firstNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		
		SinglyLinkedList.ListNode<Integer> firstNode1 = new SinglyLinkedList.ListNode<>(2);
		SinglyLinkedList.ListNode<Integer> secondNode1 = new SinglyLinkedList.ListNode<>(5);
		
		SinglyLinkedList.ListNode<Integer> node2 = firstNode1;
		firstNode1.setNext(secondNode1);
		
		mergeNode(node1, node2);

	}
	
	static void mergeNode(SinglyLinkedList.ListNode<Integer> node1, SinglyLinkedList.ListNode<Integer> node2) {
		SinglyLinkedList.ListNode<Integer> dummy = new SinglyLinkedList.ListNode<>(0);
		SinglyLinkedList.ListNode<Integer> tail = dummy;
		
		while(node1 != null && node2 != null) {
			if(node1.getData() < node2.getData()) {
				tail.setNext(node1);
				node1 = node1.getNext();
			}else {
				tail.setNext(node2);
				node2 = node2.getNext();
			}
			tail = tail.getNext();
			if(node1 == null) {
				tail.setNext(node2);
			}else if(node2 == null) {
				tail.setNext(node1);
			}
		}
		
		SinglyLinkedList.ListNode<Integer> result = dummy.getNext();
		
		System.out.println(result);
	}
}

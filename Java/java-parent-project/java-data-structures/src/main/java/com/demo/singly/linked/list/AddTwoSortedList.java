package com.demo.singly.linked.list;

public class AddTwoSortedList {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		
		SinglyLinkedList.ListNode<Integer> firstNode = new SinglyLinkedList.ListNode<>(9);
		SinglyLinkedList.ListNode<Integer> secondNode = new SinglyLinkedList.ListNode<>(4);
		SinglyLinkedList.ListNode<Integer> thirdNode = new SinglyLinkedList.ListNode<>(7);
		
		SinglyLinkedList.ListNode<Integer> node1 = firstNode;
		firstNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		
		SinglyLinkedList.ListNode<Integer> firstNode1 = new SinglyLinkedList.ListNode<>(6);
		SinglyLinkedList.ListNode<Integer> secondNode1 = new SinglyLinkedList.ListNode<>(5);
		
		SinglyLinkedList.ListNode<Integer> node2 = firstNode1;
		firstNode1.setNext(secondNode1);
		
		addNode(node1, node2);

	}
	
	static void addNode(SinglyLinkedList.ListNode<Integer> node1, SinglyLinkedList.ListNode<Integer> node2) {
		SinglyLinkedList.ListNode<Integer> dummy = new SinglyLinkedList.ListNode<>(0);
		SinglyLinkedList.ListNode<Integer> tail = dummy;
		
		int carry = 0;
		while(node1 != null || node2 != null) {
			int value1 = (node1 != null)? node1.getData(): 0;
			int value2 = (node2 != null)? node2.getData(): 0;
			
			int sum = carry + value1 + value2;
			carry = sum/10;
			tail.setNext(new SinglyLinkedList.ListNode<>(sum%10));
			
			tail = tail.getNext();
			if(node1 != null) {
				node1 = node1.getNext();
			}
			if(node2 != null) {
				node2 = node2.getNext();
			}
			
			if(node1 == null) {
				tail.setNext(node2);
			}else if(node2 == null) {
				tail.setNext(node1);
			}
		}
		if(carry > 0) {
			tail.setNext(new SinglyLinkedList.ListNode<>(carry));
		}
		
		SinglyLinkedList.ListNode<Integer> result = dummy.getNext();
		
		System.out.println(result);
	}
}

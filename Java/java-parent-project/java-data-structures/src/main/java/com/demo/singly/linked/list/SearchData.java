package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class SearchData {
	
	static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

	public static void main(String[] args) {
		populateData();
		
		boolean isDataFound = searchData(34);
		System.out.println(isDataFound);

	}
	
	static void populateData() {

		
		SinglyLinkedList.ListNode headNode = new SinglyLinkedList.ListNode(10);
		SinglyLinkedList.ListNode secondNode = new SinglyLinkedList.ListNode(12);
		SinglyLinkedList.ListNode thirdNode = new SinglyLinkedList.ListNode(14);
		SinglyLinkedList.ListNode fourthNode = new SinglyLinkedList.ListNode(16);
		
		singlyLinkedList.setHead(headNode);
		
		headNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		
	}

	static boolean searchData(int value) {
		SinglyLinkedList.ListNode head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode current = head;
		while(current != null) {
			if(current.getData() ==  value) {
				return true;
			}
			current = current.getNext();
			
		}
		return false;
	}
}

package com.demo.singly.linked.list;

public class SearchData {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		boolean isDataFound = searchData(34);
		System.out.println(isDataFound);

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

	static boolean searchData(int value) {
		SinglyLinkedList.ListNode<Integer> head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode<Integer> current = head;
		while(current != null) {
			if(current.getData() ==  value) {
				return true;
			}
			current = current.getNext();
			
		}
		return false;
	}
}

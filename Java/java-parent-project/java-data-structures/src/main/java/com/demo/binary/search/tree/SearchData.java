package com.demo.binary.search.tree;

public class SearchData {
	
	static BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	public static void main(String[] args) {
		
		populateData();
		BinarySearchTree.TreeNode<Integer> node = searchData(binarySearchTree.getRoot(), 22);
		System.out.println(node);
		
	}
	
	private static BinarySearchTree.TreeNode<Integer> searchData(BinarySearchTree.TreeNode<Integer> root, int value) {
		if(root == null || root.getData() == value) {
			return root;
		}
		if(value < root.getData()) {
			return searchData(root.getLeft(), value);
		}else {
			return searchData(root.getRight(), value);
		}
	}
	
	private static void populateData() {
		insertValues(6);
		insertValues(5);
		insertValues(8);
		insertValues(10);
		insertValues(3);
	}
	
	private static void  insertValues(int value){
		BinarySearchTree.TreeNode<Integer> root = insertValues(binarySearchTree.getRoot(), value);
		binarySearchTree.setRoot(root);
		
	}
	
	private static BinarySearchTree.TreeNode<Integer> 
	    insertValues(BinarySearchTree.TreeNode<Integer> root, int value){
		
		if(root == null) {
			root = new BinarySearchTree.TreeNode<Integer>(value);
			return root;
		}
		
		if(value < root.getData()) {
			root.setLeft(insertValues(root.getLeft(),value));
		}else {
			root.setRight(insertValues(root.getRight(),value));
		}
		return root;
	}

}

package com.demo.binary.search.tree;

public class InsertValues {
	
	static BinarySearchTree binarySearchTree = new BinarySearchTree();

	public static void main(String[] args) {
		
		insertValues(6);
		insertValues(5);
		insertValues(8);
		insertValues(10);
		insertValues(3);
		
		System.out.println(binarySearchTree);
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

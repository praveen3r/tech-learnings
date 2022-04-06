package com.demo.binary.search.tree;

import com.demo.binary.tree.BinaryTree;

public class ValidateBinaryTree {
	
	static BinaryTree<Integer> binaryTree = new BinaryTree<>();

	public static void main(String[] args) {

		populateData();
		
		boolean isValid = validate();
		System.out.println(isValid);
	}
	
	static void populateData() {

		BinaryTree.TreeNode<Integer> root = new BinaryTree.TreeNode<Integer>(6);
		BinaryTree.TreeNode<Integer> secondNode = new BinaryTree.TreeNode<Integer>(4);
		BinaryTree.TreeNode<Integer> thirdNode = new BinaryTree.TreeNode<Integer>(7);
		BinaryTree.TreeNode<Integer> fourthNode = new BinaryTree.TreeNode<Integer>(3);
		BinaryTree.TreeNode<Integer> fifthNode = new BinaryTree.TreeNode<Integer>(8);
		BinaryTree.TreeNode<Integer> sixthNode = new BinaryTree.TreeNode<Integer>(8);

		root.setLeft(secondNode);
		root.setRight(thirdNode);
		
		secondNode.setLeft(fourthNode);
		secondNode.setRight(fifthNode);
		
		thirdNode.setRight(sixthNode);
		
		binaryTree.setRoot(root);

	}
	
	private static boolean validate() {
		return validateBinaryTree(binaryTree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean validateBinaryTree(BinaryTree.TreeNode<Integer> root, int min, int max){
		if(root == null){
			return true;
		}
		
		if(root.getData() <= min || root.getData() >= max) {
			return false;
		}
		
		boolean isValid = validateBinaryTree(root.getLeft(), min, root.getData());
		if(isValid) {
			return validateBinaryTree(root.getRight(), root.getData(), max);
		}
		
		return false;
	}

}

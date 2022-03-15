package com.demo.binary.tree;

public class RecursiveInOrderTraversal {

	static BinaryTree binaryTree = new BinaryTree();

	public static void main(String[] args) {

		populateData();
		
		recursiveInOrderTraversal(binaryTree.getRoot());
	}

	static void populateData() {

		BinaryTree.TreeNode<Integer> root = new BinaryTree.TreeNode<Integer>(1);
		BinaryTree.TreeNode<Integer> secondNode = new BinaryTree.TreeNode<Integer>(2);
		BinaryTree.TreeNode<Integer> thirdNode = new BinaryTree.TreeNode<Integer>(3);
		BinaryTree.TreeNode<Integer> fourthNode = new BinaryTree.TreeNode<Integer>(4);
		BinaryTree.TreeNode<Integer> fifthNode = new BinaryTree.TreeNode<Integer>(5);
		BinaryTree.TreeNode<Integer> sixthNode = new BinaryTree.TreeNode<Integer>(6);

		root.setLeft(secondNode);
		root.setRight(thirdNode);
		
		secondNode.setLeft(fourthNode);
		secondNode.setRight(sixthNode);
		thirdNode.setLeft(fifthNode);
		
		binaryTree.setRoot(root);

	}
	
	static void recursiveInOrderTraversal(BinaryTree.TreeNode<Integer> root){
		if(root == null) {
			return;
		}
		
		recursiveInOrderTraversal(root.getLeft());
		System.out.println(root.getData());
		recursiveInOrderTraversal(root.getRight());
	}

}

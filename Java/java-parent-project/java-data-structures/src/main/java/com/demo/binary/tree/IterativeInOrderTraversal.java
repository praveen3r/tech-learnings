package com.demo.binary.tree;

import java.util.Stack;

public class IterativeInOrderTraversal {

	static BinaryTree<Integer> binaryTree = new BinaryTree<>();

	public static void main(String[] args) {

		populateData();
		
		iterativeInOrderTraversal(binaryTree.getRoot());
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
	
	static void iterativeInOrderTraversal(BinaryTree.TreeNode<Integer> root){
		Stack<BinaryTree.TreeNode<Integer>> stack = new Stack<BinaryTree.TreeNode<Integer>>();
		BinaryTree.TreeNode<Integer> temp = root;
		
		while(!stack.isEmpty() || temp!=null) {
			if(temp != null) {
				stack.push(temp);
				temp = temp.getLeft();
			}else {
				temp = stack.pop();
				System.out.println("Data is "+ temp.getData());
				temp = temp.getRight();
			}
		}
	}

}

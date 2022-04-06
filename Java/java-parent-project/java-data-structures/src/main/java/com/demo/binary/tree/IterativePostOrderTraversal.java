package com.demo.binary.tree;

import java.util.Stack;

public class IterativePostOrderTraversal {

	static BinaryTree<Integer> binaryTree = new BinaryTree<>();

	public static void main(String[] args) {

		populateData();
		
		iterativePostOrderTraversal(binaryTree.getRoot());
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
	
	static void iterativePostOrderTraversal(BinaryTree.TreeNode<Integer> root){
		Stack<BinaryTree.TreeNode<Integer>> stack = new Stack<BinaryTree.TreeNode<Integer>>();
		BinaryTree.TreeNode<Integer> current = root;
		
		while(!stack.isEmpty() || current!=null) {
			if(current != null) {
				stack.push(current);
				current = current.getLeft();
			}else {
				BinaryTree.TreeNode<Integer> temp = stack.peek().getRight();
				if(temp == null) {
					temp = stack.pop();
					System.out.println("data is "+ temp.getData());
					while(!stack.isEmpty() && temp==stack.peek().getRight()) {
						temp = stack.pop();
						System.out.println("data is "+ temp.getData());
					}
				}else {
					current = temp;
				}
			}
		}
	}

}

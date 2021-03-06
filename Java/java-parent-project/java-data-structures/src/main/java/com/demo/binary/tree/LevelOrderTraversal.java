package com.demo.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	static BinaryTree<Integer> binaryTree = new BinaryTree<>();

	public static void main(String[] args) {

		populateData();
		
		iterativePreOrderTraversal(binaryTree.getRoot());
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
	
	static void iterativePreOrderTraversal(BinaryTree.TreeNode<Integer> root){
		Queue<BinaryTree.TreeNode<Integer>> queue = new LinkedList<BinaryTree.TreeNode<Integer>>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			BinaryTree.TreeNode<Integer> node = queue.poll();
			System.out.println(node.getData());
			
			if(node.getLeft() != null) {
				queue.offer(node.getLeft());
			}
			
			if(node.getRight() != null) {
				queue.offer(node.getRight());
			}
		}
	}

}

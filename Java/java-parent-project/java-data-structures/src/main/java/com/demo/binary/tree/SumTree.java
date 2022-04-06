package com.demo.binary.tree;

public class SumTree {

	static BinaryTree<Integer> binaryTree = new BinaryTree<>();

	public static void main(String[] args) {

		populateData();

		int value = isSumTree(binaryTree.getRoot());
		System.out.println(value);
	}

	static void populateData() {

		BinaryTree.TreeNode<Integer> root = new BinaryTree.TreeNode<Integer>(5);
		BinaryTree.TreeNode<Integer> secondNode = new BinaryTree.TreeNode<Integer>(2);
		BinaryTree.TreeNode<Integer> thirdNode = new BinaryTree.TreeNode<Integer>(3);
		BinaryTree.TreeNode<Integer> fourthNode = new BinaryTree.TreeNode<Integer>(2);

		root.setLeft(secondNode);
		root.setRight(thirdNode);

		secondNode.setLeft(fourthNode);

		binaryTree.setRoot(root);

	}

	private static int isSumTree(BinaryTree.TreeNode<Integer> node) {
		
		if (node == null) 
            return 0; 
		
		if(node.getLeft()== null && node.getRight()==null) {
			return node.getData();
		}
   
        /* Get sum of nodes in left and right subtrees */
		int leftData = isSumTree(node.getLeft()); 
        int rightData = isSumTree(node.getRight());
        
     if (leftData !=Integer.MIN_VALUE && rightData!=Integer.MIN_VALUE && leftData+rightData == node.getData()) 
         return node.getData(); 

     return Integer.MIN_VALUE; 
	}

}

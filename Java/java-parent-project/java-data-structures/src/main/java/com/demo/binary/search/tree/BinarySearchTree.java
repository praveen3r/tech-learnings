package com.demo.binary.search.tree;

public class BinarySearchTree<T> {

	private TreeNode<T> root;

	static class TreeNode<T> {
		private TreeNode<T> left;
		private TreeNode<T> right;
		private T data;

		public TreeNode<T> getLeft() {
			return left;
		}

		public void setLeft(TreeNode<T> left) {
			this.left = left;
		}

		public TreeNode<T> getRight() {
			return right;
		}

		public void setRight(TreeNode<T> right) {
			this.right = right;
		}

		public TreeNode(T data) {
			this.data = data;
		}
		
		public T getData() {
			return this.data;
		}
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

	
}

package com.demo.trie;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		this.root = new TrieNode();
	}

	public static class TrieNode {
		private TrieNode[] children;
		private boolean isWord;
		
		public TrieNode() {
			this.children = new TrieNode[26];
			this.isWord = false;
		}

		public TrieNode[] getChildren() {
			return children;
		}

		public void setChildren(TrieNode[] children) {
			this.children = children;
		}

		public boolean isWord() {
			return isWord;
		}

		public void setWord(boolean isWord) {
			this.isWord = isWord;
		}
		
		
	}

	public TrieNode getRoot() {
		return root;
	}

	
}

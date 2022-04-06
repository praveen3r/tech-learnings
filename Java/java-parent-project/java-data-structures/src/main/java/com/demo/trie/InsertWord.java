package com.demo.trie;

public class InsertWord {
	
	static Trie trie = new Trie();

	public static void main(String[] args) {

		insert("cat");
		insert("son");
		insert("son");
		insert("so");
	}
	
	private static void insert(String word) {
		
		word = word.toLowerCase();
		
		Trie.TrieNode current = trie.getRoot();
		
		char[] charArr = word.toCharArray();
		for(int i=0; i<charArr.length;i++) {
			char ch = word.charAt(i);
			int index = ch - 'a';
			if(current.getChildren()[index] == null) {
				Trie.TrieNode node = new Trie.TrieNode();
				current.getChildren()[index] = node;
				current = node;
			}else {
				current = current.getChildren()[index];
			}
		}
		current.setWord(true);
		
		System.out.println(trie);
	}

}

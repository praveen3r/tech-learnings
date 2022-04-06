package com.demo.hash;

import java.util.Objects;

public class CustomHashTable<K, V> {

	private HashNode<K, V>[] buckets;
	private int noOfBuckets; // capacity
	private int size; // no of key-value pairs

	public CustomHashTable() {
		this.noOfBuckets = 10;
		this.buckets = new HashNode[noOfBuckets];
	}

	public CustomHashTable(int noOfBuckets) {
		this.noOfBuckets = noOfBuckets;
		this.buckets = new HashNode[noOfBuckets];
	}

	private class HashNode<K, V> {

		private K key;
		private V value;
		private HashNode<K, V> next;

		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	public int getBucketIndex(K key) {
		return Objects.hashCode(key) % this.noOfBuckets;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void insertNodeAtTheBeginning(HashNode newNode, K key, int bucketIndex) {
		HashNode<K, V> head = buckets[bucketIndex];
		newNode.next = head;
		buckets[bucketIndex] = newNode;

	}

	public void put(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = buckets[bucketIndex];
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		size++;
		HashNode<K, V> node = new HashNode<>(key, value);
		insertNodeAtTheBeginning(node, key, bucketIndex);

	}

	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = buckets[bucketIndex];
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public V remove(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = buckets[bucketIndex];
		HashNode<K, V> prev = null;
		while (head != null) {
			if (head.key.equals(key)) {
				break;
			}
			prev = head;
			head = head.next;
		}
		if (head == null)
			return null;
		size--;
		if (prev != null)
			prev.next = head.next;
		else
			buckets[bucketIndex] = head.next;
		return head.value;
	}

}

package com.demo.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TestDistinct {

	public static void main(String[] args) {
		Item item1 = new Item("Apple", 1, new BigDecimal(10));
		Item item2 = new Item("Mango", 1, new BigDecimal(10));
		Item item3 = new Item("Apple", 1, new BigDecimal(10));
		Item item4 = new Item("Grapes", 1, new BigDecimal(10));

		List<Item> itemList = new ArrayList<>();

		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);

		// Unique item names
		List<String> uniqueItemNameList = itemList.stream().map(item -> item.getName()).distinct()
				.collect(Collectors.toList());
		System.out.println(uniqueItemNameList);

		// Unique item objects based on name
		TreeSet<Item> uniqueItemList = itemList.stream().collect(Collectors.toCollection(
						() -> new TreeSet<Item>(Comparator.comparing(Item:: getName))
				));

		System.out.println(uniqueItemList);
	}

}

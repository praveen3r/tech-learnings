package com.demo.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.demo.dto.Roles;
import com.demo.dto.User;
import com.demo.lambda.ExceptionWrapper;

public class TestList {
	
	public static void display(List<String> alphabets) {
		// alphabets.forEach(System.out::println);
		
		// alphabets.stream().forEach(System.out::println);
	}
	
	public static void displayWithFilter(List<String> alphabets) {
		
		alphabets.stream() .filter(s -> s.startsWith("a")) .forEach(System.out::println);
		
		alphabets.stream() .filter(s -> s.length() > 2).forEach(System.out::println);
		
	}
	
	public static void displayWithFilterMap(List<String> alphabets) {
		alphabets.stream().filter(i -> i.length()>2).map(String::toUpperCase).sorted().forEach(System.out::println);
		
		//Stream<Student> map =persons.stream() .filter(p -> p.getAge() > 18) .map(person -> new Student());
		  
		 // List<Student> students = persons.stream() .filter(p -> p.getAge() > 18).map(person -> new Student()) .collect(Collectors.toList());
		
		
		  //alphabets.stream() .mapToInt(s -> s.length()).forEach(System.out::println);
		
		  //System.out.println(alphabets.stream() .mapToInt(s -> s.length()) .sum());
		 
	}
	
	public static void displayWithFilterCollect(List<String> alphabets) {
		List<String> alphabets1 = alphabets.stream() .filter(s -> s.length() > 2).collect(Collectors.toList());
		 
		  //List<String> alphabets2 = alphabets.stream() .filter(s -> s.length() > 2).collect(Collectors.toCollection(ArrayList::new));
		
		  //Set<String> alphabets3 = alphabets.stream() .filter(s -> s.length() >2).collect(Collectors.toCollection(HashSet::new));
		  
		//List<String> alphabets4 = alphabets.stream().parallel() .filter(s -> s.length() > 2).collect(Collectors.toCollection(ArrayList::new));
			
		//List<String> alphabets5 = alphabets.stream().sequential() .filter(s ->s.length() > 2).collect(Collectors.toCollection(ArrayList::new));
			 
			 // List<String> alphabets61 = alphabets.stream().parallel() .filter(s -> s.length() > 2).sequential().collect(Collectors.toCollection(ArrayList::new));
		
		
		 /* Map<String, String> map = alphabets.stream().collect(Collectors.toMap(Function.identity(), Function.identity()));
		  map.forEach((x, y) -> System.out.println("Key: " + x + ", value: " + y));*/
		
		System.out.println("Merged String: " + alphabets.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", ")));
		
		/*
		 * Map<Object, List<String>> groups = alphabets.stream()
		 * .collect(Collectors.groupingBy(s -> s.length() > 1));
		 * System.out.println(groups.get(true).size());
		 * System.out.println(groups.get(false).size());
		 */
		 
	}
	
	public static void displayWithFind(List<String> alphabets) {
		
		  alphabets.stream().findFirst().ifPresent(System.out::println);
		  
		  //System.out.println(alphabets.stream().findAny().isPresent());
		 
	}
	
	public static void displayWithSort(List<String> alphabets) {
		/*
		 * alphabets.sort(Comparator.naturalOrder());
		 * alphabets.forEach(System.out::println);
		 */

		/*
		 * alphabets.sort((a,b) -> a.compareTo(b));
		 * alphabets.forEach(System.out::println);
		 */

		//alphabets.stream().sorted((a,b) -> a.compareTo(b)).forEach(System.out::println);
		
		//alphabets.stream().sorted((a,b) -> b.compareTo(a)).forEach(System.out::println);
		
		//alphabets.stream().sorted(Comparator.comparing(a -> a.toString()).reversed()).forEach(System.out::println);
	}

	
	public static void displayWithReduce(List<String> alphabets) {
		
		/*reduce operation applies a binary operator to each element in the stream where the first argument to the operator
		is the return value of the previous application and second argument is the current stream element.
		
		T reduce(T identity, BinaryOperator<T> accumulator);*/
		
		/*
		 * System.out.println(alphabets.stream().reduce("", (acc, item) -> acc + " " +
		 * item));
		 */

		alphabets.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2).ifPresent(System.out::println);
		
		alphabets.stream().collect(Collectors.reducing((s1, s2) -> s1.length() > s2.length() ? s1 : s2)).ifPresent(System.out::println);
	}
	
	public static void displayWithAggregate(List<String> alphabets) {
		//System.out.println(alphabets.stream().count());
				//System.out.println(alphabets.stream().min(Comparator.comparing(item -> item.length())));
	}
	
	public static void displayWithOptional() {
		List<String> collection = null;
		//Optional.ofNullable(collection).map(Collection::stream).orElse(Stream.empty()).forEach(System.out::println);
				/*
				 * Optional.ofNullable(collection) .orElseGet(Collections::emptyList)
				 * .forEach(System.out::println);
				 */
	}
	
	public static void displayWithPrimitives() {
		/*
		 * Stream<Long> tenNaturalNumbers = Stream.iterate(10L, n -> n - 1) .limit(10);
		 * 
		 * tenNaturalNumbers.forEach(i -> { IntStream.range(0, LongToIntFunction); });
		 */

		/*
		 * Stream.iterate(10, n -> n - 1).limit(10).forEach(i -> { IntStream.range(0,
		 * i).forEach(e -> { System.out.print("*"); }); System.out.print("\n"); });
		 */

		/*
		 * Stream.of(1, 2, 3) .flatMap(n -> Stream.of(n, n+1))
		 * .forEach(System.out::println);
		 */

		/*
		 * Stream.iterate(10, n -> n - 1).limit(10) .flatMap(n -> Stream.of(0,
		 * n)).forEach(e -> { System.out.print(e); System.out.print("\n"); });
		 */

		/*
		 * Stream.iterate(10, n -> n - 1).limit(10) .flatMap(n -> Stream.of(0,
		 * n)).forEach(e -> { System.out.print(e); System.out.print("\n"); });
		 */
		/*
		 * List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5); int sum =
		 * numbers.stream().reduce(0, Integer::sum); System.out.println(sum);*/
	}
	
	public static void displayWithRemove(List<String> alphabets) {
		
		  alphabets.removeIf(s1 ->  s1.startsWith("b")); 
		  System.out.println(alphabets);
		 
		
	}
	
	public static void displayWithAggregateFuns() {
		List<Integer> numbers = Arrays.asList(1,2,5,6);
		
		IntSummaryStatistics summary = numbers.stream().collect(Collectors.summarizingInt(Integer::valueOf));
	 
		double average = summary.getAverage();
		int maximum = summary.getMax();
		int minimum = summary.getMin();
		long cnt = summary.getCount();
		long sum = summary.getSum();
		
		System.out.println(" average "+ average +" maximum "+ maximum +" minimum "+ minimum+" count "+cnt+ " sum "+sum);
		
		long count = numbers.stream().filter( number -> number > 5) .collect(Collectors.counting());
		
		List<String> itemsList = Arrays.asList("apple", "apple", "banana","apple", "orange", "banana", "papaya");
		
		Double result = itemsList.stream().collect(Collectors.averagingDouble(String::length));
		
		System.out.println("result "+ result); 
		
		Optional<String> result1 = itemsList.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
		
		System.out.println("result1 "+ result1); 
		
		int sumLen = itemsList.stream().collect(Collectors.summingInt(String::length));
		
		System.out.println("sumLen "+ sumLen); 
		
	}
	
	public static void displayWithGroupingBy() {
		
		List<String> itemsList = Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result = itemsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        System.out.println(result);
        
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        Map<BigDecimal, List<Item>> groupByPriceMap = items.stream().collect(Collectors.groupingBy(Item::getPrice));

        Map<String, Long> counting = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
        
        Map<String, Integer> sum = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        
        Comparator<Item> qtyComparator = Comparator.comparing(Item::getQty); 
        
        Map<String, Optional<Item>> map = items.stream().collect(Collectors.groupingBy(Item::getName,Collectors.reducing(BinaryOperator.maxBy(qtyComparator))));

        map.forEach((k,v)->System.out.println("Item Name :"+k+" Qty:"+((Optional<Item>)v).get().getQty()+" Price:"+((Optional<Item>)v).get().getPrice()));
	}
	
	public static void displayWithPartioningBy() {
		
		//The partitionBy() method can be used to partition the result of Stream in two parts e.g. pass or fail. 
		
		List<Integer> numbers = Arrays.asList(1,2,5,6);
		
		Map<Boolean, List<Integer>> evenAndOddNumbers = numbers.stream().collect(Collectors.partitioningBy(number -> number%2 ==0 ));
		
		System.out.println(evenAndOddNumbers);
	}
	
	public static void displayWithMergingStreams() {
	    Stream<Integer> stream1 = Stream.of(1, 3, 5);
	    Stream<Integer> stream2 = Stream.of(2, 4, 6);
	    Stream<Integer> stream3 = Stream.of(18, 15, 36);
	 
	    //Stream<Integer> resultingStream = Stream.concat(stream1, stream2);
	    //Stream<Integer> resultingStream = Stream.concat(Stream.concat(stream1, stream2), stream3);
	    Stream<Integer> resultingStream = Stream.of(stream1, stream2, stream3).flatMap(i -> i);
	 
	    resultingStream.forEach(System.out::println);
	    
	}
	
	public static void displayWithSpliterator() {
		
		
		  ArrayList<String> daysOfWeekAsList = new ArrayList<String>();
		  daysOfWeekAsList .addAll(Arrays.asList("Sunday", "Monday", "Tuesday",
		  "Wednesday", "Thursday", "Friday", "Saturday"));
		
		  Spliterator<String> s = daysOfWeekAsList.spliterator(); 
		  
		  Spliterator<String>  s1 = s.trySplit();
		  
		  s.forEachRemaining(System.out::println);
		  
		  System.out.println("-- traversing the other half of the spliterator --- ");
		  
		  s1.forEachRemaining(System.out::println);
		 

	}
	
	public static void displayWithFilterNestedList() {
		Roles role1 = new Roles();
		role1.setId(1);
		List<Roles> role1List = new ArrayList<>();
		role1List.add(role1);
		
		Roles role2 = new Roles();
		role2.setId(2);
		List<Roles> role2List = new ArrayList<>();
		role2List.add(role2);
		
		User user1 = new User();
		user1.setName("Mahesh");
		user1.setRoles(role1List);
		
		User user2 = new User();
		user2.setName("Praveen");
		user2.setRoles(role2List);
		
		User user3 = new User();
		user3.setName("Nishant");
		user3.setRoles(role1List);
		
		User user4 = new User();
		user4.setName("User");
		user4.setRoles(role1List);
		
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		
		//userList.removeIf(user -> user.getRoles().stream().anyMatch(role -> role.getId() == 2));
		userList = userList.stream().filter(user -> user.getRoles().stream()
				.anyMatch(role -> role.getId() != 2)).collect(Collectors.toList());
		
		userList.forEach(user -> {
			System.out.println(user.getName());
		});
		//List<Roles> roleList = userList.stream().flatMap(user -> user.getRoles().stream()).filter(role -> role.getId() == 2).collect(Collectors.toList());
	}
	
	public static void displayWithExceptions() throws Exception{
		List<String> alphabets = Arrays.asList(null, "cat", "bbb", "dog");
		alphabets.forEach(ExceptionWrapper.throwExceptions(str -> {
			displayList(str);
		}));
	}
	
	public static void displayList(String str) throws Exception{
		 System.out.println(str.toUpperCase());
	}
	
	public static void main(String[] args) {
		List<String> alphabets = Arrays.asList("aa", "cat", "bbb", "dog");
		
		/*
		 * List<String> alphabets1 = new ArrayList(); alphabets1.add("aa");
		 * alphabets1.add("cat"); alphabets1.add("bbb"); alphabets1.add("dog");
		 * 
		 * displayWithRemove(alphabets1);
		 */
		try {
			displayWithExceptions();
		} catch (Exception e) {
			System.out.println("coming here");
			e.printStackTrace();
		}
	}

}

package com.demo.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.demo.dto.Bank;

public class MultipleFilters {

	public static void main(String[] args) {
		List<Bank> bankList = addData();
		filterData1(bankList, 1, "test123", "testBranch1", "test1");
		//filterData1(bankList, null, "test123", "testBranch1", null);
	}

	/*
	 * public static void filterData(List<Bank> bankList, Integer id, String name,
	 * String branch, String address) { List<Predicate<Bank>> allPredicates = new
	 * ArrayList<>(); if(Optional.ofNullable(id).isPresent()) { Predicate<Bank>
	 * idPredicate = d-> id.equals(d.getId()); allPredicates.add(idPredicate); }
	 * if(Optional.ofNullable(name).isPresent()) { Predicate<Bank> namePredicate =
	 * d-> name.equals(d.getName()); allPredicates.add(namePredicate); }
	 * if(Optional.ofNullable(branch).isPresent()) { Predicate<Bank> branchPredicate
	 * = d-> branch.equals(d.getBranch()); allPredicates.add(branchPredicate); }
	 * if(Optional.ofNullable(address).isPresent()) { Predicate<Bank>
	 * addressPredicate = d-> address.equals(d.getAddress());
	 * allPredicates.add(addressPredicate); }
	 * 
	 * bankList.stream() .filter(allPredicates.stream().reduce(x->true,
	 * Predicate::and)) .collect(Collectors.toList()); }
	 */

	public static void filterData1(List<Bank> bankList, Integer id, String name, String branch, String address) {
		List<Predicate<Bank>> allPredicates = new ArrayList<>();
		Predicate<Bank> idPredicate = d -> Optional.ofNullable(id).isPresent() ? id.equals(d.getId()) : 1 == 1;
		allPredicates.add(idPredicate);
		Predicate<Bank> namePredicate = d -> Optional.ofNullable(name).isPresent() ? name.equals(d.getName()) : 1 == 1;
		allPredicates.add(namePredicate);
		Predicate<Bank> branchPredicate = d -> Optional.ofNullable(branch).isPresent() ? branch.equals(d.getBranch()) : 1 == 1;
		allPredicates.add(branchPredicate);
		Predicate<Bank> addressPredicate = d -> Optional.ofNullable(address).isPresent() ? address.equals(d.getAddress()) : 1 == 1;
		allPredicates.add(addressPredicate);

		List<Bank> bankListNew = bankList.stream().filter(allPredicates.stream().reduce(x -> true, Predicate::and)).collect(Collectors.toList());
		System.out.println(bankListNew);
	}

	public static List<Bank> addData() {

		List<Bank> bankList = new ArrayList<>();
		Bank bank = new Bank();
		Bank bank1 = new Bank();
		Bank bank2 = new Bank();
		Bank bank3 = new Bank();
		Bank bank4 = new Bank();

		bank.setId(1);
		bank.setAddress("test1");
		bank.setBranch("testBranch1");
		bank.setName("test123");

		bank1.setId(2);
		bank1.setAddress("test2");
		bank1.setBranch("testBranch1");
		bank1.setName("test123");

		bank2.setId(3);
		bank2.setAddress("test3");
		bank2.setBranch("testBranch1");
		bank2.setName("test123");

		bank3.setId(3);
		bank3.setAddress("test3");
		bank3.setBranch("testBranch1");
		bank3.setName("test123");

		bank4.setId(4);
		bank4.setAddress("test4");
		bank4.setBranch("testBranch1");
		bank4.setName("test123");

		bankList.add(bank);
		bankList.add(bank1);
		bankList.add(bank2);
		bankList.add(bank3);
		bankList.add(bank4);

		return bankList;
	}

}

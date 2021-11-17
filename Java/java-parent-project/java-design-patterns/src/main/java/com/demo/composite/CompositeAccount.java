package com.demo.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeAccount {

	List<Account> accountList = new ArrayList<>();
	
	public void addAccount(Account account) {
		accountList.add(account);
	}
	
	public Integer getBalance() {
		return accountList.stream().collect(Collectors.summingInt(account -> account.getBalance()));
	}
	
}

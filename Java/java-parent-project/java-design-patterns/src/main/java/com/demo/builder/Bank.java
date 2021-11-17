package com.demo.builder;

public class Bank {

	private String bankName;
	
	private String bankBranch;
	
	private boolean isHeadOffice;
	
	private Bank() {
		
	}
	
	Bank(BankBuilder bankBuilder){
		this.bankName = bankBuilder.bankName;
		this.bankBranch = bankBuilder.bankBranch;
		this.isHeadOffice = bankBuilder.isHeadOffice;
	}
	
	public static class BankBuilder {
		
		private String bankName;
		
		private String bankBranch;
		
		private boolean isHeadOffice;
		
		BankBuilder(String bankName, String bankBranch ){
			this.bankName = bankName;
			this.bankBranch = bankBranch;
		}
		
		public BankBuilder setHeadOffice(boolean isHeadOffice) {
			this.isHeadOffice = isHeadOffice;
			return this;
		}
		
		public Bank build() {
			return new Bank(this);
		}
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public boolean isHeadOffice() {
		return isHeadOffice;
	}

	public void setHeadOffice(boolean isHeadOffice) {
		this.isHeadOffice = isHeadOffice;
	}

	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", bankBranch=" + bankBranch + ", isHeadOffice=" + isHeadOffice + "]";
	}
}

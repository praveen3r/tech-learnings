package com.demo.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class TestExchanger {

	public static void main(String[] args) {
		Exchanger exchanger = new Exchanger();

		DataPublishing publishing = new DataPublishing(exchanger, new User(1, "Raghu"));

		DataConsuming consuming = new DataConsuming(exchanger, new User(2, "Ram"));

		new Thread(publishing).start();
		new Thread(consuming).start();

	}

}

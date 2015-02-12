package com.epam.multithread.simple.join;

import com.epam.multithread.common.Util;

public class Main {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				Util.sleep(5000);
			}
		});
		t1.start();
		System.out.println("t1 started");
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Program ended.");

	}
}

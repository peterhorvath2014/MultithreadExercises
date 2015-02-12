package com.epam.multithread.executorservice.join;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epam.multithread.common.Util;

public class Main {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " started");
				Util.sleep(5000);
				System.out.println(Thread.currentThread().getName() + " ended");
			}
		};
		for (int i = 0; i < 10; i++) {
			es.execute(r1);
		}
		es.shutdown();
		System.out.println("Shutdown in progress");
		while (!es.isTerminated()) {
			System.out.println(".");
			Util.sleep();
		}
		System.out.println();
		System.out.println("Program ended.");
	}
}

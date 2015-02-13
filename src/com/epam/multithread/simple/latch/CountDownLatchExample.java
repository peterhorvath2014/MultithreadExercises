package com.epam.multithread.simple.latch;

import java.util.concurrent.CountDownLatch;

import com.epam.multithread.common.Util;

public class CountDownLatchExample {
	private static final class Worker extends Thread {
		private CountDownLatch startGate;
		private CountDownLatch endGate;

		public Worker(int n, CountDownLatch startGate, CountDownLatch endGate) {
			super("Worker" + n);
			this.startGate = startGate;
			this.endGate = endGate;
		}

		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " started and waiting for start signal...");
				startGate.await();
				Util.sleepRandom();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println(Thread.currentThread().getName() + " ending, and counting down.");
				endGate.countDown();
			}
		}
	}

	public static void main(String[] args) {
		int nThreads = 6;
		CountDownLatch readyToGo = new CountDownLatch(1);
		CountDownLatch allDone = new CountDownLatch(nThreads);

		for (int i = 0; i < nThreads; i++) {
			new Worker(i, readyToGo, allDone).start();
		}

		System.out.println("Wait a second...");
		Util.sleep();
		System.out.println("Let's start!");
		readyToGo.countDown();

		try {
			allDone.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exit program");

	}
}

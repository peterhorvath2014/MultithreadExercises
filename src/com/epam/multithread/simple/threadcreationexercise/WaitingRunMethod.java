package com.epam.multithread.simple.threadcreationexercise;

public class WaitingRunMethod implements Runnable {
	private final static int WAIT_TIME = 1000;

	public void run() {
		System.out.println("WaitingRunMethod started and waits for "
				+ WAIT_TIME / 1000 + " second(s)");
		try {
			Thread.sleep(WAIT_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("WaitingRunMethod ended.");
		}
	}
}

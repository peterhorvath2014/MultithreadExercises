package com.epam.multithread.common;

import java.util.Random;

public class Util {
	private final static long DEFAULT_SLEEP_TIME = 1000l;
	private final static Random random = new Random();
	
	public static void sleep() {
		Util.sleep(DEFAULT_SLEEP_TIME);
	}
	
	public static void sleepRandom() {
		Util.sleep(random.nextInt((int)DEFAULT_SLEEP_TIME));
	}
	
	public static void sleepRandom(long maxMillis) {
		Util.sleep(random.nextInt((int)maxMillis));
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

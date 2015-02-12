package com.epam.multithread.simple.waitnotify;

import com.epam.multithread.common.Util;

public class PingPongGame {
	private boolean isNextA;

	public void playA() {
		play(true);
	}

	public void playB() {
		play(false);
	}

	private void play(boolean isA) {
		synchronized (this) {
			while (true) {
				// System.out.println("I'm ready... ThreadName: " +
				// Thread.currentThread().getName());
				while ((isA && !isNextA) || (!isA && isNextA)) {
					// System.out.println("Waiting... ThreadName: " +
					// Thread.currentThread().getName());
					waitNoException();
				}
				System.out.println("Ball is coming... ThreadName: " + Thread.currentThread().getName());
				Util.sleepRandom();
				System.out.println("Splash!! ThreadName: " + Thread.currentThread().getName());
				isNextA = !isNextA;
				notifyAll();
			}
		}
	}

	private void waitNoException() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

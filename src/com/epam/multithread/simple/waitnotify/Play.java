package com.epam.multithread.simple.waitnotify;

public class Play {
	public static void main(String[] args) {
		final PingPongGame pingPongGame = new PingPongGame();
		new Thread(new Runnable() {
			public void run() {
				pingPongGame.playA();
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				pingPongGame.playB();
			}
		}).start();
	}
}

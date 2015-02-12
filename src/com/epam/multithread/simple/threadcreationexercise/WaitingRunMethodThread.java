package com.epam.multithread.simple.threadcreationexercise;

public class WaitingRunMethodThread extends Thread {
	private WaitingRunMethod wrm;

	public WaitingRunMethodThread() {
		this.wrm = new WaitingRunMethod();
	}
	
	public void run() {
		this.wrm.run();
	}
	
}

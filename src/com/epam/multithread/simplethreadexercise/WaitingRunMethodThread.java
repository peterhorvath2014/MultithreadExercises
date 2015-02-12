package com.epam.multithread.simplethreadexercise;

public class WaitingRunMethodThread extends Thread {
	private WaitingRunMethod wrm;

	public WaitingRunMethodThread() {
		this.wrm = new WaitingRunMethod();
	}
	
	public void run() {
		this.wrm.run();
	}
	
}

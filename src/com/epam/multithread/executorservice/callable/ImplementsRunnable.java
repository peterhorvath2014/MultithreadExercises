package com.epam.multithread.executorservice.callable;

import com.epam.multithread.common.Util;

public class ImplementsRunnable implements Runnable {
	private String threadName;
	
	public ImplementsRunnable(String threadName) {
		this.threadName = threadName;
	}

	public void run() {
		Util.sleep(2000);
		throw new RuntimeException(threadName + " I'm coming!!");
	}

}

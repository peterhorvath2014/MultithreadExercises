package com.epam.multithread.executorservice.callable;

import java.util.concurrent.Callable;

import com.epam.multithread.common.Util;

public class ImplementsCallable implements Callable<String> {
	private String threadName;
	
	public ImplementsCallable(String threadName) {
		this.threadName = threadName;
	}

	public String call() throws Exception {
		
		Util.sleep(2000);
		throw new RuntimeException(threadName + " I'm coming!!");
		//return new String(threadName);
	}

}

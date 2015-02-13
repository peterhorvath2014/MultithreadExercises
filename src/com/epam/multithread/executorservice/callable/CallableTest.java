package com.epam.multithread.executorservice.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.epam.multithread.common.Util;

public class CallableTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new ImplementsRunnable("1st thread"));
		es.execute(new ImplementsRunnable("2nd thread"));
		es.execute(new ImplementsRunnable("3rd thread"));
		Future<String> f2 = es.submit(new ImplementsCallable("2nd thread"));
		Future<String> f3 = es.submit(new ImplementsCallable("3rd thread"));
		es.shutdown();
		
		while (!f2.isDone() || !f3.isDone()) {
			System.out.print(".");
			Util.sleep();
		}
		Util.sleep();
		System.out.println();
		System.out.println(f2.get());
		System.out.println(f3.get());
		
		System.out.println("Await");
		es.awaitTermination(5, TimeUnit.SECONDS);
		System.out.println("Program ended");
	}
}

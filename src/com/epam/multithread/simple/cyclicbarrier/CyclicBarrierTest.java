package com.epam.multithread.simple.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.epam.multithread.common.Util;

public class CyclicBarrierTest {
	private static final class Worker extends Thread {
		private CyclicBarrier barrier;

		public Worker(int n, CyclicBarrier barrier) {
			super("Worker" + n);
			this.barrier = barrier;
		}

		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " started and waiting for first signal...");
				barrier.await();
				Util.sleepRandom();
				System.out.println(Thread.currentThread().getName() + " started and waiting for second signal...");
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				System.out.println(Thread.currentThread().getName() + " barrier broken! " + e.getMessage());
				e.printStackTrace();
			} 
			System.out.println(Thread.currentThread().getName() + " ended.");
		}
	}

	public static void main(String[] args) {
		int nThreads = 6;
		CyclicBarrier barrier = new CyclicBarrier(6);

		for (int i = 0; i < nThreads; i++) {
			new Worker(i, barrier).start();
		}

		System.out.println("Exit program");
	}
}

package com.epam.multithread.simple.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerSample {
	private static final class ExchangerRunnable implements Runnable {
		private Exchanger exchanger;
		private Object object;
		
		public ExchangerRunnable(Exchanger exchanger, Object object) {
			this.exchanger = exchanger;
			this.object = object;
		}
		public void run() {
			Object prev = this.object;
			try {
				this.object = this.exchanger.exchange(this.object);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Changed: " + prev + " to: " + this.object);
		}
	}

	public static void main(String[] args) {
		Exchanger exch = new Exchanger();
		
		new Thread(new ExchangerRunnable(exch, "A")).start();
		new Thread(new ExchangerRunnable(exch, "B")).start();
		
	}
}

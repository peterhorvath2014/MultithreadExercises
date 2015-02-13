package com.epam.multithread.simple.timer;

import java.util.Timer;
import java.util.TimerTask;

import com.epam.multithread.common.Util;

public class TimerTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " Run started");
				Util.sleep(5000);
				System.out.println(Thread.currentThread().getName() + " Run ended");
			}
		};
		TimerTask task1 = new TimerTask() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " Run started");
				Util.sleep(5000);
				System.out.println(Thread.currentThread().getName() + " Run ended");
			}
		};
		
		timer.schedule(task, 1000);
		timer.schedule(task1, 1000);
	}
}

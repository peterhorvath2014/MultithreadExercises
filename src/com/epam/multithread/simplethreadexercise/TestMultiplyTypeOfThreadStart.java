package com.epam.multithread.simplethreadexercise;

public class TestMultiplyTypeOfThreadStart {
	public static void main(String[] args) {
		new Thread(new WaitingRunMethod()).start();
		new WaitingRunMethodThread().start();
	}
}

package com.epam.multithread.simple.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
	private static Random random = new Random();
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			numbers.add(random.nextInt(100));
			//numbers.add(1);
		}
		
		//syso the real minimum
		int min = Integer.MAX_VALUE;
		for(int number : numbers) {
			if (number < min) {
				min = number; 
			}
		}
		System.out.println("Non multithread solution minimum: " + min);
		
		//syso the real maximum
		int max = Integer.MIN_VALUE;
		for(int number : numbers) {
			if (number > max) {
				max = number; 
			}
		}
		System.out.println("Non multithread solution maximum: " + max);
		
		int sum = 0;
		for(int number : numbers) {
			sum += number;
		}
		System.out.println("Non multithread solution sum: " + sum);
		
		final ForkJoinPool pool = new ForkJoinPool(4);
		final ForkJoinMinimum forkJoinMinimum = new ForkJoinMinimum(numbers);
		System.out.println("Min: " + pool.invoke(forkJoinMinimum));
		
		final ForkJoinPool pool3 = new ForkJoinPool(4);
		final ForkJoinMaximum forkJoinMax = new ForkJoinMaximum(numbers);
		System.out.println("Max: " + pool3.invoke(forkJoinMax));
		
		final ForkJoinPool pool2 = new ForkJoinPool(4);
		final ForkJoinSum forkJoinSum = new ForkJoinSum(numbers);
		System.out.println("Sum: " + pool2.invoke(forkJoinSum));
	}
}

package com.epam.multithread.simple.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ForkJoinMinimum extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	private static final int SEQUENTIAL_TRESHOLD = 5;
	private List<Integer> numbers = new ArrayList<Integer>();

	private final int start;
	private final int end;

	public ForkJoinMinimum(List<Integer> numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	public ForkJoinMinimum(List<Integer> numbers) {
		this(numbers, 0, numbers.size() - 1);
	}

	@Override
	protected Integer compute() {
		final int length = end - start;
		if (length < SEQUENTIAL_TRESHOLD) {
			return computeDirectly();
		}
		final int split = length / 2;
		final ForkJoinMinimum left = new ForkJoinMinimum(numbers, start, start
				+ split);
		left.fork();
		final ForkJoinMinimum right = new ForkJoinMinimum(numbers, start
				+ split + 1, end);
		return Math.min(right.compute(), left.join());
	}

	private Integer computeDirectly() {
		int min = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			if (numbers.get(i) < min) {
				min = numbers.get(i);
			}
		}
		//System.out.println("Computing from start: " + start + " to end: " + end
		//		+ " min: " + min);
		return min;
	}

}

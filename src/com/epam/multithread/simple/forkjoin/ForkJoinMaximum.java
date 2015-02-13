package com.epam.multithread.simple.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ForkJoinMaximum extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	private static final int SEQUENTIAL_TRESHOLD = 5;
	private List<Integer> numbers = new ArrayList<Integer>();

	private final int start;
	private final int end;

	public ForkJoinMaximum(List<Integer> numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	public ForkJoinMaximum(List<Integer> numbers) {
		this(numbers, 0, numbers.size() - 1);
	}

	@Override
	protected Integer compute() {
		final int length = end - start;
		if (length < SEQUENTIAL_TRESHOLD) {
			return computeDirectly();
		}
		final int split = length / 2;
		final ForkJoinMaximum left = new ForkJoinMaximum(numbers, start, start
				+ split);
		left.fork();
		final ForkJoinMaximum right = new ForkJoinMaximum(numbers, start
				+ split + 1, end);
		return Math.max(right.compute(), left.join());
	}

	private Integer computeDirectly() {
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			if (numbers.get(i) > max) {
				max = numbers.get(i);
			}
		}
		/*System.out.println("Computing from start: " + start + " to end: " + end
				+ " max: " + max);*/
		return max;
	}

}

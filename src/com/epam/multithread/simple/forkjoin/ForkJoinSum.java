package com.epam.multithread.simple.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSum extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	private static final int SEQUENTIAL_TRESHOLD = 5;
	private List<Integer> numbers = new ArrayList<Integer>();

	private final int start;
	private final int end;

	public ForkJoinSum(List<Integer> numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	public ForkJoinSum(List<Integer> numbers) {
		this(numbers, 0, numbers.size() - 1);
	}

	@Override
	protected Integer compute() {
		final int length = end - start;
		if (length < SEQUENTIAL_TRESHOLD) {
			return computeDirectly();
		}
		final int split = length / 2;
		final ForkJoinSum left = new ForkJoinSum(numbers, start, start + split);
		left.fork();
		final ForkJoinSum right = new ForkJoinSum(numbers, start + split + 1,
				end);
		return (right.compute() + left.join());
	}

	private Integer computeDirectly() {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += numbers.get(i);
		}
		//System.out.println("Computing from start: " + start + " to end: " + end
		//		+ " sum: " + sum);
		return sum;
	}

}

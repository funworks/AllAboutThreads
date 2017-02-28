package com.threads.queue.array;

import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQConsumer implements Runnable {
	
	private BlockingQueue<Object> queue;

	public ArrayBlockingQConsumer(BlockingQueue<Object> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.printf("[%s] - Take object = %s%n", Thread.currentThread().getName(), queue.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

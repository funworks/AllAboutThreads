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
			for (int i = 0; i < 10; i++) {
				int value = (int) queue.take();
				System.out.printf("[%s] - Pull object = %s, Remaining Capacity = %s%n", 
						Thread.currentThread().getName(), value, queue.remainingCapacity());
				Thread.sleep(700);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
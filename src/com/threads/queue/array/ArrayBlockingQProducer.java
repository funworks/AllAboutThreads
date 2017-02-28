package com.threads.queue.array;

import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQProducer implements Runnable {

	private BlockingQueue<Object> queue;

	public ArrayBlockingQProducer(BlockingQueue<Object> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i=0;i < 10; i++) {
				queue.put(i);
				System.out.printf("[%s] - Push object = %s, Remaining Capacity = %s%n", 
						Thread.currentThread().getName(), i, queue.remainingCapacity());
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
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
			for (int i=1;i <= 10; i++) {
				System.out.printf("[%s] - Put object = %s%n", Thread.currentThread().getName(), i);
				queue.put(i);
				Thread.sleep(300);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
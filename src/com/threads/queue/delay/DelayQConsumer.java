package com.threads.queue.delay;

import java.util.concurrent.BlockingQueue;

public class DelayQConsumer implements Runnable {
	
	private BlockingQueue<DelayElement> queue;
	
	public DelayQConsumer(BlockingQueue<DelayElement> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i=1;i <= 5; i++) {
				DelayElement delayElement = queue.take();
				System.out.printf("[%s] - Take object = %s%n", Thread.currentThread().getName() + i, delayElement);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

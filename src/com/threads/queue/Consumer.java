package com.threads.queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	
	private BlockingQueue<Object> queue;

	public Consumer(BlockingQueue<Object> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println(queue.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

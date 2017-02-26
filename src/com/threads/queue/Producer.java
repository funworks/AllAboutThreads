package com.threads.queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Object> queue;

	public Producer(BlockingQueue<Object> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		try {
			for (int i=1;i <= 10; i++) {
				queue.put(i);
				Thread.sleep(400);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

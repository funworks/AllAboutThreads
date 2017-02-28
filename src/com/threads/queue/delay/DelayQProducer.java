package com.threads.queue.delay;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class DelayQProducer implements Runnable {
	
	private BlockingQueue<DelayElement> queue;
	
	private final Random random = new Random();
	
	public DelayQProducer(BlockingQueue<DelayElement> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i=1;i <= 5; i++) {
				DelayElement delayElement = new DelayElement(UUID.randomUUID().toString(), random.nextInt(20000));
				System.out.printf("[%s] - Put object = %s%n", Thread.currentThread().getName() + i, delayElement);
				queue.put(delayElement);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
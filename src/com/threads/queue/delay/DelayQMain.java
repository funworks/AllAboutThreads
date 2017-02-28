package com.threads.queue.delay;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQMain {

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		BlockingQueue<DelayElement> queue = new DelayQueue<DelayElement>();
		
		Thread consumerThread = new Thread(new DelayQConsumer(queue), "Consumer Thread ");
		Thread producerThread = new Thread(new DelayQProducer(queue), "Producer Thread ");
		
		consumerThread.start();
		producerThread.start();
		
		consumerThread.join();
		producerThread.join();
		
		System.out.println("Time taken in milliseconds: " + (System.currentTimeMillis() - startTime));
	}
}

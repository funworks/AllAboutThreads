package com.threads.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQ {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Object> bq = new ArrayBlockingQueue<Object>(10);
		
		Producer producer = new Producer(bq);
		Consumer consumer = new Consumer(bq);
		
		new Thread(producer).start();
		new Thread(consumer).start();
		
		Thread.sleep(5000);
		
	}

}

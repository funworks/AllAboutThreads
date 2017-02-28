package com.threads.queue.array;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQMain {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(10);
		
		ArrayBlockingQProducer producer = new ArrayBlockingQProducer(queue);
		ArrayBlockingQConsumer consumer = new ArrayBlockingQConsumer(queue);
		
		new Thread(producer, "Producer Thread").start();
		new Thread(consumer, "Consumer Thread").start();
		
	}
}

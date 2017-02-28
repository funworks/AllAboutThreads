package com.threads.queue.array;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @see <a href="https://double-quotes.blogspot.in/2017/02/java-concurrency-utilities-blockingqueue.html">https://double-quotes.blogspot.in/2017/02/java-concurrency-utilities-blockingqueue.html</a>
 *
 */
public class ArrayBlockingQMain {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(3);
		System.out.println("Created ArrayBlockingQueue of size = " + queue.remainingCapacity());
		
		ArrayBlockingQProducer producer = new ArrayBlockingQProducer(queue);
		ArrayBlockingQConsumer consumer = new ArrayBlockingQConsumer(queue);
		
		new Thread(producer, "Producer Thread").start();
		new Thread(consumer, "Consumer Thread").start();
		
	}
}
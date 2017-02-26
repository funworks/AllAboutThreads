package com.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @see <a href="https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html">https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html</a>
 *
 */
public class ScheduledThreadPool {

	public static void main(String[] args) {
		ExecutorService scheduledThreadPoolService = Executors.newScheduledThreadPool(5);
		
		for (int i = 1; i <= 10; i++) {
			scheduledThreadPoolService.submit(new Runner(i));
		}

		scheduledThreadPoolService.shutdown();
	}

}

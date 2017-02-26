package com.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @see <a href="https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html">https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html</a>
 *
 */
public class SingleThreadScheduledPool {

	public static void main(String[] args) {
		ExecutorService singleThreadScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		
		for (int i = 1; i <= 10; i++) {
			singleThreadScheduledExecutorService.submit(new Runner(i));
		}

		singleThreadScheduledExecutorService.shutdown();
	}

}

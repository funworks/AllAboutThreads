package com.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @see <a href="https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html">https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html</a>
 *
 */
public class SingleThreadPool {
	
	public static void main(String[] args) {
		ExecutorService singleThreadService = Executors.newSingleThreadExecutor();
		
		for (int i = 1; i <= 10; i++) {
			singleThreadService.submit(new Runner(i));
		}

		singleThreadService.shutdown();
	}

}

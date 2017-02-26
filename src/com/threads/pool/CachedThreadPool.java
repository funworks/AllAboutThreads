package com.threads.pool;

/**
 * @see <a href="https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html">https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html</a>
 *
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

	public static void main(String[] args) {
		
		ExecutorService cachedThreadPoolService = Executors.newCachedThreadPool();
		
		for (int i=1; i<=10; i++) {
			cachedThreadPoolService.submit(new Runner(i));
		}
		
		cachedThreadPoolService.shutdown();
	}
}

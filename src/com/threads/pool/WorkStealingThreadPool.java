package com.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @see <a href="https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html">https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html</a>
 *
 */
public class WorkStealingThreadPool {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService workStealingPoolService = Executors.newWorkStealingPool();
		
		for (int i = 1; i <= 10; i++) {
			workStealingPoolService.submit(new Runner(i));
		}

		workStealingPoolService.shutdown();
		workStealingPoolService.awaitTermination(1, TimeUnit.HOURS);
	}

}

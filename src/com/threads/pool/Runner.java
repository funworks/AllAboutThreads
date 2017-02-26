package com.threads.pool;

/**
 * @see <a href="https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html">https://double-quotes.blogspot.in/2017/02/thread-pools-with-executorservice.html</a>
 *
 */
public class Runner implements Runnable {
	
	private int id;
	
	public Runner(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		try {
			System.out.println("Starting Runner " + this.id);
			Thread.sleep(1000);
			System.out.println("Completing Runner " + this.id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


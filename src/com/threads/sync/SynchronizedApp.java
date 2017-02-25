package com.threads.sync;

/**
 * @see <a href="https://double-quotes.blogspot.in/2017/02/simplified-synchronized.html">https://double-quotes.blogspot.in/2017/02/simplified-synchronized.html</a>
 *
 */
public class SynchronizedApp {
	
	private static int number = 0;
	
	private synchronized void increaseNumber() {
		number++;
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedApp sa = new SynchronizedApp();
		sa.action();
	}

	private void action() throws InterruptedException {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i=1; i<=1000; i++) {
					increaseNumber();
					//number++;
				}
			}
		};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(number);
	}

}

package com.threads.sync;

/**
 * @see <a href="https://double-quotes.blogspot.in/2017/02/simplified-synchronized.html">https://double-quotes.blogspot.in/2017/02/simplified-synchronized.html</a>
 *
 */
public class UnsynchronizedApp {
	
	private static int number = 0;
	
	public static void main(String[] args) throws InterruptedException {
		UnsynchronizedApp usa = new UnsynchronizedApp();
		usa.action();
	}

	private void action() throws InterruptedException {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i=1; i<=1000; i++) {
					number++;
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
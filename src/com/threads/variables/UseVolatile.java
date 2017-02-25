package com.threads.variables;

class Worker extends Thread {
	
	private volatile boolean shouldRun = true;
	
	@Override
	public void run() {
		super.run();
		int count = 0;
		while(shouldRun) {
			System.out.println("Running... " + ++count);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopRunning() {
		shouldRun = false;
	}
}

/**
 * @see <a href="https://double-quotes.blogspot.in/2017/02/volatile-variables.html">https://double-quotes.blogspot.in/2017/02/volatile-variables.html</a>
 */
public class UseVolatile {

	public static void main(String[] args) throws InterruptedException {
		Worker w = new Worker();
		w.start();
		
		Thread.sleep(500);
		w.stopRunning();
	}
}

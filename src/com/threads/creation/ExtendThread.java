package com.threads.creation;

public class ExtendThread extends Thread {

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		super.run();
		for (int i=1; i<=10; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

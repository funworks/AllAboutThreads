package com.threads.creation;

/**
 * This app creates worker threads using anonymous implementation of Runnable
 */
public class AnonymousRunnableMain {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for (int i=1; i<=10; i++) {
					System.out.println(Thread.currentThread().getName() + " - " + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread thread1 = new Thread(runnable);
		thread1.setName("AnonymousRunnable 1");
		thread1.start();
		
		Thread thread2 = new Thread(runnable);
		thread2.setName("AnonymousRunnable 2");
		thread2.start();
		
		Thread thread3 = new Thread(runnable);
		thread3.setName("AnonymousRunnable 3");
		thread3.start();
		
		Thread thread4 = new Thread(runnable);
		thread4.setName("AnonymousRunnable 4");
		thread4.start();
	}

}

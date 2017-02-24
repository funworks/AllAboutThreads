package com.threads.creation;

/**
 * This app creates worker threads (runners) using ImplementRunnable class that implements Runnable interface
 */
public class ImplementRunnableMain {
	
	public static void main(String[] args) {
		Thread runner1 = new Thread(new ImplementRunnable());
		runner1.setName("ImplementRunnable 1");
		runner1.start();
		
		Thread runner2 = new Thread(new ImplementRunnable());
		runner2.setName("ImplementRunnable 2");
		runner2.start();
		
		Thread runner3 = new Thread(new ImplementRunnable());
		runner3.setName("ImplementRunnable 3");
		runner3.start();
		
		Thread runner4 = new Thread(new ImplementRunnable());
		runner4.setName("ImplementRunnable 4");
		runner4.start();
	}

}

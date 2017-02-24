package com.threads.runners;

/**
 * This app creates worker threads (runners) using Runner class that implements Runnable interface
 */
public class App {
	
	public static void main(String[] args) {
		Thread runner1 = new Thread(new Runner());
		runner1.setName("Runner 1");
		runner1.start();
		
		Thread runner2 = new Thread(new Runner());
		runner2.setName("Runner 2");
		runner2.start();
		
		Thread runner3 = new Thread(new Runner());
		runner3.setName("Runner 3");
		runner3.start();
		
		Thread runner4 = new Thread(new Runner());
		runner4.setName("Runner 4");
		runner4.start();
	}

}

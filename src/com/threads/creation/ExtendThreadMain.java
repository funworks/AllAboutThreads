package com.threads.creation;

/**
 * This app creates worker threads (tasks) using ExtendThread class that extends Thread class
 */
public class ExtendThreadMain {

	public static void main(String[] args) {
		ExtendThread task1 = new ExtendThread();
		task1.setName("ExtendThread 1");
		task1.start();
		
		
		ExtendThread task2 = new ExtendThread();
		task2.setName("ExtendThread 2");
		task2.start();
		
		ExtendThread task3 = new ExtendThread();
		task3.setName("ExtendThread 3");
		task3.start();
		
		ExtendThread task4 = new ExtendThread();
		task4.setName("ExtendThread 4");
		task4.start();
	}

}

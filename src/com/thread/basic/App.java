/**
 * 
 */
package com.thread.basic;

class Task extends Thread {

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		super.run();
		for (int i=0; i<10; i++) {
			System.out.println(this.getName() + " - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * This app creates worker threads (tasks) using Task class that extends Thread class
 */
public class App {

	public static void main(String[] args) {
		Task task1 = new Task();
		task1.setName("Task 1");
		task1.start();
		
		
		Task task2 = new Task();
		task2.setName("Task 2");
		task2.start();
		
		Task task3 = new Task();
		task3.setName("Task 3");
		task3.start();
		
		Task task4 = new Task();
		task4.setName("Task 4");
		task4.start();
	}

}

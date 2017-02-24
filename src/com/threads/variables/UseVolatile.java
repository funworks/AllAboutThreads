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
				Thread.sleep(250);
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
 * Volatile is a keyword that is used to mark a variable volatile. If a variable is declared as volatile, then it is fair to expect that multiple threads will operate on it and modify its value. JRE has a small memory that it uses to cache values of variables so that it does not have to go check the value of that variable from the main memory every time that variable is accessed. This indeed improves performance but reduces the certainty that the value of the variable is correct when read in a multithreaded environment.

 * The variable shouldRun is set to true first and because of this, the worker thread keeps running until the value of shouldRun is set to false by main thread. If this variable is not declared volatile, then JRE might cache its value as true and the worker thread may keep running forever because the main thread changes its value to false but the worker thread may not read it from the main memory and may keep reading it from the local cache. To overcome this problem, this variable should be declared volatile so as to tell the JRE, not to cache its value.
 */
public class UseVolatile {

	public static void main(String[] args) throws InterruptedException {
		Worker w = new Worker();
		w.start();
		
		Thread.sleep(500);
		w.stopRunning();
	}

}

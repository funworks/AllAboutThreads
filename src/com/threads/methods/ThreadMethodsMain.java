package com.threads.methods;

public class ThreadMethodsMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.printf("[%s] : Starting this thread%n", Thread.currentThread().getName());
		BankAccount account = new BankAccount();
		Thread withdraw = new Thread("Withdraw") {
			public void run() {
				System.out.printf("[%s] : Starting this thread%n", Thread.currentThread().getName());
				try {
					account.withdraw(15000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("[%s] : Exiting this thread%n", Thread.currentThread().getName());
			};
		};
		
		Thread deposit = new Thread("Deposit") {
			public void run() {
				System.out.printf("[%s] : Starting this thread%n", Thread.currentThread().getName());
				account.deposit(20000);
				System.out.printf("[%s] : Exiting this thread%n", Thread.currentThread().getName());
			};
		};
		
		withdraw.start();
		deposit.start();
		
		withdraw.join();
		deposit.join();
		
		System.out.printf("[%s] : Exiting this thread%n", Thread.currentThread().getName());
	}
}

class BankAccount {
	private int balance;
	
	public synchronized void withdraw(int amount) throws InterruptedException {
		System.out.printf("[%s] : Sleeping for 5 seconds%n", Thread.currentThread().getName());
		Thread.sleep(5000);
		System.out.printf("[%s] : Woke up after sleeping for 5 seconds%n", Thread.currentThread().getName());
		
		if (balance < amount) {
			System.out.printf("[%s] : Insufficient balance, waiting for deposit%n", Thread.currentThread().getName());
			wait();
		}
		System.out.printf("[%s] : Notify event received%n", Thread.currentThread().getName());
		balance -= amount;
		System.out.printf("[%s] : Amount withdrawn %s, new balance is %s%n", Thread.currentThread().getName(), amount, balance);
	}
	
	public synchronized void deposit(int amount) {
		balance += amount;
		System.out.printf("[%s] : Amount deposited %s, new balance is %s%n", Thread.currentThread().getName(), amount, balance);
		System.out.printf("[%s] : Notifying other waiting threads%n", Thread.currentThread().getName());
		notify();
	}
}
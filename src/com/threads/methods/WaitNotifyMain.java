package com.threads.methods;

public class WaitNotifyMain {

	public static void main(String[] args) throws InterruptedException {
		BankAccount account = new BankAccount();
		new Thread("---") {
			public void run() {
				try {
					account.withdraw(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		new Thread("+++") {
			public void run() {
				account.deposit(20000);
			};
		}.start();
	}
}

class BankAccount {
	private int balance;
	
	public synchronized void withdraw(int amount) throws InterruptedException {
		if (balance < amount) {
			System.out.println("[" + Thread.currentThread().getName() + "] : Insufficient balance, waiting for deposit");
			wait();
		}
		balance -= amount;
		System.out.printf("[%s] : Amount withdrawn %s, new balance is %s%n", Thread.currentThread().getName(), amount, balance);
	}
	
	public synchronized void deposit(int amount) {
		balance += amount;
		System.out.printf("[%s] : Amount deposited %s, new balance is %s%n", Thread.currentThread().getName(), amount, balance);
		notify();
	}
}

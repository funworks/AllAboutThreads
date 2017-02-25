package com.threads.variables;

/**
 * This code is not written by me. Credit goes to the owner
 * of this page - https://dzone.com/articles/java-volatile-keyword-0
 * 
 * I have changed a few lines to make it work in my environment.
 * 
 * This program generates different outputs depending on whether MY_INT is 
 * declared volatile or not.
 *
 */
public class VolatileTest {
    
	private volatile static int MY_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while ( local_value < 5){
                if( local_value!= MY_INT){
                    System.out.println("Got Change for MY_INT : " + MY_INT);
                     local_value= MY_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {

            int local_value = MY_INT;
            while (MY_INT <5){
                System.out.println("Incrementing MY_INT to " + (local_value+1));
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}
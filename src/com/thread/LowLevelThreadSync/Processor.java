package com.thread.LowLevelThreadSync;

import java.util.Scanner;

public class Processor {
	public void producer() throws InterruptedException{
		synchronized(this){
			System.out.println("producer thread running........");
			/**
			 * every object has wait method as it is in Object class
			 * wait does is that thread waits but not exit and it consumes very less resources 
			 * and it can only be called in synchronized blocks.
			 * it hands over control of synchronised block or lock so other threads can use it
			 * 
			 * and this thread will not resume until some other thread call notify on the same lock Object
			 * 
			 */
			wait();
			System.out.println("Resumed producer");
		}
	}
	public void consumer() throws InterruptedException{
		
			Scanner sc=new Scanner(System.in);
			Thread.sleep(2000);
		
			synchronized (this) {
				System.out.println("waiting for next line .....");
				sc.nextLine();
				System.out.println("return key pressed");
				/**
				 * It will notify other thread that it can now take control of lock
				 * but it donot give away lock immediatly first it will complete its cycle and then release the lock
				 */
				notify();
				System.out.println("consumer Thread stopeed");
				
			}
	}
}

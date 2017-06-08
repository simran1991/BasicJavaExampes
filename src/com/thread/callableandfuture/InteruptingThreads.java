package com.thread.callableandfuture;

import java.util.Random;

/**
 * 
 * we looked at how to stop a thread gracefully using volatile boolean flag in second tutorial
 * thread pool has method cancel that can cancel threads before even run
 * 
 * 
 * wait and sleep also picks up interupted exception and we can also use those to interupt a thread
 * @author Simranjit.Singh
 *
 */
public class InteruptingThreads {
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Starting.....");
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				Random ran=new Random();
				
				/**
				 * now a for loop for simulating time consuming work 1*10^6
				 */
				for(int i=0;i<1E8;i++){
					if(Thread.currentThread().isInterrupted()){
						/** to check if this thread has been 
						 * interrupted ie interrupt method called on this thread
						 */
						System.out.println("interupted !!");
						break;
					};
					
					Math.sin(ran.nextDouble());
				}
			}
		});
		t1.start();
		
		/**
		 * after start we sleep for few seconds and call thread.interupt
		 */
		Thread.sleep(2000);
		/**
		 * even calling interupt not stops the thread ,
		 * it actually sets flag on this thread that i is being interupted
		 * 
		 * to check if this thread has been interrupted ie interrupt method called on this thread
		 */
		t1.interrupt();
				
		t1.join();
		
		System.out.println("Finished...");
	}
}

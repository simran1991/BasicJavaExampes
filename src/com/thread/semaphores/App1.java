package com.thread.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * here we try to limit number of connection to resource in multi threaded environment
 * 
 * @author Simranjit.Singh
 *
 */
public class App1 {
	public static void main(String[] args) throws InterruptedException {
		
		
		/**
		 * creating 200 threads
		 */
				
		ExecutorService exec=Executors.newCachedThreadPool();
		
		for(int i=0;i<200;i++){
			exec.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Connection.getInstance().connect();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
					}
			});
		
		}
		
		/**
		 * shut down after all threads are finished
		 */
		exec.shutdown();
		
		
		exec.awaitTermination(1, TimeUnit.DAYS);
	}
}

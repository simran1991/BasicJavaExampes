package com.threads.ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * examples for thread pools are way of managing lot of
 * 
 *  threads at same time to create threadpool we use executer service to create threadpool
 * 
 * There is lot of overhead to start new threads so we should reuse threads.
 * @author simranjit.singh
 *
 */
 public class App {
	 public static void main(String[] args) {
		 /**
		  * creating 2 thread thread pool at a gven time ,to allow task to these thread we use submit
		  */
		ExecutorService exec=Executors.newFixedThreadPool(2);
	
		/**
		 * providing 5 tasks to these threads
		 */
		for(int i=0;i<5;i++){
			exec.submit(new Processor(i));
		}
		//now exec to stop accepting new tasks.it waits until all threads stop
		exec.shutdown();
		/**
		 * now these taks run on separate thread
		 */
		System.out.println("All tasks submitted");
		
		/**
		 * wait for 1 day before it blocks until all submitted tasks complete if a shutdown requests occus
		 */
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed");
	 }
 }
 
 class Processor implements Runnable{
	 private int id;
	 
	 public Processor(int id) {
		// TODO Auto-generated constructor stub
		 this.id=id;
	 }
	 
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("starting....."+id);
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("ending..... "+id);
		}
	
}


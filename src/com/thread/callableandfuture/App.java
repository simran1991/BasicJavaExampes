package com.thread.callableandfuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * we will lokk in callable and future these are two classes using which 
 * we can get a return values from threads.
 * 
 * allow thread code to throw exceptions
 * 
 * @author Simranjit.Singh
 *
 *
 */
public class App {
	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
		
		/*exec.submit(new Runnable() {
			*//**
			 *  *How can we get return result from code if i want one
			 *  
			 *  we can have a separate class implementing runnable 
			 *  and in an instance we can store a result and access at end of the code 
			 *  there is another way of doing that elegent way using futute and callabel
			 *  
			 *//*
			@Override
			public void run() {
				Random random=new Random();
				int duration=random.nextInt(4000);
				System.out.println("starting.....");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("finished");
			}
		});*/
		
		/**
		 * using callable it takes paramater of type
		 *  which you want to return from this thread
		 *	and it has call method instead of run
		 *call returns a value of mentioned type
		 *
		 * It can also be used for throwing exeptions from this thread
		 * 
		 * and now when we call submit here it will
		 * return a future object of type integer 
		 * 
		 * if we want to use future methods but dont want to get return value
		 *  then we can use future like this Future<?> future. wild card and for callable 
		 *  callable<Void> void with capitol "V"
		 *  then it will not return value and start
		 *  behaving like any other thread
		 *  and return null;
		 */
		Future<Integer> future=	exec.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Random random=new Random();
				int duration=random.nextInt(4000);
				
				/**
				 * when an exception is thrown by call method like 
				 * here it is caught in execution exception in future.get
				 */
				if(duration >2000){
					throw new IOException("too long sleep");
				}
				
				System.out.println("starting.....");
				
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("finished");
				//return duration for which thread is sleeping
				return duration;
			}
		});
		
		
		exec.shutdown();
		
		
		/**
		 * future.get method throws two types of exception
		 * interupted excepiton and execution exception
		 * 
		 * future.get also blocks 
		 * the main thread until the thread finishes so no need here to call exec.await 
		 * to wait for thread to finish its work
		 */
		try {
			System.out.println("result is "+future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}

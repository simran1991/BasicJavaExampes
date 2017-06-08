package com.thread.ReentrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * using re-entrant lock
 * 
 * @author Simranjit.Singh
 *
 */
public class Runner {

	private int count = 0;
	/**
	 * once a thread acquires a lock on lock object it
	 */
	private Lock lock = new ReentrantLock();
	
	/**
	 * condition is used in same way as
	 */
	private Condition condition=lock.newCondition();

	/**
	 * await and signal similar to wait and notify are part of condition class and we get condition 
	 * on the lock
	 * we can only call signal and await afet you get lock 
	 */
			
	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		/**
		 * this is not good way for implementing re-entrant lock
		 * beacuase if increment throws the exception then unlock will not occur and cause program to halt
		 */
		/*lock.lock();
		increment();
		lock.unlock();*/
		
		
		
		
		//good way
		lock.lock();
		
		//await ie handing over the lock
		condition.await();
		
		try{
			increment();
		}finally{
			lock.unlock();
		}
		
	}

	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		
		System.out.println("waiting press the return key");	
		new Scanner(System.in).nextLine();
		System.out.println("got key");
		
		//even after calling signal we have to unlock the lock
		condition.signal();
		
		try{
			increment();
			
		}finally{
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("count is :" + count);
	}

}

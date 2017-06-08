package com.thread.dedlockexample;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private Account acc1=new Account();
	private Account acc2=new Account();
	/**
	 * one method is to use syncronized blocks but we will use re entrant locks
	 */
	private Lock lock1=new ReentrantLock();
	private Lock lock2=new ReentrantLock();

	/**
	 * method to acquire locks in a way so that dedlock not occurs
	 * 
	 * we use try lock,it is method of re-entrant lock it returns true if it acquired lock and false if not
	 * 
	 * @param lock1
	 * @param lock2
	 * @throws InterruptedException 
	 */
	private void acquirelocks(Lock lock1,Lock lock2) throws InterruptedException {
		while(true){
			//Acquire locks
			boolean gotFirstlock=false;
			boolean gotSecondLock=false;
			
			try{
				gotFirstlock=lock1.tryLock();
				gotSecondLock=lock2.tryLock();
			}
			finally{
				if(gotFirstlock && gotSecondLock){
					return;
				}
				if(gotFirstlock){
					lock1.unlock();
				}
				if(gotSecondLock){
					lock2.unlock();
				}
			}
			//Locks not Acquire,if no lockc acquire then we will sleep 
			//the thread for some amount of time so that it can acquire lock
			Thread.sleep(10);
		}
	}
	
	public void firstThread() throws InterruptedException {
		Random random=new Random();
		
		
		
		for (int i = 0; i < 1000; i++) {
			// before transfer we want to get lock on both account
			
			/*
			 *both threads need to acquire lock in same order otherwise can have deadlock situations
			 *it can occur with both nested syncronised blocks and re entrant lock
			 *
			 * one solution is to lock all locks in same order
			 * 
			 */
			//lock1.lock();
			//lock2.lock();
			
			/**
			 * to avoid deadlocks using try lock
			 */
			acquirelocks(lock1, lock2);
			try {
				Account.transfer(acc1, acc2, random.nextInt(100));
			} finally {
				
				lock1.unlock();
				lock2.unlock();
			}

		}
		
	}

	public void secondThread() throws InterruptedException {
		Random random=new Random();
		for (int i=0;i<1000;i++){
			// before transfer we want to get lock on both account
			
			//lock2.lock();lock acuired not in same order as thread first so it causes dead lock 
			//lock1.lock();
			//lock2.lock();
			
			/**
			 * to avoid deadlocks using try lock
			 */
			acquirelocks(lock1, lock2);
			try {
				Account.transfer(acc2, acc1, random.nextInt(100));
			} finally {

				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void finished() {
		System.out.println("Account 1 balance: "+acc1.getBalance());
		System.out.println("Account 2 balance: "+acc2.getBalance());
		System.out.println("Total balance "+(acc1.getBalance()+acc2.getBalance()));
	}


}

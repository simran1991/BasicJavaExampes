package com.thread.semaphores;

import java.util.concurrent.Semaphore;

public class App {
public static void main(String[] args) throws InterruptedException {
	/**
	 * semaphore objects maintains a count,we call it number of available permits
	 */
	Semaphore sem=new Semaphore(5);
	
	/**
	 *acquire decrements the number of permits and it waits until a permits becomes avaialable. 
	 *
	 *release and acquire of permit with semaphore size one will be like lock and unlock functionality
	 *acquiring a lock and releasing a lock.
	 *
	 *we can release a semaphore from different threads
	 * and different threads can release a semaphore .
	 * for release a lock we need same thread to release the 
	 * lock which aquired a lock but in semaphore other thread can release a lock on any other thread
	 * 
	 *semaphores are commonly used for is to control access to resource.
	 */
	sem.acquire();
	/**
	 * release increments count of available permits
	 */
	sem.release();
	
	
}
}

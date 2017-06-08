package com.thread.semaphores;

import java.util.concurrent.Semaphore;

/**
 * here we try to limit number of connection to resource in multi threaded
 * environment
 * 
 * @author Simranjit.Singh
 *
 */
public class Connection {
	private static Connection instance = new Connection();

	private int connections = 0;
	/**
	 * limiting number of connections at given time using semaphore
	 * 
	 * semaphore has a faireness parameter and if set set to true then whichever thread 
	 * called the acquire first will be the first one to get the permit when permit 
	 * becomes avaiable to stop thread starvation problem
	 */
	private Semaphore sem = new Semaphore(10,true);

	/**
	 * private constructor for singleton
	 */
	private Connection() {

	}

	public static Connection getInstance() {
		return instance;
	}

	public void doConnect() {
		synchronized (this) {
			connections++;
			System.out.println("current connections :" + connections);
		}

		/**
		 * when we access connect method we decrement number of connections
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (this) {
			connections--;
		}
	}

	public void connect() throws InterruptedException {

		sem.acquire();

		try {
			doConnect();
		} finally {
			sem.release();
		}

	}
}

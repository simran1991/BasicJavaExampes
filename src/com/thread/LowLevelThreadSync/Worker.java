package com.thread.LowLevelThreadSync;

import java.util.LinkedList;
import java.util.Random;

public class Worker {
	private static final int LIMIT = 10;
	private LinkedList<Integer> dataHouse = new LinkedList<Integer>();
	private Object lock = new Object();

	
	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (lock) {
				while(dataHouse.size()==LIMIT){
					lock.wait();
					System.out.println("waiting list is full");
				}
				dataHouse.add(value++);
				lock.notify();
			}

		}
	}

	
	public void consumer() throws InterruptedException {
		Random random=new Random();
		while (true) {
			synchronized (lock) {
				while(dataHouse.size()==0){
					lock.wait();
				    System.out.println("waiting for data house");
				}
				System.out.println("List Size is : " + dataHouse.size());
				int value = dataHouse.removeFirst();
				System.out.println("removed value is " + value);
				lock.notify();
			}
			Thread.sleep(1000);
		}
	}
}

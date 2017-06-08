package com.thread.producerConsumer;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
	
	/**
	 * we use blocking queue because this interface is thread size 
	 * we can add item and remove item in FIFO order
	 */
			
	private static BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(10);
	private static volatile  boolean shutdown=true;

	
	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
	/*try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Scanner sc=new Scanner(System.in);
		sc.nextLine();
		
		shutDownThread();
		System.out.println("Threads in shutdown mode");
	}
	
	private static void shutDownThread() {
		shutdown=false;
	}

	/**
	 * one or more threads are producing things and add to queue
	 * @throws InterruptedException 
	 */
	private static void producer() throws InterruptedException{
		Random random=new Random();
		while(shutdown){
			int x=random.nextInt(100);
			queue.put(x);
			System.out.println("put value" +x);
		}
		System.out.println("producer stopped");

	}
	
	/**
	 * It will take items out of queue every once in a while so we use thread ,sleep 
	 * @throws InterruptedException 
	 */
	private static void consumer() throws InterruptedException{
		Random random=new Random();
		while(shutdown){
			Thread.sleep(100);
			if(random.nextInt(10)==0){
				Integer value=queue.take();
				
				System.out.println("Taken value :"+value+" queue size is"+queue.size());
			}
		}
		System.out.println("consumer stopped");
	}
}

package com.threads.MultipleLocksExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.StreamHandler;

/**
 * using multiple locks and synchronised code blocks
 * @author simranjit.singh
 *
 */
public class Worker {
	/**
	 * creating lock objects to create synchronied code blocks
	 */
	
	private Object lock1=new Object();
	private Object lock2=new Object();
	
	private Random random=new Random();
	
	/**
	 * trying to obtaing lock on list can cause complex situations
	 */
	private List<Integer> list1=new  ArrayList<Integer>();
	private List<Integer> list2=new  ArrayList<Integer>();
	
	
	/**
	 * Stage 1 of large process with lock objects
	 */
		public  void stage1(){
			//we are doing sleep to simulate that thread go to db toget data and 
			//it takes some time before adding that random data to list1
			synchronized (lock1) {
				try {
					Thread.sleep(1);
					} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				list1.add(random.nextInt());
			}
		}
		/**
		 * Stage 2 of large process with lock objects
		 */
		public void stage2(){
			//we are doing sleep to simulate that thread go to db toget data and 
			//it takes some time before adding that random data to list1
			synchronized (lock2) {
				try {
					Thread.sleep(1);
					} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				list2.add(random.nextInt());
			}
			
		}

			/**
 * Stage 1 of large process synchronised example
 *//*
	public synchronized void stage1(){
		//we are doing sleep to simulate that thread go to db toget data and 
		//it takes some time before adding that random data to list1
		try {
			Thread.sleep(1);
			} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		list1.add(random.nextInt());
	}
	*//**
	 * Stage 2 of large process with synchronised
	 *//*
	public synchronized void stage2(){
		//we are doing sleep to simulate that thread go to db toget data and 
		//it takes some time before adding that random data to list1
		try {
			Thread.sleep(1);
			} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		list2.add(random.nextInt());
	}*/
	/**
	 * lets say It does all processing
	 */
	public void process(){
		for(int i=0;i<1000;i++){
			stage1();
			stage2();
		}
	
	
	}
	
	 public  void main() {
		System.out.println("starting...");
	
		long start=System.currentTimeMillis();
		
		//calling process in separate thread
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//running 2 threads at same times gives unexpected results
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end=System.currentTimeMillis();
		
		System.out.println("Time take to process"+(end-start));
		
		System.out.println("List1 :"+ list1.size()+"   list2:  "+list2.size());
	 }
}

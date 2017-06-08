package com.threads.examples;

import java.util.Scanner;
/**
 * Threads caching variables example 
 * 
 * @author simranjit.singh
 *
 */
class Processor extends Thread{
	/**
	 * Thread caching
	 * we have two threads main and p1 changing shutdown and p1 has its copy of shutdown so it may always not stop
	 * in theory on some system it ca cache and never stop that is why we use volatile keyword so that 
	 *
	  It is used to prevent thread caching variables when they are not changed from within that thread.
	  when we want to update variable from other thread we can use thread.
	  or we can use synchronised keyword to do this
	 */
	
	//private boolean shutdown=false;
	private volatile boolean shutdown=false;
	public void run(){
		while(!shutdown){
			System.out.println("hell");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//gracefully shut down thread 
	public void shutdownTHread(){
		shutdown=true;
	}
}
public class ThreadCahingVariables3 {
public static void main(String[] args) {
	Processor p1=new Processor();
	p1.start();
	
	Scanner sc=new Scanner(System.in);
	sc.nextLine();
	p1.shutdownTHread();
}
}

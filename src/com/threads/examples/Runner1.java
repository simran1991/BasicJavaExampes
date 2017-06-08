package com.threads.examples;
/**
 * Thread using Thread class
 * @author simranjit.singh
 *
 */
public class Runner1 extends Thread {

	public static int count=0;
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			count++;
			System.out.println("count value "+count);
			
		}
		
	}
	
	
	
}

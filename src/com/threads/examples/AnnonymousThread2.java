package com.threads.examples;
/**
 * Creating annonymous threads
 * @author simranjit.singh
 *
 */
public class AnnonymousThread2 {
	private static int count=0;
	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {
			public void run() {
				System.out.println("hello");
			for(int i=0;i<100;i++){
				System.out.println("coutn val"+ ++count);
				}
			}
		});
		t1.start();
	}
	
}

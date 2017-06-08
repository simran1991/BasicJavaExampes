package com.thread.countDownLatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * It is thread safe class ie count down latch ,It lets you to count down to number specifies,
 * it lets one or more threads wait until latch reaches to 0z.
 * 
 * 
 * @author simranjit.singh
 *
 */
public class App {
	public static void main(String[] args) {
		CountDownLatch latch=new CountDownLatch(3);
		ExecutorService executer=Executors.newFixedThreadPool(3);
		for(int i=0;i<5;i++){
			executer.submit(new Processor(latch));
		}
	try {
		latch.await();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Completed");
	}
}
class Processor implements  Runnable {
	private CountDownLatch latch;
	public Processor(CountDownLatch latch) {
		this.latch=latch;
	}
	public void run() {
		System.out.println("Started.....");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	}
}
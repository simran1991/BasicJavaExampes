package com.threads.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Thread using runnable interface
 * @author simranjit.singh
 *
 */
class RunTest implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("using Runnable interface");
	}
	
}
/**
 * Main class to test
 * @author simranjit.singh
 *
 */
public class HelloWorld {
	
	
	public static void main(String[] args) {
		//inherit from thread class
		//executer
		//ExecutorService exec=Executors.newFixedThreadPool(3);
		//we can ruin max 3 threads
		//exec.submit(task)
		Runner1 run1=new Runner1();
		run1.start();
		
		Runner1 run2=new Runner1();
		run2.start();
		Runner1 run3=new Runner1();
		run3.start();
		Runner1 run4=new Runner1();
		run4.start();
		Runner1 run5=new Runner1();
		run5.start();
		
		Thread t6=new Thread(new RunTest());
		t6.start();
		
		System.out.println("Main Thread");

	}
}

package com.threads.examples;
/**
 * Using synchronised keyword
 * @author simranjit.singh
 *
 */
public class SynchronisedExample4 {
	private int count=0;
	//atomic integer can be used
	//we can also use volatile but its problem of interleaving threads not thread caching variables
	//private volatile int count=0;
	
	/**
	 * here we are making increment operation synchronied so that at a time only single thread can access it
	 * how this happens is that evry object in java has an intrinsic moniter lock or mutex
	 *  each thread needs to acquire this mutex before executing this method 
	 * 
	 */
	public synchronized void increment(){
		count++;
	}
	
	public static void main(String[] args) {
		SynchronisedExample4 d4=new SynchronisedExample4();
		d4.doWork();
	}
	
	public void doWork() {
		Thread t1=new Thread(new Runnable() {
			
			public void run() {
				for(int i=0;i<10000;i++){
					//count++;
					increment();
				}
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			
			public void run() {
				for(int i=0;i<10000;i++){
					//count++;
					increment();
				}
			}
		}); 
	
		t1.start();
		t2.start();
		
		/**
		 * using join we halt main thread to wait until t1 and t2 finishes their work but since both threads
		 *  are still sharing count variable it will not output expected count value each time you run this program becuase
		 *  increasing count still is not a atomic operation.when multiple threads access same value unexpected results can occur.
		 *  to make it behave like expected we need to synchronise count operation. 
		 */
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//when we print count it sometimes can display count is unexpected values because for loops are occurring on separate threads and we are printing 
		//count in main threads , to overcome this issue we can use join to stop main thread till t1 returns and t2 completes their cycle.
		//join causes main thread to wait until t1 and t2 finishes.
		System.out.println("count is" +count);
	}
}

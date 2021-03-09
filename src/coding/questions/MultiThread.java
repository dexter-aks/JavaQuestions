package coding.questions;

import java.util.Stack;
// Start -> New -> Runnable -> Running -> Dead --- Waiting/Blocked
public class MultiThread {


	public static void main(String[] args) throws InterruptedException {
		/*for(int i=1;i<4;i++) {
			ThreadRunnable tr=new ThreadRunnable();
			MyThread mt=new MyThread();
			Thread t1=new Thread(tr);
			t1.setPriority(i);
			t1.start();
			t1.join();
			Thread t2=new Thread(mt);
			t2.start();
			t2.join();

		}*/
		
		/*for(int i=0;i<3;i++) {
			MyThread mt=new MyThread();
			mt.run();
		}*/
//		Stack<Integer> s=new Stack<>();
		
		Thread x1 = new Thread(new MyRunnableThread());
		x1.start();
//		x1.join();
		
		Thread x2 = new Thread(new MyThreadTest());
		x2.start();
//		x2.join();

	}


}

class MyRunnableThread implements Runnable{

//	@Override
	public void run() {
		System.out.println("Runnable:"+Thread.currentThread().getName());
		
	}
	
	
}

class MyThreadTest extends Thread{
	@Override
	public void run() {
		System.out.println("Thread:"+Thread.currentThread().getName());
	}
}

class ThreadRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("ThreadRunnable called:"+Thread.currentThread().getName());
		
	}
	
}

class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println("MyThread called:"+Thread.currentThread().getName());
	}
}

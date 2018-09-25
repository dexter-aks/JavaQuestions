package coding.questions;

import java.util.Stack;

public class MultiThread {

	public static void main(String[] args) throws InterruptedException {
		for(int i=1;i<11;i++) {
			ThreadRunnable tr=new ThreadRunnable();
			Thread t1=new Thread(tr);
//			t1.setPriority(i);
			t1.start();
			t1.join();

		}
		
		/*for(int i=0;i<3;i++) {
			MyThread mt=new MyThread();
			mt.run();
		}*/
		Stack<Integer> s=new Stack<>();

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

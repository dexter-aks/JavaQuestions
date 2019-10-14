package coding.questions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<4;i++) {
			WorkerThread worker=new WorkerThread(""+i);
			executor.execute(worker);
		}
		executor.shutdown();
		while(!executor.isTerminated()) {
			
		}
		System.out.println(Thread.currentThread().getName()+" Done");
	}

}

class WorkerThread implements Runnable{
	
	private String command;
	
	public WorkerThread(String command) {
		this.command=command;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Start.Command= "+command);
		processCommand();
		System.out.println(Thread.currentThread().getName()+" End");
	}
	
	private void processCommand() {
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

package coding.questions;

public class DeadlockTest {

	public static void main(String[] args) throws InterruptedException{
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		Thread t1 = new Thread(new SyncObject(obj1, obj2), "t1");
		Thread t2 = new Thread(new SyncObject(obj2, obj3), "t2");
		Thread t3 = new Thread(new SyncObject(obj3, obj1), "t3");
		
		t1.start();
		Thread.sleep(50000);
		t2.start();
		Thread.sleep(50000);
		t3.start();

	}

}

class SyncObject implements Runnable{
	private Object o1;
	private Object o2;
	public SyncObject(Object o1, Object o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void run() {
		System.out.println("Acquiring Lock:"+Thread.currentThread().getName() +":"+o1);
		synchronized(o1) {
			System.out.println("Acquired Lock:"+Thread.currentThread().getName() +":"+o1);
			work();
			System.out.println("Acquiring Lock:"+Thread.currentThread().getName() +":"+o2);
			synchronized(o2) {
				System.out.println("Acquired Lock:"+Thread.currentThread().getName() +":"+o2);
				work();
			}
			System.out.println("Released Lock:"+Thread.currentThread().getName() +":"+o2);
		}
		System.out.println("Released Lock:"+Thread.currentThread().getName() +":"+o1);
	}
	
	private void work() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

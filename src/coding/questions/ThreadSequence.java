package coding.questions;


public class ThreadSequence {
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new Sequence(1));
		t1.setName("t1");
		Thread t2=new Thread(new Sequence(2));
		t2.setName("t2");
		Thread t3=new Thread(new Sequence(3));
		t3.setName("t3");
		Thread t4=new Thread(new Sequence(0));
		t4.setName("t4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}

class Sequence implements Runnable{
	static int number=1;
	int rem;
	static Object lock =new Object();
	
	public Sequence(int rem) {
		this.rem=rem;
	}

	@Override
	public void run() {
		while(number<10) {
			synchronized(lock) {
				while(number % 4 !=rem) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(number<=10) {
					System.out.println(Thread.currentThread().getName()+":"+number);
					number++;
					lock.notifyAll();
				}
			}
		}
		if(number>10 && Thread.currentThread().getName().equals("t3")) {
			System.out.println(Thread.currentThread().getName()+":"+number);
		}
	}
	
}

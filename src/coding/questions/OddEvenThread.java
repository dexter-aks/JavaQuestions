package coding.questions;


public class OddEvenThread extends Thread{
	 static int i=1;
	public static void main(String[] args) {
		OddEvenThread odd=new OddEvenThread();
		OddEvenThread even=new OddEvenThread();
		odd.setName("odd");
		even.setName("even");
		odd.start();
		even.start();

	}
	
	@Override
	public void run() {
		while(i<=10) {
			if(i%2!=0 && Thread.currentThread().getName().equals("odd")) {
				synchronized(this) {
					System.out.println(Thread.currentThread().getName()+":"+i);
					i++;
					/*try {
//						lock.wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}*/
				}
				
			}
			else if(i%2==0 && Thread.currentThread().getName().equals("even")) {
				synchronized(this) {
					System.out.println(Thread.currentThread().getName()+":"+i);
					i++;
//					lock.notify();
				}
			}
		}
	}

}

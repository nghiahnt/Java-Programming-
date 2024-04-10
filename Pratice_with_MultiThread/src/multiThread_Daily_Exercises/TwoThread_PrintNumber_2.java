package multiThread_Daily_Exercises;

public class TwoThread_PrintNumber_2 extends Thread {
	
	private int startNumber;
	
	public TwoThread_PrintNumber_2(int s) {
		startNumber = s;
	}
	
	// Shared method
	// When a thread is using the static method, another thread will be waited to be finished
	public static synchronized void go(int start) {
		for (int i=start; i<=10; i+=2) {
			System.out.print(i + " ");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void run() {
		go(startNumber);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new TwoThread_PrintNumber_2(1);
		Thread t2 = new TwoThread_PrintNumber_2(2);
		
		t1.start();
		t2.start();
	}

}

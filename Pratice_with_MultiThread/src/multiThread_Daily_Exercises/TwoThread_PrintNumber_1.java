package multiThread_Daily_Exercises;

/**
 * Create two threads 
 * Thread 1 prints the odd numbers from 1 - 9
 * Thread 2 prints the even numbers from 2 - 10
 */

// The first way
class Thread1 extends Thread {
	// Thread 1 prints the odd numbers - odd: so le
	public void run() {
		for (int i=1; i<10; i+=2) {
			System.out.print(i + " ");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

class Thread2 extends Thread {
	// Prints the even numbers - even: so chan
	public void run() {
		for (int i=2; i<=10; i+=2) {
			System.out.print(i + " ");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

public class TwoThread_PrintNumber_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create two child threads
		Thread t1 = new Thread1();
		Thread t2 = new Thread2();
		
		// Start
		t1.start();
		t2.start();
	}

}

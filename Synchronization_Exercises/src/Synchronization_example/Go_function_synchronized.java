package Synchronization_example;

public class Go_function_synchronized extends Thread {
	
	int start;
	
	public Go_function_synchronized(int s) {
		start = s;
	}
	
	// Function has synchronized
	// That means although has many thread with the same function which has synchronized
	// The OS will block the thread2 until thread 1 finished.
	public synchronized static void Go(int s) {
		for (int i=s; i<10; i+=2) {
			System.out.print(i+" ");
			try {
				 Thread.sleep(100);		
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void run() {
		Go(start);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Go_function_synchronized thread1 = new Go_function_synchronized(1);
		Go_function_synchronized thread2 = new Go_function_synchronized(2);
		thread1.start();
		thread2.start();
	}

}

package DiningOf_5_Philosophers;

import java.util.concurrent.Semaphore;

public class DiningReslove {
	
	// Init 5 philosophers
	private static final int NUM_PHILOSOPHERS = 5;
	// Init Semaphore forks - 2 persons can eat together with 4 forks
	private static final Semaphore forks = new Semaphore(NUM_PHILOSOPHERS - 1);
	
	private static class Philosopher extends Thread {
		private final int id;
		
		public Philosopher(int id) {
			this.id = id;
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					forks.acquire(); // The forks decrease to 2
					System.out.println("Triet gia " + id + " dang an");
					Thread.sleep(1000);
					forks.release(); // Increase to 2
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0; i<NUM_PHILOSOPHERS; i++) {
			new Philosopher(i).start();
		}
	}

}

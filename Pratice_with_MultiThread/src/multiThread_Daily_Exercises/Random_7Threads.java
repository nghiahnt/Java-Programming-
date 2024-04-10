package multiThread_Daily_Exercises;

import java.util.concurrent.ThreadLocalRandom;

class randomThread extends Thread {		
	public int random() {
		int randomNumber = ThreadLocalRandom.current().nextInt(1, 30);	
		return randomNumber;
	}
	
	public void run() {
		random();
	}
	
	public int getResult() {
		return random();
	}
}

public class Random_7Threads {

	int sum = 0;
	randomThread[] threads = new randomThread[7];
	
	public Random_7Threads() {
		for (int i=0; i<threads.length; i++) {
			threads[i] = new randomThread();
			threads[i].start();
			
			try {
				threads[i].join();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}			
		}
		for (int i=0; i<threads.length; i++) {
			sum += threads[i].getResult();
		}
		System.out.println("The total of seven threads is: " + sum);
	}
	
	public static void main(String[] args) {
		new Random_7Threads();
	}
}

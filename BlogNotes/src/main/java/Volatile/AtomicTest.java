package Volatile;

public class AtomicTest extends Thread {
	volatile static int i = 0;

	@Override
	public void run() {
		for (int k = 0; k < 100; k++) {
			i++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[10];
		for (int c = 0; c < 10; c++) {
			threads[c] = new Thread(new AtomicTest());
			threads[c].start();
		}
		for (int c = 0; c < 10; c++) {
			threads[c].join();
		}
		System.out.println(i);
	}
}

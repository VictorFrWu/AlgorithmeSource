package MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mac lock and condition
 */

public class MethodTwo {

	private Lock lock = new ReentrantLock(true);
	private Condition condition = lock.newCondition();
	private static int value = 1;

	public Runnable newThreadOne() {
		final String[] inputArr = Helper.buildNoArr(52);
		return new Runnable() {
			private String[] arr = inputArr;

			public void run() {
				for (int i = 0; i < arr.length; i = i + 2) {
					try {
						lock.lock();
						while (value == 2)
							condition.await();
						Helper.print(arr[i], arr[i + 1]);
						value = 2;
						condition.signal();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
			}
		};
	}

	public Runnable newThreadTwo() {
		final String[] inputArr = Helper.buildCharArr(26);
		return new Runnable() {
			private String[] arr = inputArr;

			public void run() {
				for (int i = 0; i < arr.length; i++) {
					try {
						lock.lock();
						while (value == 1)
							condition.await();
						Helper.print(arr[i]);
						value = 1;
						condition.signal();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
			}
		};
	}

	public static void main(String args[]) throws InterruptedException {
		MethodTwo two = new MethodTwo();
		Helper.getInstance().run(two.newThreadOne());
		Helper.getInstance().run(two.newThreadTwo());
		Helper.getInstance().shutdown();
	}
}
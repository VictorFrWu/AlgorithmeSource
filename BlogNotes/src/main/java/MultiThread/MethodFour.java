package MultiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class MethodFour {
	private AtomicInteger threadToGo = new AtomicInteger(1);

	public Runnable newThreadOne() {
		final String[] inputArr = Helper.buildNoArr(52);
		return new Runnable() {
			private String[] arr = inputArr;

			public void run() {
				for (int i = 0; i < arr.length; i = i + 2) {
					while (threadToGo.get() == 2) {
					}
					Helper.print(arr[i], arr[i + 1]);
					threadToGo.set(2);
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
					while (threadToGo.get() == 1) {
					}
					Helper.print(arr[i]);
					threadToGo.set(1);
				}
			}
		};
	}

	public static void main(String args[]) throws InterruptedException {
		MethodFour four = new MethodFour();
		Helper.getInstance().run(four.newThreadOne());
		Helper.getInstance().run(four.newThreadTwo());
		Helper.getInstance().shutdown();
	}
}
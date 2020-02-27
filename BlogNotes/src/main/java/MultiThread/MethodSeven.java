package MultiThread;


public class MethodSeven {
	private volatile int threadToGo = 1;

	public Runnable newThreadOne() {
		final String[] inputArr = Helper.buildNoArr(52);
		return new Runnable() {
			private String[] arr = inputArr;

			public void run() {
				for (int i = 0; i < arr.length; i = i + 2) {
					while (threadToGo == 2) {
					}
					Helper.print(arr[i], arr[i + 1]);
					threadToGo = 2;
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
					while (threadToGo == 1) {
					}
					Helper.print(arr[i]);
					threadToGo = 1;
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

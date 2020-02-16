package MultiThread;

/**
 * @author mac 今天在群里面看到一个很有意思的面试题：
 *         “编写两个线程，一个线程打印1~25，另一个线程打印字母A~Z，打印顺序为12A34B56C……5152Z，要求使用线程间的通信。”
 *         这是一道非常好的面试题，非常能彰显被面者关于多线程的功力，一下子就勾起了我的兴趣
 * 
 *         synchronize + wait + notify
 */
public class MethodOne {
	class ThreadToGo {
		int value = 1;
	}

	private final ThreadToGo threadToGo = new ThreadToGo();

	public Runnable newThreadOne() {
		final String[] inputArr = Helper.buildNoArr(52);
		return new Runnable() {
			private String[] arr = inputArr;

			public void run() {
				try {
					for (int i = 0; i < arr.length; i = i + 2) {
						synchronized (threadToGo) {
							while (threadToGo.value == 2)
								threadToGo.wait();
							Helper.print(arr[i], arr[i + 1]);
							threadToGo.value = 2;
							threadToGo.notify();
						}
					}
				} catch (InterruptedException e) {
					System.out.println("Oops...");
				}
			}
		};
	}

	public Runnable newThreadTwo() {
		final String[] inputArr = Helper.buildCharArr(26);
		return new Runnable() {
			private String[] arr = inputArr;

			public void run() {
				try {
					for (int i = 0; i < arr.length; i++) {
						synchronized (threadToGo) {
							while (threadToGo.value == 1)
								threadToGo.wait();
							Helper.print(arr[i]);
							threadToGo.value = 1;
							threadToGo.notify();
						}
					}
				} catch (InterruptedException e) {
					System.out.println("Oops...");
				}
			}
		};
	}

	public static void main(String args[]) throws InterruptedException {
		MethodOne one = new MethodOne();
		Helper.getInstance().run(one.newThreadOne());
		Helper.getInstance().run(one.newThreadTwo());
		Helper.getInstance().shutdown();
	}
}

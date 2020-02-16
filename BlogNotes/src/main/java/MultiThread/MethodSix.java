package MultiThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author mac
 *         CyclicBarrier可以实现让一组线程在全部到达Barrier时(执行await())，再一起同时执行，并且所有线程释放后，还能复用它,即为Cyclic。
 *         CyclicBarrier类提供两个构造器：
 * 
 *         public CyclicBarrier(int parties, Runnable barrierAction) { } public
 *         CyclicBarrier(int parties) { }
 */

public class MethodSix {
	private final CyclicBarrier barrier;
	private final List<String> list;

	public MethodSix() {
		list = Collections.synchronizedList(new ArrayList<String>());
		barrier = new CyclicBarrier(2, newBarrierAction());
	}

	public Runnable newThreadOne() {
		final String[] inputArr = Helper.buildNoArr(52);
		return new Runnable() {
			private String[] arr = inputArr;

			public void run() {
				for (int i = 0; i < arr.length; i = i + 2) {
					try {
						list.add(arr[i]);
						list.add(arr[i + 1]);
						barrier.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
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
						list.add(arr[i]);
						barrier.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

	private Runnable newBarrierAction() {
		return new Runnable() {
			@Override
			public void run() {
				Collections.sort(list);
				list.forEach(c -> System.out.print(c));
				list.clear();
			}
		};
	}

	public static void main(String args[]) {
		MethodFour four = new MethodFour();
		Helper.getInstance().run(four.newThreadOne());
		Helper.getInstance().run(four.newThreadTwo());
		Helper.getInstance().shutdown();
	}
}

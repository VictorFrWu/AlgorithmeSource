package Huawai;

import java.util.Scanner;

public class MultiThread {
	private final static int THREAD_NUM = 4;
	private static char[] chs = new char[1032 * THREAD_NUM];

	public static void main(String[] args) {
		createThreads();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(new String(chs).substring(0, n * THREAD_NUM));
		}
		sc.close();
	}

	// 创建线程并进行调用
	private static void createThreads() {
		char ch = 'A';
		for (int i = 0; i < THREAD_NUM; i++) {
			new Thread(new InnerThread(ch++, i)).start();
		}
	}

	// 内部线程类
	private static class InnerThread implements Runnable {
		private char ch;
		private int index;

		public InnerThread(char ch, int index) {
			this.ch = ch;
			this.index = index;
		}

		public void run() {
			while (this.index < chs.length) {
				chs[this.index] = this.ch;
				this.index += THREAD_NUM;
			}
		}

	}
}

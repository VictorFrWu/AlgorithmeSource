package GreedySnake;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test extends JFrame {
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setTitle("Picture Application");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JPanel panel1 = new JPanel();
//		ImageIcon pic = new ImageIcon("/Users/mac/Desktop/AlgorithmeSource/BlogNotes/src/main/java/GreedySnake/up.png");
//		panel1.add(new JLabel(pic));
//		frame.add(panel1);
//		frame.setVisible(true);
//	}

	public static void main(String[] args) {
		ThreadA t1 = new ThreadA("t1");
		t1.start();
	}

}

class ThreadA extends Thread {
	public ThreadA(String name) {
		super(name);
	}

	public synchronized void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.printf("%s: %d\n", this.getName(), i);
				// i能被4整除时，休眠100毫秒
				if (i % 4 == 0)
					Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
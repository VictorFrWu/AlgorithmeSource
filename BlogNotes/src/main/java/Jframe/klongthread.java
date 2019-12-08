package Jframe;

import java.awt.Container;

import javax.swing.JOptionPane;


public class klongthread extends Thread {
	private DragonPanel p;

	public klongthread(DragonPanel p) {
		this.p = p;
	}

	@Override
	public void run() {

		while (!p.isFinish()) {
			p.repaint();// repaint
			try {
				Thread.sleep(p.FRESH);// refresh
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		

	}
}

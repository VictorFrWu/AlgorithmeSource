package DragonJump;

import javax.swing.*;
import java.awt.*;

//thread class
public class FreshThread extends Thread {
	private GamePanl p;

	public FreshThread(GamePanl p) {
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

		Container c = p.getParent();
		while (!(c instanceof MainFrame)) {
			c = c.getParent();
		}
		MainFrame f = (MainFrame) c;
		if (p.isFinish()) {
			JOptionPane.showMessageDialog(f, "         G A M E  O V E R");
			f.restart();
		}

	}

}

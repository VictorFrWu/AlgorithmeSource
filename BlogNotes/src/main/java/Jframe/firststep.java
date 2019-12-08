package Jframe;

import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;

public class firststep extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DragonPanel p;

	public firststep() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			p = new DragonPanel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// get frame mainly container
		Container c = getContentPane();
		// add game panel to container
		c.add(p);
		this.addKeyListener(p);
	}

	public static void main(String[] args) {
		firststep frame = new firststep();
		frame.setBounds(340, 220, 734, 320);// set up the frame
		frame.setVisible(true);
		// center to your screen
		frame.setLocationRelativeTo(null);
		frame.setTitle("test");
	}
}

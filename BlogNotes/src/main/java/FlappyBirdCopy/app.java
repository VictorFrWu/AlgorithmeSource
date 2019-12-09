package FlappyBirdCopy;


import javax.swing.*;

import java.awt.*;

public class app extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GPanel p;

	public app() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new GPanel();
		// get frame mainly container
		Container c = getContentPane();
		// add game panel to container
		c.add(p);
		this.addKeyListener(p);
	}

	public static void main(String[] args) {
		app frame = new app();
		frame.setSize(500,500);// set up the frame
		frame.setVisible(true);
		// center to your screen
		frame.setLocationRelativeTo(null);
		frame.setTitle("test");
	}

}

package DragonJump;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static int topScore = 0;// record
	private GamePanl p;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new GamePanl();
		// get frame mainly container
		Container c = getContentPane();
		// add game panel to container
		c.add(p);
		addKeyListener(p);

	}

	public static void main(String[] args) {

		MainFrame frame = new MainFrame();
		frame.setBounds(340, 220, 734, 320);// set up the frame
		frame.setVisible(true);
		// center to your screen
		frame.setLocationRelativeTo(null);
		frame.setTitle("dragon jump");

	}

	// restart after game over
	public void restart() {
		Container c = getContentPane();
		// remove all components
		c.removeAll();
		GamePanl gp = new GamePanl();
		c.add(gp);
		addKeyListener(gp);
		c.validate();// reverify

	}

}

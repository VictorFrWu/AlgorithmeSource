package tetriscopy;

import javax.swing.JFrame;


public class frame extends JFrame {
	gamepanel game = new gamepanel();// contains logic
	public frame() {
		this.addKeyListener(game);

		this.add(game);

		this.setTitle("Tetris");
		this.setSize(400, 500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new frame();
	}
}

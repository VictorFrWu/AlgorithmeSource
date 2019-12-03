package GreedySnake;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Picture Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		ImageIcon pic = new ImageIcon("/Users/mac/Desktop/AlgorithmeSource/BlogNotes/src/main/java/GreedySnake/up.png");
		panel1.add(new JLabel(pic));
		frame.add(panel1);
		frame.setVisible(true);
	}

}

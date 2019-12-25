package Tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GameFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int widthFrame = 400;
	private int heightFrame = 500;
	private JMenu menuone = new JMenu("Game");// create first menu
	private JMenuItem newGame = menuone.add("restart");// a submenu
	private JMenuItem exitGame = menuone.add("exit");
	private JMenuItem stopGame = menuone.add("pause");
	private JMenuItem goOnGame = menuone.add("continue");

	private JMenu menutwo = new JMenu("help");// create a second menu
	private JMenuItem aboutGame = menutwo.add("about");
	GamePanel gamepanel = new GamePanel();// contains logic

	public GameFrame()// constructor
	{
		this.addKeyListener(gamepanel);
		newGame.addActionListener(this);
		exitGame.addActionListener(this);
		stopGame.addActionListener(this);
		goOnGame.addActionListener(this);
		aboutGame.addActionListener(this);

		this.add(gamepanel);

		JMenuBar menu = new JMenuBar();
		menu.add(menuone);
		menu.add(menutwo);
		this.setJMenuBar(menu);

		this.setTitle("Tetris");
		this.setSize(widthFrame, heightFrame);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame)// restart game
		{
			gamepanel.newGame();
		}
		if (e.getSource() == exitGame)// stop game
		{
			System.exit(0);// close application
		}
		if (e.getSource() == stopGame)// pause
		{
			gamepanel.stopGame();
		}
		if (e.getSource() == goOnGame)// continue
		{
			gamepanel.continueGame();
		}
		if (e.getSource() == aboutGame)// about game
		{
			JOptionPane.showMessageDialog(null, "left and right move，rotate up and down", "tip", JOptionPane.OK_OPTION);
		}
	}

	public static void main(String[] args) {
		new GameFrame();
	}
}
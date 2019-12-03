package GreedySnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePanel extends JPanel implements KeyListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 7 photo
	String prefix = "/Users/mac/Desktop/AlgorithmeSource/BlogNotes/img/";
	ImageIcon up = new ImageIcon(prefix + "up.png"); // 向上的蛇头
	ImageIcon down = new ImageIcon(prefix + "down.png"); // 向下的蛇头
	ImageIcon left = new ImageIcon(prefix + "left.png"); // 向左的蛇头
	ImageIcon right = new ImageIcon(prefix + "right.png"); // 向右的蛇头
	ImageIcon food = new ImageIcon(prefix + "food.png"); // 食物
	ImageIcon body = new ImageIcon(prefix + "/body.png"); // 蛇的身体
	ImageIcon title = new ImageIcon(prefix + "/title.jpg"); // 游戏界面的主题

	int[] snakex = new int[750];
	int[] snakey = new int[750];

	int len = 3;
	int score = 0;
	String direction = "R";

	boolean isStarted = false;
	boolean isFailed = false;

	Timer timer = new Timer(100, this);

	Random rand = new Random();
	int foodx = rand.nextInt(34) * 25 + 25;
	int foody = rand.nextInt(24) * 25 + 75;

	public SnakePanel() {
		this.setFocusable(true);
		this.addKeyListener((KeyListener) this);
		setup();
		timer.start();
	}

	private void setup() {
		isStarted = false;
		isFailed = false;
		len = 3;
		score = 0;
		snakex[0] = 100;
		snakex[1] = 75;
		snakex[2] = 50;
		snakey[0] = 100;
		snakey[1] = 100;
		snakey[2] = 100;
	}

	public void paint(Graphics g) {
		this.setBackground(Color.BLACK); // 设置画布背景颜色
		title.paintIcon(this, g, 25, 11);
		g.fillRect(25, 75, 850, 650);

		if (direction.equals("R"))
			right.paintIcon(this, g, snakex[0], snakey[0]);
		else if (direction.equals("L"))
			left.paintIcon(this, g, snakex[0], snakey[0]);
		else if (direction.equals("U"))
			up.paintIcon(this, g, snakex[0], snakey[0]);
		else if (direction.equals("D"))
			down.paintIcon(this, g, snakex[0], snakey[0]);

		for (int i = 1; i < len; i++)
			body.paintIcon(this, g, snakex[i], snakey[i]);

		if (!isStarted) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Press Space to start / pause", 200, 300);
		}

		if (isFailed) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Game Over ! Press space to restart", 200, 300);
		}

		food.paintIcon(this, g, foodx, foody);

		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 15));
		g.drawString("Score : " + score, 650, 37);
		g.drawString("Len :" + len, 650, 57);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int KeyCode = e.getKeyCode();
		if (KeyCode == KeyEvent.VK_SPACE) { // 敲击空格现实/消除提示信息
			if (isFailed) {
				isStarted = false; // 可以将这两行放入setup中
				isFailed = false;
				setup();
			} else
				isStarted = !isStarted;
		} else if (KeyCode == KeyEvent.VK_UP && direction != "D")
			direction = "U";
		else if (KeyCode == KeyEvent.VK_DOWN && direction != "U")
			direction = "D";
		else if (KeyCode == KeyEvent.VK_RIGHT && direction != "L")
			direction = "R";
		else if (KeyCode == KeyEvent.VK_LEFT && direction != "R")
			direction = "L";
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();

		if (isStarted && !isFailed) {

			for (int i = len; i > 0; i--) {
				snakex[i] = snakex[i - 1];
				snakey[i] = snakey[i - 1];
			}

			if (direction.equals("R")) {
				snakex[0] = snakex[0] + 25;
				if (snakex[0] > 850)
					snakex[0] = 25;
			} else if (direction.equals("L")) {
				snakex[0] = snakex[0] - 25;
				if (snakex[0] < 25)
					snakex[0] = 850;
			} else if (direction.equals("U")) {
				snakey[0] = snakey[0] - 25;
				if (snakey[0] < 75)
					snakey[0] = 650;
			} else if (direction.equals("D")) {
				snakey[0] = snakey[0] + 25;
				if (snakey[0] > 650)
					snakey[0] = 75;
			}

			if (snakex[0] == foodx && snakey[0] == foody) { // 吃食物
				len++;
				score++;
				foodx = rand.nextInt(34) * 25 + 25;
				foody = rand.nextInt(24) * 25 + 75;
			}

			for (int i = 1; i < len; i++) { // 如果蛇头碰到自己的身体游戏结束
				if (snakex[0] == snakex[i] && snakey[0] == snakey[i]) {
					isFailed = true;
				}
			}

		}
		// 3. repaint（）
		repaint();
	}
}

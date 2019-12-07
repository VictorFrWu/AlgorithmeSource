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
	// photo
	String prefix = "/Users/mac/Desktop/AlgorithmeSource/BlogNotes/img/";
	ImageIcon title = new ImageIcon(prefix + "title.jpg"); // title
	ImageIcon up = new ImageIcon(prefix + "up.png"); // up head
	ImageIcon body = new ImageIcon(prefix + "body.png"); // snake body
	ImageIcon down = new ImageIcon(prefix + "down.png"); // down head
	ImageIcon left = new ImageIcon(prefix + "left.png"); // left head
	ImageIcon right = new ImageIcon(prefix + "right.png"); // right head
	ImageIcon orange = new ImageIcon(prefix + "orange.png"); // food orange
	ImageIcon peach = new ImageIcon(prefix + "peach.png"); // food peach
	ImageIcon apple = new ImageIcon(prefix + "apple.png"); // food apple
	ImageIcon poison = new ImageIcon(prefix + "poison.png"); // poison

	int record = 0;

	// snake coordinate
	int[][] snake = new int[750][750];// x,y

	String direction = "R";
	int len = 3;
	int score = 0;

	boolean isStarted = false;// pause
	boolean isFailed = false;// game over

	Timer timer = new Timer(100, this);
	Timer poisonTime = new Timer(15 * 1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (poisonExist) {
				poisonx = rand.nextInt(34) * 25 + 25;
				poisony = rand.nextInt(24) * 25 + 75;
				return;
			}
			if (!poisonExist) {
				poisonx = 0;
				poisony = 0;
				poisonExist = true;
				poisonTime.setDelay(10 * 1000);
			}
		}

	});

	Random rand = new Random();
	int foodType = getRandomNumber();
	int foodx = rand.nextInt(34) * 25 + 25;
	int foody = rand.nextInt(24) * 25 + 75;

	int poisonx = rand.nextInt(34) * 25 + 25;
	int poisony = rand.nextInt(24) * 25 + 75;
	boolean poisonExist = true;

	private int getRandomNumber() {
		int a = rand.nextInt(100);// generate a number in 1 to 100
		int b = 0;
		if (a <= 50)
			b = 1;
		else if (a <= 80)
			b = 2;
		else
			b = 3;
		return b;
	}

	public SnakePanel() {
		this.setFocusable(true);
		this.addKeyListener((KeyListener) this);
		setup();
		timer.start();
		poisonTime.start();
	}

	private void setup() {
		direction = "R";
		isStarted = false;
		isFailed = false;
		len = 3;
		score = 0;
		snake[0][0] = 100;
		snake[0][1] = 100;
		snake[1][0] = 75;
		snake[1][1] = 100;
		snake[2][0] = 50;
		snake[2][1] = 100;
	}

	private boolean checkPosition(int[][] sanke, int x, int y) {
		for (int i = 0; i < sanke.length; i++) {
			if (x == snake[i][0] && y == snake[i][1])
				return false;
		}
		return true;

	}

	public void paint(Graphics g) {
		this.setBackground(Color.white); // set background color
		title.paintIcon(this, g, 25, 11);
		int height = 625;
		int width = 850;
		g.fillRect(25, 75, 850, 625);
		g.setColor(Color.blue);
		g.drawRect(25, 75, width, height);

		// paint snake head
		if (direction.equals("R"))
			right.paintIcon(this, g, snake[0][0], snake[0][1]);
		else if (direction.equals("L"))
			left.paintIcon(this, g, snake[0][0], snake[0][1]);
		else if (direction.equals("U"))
			up.paintIcon(this, g, snake[0][0], snake[0][1]);
		else if (direction.equals("D"))
			down.paintIcon(this, g, snake[0][0], snake[0][1]);

		// paint snake body
		for (int i = 1; i < len; i++)
			body.paintIcon(this, g, snake[i][0], snake[i][1]);

		if (!isStarted) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Press Space to start / pause", 200, 300);
		}

		if (isFailed) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Game Over ! Press space to restart", 200, 300);
			if (score > record)
				record = score;
		}

		boolean bool = checkPosition(snake, foodx, foody);
		while (!bool) {
			foodType = getRandomNumber();
			foodx = rand.nextInt(34) * 25 + 25;
			foody = rand.nextInt(24) * 25 + 75;
			bool = checkPosition(snake, foodx, foody);
		}
		// paint food
		if (foodType == 1)
			orange.paintIcon(this, g, foodx, foody);
		else if (foodType == 2)
			peach.paintIcon(this, g, foodx, foody);
		else
			apple.paintIcon(this, g, foodx, foody);

		// check snake and poison are superposition or not
		bool = checkPosition(snake, poisonx, poisony);
		while (!bool || (poisonx == foodx && poisony == foody)) {
			poisonx = rand.nextInt(34) * 25 + 25;
			poisony = rand.nextInt(24) * 25 + 75;
		}
		poison.paintIcon(this, g, poisonx, poisony);

		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 15));
		g.drawString("Score : " + score, 650, 37);
		g.drawString("Len :" + len, 650, 57);

		g.setColor(Color.black);
		g.setFont(new Font("arial", Font.PLAIN, 30));
		g.drawString("Your record is " + record, 900, 100);
		g.drawString("Introduction", 900, 150);
		g.setFont(new Font("arial", Font.PLAIN, 15));
		g.drawString("The snake eat orange can get 1 point", 900, 200);
		g.drawString("The snake eat orange can get 2 points", 900, 220);
		g.drawString("The snake eat orange can get 3 points", 900, 240);
		g.setColor(Color.red);
		g.drawString("The snake eat poison will cut 10 points", 900, 260);
		g.drawString("when your notes is smaller than 0 or ", 900, 280);
		g.drawString("you hit the wall, the game will be over", 900, 300);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		if (isFailed) {
			if (KeyCode == KeyEvent.VK_SPACE)
				setup();
		} else if (!isStarted) {
			if (KeyCode == KeyEvent.VK_SPACE)
				isStarted = !isStarted;
		} else {
			if (KeyCode == KeyEvent.VK_SPACE)
				isStarted = !isStarted;
			else if (KeyCode == KeyEvent.VK_UP && direction != "D")
				direction = "U";
			else if (KeyCode == KeyEvent.VK_DOWN && direction != "U")
				direction = "D";
			else if (KeyCode == KeyEvent.VK_RIGHT && direction != "L")
				direction = "R";
			else if (KeyCode == KeyEvent.VK_LEFT && direction != "R")
				direction = "L";
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1 reset timer
		timer.start();

		// 2 snake move
		if (isStarted && !isFailed) {
			// body move from tail to head
			for (int i = len; i > 0; i--) {
				snake[i][0] = snake[i - 1][0];
				snake[i][1] = snake[i - 1][1];
			}
			// move head
			if (direction.equals("R")) {
				snake[0][0] = snake[0][0] + 25;
				if (snake[0][0] == 850)
					// snake[0][0] = 25;
					isFailed = true;
			} else if (direction.equals("L")) {
				snake[0][0] = snake[0][0] - 25;
				if (snake[0][0] == 25)
					// snake[0][0] = 850;
					isFailed = true;
			} else if (direction.equals("U")) {
				snake[0][1] = snake[0][1] - 25;
				if (snake[0][1] == 75)
					// snake[0][1] = 650;
					isFailed = true;
			} else if (direction.equals("D")) {
				snake[0][1] = snake[0][1] + 25;
				if (snake[0][1] == 650)
					// snake[0][1] = 75;
					isFailed = true;
			}

			// eat food
			if (snake[0][0] == foodx && snake[0][1] == foody) {
				len += foodType;
				score += foodType;
				foodType = getRandomNumber();
				foodx = rand.nextInt(34) * 25 + 25;
				foody = rand.nextInt(24) * 25 + 75;
			}

			if (snake[0][0] == poisonx && snake[0][1] == poisony) {
				score -= 10;
				poisonx = rand.nextInt(34) * 25 + 25;
				poisony = rand.nextInt(24) * 25 + 75;
				poisonExist = false;
			}

			if (score < 0) {
				isFailed = true;
				return;
			}

			// head touch body, game over
			for (int i = 1; i < len; i++) {
				if (snake[0][0] == snake[i][0] && snake[0][1] == snake[i][1]) {
					isFailed = true;
				}
			}

		}
		// 3. repaint（）
		repaint();
	}
}

package DragonJump;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Heritage images to frame
 */
public class GamePanl extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;// mainly image
	private Graphics2D g2;// paint image
	private Dragon dragon;// dragon
	boolean finish = false;// game over

	static final int FRESH = 10;// refresh ms

	BackgroundImage background;

	List<Obstacle> list = new ArrayList<Obstacle>();// obstacle collection

	int addObstacleTimer = 0;
	Obstacle ob = new Obstacle();

	int score = 0;// note
	int addScoreTimer = 0;
	boolean isPasue = false;

	// game panel construct function
	public GamePanl() {
		image = new BufferedImage(734, 286, BufferedImage.TYPE_INT_RGB);
		g2 = image.createGraphics();
		dragon = new Dragon();// instance dragon
		background = new BackgroundImage();// instance background
		list.add(new Obstacle());
		FreshThread t = new FreshThread(this);// refresh thread
		t.start();

	}

	private void painImage() {// paint pictures
		if (isPasue) {
			g2.setColor(Color.WHITE);
			g2.setFont(new Font("arial", Font.BOLD, 30));
			g2.drawString("Press Space to start / pause", 120, 150);
		} else {
			dragon.move();
			background.roll();
			g2.drawImage(background.image, 0, 0, this);// draw background
			g2.drawImage(background.image_yun1, background.x_yun1, background.y_yun1, this);// draw cloud 1
			g2.drawImage(background.image_yun2, background.x_yun2, background.y_yun2, this);// draw cloud 2
			g2.drawImage(dragon.image, dragon.x, dragon.y, this);// draw dragon

//			g2.setColor(Color.BLACK);
//			Rectangle rt = dragon.bounds1();
//			g2.fillRect(rt.x, rt.y, rt.width, rt.height);

			if (addObstacleTimer >= 1500) {// 1.5s refresh an obstacle
				Random rand = new Random();
				int tmp = rand.nextInt(100);
				if (tmp < 70) {
					list.add(new Obstacle());
				}
				addObstacleTimer = 0;

			}

			for (int i = 0; i < list.size(); i++) {
				Obstacle o = list.get(i);
				if (o.kind == 0) {
					o.move();
					g2.drawImage(o.image, o.x, o.yCactus, this);// draw cactus
					// knocking head and food
					if (o.cactusBounds().intersects(dragon.bounds1())
							|| o.cactusBounds().intersects(dragon.bounds2())) {
						gameOver();// game over
					}
				} else {
					o.move();
					o.bridMove();
					g2.drawImage(o.image, o.x, o.yBird, this);
					// knocking head and food
					if (o.birdBounds().intersects(dragon.bounds1()) || o.birdBounds().intersects(dragon.bounds2())) {
						gameOver();// game over
					}
				}
			}

			// score++
			if (addObstacleTimer >= 50) {
				score += 1;
				addScoreTimer = 0;
			}

			// 5 digits present scores
			g2.drawString(String.format("%05d", score), 640, 35);
			g2.drawString("Hi", 520, 35);
			g2.drawString(String.format("%05d", +MainFrame.topScore), 560, 35); // top score

			addObstacleTimer += FRESH;
			addScoreTimer += FRESH;
		}

	}

	// game over
	public void gameOver() {
		finish = true;
		g2.drawImage(background.image_over, background.x_over, background.y_over, null);
		if (score > MainFrame.topScore) {
			// check the top socre
			MainFrame.topScore = score;
		}
	}

	@Override
	public void paint(Graphics g) {
		painImage();
		g.drawImage(image, 0, 0, this);
	}

	public boolean isFinish() {
		return finish;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_SPACE) {
			dragon.jump();
		}
		if (code == KeyEvent.VK_ENTER) {
			isPasue = !isPasue;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}

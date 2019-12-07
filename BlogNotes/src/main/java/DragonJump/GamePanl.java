package DragonJump;

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

	private BufferedImage image;// mainly image
	private Graphics2D g2;// paint image
	private Dragon Dragon;// dragon
	boolean finish = false;// game over

	static final int FRESH = 10;// refresh ms

	BackgroundImage background;

	List<Obstacle> list = new ArrayList<Obstacle>();// obstacle collection

	int addObstacleTimer = 0;
	Obstacle ob = new Obstacle();

	int score = 0;// note
	int addScoreTimer = 0;

	// game panel construct function
	public GamePanl() {
		image = new BufferedImage(734, 286, BufferedImage.TYPE_INT_BGR);
		g2 = image.createGraphics();
		Dragon = new Dragon();// instance dragon
		background = new BackgroundImage();// instance background
		list.add(new Obstacle());
		FreshThread t = new FreshThread(this);// refresh thread
		t.start();

	}

	private void painImage() {// paint pictures
		Dragon.move();
		background.roll();
		g2.drawImage(background.image, 0, 0, this);// draw background
		g2.drawImage(background.image_yun1, background.x_yun1, background.y_yun1, this);// draw cloud 1
		g2.drawImage(background.image_yun2, background.x_yun2, background.y_yun2, this);// draw cloud 2
		g2.drawImage(Dragon.image, Dragon.x, Dragon.y, this);// draw dragon

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
				if (o.cactusBounds().intersects(Dragon.bounds1()) || o.cactusBounds().intersects(Dragon.bounds2())) {
					gameOver();// game over
				}
			} else {
				o.move();
				o.bridMove();
				g2.drawImage(o.image, o.x, o.yBird, this);
				// knocking head and food
				if (o.birdBounds().intersects(Dragon.bounds1()) || o.birdBounds().intersects(Dragon.bounds2())) {
					gameOver();// game over
				}
			}

		}
		// score++
		if (addObstacleTimer >= 50) {
			score += 1;
			addScoreTimer = 0;
		}

		// 分数显示代码---"%05d"---指的是分数以五位数显示
		g2.drawString(String.format("%05d", score), 600, 35);
		g2.drawString("Hi", 536, 35);
		g2.drawString(String.format("%05d", +MainFrame.topScore), 550, 35);

		addObstacleTimer += FRESH;
		addScoreTimer += FRESH;
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
			Dragon.jump();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}

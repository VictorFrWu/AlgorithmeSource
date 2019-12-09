package FlappyBirdCopy;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GPanel extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage image;
	BufferedImage image1, image2;
	Pipe p1;
	Pipe p2;
	bird b1;
	private Graphics2D g2;// paint image

	bird b = new bird();

	public GPanel() {
		try {
			image1 = ImageIO.read(new File("lib/background.png"));
			image2 = ImageIO.read(new File("lib/foreground.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1 = new Pipe("north");
		p2 = new Pipe("south");
		b1 = new bird();
		image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		g2 = image.createGraphics();

	}

	protected void painImage() {
		g2.drawImage(image1, 0, 0, this);
		g2.drawImage(image2, 0, 0, this);
		g2.drawImage(p2.image2, p2.x, p2.y, this);
		g2.drawImage(p2.image2, p2.x, p2.y, this);
		g2.drawImage(b1.image, b1.x, b1.y, this);
	}

	@Override
	public void paint(Graphics g) {
		painImage();
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

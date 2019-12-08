package Jframe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class DragonPanel extends JPanel implements KeyListener {
	/**
	 *   
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage image;
	Graphics2D g2;
	BufferedImage image1;
	private Klong klong;
	private boolean finish = false;
	public static int FRESH = 10;

	public DragonPanel() throws IOException {
		image = new BufferedImage(734, 286, BufferedImage.TYPE_INT_RGB);
		g2 = image.createGraphics();
		klong = new Klong();
		image1 = ImageIO.read(new File("image/map.png"));
		klongthread t = new klongthread(this);
		t.start();
	}

	public boolean isFinish() {
		return finish;
	}

	private void paintImage() {
		klong.move();
		g2.drawImage(image1, 0, 0, this);
		g2.drawImage(klong.image, klong.x, klong.y, this);// draw dragon
	}

	@Override
	public void paint(Graphics g) {
		paintImage();
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_SPACE) {
			klong.jump();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}

package FlappyBirdCopy;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class bird {
	public int x;
	public int y;
	public int width;
	public int height;

	public boolean dead;

	public double yvel;
	public double gravity;

	private int jumpDelay;
	private double rotation;

	public BufferedImage image;

	public void set() {
		x = 100;
		y = 150;
		yvel = 0;
		width = 45;
		height = 32;
		gravity = 0.5;
		jumpDelay = 0;
		rotation = 0.0;
		dead = false;

	}

	public bird() {
		set();
		try {
			image = ImageIO.read(new File("lib/bird.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

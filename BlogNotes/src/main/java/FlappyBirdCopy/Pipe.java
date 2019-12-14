package FlappyBirdCopy;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import FlappyBird.App;

public class Pipe {
	public int x;
	public int y;
	public int width = 66;
	public int height = 400;
	public int speed = 3;

	public String orientation;

	public BufferedImage image;
	public BufferedImage imageSouth;
	public BufferedImage imageNorth;

	public Pipe(String orientation) {
		this.orientation = orientation;
		reset();
		try {
			imageNorth = ImageIO.read(new File("lib/pipe-north.png"));
			imageSouth = ImageIO.read(new File("lib/pipe-south.png"));


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reset() {
		// x = App.WIDTH + 2;
		x = 200;
		if (orientation.equals("south")) {
			y = -200;
		}
		if (orientation.equals("north")) {
			y = 400;
		}
	}
}

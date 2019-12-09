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
	public BufferedImage image1;
	public BufferedImage image2;

	public Pipe(String orientation) {
		this.orientation = orientation;
		reset();
		try {
			image1 = ImageIO.read(new File("lib/pipe-north.png"));
			image2 = ImageIO.read(new File("lib/pipe-south.png"));


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

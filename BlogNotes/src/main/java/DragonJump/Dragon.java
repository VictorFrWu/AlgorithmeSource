package DragonJump;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * dragon
 */
public class Dragon {
	public int x, y;// dragon two dimension coordinate
	BufferedImage image;// mainly image
	BufferedImage image1, image2, image3, image_over;
	int stepTime = 0;// time control
	int fresh = GamePanl.FRESH;

	boolean jumpState = false;// jump state
	int jumpHeight = 100;// jump height
	final int LOWEST_Y = 200;// origin position of dragon
	int jumpValue = 5;// jump speed

	public Dragon() {

		try {
			image1 = ImageIO.read(new File("image/long1.png"));
			image2 = ImageIO.read(new File("image/long2.png"));
			image3 = ImageIO.read(new File("image/long3.png"));
			image_over = ImageIO.read(new File("image/over.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		x = 50;// init x
		y = LOWEST_Y;// init y
	}

	public void move() {// move
		step();// mark time
		if (jumpState) {
			// on the ground
			if (y >= LOWEST_Y) {
				jumpValue = -5;
			}
			// in sky
			if (y <= LOWEST_Y - jumpHeight) {
				jumpValue = 5;
			}
			y += jumpValue;
			image = image3;
			if (y >= LOWEST_Y) {
				jumpState = false;
			}

		}
	}

	// mark time
	void step() {
		int tmp = stepTime / 100 % 2;
		if (tmp == 1) {
			image = image1;
		} else {
			image = image2;
		}

		stepTime += fresh;

	}

	public void jump() {// jump
		jumpState = true;
	}

	// touch cactus
	public Rectangle bounds1() {
		return new Rectangle(x + 20, y, 20, 10);
	}

	// touch cactus
	public Rectangle bounds2() {
		return new Rectangle(x + 5, y + 35, 20, 10);
	}

}

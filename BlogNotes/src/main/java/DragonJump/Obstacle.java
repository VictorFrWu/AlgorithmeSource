package DragonJump;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * obstacle
 */
public class Obstacle {
	Dragon Dragon = new Dragon();
	Random r = new Random();
	int x, yCactus, yBird;
	public boolean judge = false;
	BufferedImage image;
	BufferedImage cactus01, cactus02, cactus03, bird1, bird2;// cactus and bird
	int speed = BackgroundImage.SPEED - 1;
	int temp = r.nextInt(4) + 1;// 1-2-3
	int kind = 0;

	public Obstacle() {
		// charge pictures
		try {
			cactus01 = ImageIO.read(new File("image/cactus01.png"));
			cactus02 = ImageIO.read(new File("image/cactus02.png"));
			cactus03 = ImageIO.read(new File("image/cactus03.png"));
			bird1 = ImageIO.read(new File("image/bird1.png"));
			bird2 = ImageIO.read(new File("image/bird2.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		x = 800;
		yCactus = 209;
		yBird = r.nextInt(200);
		// random get obstacle
		switch (temp) {
		case 1:
			image = cactus01;
			kind = 0;
			break;
		case 2:
			image = cactus02;
			kind = 0;
			break;
		case 3:
			image = cactus03;
			yCactus = 200;
			kind = 0;
			break;
		default:
			judge = true;
			kind = 1;
		}

	}

	// bird
	void bridMove() {
		if (judge) {
			int tmp = Dragon.stepTime / 100 % 2;
			if (tmp == 1) {
				image = bird1;
			} else {
				image = bird2;
			}
			Dragon.stepTime += Dragon.fresh;
		}
	}

	// obstacle move
	public void move() {
		x -= speed;
		x -= speed;
	}

	// cactus dead
	public Rectangle cactusBounds() {
		return new Rectangle(x, yCactus + 2, image.getWidth() - 2, image.getHeight() - 10);
	}

	// cactus dead
	public Rectangle birdBounds() {
		return new Rectangle(x, yBird + 2, image.getWidth() - 2, image.getHeight() - 10);
	}

}

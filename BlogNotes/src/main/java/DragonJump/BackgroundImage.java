package DragonJump;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class BackgroundImage {

	BufferedImage image;// mainly image
	BufferedImage image1, image2, image3, image4, image_over, image_yun1, image_yun2;// loop image
	Graphics2D g2;
	int x1, x2;// coordinates of two images
	Random rand = new Random();
	int x_yun1 = 800, y_yun1 = rand.nextInt(100);
	int x_yun2 = 1200, y_yun2 = rand.nextInt(100);
	int x_over = 240, y_over = 50;
	static final int SPEED = 3;// speed of background
	int start = 0;

	public BackgroundImage() {

		try {
			image1 = ImageIO.read(new File("image/map.png"));// ground
			image2 = ImageIO.read(new File("image/map1.png"));// ground
			image3 = ImageIO.read(new File("image/map2.png"));// ground night
			image4 = ImageIO.read(new File("image/map3.png"));// ground night
			image_over = ImageIO.read(new File("image/game_over.png"));
			image_yun1 = ImageIO.read(new File("image/yun.png"));// cloud
			image_yun2 = ImageIO.read(new File("image/yun.png"));// cloud

		} catch (Exception e) {
			e.printStackTrace();
		}
		image = new BufferedImage(734, 286, BufferedImage.TYPE_INT_RGB);
		g2 = image.createGraphics();
		x1 = 0;// first image
		x2 = 734;// second image

		g2.drawImage(image1, x1, 0, null);
		g2.drawImage(image2, x2, 0, null);
	}

	// background roller
	public void roll() {
		x1 -= SPEED;
		x2 -= SPEED;

		// pass first image
		if (x1 <= -734) {
			x1 = 734;
			start++;
		}
		// pass second image
		if (x2 <= -734) {
			x2 = 734;
		}
		x_yun1 -= 1;
		x_yun2 -= 1;
		if (start % 3 == 0 && start != 0) {
			g2.drawImage(image3, x1, 0, null);
			g2.drawImage(image4, x2, 0, null);
		} else {
			g2.drawImage(image1, x1, 0, null);
			g2.drawImage(image2, x2, 0, null);
		}
		if (x_yun1 <= 0) {
			g2.drawImage(image_yun1, x_yun1, y_yun1, null);
			x_yun1 = 750;
		}
		if (x_yun2 <= 0) {
			g2.drawImage(image_yun1, x_yun2, y_yun2, null);
			x_yun2 = 900;
		}
	}

}

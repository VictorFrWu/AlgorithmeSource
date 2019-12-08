package Jframe;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class graphicTest {

	public static void main(String[] args) throws IOException {
		int width = 800;
		int height = 800;
		File file = new File("/Users/mac/Desktop/AlgorithmeSource/BlogNotes/image/map2.png");
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);// RGB形式
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		g2.setBackground(Color.WHITE);// 设置背景色
		g2.clearRect(0, 0, width, height);// 通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
		g2.setPaint(Color.BLUE);// 设置画笔,设置Paint属性
		g2.drawOval(0, 0, 80, 80);
		ImageIO.write(bi, "jpeg", file);
		g2.dispose();
		System.out.println("test");
	}
}

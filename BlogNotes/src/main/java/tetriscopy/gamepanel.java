package tetriscopy;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class gamepanel extends JPanel implements KeyListener {
	private int mapRow = 21;// map height
	private int mapCol = 12;// map width
	private int mapGame[][] = new int[mapCol][mapRow];// create a two dimension array for stocking

	private int score = 0;
	private int topscore = 0;

	static int RectWidth = 20;

	public gamepanel() {
		initMap();// init map
		setWall();
	}

	public void initMap()// init map，wall is 2，whitespace is 0，square is 1
	{
		for (int i = 0; i < mapCol; i++) {
			for (int j = 0; j < mapRow; j++) {
				mapGame[i][j] = 0;
			}
		}
	}

	public void setWall()// set wall O,11 column and 20 row is wall
	{
		for (int i = 0; i < mapRow; i++)// paints wall of column
		{
			mapGame[0][i] = 2;
			mapGame[11][i] = 2;
		}
		for (int j = 1; j < mapCol - 1; j++)// paint wall of row
		{
			mapGame[j][20] = 2;
		}
	}

	@Override
	public void paint(Graphics g)// repaint
	{
		super.paint(g);

		for (int i = 0; i < mapCol; i++)// draw wall and react has existed in image
		{
			for (int j = 0; j < mapRow; j++) {
				if (mapGame[i][j] == 2)// draw wall
				{
					g.drawRect((i + 1) * RectWidth, (j + 1) * RectWidth, RectWidth, RectWidth);
				}
				if (mapGame[i][j] == 1)// draw rectangle
				{
					g.fillRect((i + 1) * RectWidth, (j + 1) * RectWidth, RectWidth, RectWidth);
				}
			}
		}
		g.drawString("score = " + score, 270, 50);
		g.drawString("top score = " + topscore, 270, 90);
		g.drawString("the next rectangle：", 270, 140);

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

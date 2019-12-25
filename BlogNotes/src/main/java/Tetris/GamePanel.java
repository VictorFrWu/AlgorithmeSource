package Tetris;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mapRow = 21;// map height
	private int mapCol = 12;// map width
	private int mapGame[][] = new int[mapCol][mapRow];// create a two dimension array for stocking

	private Timer timer;
	private int score = 0;// record score
	private int topscore = 0;

	Random random = new Random();
	private int curShapeType = -1;
	private int curShapeState = -1;// set current shape
	private int nextShapeType = -1;
	private int nextShapeState = -1;// set next shape

	// init position
	private int posx = 0;
	private int posy = 0;

	/*
	 * there are 7 types of shape, and set theirs state three dimension, first
	 * dimension for which type of shape
	 * 
	 * second and dimension save the position of shape, maximum shape can have four
	 * state
	 */
	utils u = new utils();
	int[][][] shapes = utils.Shapes;

	private int rowRect = 4;
	private int colRect = 4;// each shape state will display by a 4*4 matrix
	static int RectWidth = 20;

	public GamePanel()// constructor create map
	{
		createRect();
		initMap();// init map
		setWall();// set wall
		timer = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDown();
			}
		});
		timer.start();
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

	public void initMap()// init map，wall is 2，whitespace is 0，square is 1
	{
		for (int i = 0; i < mapCol; i++) {
			for (int j = 0; j < mapRow; j++) {
				mapGame[i][j] = 0;
			}
		}
	}

	public void createRect()// create square
	{
		if (curShapeType == -1 && curShapeState == -1)// if type and state equal to 1, it means start game
		{
			curShapeType = random.nextInt(shapes.length);
			curShapeState = random.nextInt(shapes[0].length);
		} else {
			curShapeType = nextShapeType;
			curShapeState = nextShapeState;
		}
		// nextShapeType = random.nextInt(shapes.length);
		nextShapeType = random.nextInt(shapes.length);
		nextShapeState = random.nextInt(shapes[0].length);
		posx = 1;
		posy = 0;// left top for creating new shape
		if (gameOver(posx, posy, curShapeType, curShapeState)) {
			repaint();
			Container c = this.getParent();
			while (!(c instanceof GameFrame)) {
				c = c.getParent();
			}
			GameFrame f = (GameFrame) c;
			int dialogResult = JOptionPane.showConfirmDialog(f, "Are you want to restart this game?", "Game over?",
					JOptionPane.OK_CANCEL_OPTION);
			if (dialogResult == JOptionPane.OK_OPTION) {
				newGame();
			} else {
				System.exit(0);// close application
			}
		}
	}

	public boolean isOrNoMove(int x, int y, int ShapeType, int ShapeState)// check this shape can move or not
	{
		for (int i = 0; i < colRect; i++) {
			for (int j = 0; j < rowRect; j++) {
				if (shapes[ShapeType][ShapeState][i * colRect + j] == 1 && mapGame[x + i][y + j] == 1
						|| shapes[ShapeType][ShapeState][i * colRect + j] == 1 && mapGame[x + i][y + j] == 2) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean gameOver(int x, int y, int ShapeType, int ShapeState)// check game over or not
	{
		if (isOrNoMove(x, y, ShapeType, ShapeState)) {
			return false;
		}
		return true;
	}

	public void turn()// rotate
	{
		int temp = curShapeState;
		curShapeState = (curShapeState + 1) % shapes[0].length;
		if (isOrNoMove(posx, posy, curShapeType, curShapeState)) {
		} else {
			curShapeState = temp;
		}
		repaint();
	}

	public void moveDown()// move down
	{
		if (isOrNoMove(posx, posy + 1, curShapeType, curShapeState)) {
			posy++;
		} else {
			addToMap();// add to map
			checkLine();
			createRect();// repaint a new rectangle
		}
		repaint();
	}

	public void moveLeft()// move to left
	{
		if (isOrNoMove(posx - 1, posy, curShapeType, curShapeState)) {
			posx--;
		}
		repaint();
	}

	public void moveRight()// move to right
	{
		if (isOrNoMove(posx + 1, posy, curShapeType, curShapeState)) {
			posx++;
		}
		repaint();
	}

	public void addToMap()// add rectangle to map
	{
		for (int i = 0; i < colRect; i++) {
			for (int j = 0; j < rowRect; j++) {
				if (shapes[curShapeType][curShapeState][i * colRect + j] == 1) {
					mapGame[posx + i][posy + j] = shapes[curShapeType][curShapeState][i * colRect + j];
				}
			}
		}
	}

	public void checkLine()// check there is a row fill of 1
	{
		int count = 0;
		for (int i = mapRow - 2; i >= 0; i--) {
			count = 0;
			for (int j = 1; j < mapCol - 1; j++) {
				if (mapGame[j][i] == 1) {
					count++;
				} else
					break;
			}
			if (count >= mapCol - 2) { // exist a row of full 1
				for (int k = i; k > 0; k--) {
					for (int p = 1; p < mapCol - 1; p++) {
						mapGame[p][k] = mapGame[p][k - 1];
					}
				}
				score += 10;
				i++;
			}
		}
	}

	@Override
	public void paint(Graphics g)// repaint
	{
		super.paint(g);
		for (int i = 0; i < rowRect; i++)// draw rectangle who is falling
		{
			for (int j = 0; j < colRect; j++) {
				if (shapes[curShapeType][curShapeState][i * colRect + j] == 1) {
					g.fillRect((posx + i + 1) * RectWidth, (posy + j + 1) * RectWidth, RectWidth, RectWidth);
				}
			}
		}
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
		// draw the next shape
		for (int i = 0; i < colRect; i++) {
			for (int j = 0; j < rowRect; j++) {
				if (shapes[nextShapeType][nextShapeState][i * colRect + j] == 1) {
					g.fillRect(270 + (i * RectWidth), 200 + (j * RectWidth), RectWidth, RectWidth);
				}
			}
		}
	}

	public void newGame()// restartGame
	{
		topscore = score > topscore ? score : topscore;
		score = 0;
		initMap();
		setWall();
		createRect();
		repaint();
	}

	public void stopGame()// suspend timer thread
	{
		timer.stop();
	}

	public void continueGame() {// continue time thread
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:// rotate up
			turn();
			break;
		case KeyEvent.VK_DOWN:// rotate down
			moveDown();
			break;
		case KeyEvent.VK_LEFT:// left move
			moveLeft();
			break;
		case KeyEvent.VK_RIGHT:// right move
			moveRight();
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

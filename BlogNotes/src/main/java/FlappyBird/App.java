package FlappyBird;

import javax.swing.*;

public class App {

    public static int WIDTH = 500;
    public static int HEIGHT = 520;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle("Falppy Bird");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        Keyboard keyboard = Keyboard.getInstance();
        frame.addKeyListener(keyboard);
        GamePanel panel = new GamePanel();
        frame.add(panel);
    }
}

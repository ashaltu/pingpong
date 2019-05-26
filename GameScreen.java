
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GameScreen extends JPanel implements KeyListener {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final Color backgroundColor = new Color(68, 158, 60);
	private int speed = 20;
	private Paddle pad1, pad2;
	private Ball ball;
	private int player1Score, player2Score;

	public GameScreen() {
		setFocusable(true);
		addKeyListener(this);
		Rectangle box1 = new Rectangle(30, 250, 25, 100);
		Rectangle box2 = new Rectangle(WIDTH - 30 - box1.width, 250, 25, 100);
		Rectangle ballBox = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		pad1 = new Paddle(box1, true, Color.PINK);
		pad2 = new Paddle(box2, true, Color.CYAN);
		ball = new Ball(this, ballBox, 1, 1);
		reset();
	}

	public void reset() {
		Rectangle ballBox = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		ball = new Ball(this, ballBox, 1, 1);
	}

	public void paint(Graphics g) {
		// Update
		ball.update(pad1, pad2);

		// Draw
		g.setColor(backgroundColor);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		pad1.draw(g);
		pad2.draw(g);
		ball.draw(g);

		repaint();

	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		System.out.println("DEBUG");
		if (e.getKeyCode() == KeyEvent.VK_W) {
			pad1.moveY(-speed);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			pad1.moveY(speed);
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			pad2.moveY(-speed);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			pad2.moveY(speed);
		}

	}

	public void keyReleased(KeyEvent e) {

	}

}

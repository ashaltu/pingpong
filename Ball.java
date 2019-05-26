
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {

	private Rectangle ball;
	private int vx, vy;
	private GameScreen screen;

	public Ball(GameScreen screen, Rectangle ball, int vx, int vy) {
		this.screen = screen;
		this.ball = ball;
		this.vx = vx;
		this.vy = vy;
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(ball.x, ball.y, ball.width, ball.height);
	}

	public void update(Paddle pad1, Paddle pad2) {
		// Add direction vector to position of ball
		ball.x += vx;
		ball.y += vy;

		// Left and Right Wall Collision Detection
		if (ball.x <= 0 || ball.x >= GameScreen.WIDTH - ball.width) {
			screen.reset();
		}

		// Bottom and Top Wall Collision Detection
		if (ball.y <= 0 || ball.y >= GameScreen.HEIGHT - ball.height) {
			vy = -vy;
		}

		// Right Paddle Collision
		if (vx > 0) {
			if ((ball.x + ball.width >= pad2.getBox().x) && (ball.y < pad2.getBox().y + pad2.getBox().height)
					&& (ball.y + ball.height > pad2.getBox().height)) {
				vx = -vx;
			}
		} else if (vx < 0) {
			// Left Paddle Collision
			if ((ball.x <= pad1.getBox().x + pad1.getBox().width) && (ball.y < pad1.getBox().y + pad1.getBox().height)
					&& (ball.y + ball.height > pad1.getBox().height)) {
				vx = -vx;
			}
		}

	}

	public Rectangle getBall() {
		return ball;
	}

}

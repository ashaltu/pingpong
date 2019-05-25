import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball implements KeyListener{

	private Rectangle ball;
	private int vx, vy;
	private GameScreen screen;
	
	public Ball(GameScreen screen, Rectangle ball, int vx, int vy) {
		this.ball = ball;
		this.vx = vx;
		this.vy = vy;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(ball.x, ball.y, ball.width, ball.height);
	}
	
	public void update(Paddle pad1, Paddle pad2) {
		//Add direction vector to position of ball
		ball.x += vx;
		ball.y += vy;
		
		//Left and Right Wall Collision Detection
		if(ball.x <= 0 || ball.x >= GameScreen.WIDTH-ball.width) {
			//Update GameScreen Score
		}
		
		//Bottom and Top Wall Collision Detection
		if(ball.y <= 0 || ball.y >= GameScreen.HEIGHT-ball.height) {
			vy = -vy;
		}
		
		//Right Paddle Collision
		if(vx > 0) {
			if((ball.x+ball.width >= pad2.x) && (ball.y < pad2.y + pad2.height) && (ball.y + ball.height > pad2.y)) {
				vx = -vx;
			}
		}else if (vx < 0){
			//Left Paddle Collision
			if((ball.x <= pad1.x + pad1.width) && (ball.y < pad1.y + pad1.height) && (ball.y + ball.height > pad1.y)) {
				vx = -vx;
			}
		}
		
	}
	
	public Rectangle getBall() {
		return ball;
	}
	
}


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle{
   private Rectangle box;
   private boolean player1;
   private Color color;
   
   public Paddle(Rectangle box, boolean player1, Color color) {
      this.box = box;
      this.player1 = player1;
      this.color = color;
   }
   
   
   public void draw(Graphics g) {
      g.setColor(color);
      g.fillRect(box.x, box.y, box.width, box.height);
   }
   
   public Rectangle getBox() {
      return box;
   }

   public void moveY(int Y) {
	   box.y += Y; 
   } 

}
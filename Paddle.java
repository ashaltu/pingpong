import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle implements KeyListener {
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
   
   public void keyTyped(KeyEvent e) {
   
   }
   
   public void keyPressed(KeyEvent e) {
      if (player1) {
         if (e.getKeyCode() == KeyEvent.VK_W) {
            box.y -= 5;
         } else if (e.getKeyCode() == KeyEvent.VK_S) {
            box.y += 5;
         }
      } else {
         if (e.getKeyCode() == KeyEvent.VK_UP) {
            box.y -= 5;
         } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            box.y += 5;
         }

      }
      
   }

   public void keyReleased(KeyEvent e) {
   
   }

   

}
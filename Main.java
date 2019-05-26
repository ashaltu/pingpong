import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame("Ping Pong");
		GameScreen screen = new GameScreen();
		window.setSize(800, 600);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(screen);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}

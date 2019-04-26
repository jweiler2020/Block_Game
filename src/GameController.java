import java.awt.event.*;
import javax.swing.*;

public class GameController
	implements ActionListener, KeyListener
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	private static long timeStart;
	private static double dt;
	
	private static GameWindow game;
	
	public GameController()
	{
		game = new GameWindow(WIDTH, HEIGHT);
		game.setBounds(200, 200, WIDTH, HEIGHT);
		game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		game.setResizable(false);
		game.setVisible(true);
		
		new Timer((int)(1000/60f), this).start();
		timeStart = System.nanoTime();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		dt = (System.nanoTime() - timeStart)/1000000000f;
		System.out.println("test");
		game.repaint(dt);
		timeStart = System.nanoTime();
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e)
	{
		// TODO: implement block moving also just create the block class too
	}
	public void keyReleased(KeyEvent e) {}
	
	public static void main(String[] args)
	{
		new GameController();
	}
}

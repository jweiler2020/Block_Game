import java.awt.*;
import javax.swing.*;

public class Game extends JFrame
{
	private JPanel canvas;
	
	public Game()
	{
		super("Block Game 2019 Edition™");
		
		canvas = new JPanel();
		canvas.setBackground(Color.WHITE);
		
		getContentPane().add(canvas);
	}
	
	public static void main(String[] args)
	{
		Game win = new Game();
		win.setBounds(200, 200, 800, 600);
		win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		win.setResizable(false);
		win.setVisible(true);
	}
}

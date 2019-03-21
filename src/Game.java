import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game extends JFrame
	implements ActionListener
{
	private int i = 0;
	
	public Game()
	{
		super("Block Game 2019 Edition™");
		
		new Timer((int)(1000/60f), this).start();
	}
	
	public void paint(Graphics g)
	{
		setBackground(Color.WHITE);
		
		int w = getWidth();
		int h = getHeight();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.BLACK);
		
		g.fillRect(w/4 + i, h/4+i, w/2, h/2);
		i++;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		repaint();
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

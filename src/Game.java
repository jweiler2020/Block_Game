import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game extends JFrame
	implements ActionListener
{
	private Image backImage;
	private static final int w = 800;
	private static final int h = 600;
	
	private long timeStart;
	
	private double x, y;
	
	public Game()
	{
		super("Block Game 2019 Edition™");
		
		new Timer((int)(1000/60f), this).start();
		timeStart = System.nanoTime();
	}
	
	public void paint(Graphics g)
	{
		if(backImage == null || backImage.getWidth(null) != w || backImage.getHeight(null) != h)
			backImage = createImage(w, h);
		
		Graphics imgG = backImage.getGraphics();
		super.paint(imgG);
		draw(imgG);
		
		g.drawImage(backImage, 0, 0, null);
	}
	
	private void draw(Graphics g)
	{
		double dt = (System.nanoTime() - timeStart)/1000000000f;
		g.fillRect((int)x, (int)y, w/4, h/4);
		x += 20*dt;
		y += 20*dt;
		timeStart = System.nanoTime();
	}
	
	public void actionPerformed(ActionEvent e) { repaint(); }
	
	public static void main(String[] options)
	{
		Game win = new Game();
		win.setBounds(200, 200, w, h);
		win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		win.setResizable(false);
		win.setVisible(true);
	}
}

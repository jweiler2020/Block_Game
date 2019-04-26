import java.awt.*;
import javax.swing.*;

public class GameWindow extends JFrame
{
	private Image backImage;
	
	private final int w, h;
	
	private double dt;
	
	private double x, y;
	
	public GameWindow(int w, int h)
	{
		super("Block Game 2019 Edition™");
		this.w = w;
		this.h = h;
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
		// TODO: do actual things here rather than just moving a single block
		g.fillRect((int)x, (int)y, w/4, h/4);
		x += 20*dt;
		y += 20*dt;
	}
	
	public void repaint(double dt)
	{
		this.dt = dt;
		super.repaint();
	}
}

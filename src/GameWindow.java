import java.awt.*;
import javax.swing.*;

public class GameWindow extends JFrame
{
	private Image backImage;
	
	private final int w, h;
	private final Block[] blocks;

	private boolean gameOver = false;

	public GameWindow(int w, int h, GameController gc,  Block[] blocks)
	{
		super("Block Game 2019 Edition™");
		this.w = w;
		this.h = h;
		this.addKeyListener(gc);
		this.blocks = blocks;
	}

	public void gameOver()
	{
		gameOver = true;
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
		if(!gameOver)
		{
			for (Block b : blocks)
			{
				b.draw(g);
			}
		}
		else
		{
			g.setFont(new Font("Helvetica", Font.PLAIN, w/8));
			FontMetrics fm = g.getFontMetrics();
			int width = fm.stringWidth("Game Over");
			int height = fm.getHeight();
			g.drawString("Game Over", w/2-width/2, h/2+height/4);
		}
	}
}

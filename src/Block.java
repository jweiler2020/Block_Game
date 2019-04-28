import java.awt.*;

public abstract class Block
{
	protected double x, y;
	protected int w, h;
	protected Color c;

	public Block(double x, double y, int w, int h, Color c)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}

	public void draw(Graphics g)
	{
		Color prevC = g.getColor();
		g.setColor(c);
		g.fillRect((int)x, (int)y, w, h);
		g.setColor(prevC);
	}

	public boolean touching(Block b)
	{
		/*
		 * Variable naming format is as follows:
		 * (block letter)(x/y)(point number)
		 * block letter: which block does the point belong to?
		 * x/y: is the point an x or y point?
		 * point number: is it the greater or lesser point?
		 */
		// Block a (this)
		double ax0 = x;
		double ax1 = x + w;
		double ay0 = y;
		double ay1 = y + h;
		// Block b (b)
		double bx0 = b.getX();
		double bx1 = b.getX() + b.getW();
		double by0 = b.getY();
		double by1 = b.getY() + b.getH();

		// Actual detection
		//             detect point 0 between      detect point 0 between
		boolean detX = (ax0 > bx0 && ax0 < bx1) || (ax1 > bx0 && ax1 < bx1);
		boolean detY = (ay0 > by0 && ay0 < by1) || (ay1 > by0 && ay1 < by1);

		return detX && detY;
	}

	// Setter methods should be implemented in subclasses

	public double getX() { return x; }
	public double getY() { return y; }
	public int getW() { return w; }
	public int getH() { return h; }
}

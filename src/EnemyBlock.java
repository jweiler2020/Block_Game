import java.awt.*;

public class EnemyBlock extends Block
{
	private double s;
	public EnemyBlock(double x, double y, int w, int h, double s, Color c)
	{
		super(x, y, w, h, c);
		this.s = s;
	}

	public void setX(double x) { this.x = x; }

	public void setY(double y) { this.y = y; }
	public void changeY(double dy) { this.y += dy; }

	public void setS(double s) { this.s = s; }
	public double getS() { return s; }
}

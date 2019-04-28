import java.awt.*;

public class PlayerBlock extends Block
{
	public PlayerBlock(double x, double y, int w, int h, Color c)
	{
		super(x, y, w, h, c);
	}

	public void setX(double x) { this.x = x; }
	public void changeX(double dx) { x += dx; }
}

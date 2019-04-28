import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameController
	implements ActionListener, KeyListener
{
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	
	private long timeStart;

	private PlayerBlock p;
	private final double playerSpeed = 500;
	private final int playerWidth = 30;
	private final int playerHeight = 30;
	private final Color playerColor = Color.BLACK;
	private int playerMove = 0;

	private final double enemySpeed = 500;
	private final int enemyCount = 20;
	private final int enemyWidth = 30;
	private final int enemyHeight = 30;
	private final Color enemyColor = Color.RED;
	private EnemyBlock[] enemyBlocks = new EnemyBlock[enemyCount];
	
	private GameWindow game;
	
	public GameController()
	{
		p = new PlayerBlock(WIDTH/2f-(playerWidth)/2f, HEIGHT*(5/6f), playerWidth, playerHeight, playerColor);

		Block[] blocks = new Block[1 + enemyCount];
		blocks[0] = p;
		for(int i = 0; i < enemyCount; i++)
		{
			EnemyBlock b = new EnemyBlock(Math.random()*WIDTH, 0, enemyWidth, enemyHeight, enemySpeed + 50*(2*Math.random()-1), enemyColor);
			blocks[i+1] = b;
			enemyBlocks[i] = b;
		}

		game = new GameWindow(WIDTH, HEIGHT, this, blocks);
		game.setBounds(200, 200, WIDTH, HEIGHT);
		game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		game.setResizable(false);
		game.setVisible(true);

		new Timer((int)(1000/60f), this).start();
		timeStart = System.nanoTime();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		double dt = (System.nanoTime() - timeStart)/1000000000f;

		p.changeX(playerMove*playerSpeed*dt);
		if(p.getX() < 0)
			p.setX(0);
		else if(p.getX() > WIDTH - p.getW())
			p.setX(WIDTH - p.getW());

		for(EnemyBlock b : enemyBlocks)
		{
			b.changeY(b.getS()*dt);
			if(b.getY() > HEIGHT)
			{
				b.setX(Math.random()*WIDTH);
				b.setY(-b.getH());
				b.setS(b.getS()*1.01 + 10*(2*Math.random()-1));
			}
			if(p.touching(b))
				System.out.println("touching block");
		}

		game.repaint();
		timeStart = System.nanoTime();
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
			playerMove = -1;
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
			playerMove = 1;
	}
	public void keyReleased(KeyEvent e)
	{
		if((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) && playerMove == -1)
			playerMove = 0;
		else if((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) && playerMove == 1)
			playerMove = 0;
	}
	public void keyTyped(KeyEvent e) {}

	public static void main(String[] args)
	{
		new GameController();
	}
}

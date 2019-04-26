import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartWindow extends JFrame
	implements ActionListener
{
	private JButton playGameButton, settingsButton, quitButton;
	private JButton backToMainButton;
	private JPanel mainPanel, settingsPanel;
	private CardLayout cl = new CardLayout();
	
	public StartWindow(String title)
	{
		super(title);
		
		// Useful objects
		Font labelFont = new Font("Arial", Font.BOLD, 20);
		Font buttonFont = new Font("Arial", Font.PLAIN, 15);
		GridBagConstraints c = new GridBagConstraints();
		
		//----------------------------Start Main Panel------------------------------//
		JLabel mainPanelLabel = new JLabel("Block Game 2019 Edition™", JLabel.CENTER);
		mainPanelLabel.setFont(labelFont);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		
		playGameButton = new JButton("Play");
		playGameButton.addActionListener(this);
		playGameButton.setFont(buttonFont);
		
		settingsButton = new JButton("Settings");
		settingsButton.addActionListener(this);
		settingsButton.setFont(buttonFont);
		
		quitButton = new JButton("Quit");
		quitButton.addActionListener(this);
		quitButton.setFont(buttonFont);
		
		c.weightx = 1;
		c.weighty = 1 / 3d;
		c.insets = new Insets(5, 0, 5, 0);
		c.gridx = 0;
		
		c.gridy = 0;
		buttonPanel.add(playGameButton, c);
		c.gridy++;
		buttonPanel.add(settingsButton, c);
		c.gridy++;
		buttonPanel.add(quitButton, c);
		
		
		mainPanel = new JPanel();
		mainPanel.setName("mainPanel");
		mainPanel.setLayout(new GridBagLayout());
		
		c.weightx = 1;
		c.weighty = 0.5;
		c.gridx = 0;
		c.insets = new Insets(0, 0, 0, 0);
		
		c.gridy = 0;
		mainPanel.add(mainPanelLabel, c);
		c.gridy++;
		mainPanel.add(buttonPanel, c);
		//----------------------------End Main Panel--------------------------------//
		
		
		//----------------------------Start Settings Panel--------------------------//
		JLabel settingsPanelLabel = new JLabel("Settings");
		settingsPanelLabel.setFont(labelFont);
		
		
		backToMainButton = new JButton("Back to Main Menu");
		backToMainButton.addActionListener(this);
		backToMainButton.setFont(buttonFont);
		
		
		settingsPanel = new JPanel();
		settingsPanel.setName("settingsPanel");
		settingsPanel.setLayout(new GridBagLayout());
		
		c.weightx = 1;
		c.weighty = 0.5;
		c.gridx = 0;
		
		c.gridy = 0;
		settingsPanel.add(settingsPanelLabel, c);
		c.gridy++;
		settingsPanel.add(backToMainButton, c);
		//---------------------------End Settings Panel-----------------------------//
		
		Container con = getContentPane();
		con.setLayout(cl);
		con.add(mainPanel, mainPanel.getName());
		con.add(settingsPanel, settingsPanel.getName());
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == playGameButton)
		{
			new GameController();
			dispose();
		} else if (e.getSource() == settingsButton)
		{
			cl.show(getContentPane(), settingsPanel.getName());
		} else if (e.getSource() == quitButton)
		{
			System.exit(0);
		} else if (e.getSource() == backToMainButton)
		{
			cl.show(getContentPane(), mainPanel.getName());
		}
	}
	
	public static void main(String[] args)
	{
		StartWindow win = new StartWindow("Block Game 2019 Edition™");
		win.setBounds(200, 200, 400, 300);
		win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		win.setResizable(false);
		win.setVisible(true);
	}
}

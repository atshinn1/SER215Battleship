/* 
Name: Game Window
Author: Joshua Becker
Create On: 10/26/15
Contributors:
 */

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.ImageIcon.*;
import javax.swing.JFrame;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class GameWindow
{
	private JFrame m_Game_F, m_OldWindow_F;
	private int m_ScreenWidth, m_ScreenHeight;
	private JButton m_Options_B, m_Exit_B;
	private JComboBox<String> m_NumOfPly_CB, m_AIDiff_CB;
	private JLabel m_Background_L, m_Instructions_L, m_Header_L;
	private JPanel m_GameBoards_P;
	private Game m_CurrentGame;
	private Player m_CurrentPlayer;
	private Ship m_CurrentShip;
	private LoadAssets m_Assets;
	
    public GameWindow(Game game, LoadAssets assets, JFrame window)// constructer
    {
		m_CurrentGame = game;
		m_CurrentPlayer = game.getPlayer("Player 1");
		m_CurrentPlayer.setTargetBoard();
		
		m_OldWindow_F = window;
		
		m_Assets = assets;
		
		createComponents();
		
		buildComponents();
		
		addActionListeners();
		
		addElements();
	}
	/**createComponents
	* creates components and gives them
	* default values.
	**/
	public void createComponents()
	{
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();// geting size of screen
		m_ScreenWidth = gd.getDisplayMode().getWidth();
		m_ScreenHeight = gd.getDisplayMode().getHeight();
		
		m_Background_L = new JLabel(m_Assets.getImage("GameBG"));
		m_Instructions_L = new JLabel(m_Assets.getImage("Instructions"));
		m_Header_L = new JLabel(m_Assets.getImage("Instructions"));
		m_GameBoards_P = new JPanel();
		
		m_Options_B = new JButton("Options");
		
		m_Game_F = new JFrame("GamePlay");
	}
	/**buildComponents
	* set up components and there attributes.
	**/
	public void buildComponents()
	{
		m_Game_F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		m_Background_L.setLayout(new BoxLayout(m_Background_L, BoxLayout.Y_AXIS));
		m_GameBoards_P.setLayout(new BoxLayout(m_GameBoards_P, BoxLayout.X_AXIS));
		m_Instructions_L.setLayout(new BoxLayout(m_Instructions_L, BoxLayout.Y_AXIS));
		
		m_Header_L.setPreferredSize(new Dimension(m_ScreenWidth, 20));
		m_GameBoards_P.setPreferredSize(new Dimension(1200, 700));
		//m_GameBoards_P.setMaximumSize(new Dimension(m_ScreenWidth, 700));
		
		m_Game_F.setUndecorated(true);
        m_Game_F.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		m_Game_F.setSize(new Dimension(m_ScreenWidth,m_ScreenHeight));
	}
	/**addElements
	* add components to panels and
	* adds panels to Frame
	**/
	public void addElements()
	{
		setKeyBind();
		
		JLabel instructions[] = {new JLabel("Use the Arrow Keys to move the ship"), new JLabel("Press the Space Bar to change the oriantation"), 
								 new JLabel("Press Enter to Place the Ship"), new JLabel("Press Esc to quit")};
		instructions[0].setAlignmentX(Component.CENTER_ALIGNMENT);
		instructions[1].setAlignmentX(Component.CENTER_ALIGNMENT);
		instructions[2].setAlignmentX(Component.CENTER_ALIGNMENT);
		instructions[3].setAlignmentX(Component.CENTER_ALIGNMENT);
		
		instructions[0].setForeground(Color.WHITE);
		instructions[1].setForeground(Color.WHITE);
		instructions[2].setForeground(Color.WHITE);
		instructions[3].setForeground(Color.WHITE);	
		
		m_Instructions_L.add(new JLabel("\n"));
		m_Instructions_L.add(instructions[0]);
		m_Instructions_L.add(instructions[1]);
		m_Instructions_L.add(instructions[2]);
		m_Instructions_L.add(instructions[3]);
		
		JPanel board = m_CurrentPlayer.getBoard();
		
		board.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		m_GameBoards_P.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_Instructions_L.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_Header_L.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		m_GameBoards_P.add(m_CurrentPlayer.getBoard());
		//m_GameBoards_P.add(m_CurrentGame.getPlayer("Player 2").getBoard());
		
		m_Background_L.add(m_Header_L);
		m_Background_L.add(new JLabel("\n"));
		m_Background_L.add(new JLabel("\n"));
		m_Background_L.add(board);
		m_Background_L.add(new JLabel("\n"));
		m_Background_L.add(new JLabel("\n"));
		m_Background_L.add(m_Instructions_L);
		
		m_Game_F.add(m_Background_L);
		
		m_Game_F.pack();
		
		m_Game_F.setVisible(true);
	}
	/**addActionListeners
	* adds ActionListener, which wait till
	* an action is Performed then sends 
	* a event to the type of listener.
	**/
	private void addActionListeners()
	{
		m_Options_B.addActionListener(new ButtonListener());
	}

	/**Listeners
	* Once an event occurs the program goes here
	* and decides what to do with each event.
	**/
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = event.getActionCommand();
			switch(command)
			{
				case "Settings_B":
					break;
				case "Exit_B":
					break;
			}
		}  
	}
	
	private class ComboListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = event.getActionCommand();
			switch(command)
			{
			// create default error message
			}
		}
	}
	/**setKeyBind
	* maps the key strokes with there actions
	* and decides what to do with each event.
	**/
	private class KeyAction extends AbstractAction
    {
		private String m_Command;
		KeyAction()
		{
			
		}
		
		KeyAction(String command)
		{
			m_Command = command;
		}
        public void actionPerformed(ActionEvent event)
        {
			if(m_Command.compareTo("EXIT") == 0)
			{
				System.exit(1);// DOUBLE CHECK WHERE TO SEND...
			}
		}
    }
	/**setKeyBind
	* maps the key strokes with there actions
	* and decides what to do with each event.
	**/
	private void setKeyBind()
	{
		m_Background_L.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),"EXIT");
		m_Background_L.getActionMap().put( "EXIT", new KeyAction("EXIT"));
	}
}

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
import javax.swing.text.*;

public class GameWindow
{
	private JFrame m_Game_F, m_OldWindow_F;
	private int m_ScreenWidth, m_ScreenHeight;
	private JButton m_Options_B, m_Exit_B;
	private JLabel m_Background_L, m_Footer_L, m_Header_L;
	private JTextArea m_ActionConsole_TA, m_Chat_TA;
	private JLabel m_CurrentPlayerStats_L, m_OtherPlayerStats_L;
	private DefaultCaret m_ActionConsolesCaret;
	private JScrollPane m_ActionConsole_SP;
	private JLabel m_Boards_P;
	private Game m_CurrentGame;
	private LoadAssets m_Assets;
	
    public GameWindow(Game game, LoadAssets assets, JFrame oldWindow)// constructer
    {
		m_CurrentGame = game;
		
		m_OldWindow_F = oldWindow;
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
		
		m_ActionConsole_TA = new JTextArea("", 100, 20);
		m_Chat_TA = new JTextArea("Press 't' to talk", 50, 4);
		
		m_ActionConsolesCaret = new DefaultCaret();
		m_ActionConsole_SP = new JScrollPane(m_ActionConsole_TA);
		
		m_Background_L = new JLabel(m_Assets.getImage("GameBG"));
		m_Footer_L = new JLabel(m_Assets.getImage("GameBoardBlank"));
		m_Header_L = new JLabel(m_Assets.getImage("Instructions"));
		
		m_CurrentPlayerStats_L = new JLabel("");
		m_OtherPlayerStats_L = new JLabel("");
		
		m_Boards_P = new JLabel(m_Assets.getImage("GameBoardBlank"));
		
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
		
		BorderLayout layout = new BorderLayout();
		layout.setHgap(650);
		
		m_Footer_L.setLayout(layout);
		m_Header_L.setLayout(new GridLayout(1,2,0,0));
		
		FlowLayout layout2 = new FlowLayout();
		layout2.setHgap((m_ScreenWidth -(m_CurrentGame.getCurrentPlayer().getBoard().getWidth()*2))/3);//getting a third spacing to center each window
		
		m_Boards_P.setLayout(layout2);
		
		m_Footer_L.setPreferredSize(new Dimension(m_ScreenWidth, 100));
		m_Footer_L.setMaximumSize(new Dimension(m_ScreenWidth, 100));
		m_Footer_L.setMinimumSize(new Dimension(m_ScreenWidth, 100));
		
		m_Header_L.setPreferredSize(new Dimension(m_ScreenWidth, 100));
		m_Header_L.setMaximumSize(new Dimension(m_ScreenWidth, 100));
		
		m_ActionConsole_TA.setPreferredSize(new Dimension(200, 100));
		m_ActionConsole_TA.setMaximumSize(new Dimension(200, 100));
		m_ActionConsole_TA.setEditable(false);
		m_ActionConsole_TA.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_ActionConsole_TA.setBackground(new Color(4, 9, 15));
		m_ActionConsole_TA.setForeground(Color.WHITE);
		m_ActionConsole_TA.setWrapStyleWord(true);
		m_ActionConsole_TA.setLineWrap(true);
		
		m_ActionConsole_SP.setPreferredSize(new Dimension(400, 100));
		m_ActionConsole_SP.setMaximumSize(new Dimension(400, 100));
		
		m_ActionConsolesCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		m_ActionConsole_TA.setCaret(m_ActionConsolesCaret);
		
		m_Chat_TA.setPreferredSize(new Dimension(200, 100));
		m_Chat_TA.setMaximumSize(new Dimension(200, 100));
		m_Chat_TA.setEditable(false);
		m_Chat_TA.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_Chat_TA.setBackground(new Color(4, 9, 15));
		m_Chat_TA.setForeground(Color.WHITE);
		
		m_CurrentPlayerStats_L.setLayout(new BoxLayout(m_CurrentPlayerStats_L, BoxLayout.Y_AXIS));
		m_OtherPlayerStats_L.setLayout(new BoxLayout(m_OtherPlayerStats_L, BoxLayout.Y_AXIS));
		
		
		m_Boards_P.setPreferredSize(new Dimension(m_ScreenWidth,m_CurrentGame.getCurrentPlayer().getBoard().getHeight()));
		m_Boards_P.setMinimumSize(new Dimension(m_CurrentGame.getCurrentPlayer().getBoard().getWidth()*2,m_CurrentGame.getCurrentPlayer().getBoard().getHeight()));
		m_Boards_P.setMaximumSize(new Dimension(m_ScreenWidth,m_CurrentGame.getCurrentPlayer().getBoard().getHeight()));
		
		m_Game_F.setUndecorated(true);
        m_Game_F.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		m_Game_F.setSize(new Dimension(m_ScreenWidth,m_ScreenHeight));
		
		updateActionConsole("Waiting for " + m_CurrentGame.getCurrentPlayer().getName() + " To Finish Turn");
	}
	/**addElements
	* add components to panels and
	* adds panels to Frame
	**/
	public void addElements()
	{
		JLabel label = new JLabel("CHAT");
		label.setForeground(Color.WHITE);
		
		setKeyBind();
		m_Background_L.setForeground(Color.WHITE);
		
		JPanel board = m_CurrentGame.getCurrentPlayer().getBoard();
		JPanel board2 = m_CurrentGame.getPlayer("AI").getBoardHide();
	
		m_Boards_P.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_Footer_L.setAlignmentX(Component.CENTER_ALIGNMENT);
		m_Header_L.setAlignmentX(Component.CENTER_ALIGNMENT);
		board2.setAlignmentX(Component.CENTER_ALIGNMENT);
		board.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		m_Boards_P.add(board);
		m_Boards_P.add(board2);
		
		m_Header_L.add(updatePlayerStats(m_CurrentGame.getCurrentPlayer(),m_CurrentPlayerStats_L));
		m_Header_L.add(updatePlayerStats(m_CurrentGame.getPlayer("AI"),m_OtherPlayerStats_L));
		
		//m_Footer_L.add(label);
		m_Footer_L.add(m_Chat_TA, BorderLayout.WEST);
		
		label = new JLabel("ACTION CONSOLE");
		label.setForeground(Color.WHITE);
		
		//m_Footer_L.add(label);
		m_Footer_L.add(m_ActionConsole_SP,BorderLayout.CENTER);
		
		m_Background_L.add(m_Header_L);
		m_Background_L.add(new JLabel("\n"));
		m_Background_L.add(m_Boards_P);
		m_Background_L.add(new JLabel("\n"));
		m_Background_L.add(new JLabel("\n"));
		m_Background_L.add(m_Footer_L);
		
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
	
	private JLabel updatePlayerStats(Player player, JLabel stats)
	{
		stats.removeAll();
		JLabel tmp = new JLabel(player.getName() + " Stats");
		tmp.setAlignmentX(Component.CENTER_ALIGNMENT);
		tmp.setForeground(Color.WHITE);
		stats.add(tmp);
		
		tmp = new JLabel("BattleShip Health: " + (player.m_Battleship.getLives()*25) + "%");
		tmp.setAlignmentX(Component.CENTER_ALIGNMENT);
		tmp.setForeground(Color.WHITE);
		stats.add(tmp);
		
		tmp = new JLabel("Carrier Health: " + (player.m_AirCarr.getLives()*20) + "%");
		tmp.setAlignmentX(Component.CENTER_ALIGNMENT);
		tmp.setForeground(Color.WHITE);
		stats.add(tmp);
		
		tmp = new JLabel("Cruiser Health: " + (player.m_Cruiser.getLives()*50) + "%");
		tmp.setAlignmentX(Component.CENTER_ALIGNMENT);
		tmp.setForeground(Color.WHITE);
		stats.add(tmp);
		
		tmp = new JLabel("Submarine Health: " + (player.m_Sub.getLives()*33 + 1) + "%");
		tmp.setAlignmentX(Component.CENTER_ALIGNMENT);
		tmp.setForeground(Color.WHITE);
		stats.add(tmp);
		
		tmp = new JLabel("Destroyer Health: " + (player.m_Destoyer.getLives()*33 + 1) + "%");
		tmp.setAlignmentX(Component.CENTER_ALIGNMENT);
		tmp.setForeground(Color.WHITE);
		stats.add(tmp);
		
		return stats;
	}
	public void updateChatConsole(Player player, String message)
	{
		m_Chat_TA.append("\n\t\t"+ player.getName() + " says " + message + "\n");
	}
	public void updateChatConsole(String message)
	{
		m_Chat_TA.append("\n\t\t"+ m_CurrentGame.getCurrentPlayer().getName() + " says " + message + "\n");
	}
	public void updateActionConsole(String message)
	{
		m_ActionConsole_TA.append("\t" + message + "\n");
		m_ActionConsole_TA.setCaretPosition(m_ActionConsole_TA.getDocument().getLength());
		m_ActionConsolesCaret.setVisible(true);
	}
}

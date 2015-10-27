/* 
Name: Menu Panel 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/19/15
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

public class MenuWindow
{
	private JFrame m_MenuFrame;
	private int m_ScreenWidth, m_ScreenHeight;
	private JButton m_PlayGame_B, m_Exit_B, m_Settings_B;
	private JLabel m_Background_L;
	private LoadAssets m_Assets;
	
    public MenuWindow(LoadAssets assets)// constructer
    {
		m_Assets = assets;
		
		createComponents();
		
		buildComponents();
		
		addActionListeners();
		
		addElements();
	}
	/**createComponents
	* creates components and gives them
	* default values.
	* J.B.
	**/
	public void createComponents()
	{
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();// geting size of screen
		m_ScreenWidth = gd.getDisplayMode().getWidth();
		m_ScreenHeight = gd.getDisplayMode().getHeight();
		
		m_Background_L = new JLabel(m_Assets.getImage("MenuBG"));
		
		m_MenuFrame = new JFrame("Menu");
		
		m_PlayGame_B = new JButton(m_Assets.getImage("PlayGameButton"));
		m_Settings_B = new JButton(m_Assets.getImage("SettingsButton"));
		m_Exit_B = new JButton(m_Assets.getImage("ExitButton"));
	}
	/**buildComponents
	* set up components and there attributes.
	* J.B.
	**/
	public void buildComponents()
	{
		m_MenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_MenuFrame.add(m_Background_L);
		m_Background_L.setLayout(new FlowLayout());
		
		m_MenuFrame.setUndecorated(true);
        m_MenuFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		m_MenuFrame.setLayout(new BorderLayout());
		m_MenuFrame.setSize(new Dimension(m_ScreenWidth,m_ScreenHeight));
		
		m_Exit_B.setMargin(new Insets(0,0,0,0));
		m_PlayGame_B.setMargin(new Insets(0,0,0,0));
		m_Settings_B.setMargin(new Insets(0,0,0,0));
		
		m_Exit_B.setActionCommand("Exit");
		m_PlayGame_B.setActionCommand("PlayGame");
		m_Settings_B.setActionCommand("Settings");
		
	}
	/**addElements
	* add components to panels and
	* adds panels to Frame
	* J.B.
	**/
	public void addElements()
	{
		m_Background_L.add(m_PlayGame_B);
		m_Background_L.add(m_Settings_B);
		m_Background_L.add(m_Exit_B);
		
		m_MenuFrame.add(m_Background_L);
		
		m_MenuFrame.pack();
		
		m_MenuFrame.setVisible(true);
	}
	
	/**addActionListeners
	* adds ActionListener, which wait till
	* an action is Performed then sends 
	* a event to the type of listener.
	* J.B.
	**/
	private void addActionListeners()
	{
		m_PlayGame_B.addActionListener(new ButtonListener());
		m_Exit_B.addActionListener(new ButtonListener());
		m_Settings_B.addActionListener(new ButtonListener());
	}

	/**Listeners
	* Once an event occurs the program goes here
	* and decides what to do with each event.
	*
	*@peram MenuPanel.
	*@peram nothing.
	* J.B.
	**/
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = event.getActionCommand();
			switch(command)
			{
				case "PlayGame": GameSetUpWindow newGame = new GameSetUpWindow(m_MenuFrame, m_Assets);
					break;
				case "Exit": m_MenuFrame.dispose(); System.exit(1);
					break;
				case "Settings":
					break;
			}
		}  
	}
}

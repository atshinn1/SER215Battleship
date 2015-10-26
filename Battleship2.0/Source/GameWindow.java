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

public class GameWindow
{
	private JFrame m_GameFrame, m_GameSetUpFrame;
	private int m_ScreenWidth, m_ScreenHeight;
	private JButton m_BackToMenu_B, m_StartGame_B;
	private JComboBox<String> m_NumOfPly_CB, m_AIDiff_CB;
	private JLabel m_Background_L, m_Buttons_L, m_GameBoard_L;
	private Game m_currentGame;
	
    public GameWindow(Game game)// constructer
    {
		m_currentGame = game;
		
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
		
		m_Background_L = new JLabel(loadImage("GameBackground"));
		m_GameBoard_L = new JLabel(loadImage("gameBoard"));
		m_Buttons_L = new JLabel();
		
		m_GameFrame = new JFrame("GamePlay");
	}
	/**buildComponents
	* set up components and there attributes.
	* J.B.
	**/
	public void buildComponents()
	{
		m_GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_GameFrame.add(m_Background_L);
		
		m_Background_L.setLayout(new BoxLayout(m_Background_L, BoxLayout.Y_AXIS));
		m_Buttons_L.setLayout(new FlowLayout());
		m_GameBoard_L.setLayout(new GridLayout(16,16));
		m_GameBoard_L.setSize(482,633);
		
		m_GameFrame.setUndecorated(true);
        m_GameFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		m_GameFrame.setSize(new Dimension(m_ScreenWidth/4,m_ScreenHeight/4));
		
		m_GameBoard_L.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	/**addElements
	* add components to panels and
	* adds panels to Frame
	* J.B.
	**/
	public void addElements()
	{	
		/*m_Background_L.add(new JLabel("\n\n"));
		m_Background_L.add(m_AIDiff_CB);
		m_Background_L.add(new JLabel("\n\n"));
		m_Background_L.add(m_NumOfPly_CB);
		m_Background_L.add(new JLabel("\n\n"));
		m_Background_L.add(m_StartGame_B);
		m_Background_L.add(new JLabel("\n\n"));
		m_Background_L.add(m_BackToMenu_B);*/
		m_Buttons_L.add(new JLabel("Use the arrow Keys to select Where you boats Are located."));
		for(int i = 0; i < 16*16;i++)
		{
			m_GameBoard_L.add(new JLabel("Box " + i));
		}
		
		m_Background_L.add(m_GameBoard_L);
		m_Background_L.add(m_Buttons_L);
		
		m_GameFrame.add(m_Background_L);
		
		m_GameFrame.pack();
		
		m_GameFrame.setVisible(true);
	}
	
	/**addActionListeners
	* adds ActionListener, which wait till
	* an action is Performed then sends 
	* a event to the type of listener.
	* J.B.
	**/
	private void addActionListeners()
	{
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
				case "BackToMenu": m_GameSetUpFrame.setVisible(true); m_GameFrame.dispose();
					break;
				case "StartGame":
						/*Loading Screen...*/
				// create default error message
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
				case "AIDiff":
					break;
				case "numOfPly":
					break;
			// create default error message
			}
		}
	}
	/**loadImg
	* loads image from file.
	* J.B.
	**/
	private Icon loadButton(String name)
	{
		String path = "";
		path = System.getProperty("user.dir");
		path = path.replace('\\','/');
		path = path.replaceAll("Source", "Assets/GUI/MenuButtons/" + name + ".png");

		try 
		{
		Image img = ImageIO.read(new File(path));
		return new ImageIcon(img);
		
		} catch (IOException ex) 
		{
			System.out.println("FIle Not Found\nFile Path: " + path);
		}
			return null;
	}
	
	private ImageIcon loadImage(String name)
	{
		String path = "";
		path = System.getProperty("user.dir");
		path = path.replace('\\','/');
		path = path.replaceAll("Source", "Assets/GUI/GameImages/" + name + ".jpg");
		Image img;
		
		try 
		{
			img = ImageIO.read(new File(path));
			if(name.equals("GameBackground"))
			{
				img = img.getScaledInstance(m_ScreenWidth, m_ScreenHeight,  java.awt.Image.SCALE_SMOOTH);
			}else
			{
				img = img.getScaledInstance(600, 700,  java.awt.Image.SCALE_SMOOTH);
			}
			return new ImageIcon(img);
		
		} catch (IOException ex) 
		{
			System.out.println("FIle Not Found\nFile Path: " + path);
		}
			return null;
	}
}

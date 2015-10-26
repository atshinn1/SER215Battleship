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

public class SetUpBoardWindow
{
	private JFrame m_SetUpBoard_F, m_Game_F;
	private int m_ScreenWidth, m_ScreenHeight;
	private JButton m_BackToMenu_B, m_StartGame_B;
	private JComboBox<String> m_NumOfPly_CB, m_AIDiff_CB;
	private JLabel m_Background_L, m_Buttons_L, m_GameBoard_L, m_GameBoardGrid_L[][];
	private Game m_currentGame;
	
    public SetUpBoardWindow(Game game)// constructer
    {
		m_currentGame = game;
		
		m_GameBoardGrid_L = new JLabel[21][16];
		
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
		
		m_BackToMenu_B = new JButton("BackToMenu");
		
		m_SetUpBoard_F = new JFrame("GamePlay");
	}
	/**buildComponents
	* set up components and there attributes.
	* J.B.
	**/
	public void buildComponents()
	{
		m_SetUpBoard_F.add(m_Background_L);
		
		m_Background_L.setLayout(new BoxLayout(m_Background_L, BoxLayout.Y_AXIS));
		m_Buttons_L.setLayout(new FlowLayout());
		m_GameBoard_L.setLayout(new GridLayout(21,16,1,1));
		m_GameBoard_L.setSize(485,635);
		
		m_SetUpBoard_F.setUndecorated(true);
        m_SetUpBoard_F.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		m_SetUpBoard_F.setSize(new Dimension(m_ScreenWidth/4,m_ScreenHeight/4));
		
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
		m_Background_L.add(new JLabel("\n\n"));*/
		m_Background_L.add(m_BackToMenu_B);
		m_Buttons_L.add(new JLabel("Use the arrow Keys to select Where you boats Are located."));
		
		for(int y = 0; y < 21;y++)
		{
			for(int x = 0; x < 16; x++)
			{
				m_GameBoardGrid_L[y][x] = new JLabel("");
				m_GameBoard_L.add(m_GameBoardGrid_L[y][x]);
			}
		}
		
		updateBoard(m_currentGame.getPlayer("Player 1").m_Battleship.getImage(), 10,11);
		updateBoard(m_currentGame.getPlayer("Player 1").m_Cruiser.getImage(), 10,13);
		updateBoard(m_currentGame.getPlayer("Player 1").m_Sub.getImage(), 10,12);
		
		m_Background_L.add(m_GameBoard_L);
		m_Background_L.add(m_Buttons_L);
		
		m_SetUpBoard_F.add(m_Background_L);
		
		m_SetUpBoard_F.pack();
		
		m_SetUpBoard_F.setVisible(true);
	}
	
	/**addActionListeners
	* adds ActionListener, which wait till
	* an action is Performed then sends 
	* a event to the type of listener.
	* J.B.
	**/
	private void addActionListeners()
	{
		m_BackToMenu_B.addActionListener(new ButtonListener());
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
				case "BackToMenu": m_SetUpBoard_F.dispose();System.exit(1);
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
	
	private void updateBoard(ImageIcon image, int xx, int yy)
	{
		m_GameBoard_L.removeAll();
		for(int y = 0; y < 21;y++)
		{
			for(int x = 0; x < 16; x++)
			{
				if(xx == x && yy == y)
				{
					m_GameBoardGrid_L[y][x] = new JLabel(image);
				}else
				{
					m_GameBoardGrid_L[y][x] = new JLabel("");
				}
				m_GameBoard_L.add(m_GameBoardGrid_L[y][x]);
			}
		}
	}
}

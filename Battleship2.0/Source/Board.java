/********************** 
Name: Board object 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/17/15
Contributors:
***********************/
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.ImageIcon.*;
import javax.swing.JFrame;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Board
{	
	private JLabel  m_GameBoardGrid_L[][], m_GameBoard_L;
	private int m_ScreenHeight, m_ScreenWidth;
	
	Board()
	{
		m_GameBoardGrid_L = new JLabel[21][16];
		m_GameBoard_L = new JLabel(loadImage("gameBoard"));
		
		createBoard();
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();// geting size of screen
		m_ScreenWidth = gd.getDisplayMode().getWidth();
		m_ScreenHeight = gd.getDisplayMode().getHeight();
		
		m_GameBoard_L.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	
	public JLabel getBoard()
	{
		return m_GameBoard_L;
	}
	
	public JLabel getBoardHide()
	{
		return m_GameBoard_L;// show board with hidden ships, for others to see
	}
	private void createBoard()
	{
		for(int y = 0; y < 21;y++)
		{
			for(int x = 0; x < 16; x++)
			{
				m_GameBoardGrid_L[y][x] = new JLabel("");
				m_GameBoard_L.add(m_GameBoardGrid_L[y][x]);
			}
		}
		m_GameBoard_L.setAlignmentX(Component.CENTER_ALIGNMENT);
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
			System.out.println("FIle Not Found\nFile Path: " + path);System.exit(0);
		}
			return null;
	}
}
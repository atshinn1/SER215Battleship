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
import java.util.*;

public class Board
{	
	private JLabel  m_GameBoardGrid_L[][], m_GameBoard_L;
	private int m_ScreenHeight, m_ScreenWidth;
	private LoadAssets m_Assets;
	private int[] m_OutOfBounds;
	
	Board(LoadAssets assets)
	{
		m_Assets = assets;
		
		m_OutOfBounds = new int[35];
		setOutOfBounds();
		
		m_GameBoardGrid_L = new JLabel[21][16];
		m_GameBoard_L = new JLabel(m_Assets.getImage("GameBoard"));
		
		m_GameBoard_L.setLayout(new FlowLayout(FlowLayout.RIGHT, 0,0));
		
		createBoard();
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();// geting size of screen
		m_ScreenWidth = gd.getDisplayMode().getWidth();
		m_ScreenHeight = gd.getDisplayMode().getHeight();
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
		int height = m_Assets.getImage("GameBoard").getIconHeight()/21;
		int width = m_Assets.getImage("GameBoard").getIconWidth()/16;
		int count = 0;
		for(int y = 0; y < 21;y++)
		{
			for(int x = 0; x < 16; x++)
			{
				m_GameBoardGrid_L[y][x] = new JLabel("" + count);
				m_GameBoardGrid_L[y][x].setPreferredSize(new Dimension(width, height));
				m_GameBoardGrid_L[y][x].setForeground(Color.WHITE);
				m_GameBoard_L.add(m_GameBoardGrid_L[y][x]);
				count++;
			}
			
		}
	}
	
	public void updateBoard(Ship ship, int x, int y)
	{
		
		int loc = (y)*16 + x;
		System.out.println(loc);
		if(!isOutOfBounds(loc))
		{
			m_GameBoard_L.remove(loc);
			for(int i = 1; i < ship.getLength(); i++)
			{
				m_GameBoard_L.remove(loc + i - 1);
			}
			m_GameBoard_L.add(new JLabel(ship.getImage()),loc);
		}
	}
	
	private void setOutOfBounds()
	{
		for(int i = 0; i < 16; i++)
		{
			m_OutOfBounds[i] = (i);
		}
		for(int i = 1; i < 21; i++)
		{
			m_OutOfBounds[i] = (i*16);
		}
	}
	private boolean isOutOfBounds(int loc)
	{
		for(int i = 0; i < 35; i++)
		{
			if(m_OutOfBounds[i] == loc)
			{
				return true;
			}
		}
		return false;
	}
}
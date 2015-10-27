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
	private LoadAssets m_Assets;
	
	Board(LoadAssets assets)
	{
		m_Assets = assets;
		
		m_GameBoardGrid_L = new JLabel[21][16];
		m_GameBoard_L = new JLabel(m_Assets.getImage("GameBoard"));
		
		m_GameBoard_L.setLayout(new GridLayout(21,16,0,0));
		
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
		for(int y = 0; y < 21;y++)
		{
			for(int x = 0; x < 16; x++)
			{
				m_GameBoardGrid_L[y][x] = new JLabel("");
				m_GameBoard_L.add(m_GameBoardGrid_L[y][x]);
			}
		}
	}
	
	public void updateBoard(ImageIcon image, int xx, int yy)
	{
		m_GameBoard_L.removeAll();
		m_GameBoardGrid_L = new JLabel[21][16];
		m_GameBoard_L = new JLabel(m_Assets.getImage("GameBoard"));
		m_GameBoard_L.setLayout(new GridLayout(21,16,0,0));
		
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
	public void updateBoard(ImageIcon image, ImageIcon image2, int xx, int yy)
	{
		m_GameBoard_L.removeAll();
		m_GameBoardGrid_L = new JLabel[21][16];
		m_GameBoard_L = new JLabel(m_Assets.getImage("GameBoard"));
		m_GameBoard_L.setLayout(new GridLayout(21,16,0,0));
		
		for(int y = 0; y < 21;y++)
		{
			for(int x = 0; x < 16; x++)
			{
				if(xx == x && yy == y)
				{
					m_GameBoardGrid_L[10][10] = new JLabel(m_Assets.getImage("CruiserXTop"));
					m_GameBoard_L.add(m_GameBoardGrid_L[10][10]);
					x++;
					System.out.println(x + "");
					m_GameBoardGrid_L[10][11] = new JLabel(m_Assets.getImage("CruiserXBut"));
					m_GameBoard_L.add(m_GameBoardGrid_L[10][11]);
				}else
				{
					m_GameBoardGrid_L[y][x] = new JLabel("");
					m_GameBoard_L.add(m_GameBoardGrid_L[y][x]);
				}
				
			}
		}
	}
}
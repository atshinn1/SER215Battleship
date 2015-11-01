/********************** 
Name: Board object 
Author: Joshua Becker
Create On: 10/26/15
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
	private int m_ShipCount;
	
	Board(LoadAssets assets)
	{
		m_Assets = assets;
		m_ShipCount = 0;
		
		m_OutOfBounds = new int[55];
		setOutOfBounds();
		
		m_GameBoardGrid_L = new JLabel[21][16];
		m_GameBoard_L = new JLabel(m_Assets.getImage("GameBoard"));
		
		FlowLayout boardLayout = new FlowLayout();
		boardLayout.setHgap(0);
		boardLayout.setVgap(0);
		
		m_GameBoard_L.setLayout(boardLayout);
		
		createBoard();
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();// geting size of screen
		m_ScreenWidth = gd.getDisplayMode().getWidth();
		m_ScreenHeight = gd.getDisplayMode().getHeight();
	}
	
	public int getShipCount()
	{
		return m_ShipCount;
	}
	public JLabel getBoard()
	{
		return m_GameBoard_L;
	}
	
	public JLabel getBoardHide()
	{
		return m_GameBoard_L;// show board with hidden ships, for others to see
	}
	public void addNextShip(Ship ship)
	{
		int height = m_Assets.getImage("GameBoard").getIconHeight()/21;
		int width = m_Assets.getImage("GameBoard").getIconWidth()/16;
		int x = 1; int y = 1;
		int newLoc = (y)*16 + x;
		
		while(hasShip(newLoc, ship.getLength(), ship.getName()))//find safe location
		{
			y++;
			newLoc = (y)*16 + x;
		}
		
		((JLabel) m_GameBoard_L.getComponent(newLoc)).setText(ship.getName());
		((JLabel) m_GameBoard_L.getComponent(newLoc)).setIcon(ship.getImage());
		((JLabel) m_GameBoard_L.getComponent(newLoc)).setPreferredSize(new Dimension(width*ship.getLength(), height));
		for(int i = 1; i < ship.getLength(); i++)
		{
			((JLabel) m_GameBoard_L.getComponent(newLoc + i)).setVisible(false);
			((JLabel) m_GameBoard_L.getComponent(newLoc + i)).setText(ship.getName());
			System.out.println(newLoc+ i);
		}
		System.out.println("New Loc" + newLoc + " Total count: " + m_GameBoard_L.getComponentCount());
		ship.setLocation(x,y);
		m_ShipCount++;
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
		int height = m_Assets.getImage("GameBoard").getIconHeight()/21;
		int width = m_Assets.getImage("GameBoard").getIconWidth()/16;
		int oldLoc = ship.getLocation().y()*16 + ship.getLocation().x();
		int newLoc = (y)*16 + x;
		
		if(!isOutOfBounds(newLoc, ship.getLength()) && newLoc <=  336-ship.getLength() && !hasShip(newLoc, ship.getLength(), ship.getName()))
		{
			((JLabel) m_GameBoard_L.getComponent(oldLoc)).setPreferredSize(new Dimension(width, height));
			((JLabel) m_GameBoard_L.getComponent(oldLoc)).setText(oldLoc + "");
			
			for(int i = 0; i < ship.getLength(); i++)
			{
				((JLabel) m_GameBoard_L.getComponent(oldLoc + i)).setText((oldLoc + i) + "");
				((JLabel) m_GameBoard_L.getComponent(oldLoc + i)).setVisible(true);
			}
			
			((JLabel) m_GameBoard_L.getComponent(oldLoc)).setIcon(null);
			((JLabel) m_GameBoard_L.getComponent(newLoc)).setText(ship.getName());
			((JLabel) m_GameBoard_L.getComponent(newLoc)).setIcon(ship.getImage());
			((JLabel) m_GameBoard_L.getComponent(newLoc)).setPreferredSize(new Dimension(width*ship.getLength(), height));
			for(int i = 1; i < ship.getLength(); i++)
			{
				((JLabel) m_GameBoard_L.getComponent(newLoc + i)).setVisible(false);
				((JLabel) m_GameBoard_L.getComponent(newLoc + i)).setText(ship.getName());
				System.out.println(newLoc+ i);
			}
			System.out.println("New Loc" + newLoc + " Total count: " + m_GameBoard_L.getComponentCount());
			ship.setLocation(x,y);
		}
	}
	
	private void setOutOfBounds()
	{
		int j = 0;
		for(int i = 0; i < 16; i++)
		{
			m_OutOfBounds[j++] = (i);
		}
		for(int i = 1; i < 21; i++)
		{
			m_OutOfBounds[j++] = (i*16);
		}
		for(int i = 2; i < 21; i++)
		{
			m_OutOfBounds[j++] = (i*16 - 1);
		}
	}
	private boolean isOutOfBounds(int loc, int length)
	{
		for(int i = 0; i < 55; i++)
		{
			if(m_OutOfBounds[i] == loc || m_OutOfBounds[i] == loc + length-2)
			{
				return true;
			}
		}
		return false;
	}
	private boolean hasShip(int loc, int length, String shipName)
	{
		for(int i = 0; i < length; i++)
		{
			if(Ship.isShip(((JLabel) m_GameBoard_L.getComponent(loc + i)).getText()) && ((JLabel) m_GameBoard_L.getComponent(loc + i)).getText() != shipName)
			{
				return true;
			}
		}
		return false;
	}
}
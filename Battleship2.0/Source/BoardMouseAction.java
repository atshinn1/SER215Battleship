/* 
Name: MouseAction
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
 
public class BoardMouseAction extends MouseAdapter
{
	private int m_x;
	private int m_y;
	private Player m_CurrentPlayer;
	private JLabel m_GameBoardTargets_L[];
	private Game m_Game;
	private LoadAssets m_Assets;
	BoardMouseAction(int x , int y, Game game, JLabel[] gameBoardTargets_L, LoadAssets assets)
	{
		m_x = x;
		m_y = y;
		m_Game = game;
		m_GameBoardTargets_L = gameBoardTargets_L;
		m_Assets = assets;
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent evt) 
	{
		if(m_Game.getCurrentPlayer().allShipsSet())
		m_GameBoardTargets_L[m_x].getComponent(m_y).setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent evt) 
	{
		//if(m_ShipCount > 5)
	}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent evt)
	{
		//((JLabel) m_GameBoardTargets_L[m_x].getComponent(m_y)).setIcon(m_Assets.getImage("HitMarker"));
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent evt)
	{
		((JLabel) m_GameBoardTargets_L[m_x].getComponent(m_y)).setIcon(m_Assets.getImage("Target"));
		if(m_Game.getCurrentPlayer().getNumOfSelectedTargets() == 5)
		{
			m_Game.fire();
			m_Game.nextTurn();
		}else
		{
			m_CurrentPlayer.incNumOfSelTargets();
		}
	}
}
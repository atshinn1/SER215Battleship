/********************** 
Name: main 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/17/15
Contributors:
***********************/
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Ship
{
	public static final boolean Y_AXIS = true;
	public static final boolean X_AXIS = false;
	public static final int CARRIER_LENGTH = 5;
	public static final int BATTLESHIP_LENGTH = 4;
	public static final int CRUISER_LENGTH = 2;
	public static final int DESTROYER_LENGTH = 3;
	public static final int SUBMARINE_LENGTH = 3;
	
	private String m_Name;
	private int m_Length;
	private int m_Lives;
	private ImageIcon image;
	private LoadAssets m_Assets;
	private boolean m_Orientation;
	private Location m_Location;
	
	class Location
	{
		private int m_x;
		private int m_y;
		
		Location()
		{
			m_x = 1;
			m_y = 1;
		}
		
		Location(int x, int y)
		{
			m_x = x;
			m_y = y;
		}
		public void setLocation(int x, int y)
		{
			m_x = x;
			m_y = y;
		}
		public int x()
		{
			return m_x;
		}
		public int y()
		{
			return m_y;
		}
	}
	
	Ship()
	{
		m_Name = "Dumb Ship";
		m_Length = 20;
		m_Lives = 20;
		m_Location = new Location();
		m_Orientation = Ship.X_AXIS;
	}
	Ship(String name, int length, LoadAssets assets)
	{
		m_Assets = assets;
		m_Name = name;
		m_Length = length;
		m_Lives = length;
		m_Location = new Location(1,1);
		m_Orientation = Ship.X_AXIS;
		
		image = m_Assets.getImage(name);
		if(image == null)
		{
			System.out.println(name + " was not found");
		}
	}
	
	public String getName()
	{
		return m_Name;
	}
	
	public int getLength()
	{
		return m_Length;
	}
	
	public int getLives()
	{
		return m_Lives;
	}
	public void decLives()
	{
		m_Lives--;
	}
	public ImageIcon getImage()
	{
		return image;
	}
	
	public Location getLocation()
	{
		return m_Location;
	}
	public void setLocation(int x, int y)
	{
		m_Location.setLocation(x,y);
	}
	public void reset()
	{
		m_Lives = m_Length;
	}
	public static boolean isShip(String name)
	{
		switch(name)
		{
			case "AircraftCarrier": return true;
			case "Battleship":      return true; 
			case "Submarine":       return true;
			case "Cruiser":         return true;
			case "Destroyer":       return true;
			default: return false;
		}
	}
}
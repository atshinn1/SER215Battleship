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
	private String m_Name;
	private int m_Length;
	private int m_Lives;
	private ImageIcon image;
	
	Ship()
	{
		m_Name = "Dumb Ship";
		m_Length = 20;
		m_Lives = 20;
	}
	Ship(String name, int length)
	{
		m_Name = name;
		m_Length = length;
		m_Lives = length;
		image = loadImage();
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
	public void reset()
	{
		m_Lives = m_Length;
	}
	private ImageIcon loadImage()
	{
		String path = "";
		path = System.getProperty("user.dir");
		path = path.replace('\\','/');
		path = path.replaceAll("Source", "Assets/ships/" + m_Name + ".png");
		Image img;
		
		try 
		{
			img = ImageIO.read(new File(path));
			img = img.getScaledInstance(27, 27*m_Length,  java.awt.Image.SCALE_SMOOTH);
		
		} catch (IOException ex) 
		{
			System.out.println("FIle Not Found\nFile Path: " + path);
		}
			return null;
	}
}
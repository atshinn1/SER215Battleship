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
	private LoadAssets m_Assets;
	
	Ship()
	{
		m_Name = "Dumb Ship";
		m_Length = 20;
		m_Lives = 20;
	}
	Ship(String name, int length, LoadAssets assets)
	{
		m_Assets = assets;
		m_Name = name;
		m_Length = length;
		m_Lives = length;
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
	public void reset()
	{
		m_Lives = m_Length;
	}
}
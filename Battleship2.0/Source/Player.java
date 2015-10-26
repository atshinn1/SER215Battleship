/********************** 
Name: main 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/17/15
Contributors:
***********************/
import javax.swing.*;

public class Player
{
	private String m_Name;
	private boolean m_Type;
	private int m_Wins;
	private int m_Losses;
	public Ship m_AirCarr;
	public Ship m_Battleship;
	public Ship m_Sub;
	public Ship m_Cruiser;
	public Ship m_Destoyer;
	public Board m_Board;
	
	Player()
	{
		
	}
	Player(String name, boolean type)
	{
		m_Name = name;
		m_Type = type;
		m_Losses = 0;
		m_Wins = 0;
		m_Board = new Board();
		m_AirCarr = new Ship("AircraftCarrier", 5);
		m_Battleship = new Ship("Battleship", 4);
		m_Sub = new Ship("Submarine", 3);
		m_Cruiser = new Ship("Cruiser", 3);
		m_Destoyer = new Ship("Destroyer", 2);
	}
	
	public JLabel getBoard()
	{
		return m_Board.getBoard();
	}
	
	public String getName()
	{
		return m_Name;
	}
	public boolean isHuman()
	{
		return m_Type;
	}
	public int getWins()
	{
		return m_Wins;
	}
	public int getLosses()
	{
		return m_Losses;
	}
	public int getNumGames()
	{
		return m_Losses + m_Wins;
	}
	public void resetShips()
	{
		m_AirCarr.reset();
		m_Battleship.reset();
		m_Sub.reset();
		m_Cruiser.reset();
		m_Destoyer.reset();
	}
}
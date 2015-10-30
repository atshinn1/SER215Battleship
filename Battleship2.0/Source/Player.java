/********************** 
Name: Player Object
Author: Joshua Becker
Create On: 10/29/15
Contributors:
***********************/
import javax.swing.*;

public class Player
{
	private String m_Name;
	private boolean m_Type;
	private int m_Wins;
	private int m_Losses;
	private LoadAssets m_Assets;
	private Board m_Board;
	public Ship m_AirCarr;
	public Ship m_Battleship;
	public Ship m_Sub;
	public Ship m_Cruiser;
	public Ship m_Destoyer;

	
	Player()
	{
		
	}
	Player(String name, boolean type, LoadAssets assets)
	{
		m_Assets = assets;
		m_Name = name;
		m_Type = type;
		m_Losses = 0;
		m_Wins = 0;
		m_Board = new Board(m_Assets);
		m_AirCarr = new Ship("AircraftCarrier", Ship.CARRIER_LENGTH, m_Assets);
		m_Battleship = new Ship("Battleship", Ship.BATTLESHIP_LENGTH, m_Assets);
		m_Sub = new Ship("Submarine", Ship.SUBMARINE_LENGTH, m_Assets);
		m_Cruiser = new Ship("Cruiser", Ship.CRUISER_LENGTH, m_Assets);
		m_Destoyer = new Ship("Destroyer", Ship.DESTROYER_LENGTH, m_Assets);
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
	
    /**getShip
	* gets the ship by name
	* @param int: index
	* @return: Ship object.
	**/
	public Ship getShip(String name)
	{
		switch(name)
		{
			case "AircraftCarrier": return m_AirCarr;
			case "Battleship":      return m_Battleship; 
			case "Submarine":       return m_Sub;
			case "Cruiser":         return m_Cruiser;
			case "Destroyer":       return m_Destoyer;
			default: return null;
		}
	}
	
	/**getShip
	* gets the ship at a index.
	* @param int: index
	* @return: Ship object.
	**/
	public Ship getShip(int index)
	{
		switch(index)
		{
			case 0: 	return m_AirCarr;
			case 1:     return m_Battleship; 
			case 2:     return m_Sub;
			case 3:     return m_Cruiser;
			case 4:     return m_Destoyer;
			default:    return null;
		}
	}
	
	/**updateBoard
	* updates the board with the ship object and the new x, y values.
	* @param Ship: object to be updated
	* @param int: x location on grid
	* @param int: y location on grid
	**/
	public void updateBoard(Ship ship, int x, int y)
	{
		m_Board.updateBoard(ship,x, y);
	}
	
	/**getNextShip
	* gets the next ship inline to be placed
	**/
	public Ship getNextShip()
	{
		return getShip(m_Board.getShipCount());
	}
	
	/**setNextShip
	* sets's the a new ship to the board.
	* very similar to updateBoard.
	**/
	public void setNextShip()
	{
		if(m_Board.getShipCount() < 5)
		{
			m_Board.addNextShip(getShip(m_Board.getShipCount()));
		}
	}
}
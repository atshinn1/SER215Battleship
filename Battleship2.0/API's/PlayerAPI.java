/********************** 
Name: Player Object API
Author: Joshua Becker
Create On: 10/26/15
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
	//constructer
	Player(String name, boolean type, LoadAssets assets)
	
	public JLabel getBoard()
	
	public String getName()
	
	public boolean isHuman()

	public int getWins()

	public int getLosses()

	public int getNumGames()

	public void resetShips()

    /**getShip
	* gets the ship by name
	* @param int: index
	* @return: Ship object.
	**/
	public Ship getShip(String name)
	
	/**getShip
	* gets the ship at a index.
	* @param int: index
	* @return: Ship object.
	**/
	public Ship getShip(int index)
	
	/**updateBoard
	* updates the board with the ship object and the new x, y values.
	* @param Ship: object to be updated
	* @param int: x location on grid
	* @param int: y location on grid
	**/
	public void updateBoard(Ship ship, int x, int y)
	
	/**getNextShip
	* gets the next ship inline to be placed
	**/
	public Ship getNextShip()

	/**setNextShip
	* sets's the a new ship to the board.
	* very similar to updateBoard.
	**/
	public void setNextShip()

	
}
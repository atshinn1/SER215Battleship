/********************** 
Name: Game Object
Author: Joshua Becker
Create On: 10/26/15
Contributors:
***********************/

public class Game
{
	private Player m_Players[];
	private int m_difficulty;
	private int m_NumOfGames;
	private LoadAssets m_Assets;
	
	Game()
	{
		
	}
	Game(int difficulty, int numOfPlys, LoadAssets assets)
	{
		m_Assets = assets;
		m_difficulty = difficulty;
		m_Players = new Player[2];// change this later...
		m_NumOfGames = 0;
		fillPlayers();
	}
	/**getNumOfPlys
	* gets the number of players
	* @return int: number of players
	**/
	
	public int getNumOfPlys()
	{
		return m_Players.length;
	}
	/**getDifficulty
	* gets the difficulty
	* @return int: difficulty
	**/
	
	public int getDifficulty()
	{
		return m_difficulty;
	}
	/**getPlayer
	* gets the player
	* @param String: name of wanted player;
	* @return Player: wanted Player object;
	**/
	
	public Player getPlayer(String name)
	{
		for(int i = 0; i < m_Players.length; i++)
		{
			if(m_Players[i].getName().equals(name))
			{
				return m_Players[i];
			}				
		}
		return null;
	}
	
	/**getNumOfGames
	* gets the number of games played
	* @return int: number of games played
	**/
	public int getNumOfGames()
	{
		return m_NumOfGames;
	}
	
	/**incNumOfGames
	* increments the number of games by one
	**/
	public void incNumOfGames()
	{
		m_NumOfGames++;
	}
	
	/**resetGame
	* resets the Current Game
	**/
	public void resetGame()
	{
		for(int i = 0; i < m_Players.length; i++)
		{
			m_Players[i].resetShips();
		}
	}

	/**TEMP METHOD fillPlayers
	* fillPlayers with some value
	**/
	private void fillPlayers()
	{
		m_Players[0] = new Player("Player 1", true, m_Assets);
		m_Players[1] = new Player("AI", false, m_Assets);
		fillAI();
	}
	public void fillAI()
	{
		Ship ship = m_Players[1].getNextShip();
		m_Players[1].setNextShip();
		m_Players[1].updateBoard(ship, 2,2);
		
		ship = m_Players[1].getNextShip();
		m_Players[1].setNextShip();
		m_Players[1].updateBoard(ship, 3,3);
		
		ship = m_Players[1].getNextShip();
		m_Players[1].setNextShip();
		m_Players[1].updateBoard(ship, 4,4);
		
		m_Players[1].setNextShip();
		m_Players[1].updateBoard(ship, 5,5);
		ship = m_Players[1].getNextShip();
		
		m_Players[1].setNextShip();
		m_Players[1].updateBoard(ship, 6,6);
		ship = m_Players[1].getNextShip();
	}
}
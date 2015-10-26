/********************** 
Name: main 
Author: Joshua Becker
Create On: 9/9/15
Updated On: 9/17/15
Contributors:
***********************/

public class Game
{
	private Player m_Players[];
	private int m_difficulty;
	private int m_NumOfGames;
	
	Game()
	{
		
	}
	Game(int difficulty, int numOfPlys)
	{
		m_difficulty = difficulty;
		m_Players = new Player[numOfPlys+1];
		m_NumOfGames = 0;
		fillPlayers();
	}
	
	public int getNumOfPlys()
	{
		return m_Players.length;
	}
	public int getDifficulty()
	{
		return m_difficulty;
	}
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
	
	public int getNumOfGames()
	{
		return m_NumOfGames;
	}
	
	public void incNumOfGames()
	{
		m_NumOfGames++;
	}
	
	public void resetGame()
	{
		for(int i = 0; i < m_Players.length; i++)
		{
			m_Players[i].resetShips();
		}
	}
	private void fillPlayers()
	{
		m_Players[0] = new Player("Player 1", true);
		for(int i = 1; i < m_Players.length;i++)
		{
			m_Players[i] = new Player("Player" + (i+1), false);
		}
	}
}
/********************** 
Name: Game API
Author: Joshua Becker
Create On: 10/29/15
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
	//constructer
	Game(int difficulty, int numOfPlys, LoadAssets assets)
	
	/**getNumOfPlys
	* gets the number of players
	* @return int: number of players
	**/
	public int getNumOfPlys()
	
	/**getDifficulty
	* gets the difficulty
	* @return int: difficulty
	**/
	public int getDifficulty()
	
	/**getPlayer
	* gets the player
	* @param String: name of wunted player;
	* @return Player: wunted Player object;
	**/
	public Player getPlayer(String name)
	
	/**getNumOfGames
	* gets the number of games played
	* @return int: number of games played
	**/
	public int getNumOfGames()
	
	/**incNumOfGames
	* increments the number of games by one
	**/
	public void incNumOfGames()
	
	/**resetGame
	* resets the Current Game
	**/
	public void resetGame()
	
	/**TEMP METHOD fillPlayers
	* fillPlayers with some value
	**/
	private void fillPlayers()
}
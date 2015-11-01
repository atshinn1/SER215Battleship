/********************** 
Name: Board API
Author: Joshua Becker
Create On: 10/26/15
Contributors:
***********************/

public class Board
{	
	private JLabel  m_GameBoardGrid_L[][], m_GameBoard_L;
	private int m_ScreenHeight, m_ScreenWidth;
	private LoadAssets m_Assets;
	private int[] m_OutOfBounds;
	private int m_ShipCount;
	//constructer
	Board(LoadAssets assets)
	
	/**getShipCount
	* returns the number of ships on the board
	* used in setUpBoard and here.
	* @return int: ship count
	**/
	public int getShipCount()
	
	/**getBoard
	* gets the JLabel Board.
	* @return JLabel: the current board Image.
	**/
	public JLabel getBoard()
	
	/**getBoardHide
	* gets the JLabel Board with all the ships hidden.
	* return JLabel: Board with hidden ships.
	**/
	public JLabel getBoardHide()
	
	/**addNextShip
	* add's the a new ship to the board.
	* very similar to updateBoard.
	* @param Ship: Ship object ot be added
	**/
	public void addNextShip(Ship ship)
	
	/**createBoard
	* initializes the board with default values.
	**/
	private void createBoard()
	
	/**updateBoard
	* updates the board with the ship object and the new x, y values.
	* @param Ship: object to be updated
	* @param int: x location on grid
	* @param int: y location on grid
	**/
	public void updateBoard(Ship ship, int x, int y)
	
	/**setOutOfBounds
	* initializes an array with the out of bounds values.
	**/
	private void setOutOfBounds()
	
	/**isOutOfBounds
	* checks if the loc is out of bounds
	* @param int: location to be checked.
	* @param int: Ship length.
	**/
	private boolean isOutOfBounds(int loc, int length)
	
	/**hasShip
	* checks if the loc is occupied
	* @param int: location to be checked.
	* @param int: length of the Ship.
	* @param String: ship name
	**/
	private boolean hasShip(int loc, int length, String shipName)
}
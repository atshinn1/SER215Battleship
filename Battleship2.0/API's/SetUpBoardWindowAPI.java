/** 
Name: Set Up Board Window API
Author: Joshua Becker
Create On: 10/29/15
Contributors:
 **/

public class SetUpBoardWindow
{
	private JFrame m_SetUpBoard_F, m_Game_F;
	private int m_ScreenWidth, m_ScreenHeight;
	private JButton m_BackToMenu_B, m_StartGame_B;
	private JComboBox<String> m_NumOfPly_CB, m_AIDiff_CB;
	private JLabel m_Background_L, m_Instructions_L;
	private Game m_currentGame;
	private Player m_CurrentPlayer;
	private Ship m_CurrentShip;
	private LoadAssets m_Assets;
	
	// constructer
    public SetUpBoardWindow(Game game, LoadAssets assets)
	
	/**createComponents
	* creates components and gives them
	* default values.
	**/
	public void createComponents()
	/**buildComponents
	* set up components and there attributes.
	**/
	public void buildComponents()
	/**addElements
	* add components to panels and
	* adds panels to Frame
	**/
	public void addElements()
	/**addActionListeners
	* adds ActionListener, which wait till
	* an action is Performed then sends 
	* a event to the type of listener.
	**/
	private void addActionListeners()

	/**Listeners
	* Once an event occurs the program goes here
	* and decides what to do with each event.
	**/
	private class ButtonListener implements ActionListener
	
	private class ComboListener implements ActionListener

	/**KeyAction
	* Once an Key stroke occurs the program goes here
	* and decides what to do with each event.
	**/
	private class KeyAction extends AbstractAction
	
	/**setKeyBind
	* maps the key strokes with there actions
	* and decides what to do with each event.
	**/
	private void setKeyBind()
}

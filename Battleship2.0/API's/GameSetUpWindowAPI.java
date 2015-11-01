/**
Name: GameSetUpWindow API
Author: Joshua Becker
Create On: 10/26/15
Contributors:
 **/

public class GameSetUpWindow
{
	private JFrame m_GameSetUpFrame, m_MenuFrame;
	private int m_ScreenWidth, m_ScreenHeight;
	private JButton m_StartNewGame_B, m_BackToMenu_B, m_LoadAGame_B;
	private JPanel m_MenuButton_P;
	private JLabel m_Background_L;
	private LoadAssets m_Assets;
	
	// constructer
    public GameSetUpWindow(JFrame window, LoadAssets assets)
	
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
}

public class Location
{
	private int m_x;
	private int m_y;
	private String m_message;
	
	Location()
	{
		m_x = 1;
		m_y = 1;
		m_message="";
	}
	
	Location(int x, int y)
	{
		m_x = x;
		m_y = y;
		m_message="";
	}
	Location(Location copy)
	{
		m_x=copy.x();
		m_y=copy.y();
		m_message=copy.getMessage();
	}
	public void setLocation(int x, int y)
	{
		m_x = x;
		m_y = y;
	}
	public int x()
	{
		return m_x;
	}
	public int y()
	{
		return m_y;
	}

	//im using this to send messages confirming cooridates recieved. At this point mostly for testing 
	public String getMessage(){
		return m_message;
	}

	public void setMessage(String message){
		m_message=message;
	}
}
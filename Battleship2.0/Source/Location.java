public class Location
{
	private int m_x;
	private int m_y;
	
	Location()
	{
		m_x = 1;
		m_y = 1;
	}
	
	Location(int x, int y)
	{
		m_x = x;
		m_y = y;
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
}
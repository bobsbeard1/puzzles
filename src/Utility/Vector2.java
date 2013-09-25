package Utility;

/**
 * A class for representing 2D vectors.
 * @author tom
 *
 */
public class Vector2
{
	int first;
	int second;
	
	public Vector2(int x, int y)
	{
		first = x;
		second = y;
	}
	
	public int getX()
	{
		return first;
	}
	
	public int getY()
	{
		return second;
	}
	
	public void setX(int x)
	{
		first = x;
	}
	
	public void setY(int y)
	{
		second = y;
	}
}

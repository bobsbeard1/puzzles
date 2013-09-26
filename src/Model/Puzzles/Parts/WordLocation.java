package Model.Puzzles.Parts;

import java.util.Vector;

import Utility.Vector2;

/**
 * A class for representing locations of words in a puzzle
 * 
 * @author tom
 * 
 * @param <T>
 *            T is type integer
 */
public class WordLocation
{
	Vector2 beg;
	Vector2 end;
	
	public WordLocation(int xBeg, int yBeg, int xEnd, int yEnd)
	{
		beg = new Vector2(xBeg,yBeg);
		end = new Vector2(xEnd,yEnd);
	}

	public WordLocation(Vector2 beginingOfWord, Vector2 endOfWord)
	{
		beg = beginingOfWord;
		end = endOfWord;
	}

	public Vector2 getBegining()
	{
		return beg;
	}

	public Vector2 getEnd()
	{
		return end;
	}
	
	public void printLocation()
	{
		System.out.printf("Begining: X:%d Y:%d ",beg.getX(),beg.getY());
		System.out.printf("End: X:%d Y:%d",end.getX(),end.getY());
	}
}

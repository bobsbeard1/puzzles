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
public class WordLocation<T>
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
}

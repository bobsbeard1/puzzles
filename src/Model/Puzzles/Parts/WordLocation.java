package Model.Puzzles.Parts;

import java.util.Vector;

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
	Vector<T> begining;
	Vector<T> end;

	public WordLocation(int xBeg, int yBeg, int xEnd, int yEnd)
	{
		begining = new Vector<T>(xBeg, yBeg);
		end = new Vector<T>(xEnd, yEnd);
	}

	public WordLocation(Vector<T> beginingOfWord, Vector<T> endOfWord)
	{
		begining = beginingOfWord;
		end = endOfWord;
	}

	public Vector<T> getBegining()
	{
		return begining;
	}

	public Vector<T> getEnd()
	{
		return end;
	}
}

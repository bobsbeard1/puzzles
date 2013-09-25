package Model.Puzzles;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import Model.WordList;
import Model.Puzzles.Parts.*;
import Utility.RandomHelper;

/**
 * Class for generating puzzles based on the puzzle type. Currently only
 * generates word search and cross word puzzles.
 * 
 * @author tom
 * 
 */
public class PuzzleGenerator
{
	/**
	 * Main method for creating puzzles. Passes the data off to the respective
	 * method based on the puzzle type.
	 * 
	 * @param type
	 *            The type of puzzle to be created.
	 * @param size
	 *            The size of the puzzle (size X size)
	 * @param wordList
	 *            The list of words used to create the puzzle
	 * @return
	 */
	public static Puzzle generatePuzzle(PuzzleType type, int size,
			WordList wordList)
	{
		switch (type)
		{
		case CrossWord:
			return generateCrossWord(size, wordList);
		case WordSearch:
			return generateWordSearch(size);
		}
		return null;

	}

	/**
	 * Generates a word search puzzle.
	 * 
	 * @param size
	 *            The square size of the puzzle
	 * @return
	 */
	private static WordSearch generateWordSearch(int size)
	{

		WordSearch wordSearch = new WordSearch(size);
		WordSearchCell[][] wordsearchArray = new WordSearchCell[size][size];

		for (int i = 0; i < wordsearchArray.length; i++)
		{
			for (int j = 0; j < wordsearchArray[0].length; j++)
			{
				wordsearchArray[i][j] = new WordSearchCell(
						RandomHelper.getRandomChar());
			}
		}

		wordSearch = new WordSearch(wordsearchArray);

		return wordSearch;
	}

	/**
	 * Generates a cross word puzzle.
	 * 
	 * @param size
	 *            The square size of the puzzle
	 * @return
	 */
	private static CrossWord generateCrossWord(int size, WordList list)
	{

		CrossWordCell[][] crosswordArray = new CrossWordCell[size][size];

		for (int i = 0; i < crosswordArray.length; i++)
		{
			for (int j = 0; j < crosswordArray[0].length; j++)
			{
				crosswordArray[i][j] = new CrossWordCell();
			}
		}

		fillCrossWord(crosswordArray, list);

		for (int i = 0; i < crosswordArray.length; i++)
		{
			for (int j = 0; j < crosswordArray[0].length; j++)
			{
				if (crosswordArray[i][j].isPartOfWord() == false)
				{
					crosswordArray[i][j].setBlank();
				}
			}
		}

		return new CrossWord(crosswordArray);

	}

	private static void fillCrossWord(CrossWordCell[][] array, WordList list)
	{
		HashMap<String, WordLocation> wordMap = new HashMap<String, WordLocation>();
		placeCrossWordWord(list.getList().get(0),wordMap,array);
		
		for (int i = 0; i < list.getLength(); i++)
		{

		}

	}

	private static boolean placeCrossWordWord(String word,
			HashMap<String, WordLocation> wordMap, CrossWordCell[][] array)
	{
		int length = word.length();
		WordLocation location;
		if (wordMap.isEmpty())
		{
			location = new WordLocation(0, 0, length - 1, 0);
		} else
		{
			location = findWordLocation(word, wordMap);
		}
		
		if (location.getBegining().getX() != location.getEnd()
				.getX())
		{
			wordMap.put(word, location);
			return placeCrossWordWordAcross(word, location, array);
			
		} else
		{
			wordMap.put(word, location);
			return placeCrossWordWordDown(word, location, array);
		}

	}

	private static WordLocation findWordLocation(String word,
			HashMap<String, WordLocation> wordMap)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean placeCrossWordWordAcross(String word,
			WordLocation location,CrossWordCell[][] array)
	{
		int begining = location.getBegining().getX();
		int end = location.getEnd().getX();
		int row = location.getBegining().getY();
		
		int charIndex = 0;
		for (int i = begining; i < end; i++)
		{
			array[i][row].setChar(word.charAt(charIndex));
			charIndex++;
		}
		
		return true;
	}

	private static boolean placeCrossWordWordDown(String word,
			WordLocation location,CrossWordCell[][] array)
	{
		return true;
	}
}

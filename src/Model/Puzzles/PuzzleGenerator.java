package Model.Puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import Model.WordList;
import Model.Puzzles.Parts.*;
import Utility.RandomHelper;
import Utility.Vector2;

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
		placeCrossWordWordDown("blob", new WordLocation(2, 0, 2, 4),
				crosswordArray);
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
		// placeCrossWordWord(list.getWordAt(0), wordMap, array);

		for (String word : list)
		{
			placeCrossWordWord(word, wordMap, array);
		}

	}

	private static boolean placeCrossWordWord(String word,
			HashMap<String, WordLocation> wordMap, CrossWordCell[][] array)
	{
		int length = word.length();
		WordLocation location;
		if (wordMap.isEmpty())
		{
			// Test down/across
			location = new WordLocation(19, 0, 19, length);
			// location = new WordLocation(0, 0,length,0);
		} else
		{
			location = findWordLocation(word, array);
		}

		if (location != null)
		{
			if (location.getBegining().getX() != location.getEnd().getX())
			{
				wordMap.put(word, location);
				return placeCrossWordWordAcross(word, location, array);

			} else
			{
				wordMap.put(word, location);
				return placeCrossWordWordDown(word, location, array);
			}
		} else
		{
			return false;
		}

	}

	private static WordLocation findWordLocation(String word,
			CrossWordCell[][] cellArray)
	{

		HashMap<String, WordLocation> potentialLocations = new HashMap<String, WordLocation>();

		for (int i = 0; i < word.length(); i++)
		{

			for (int j = 0; j < cellArray.length; j++)
			{
				for (int k = 0; k < cellArray[0].length; k++)
				{

					if (word.charAt(i) == cellArray[j][k].getChar())
					{
						System.out.println(word.charAt(i) + " "
								+ cellArray[j][k].getChar());
						WordLocation potLocation;
						// Make sure across/down check is in bounds
						if (j + 1 < cellArray[0].length
								|| (j + 1 == cellArray[0].length && i == word
										.length() - 1))
						{

							// Check if placing across or down. If this cell is
							// part of a word it can only be down.
							if ((!(j + 1 == cellArray[0].length && i == word
									.length() - 1))
									&& cellArray[j + 1][k].isPartOfWord() == true)
							{
								if (k - i >= 0
										&& k - i + word.length() - 1 < cellArray.length)
								{
									potLocation = new WordLocation(new Vector2(
											j , k-i), new Vector2(j
											, (k-i)+ word.length()));
									if (canPlaceDown(cellArray, word,
											potLocation))
									{
										return potLocation;
									}
								}

							}

							// Across
							else
							{
								if (j - i >= 0
										&& j - i + word.length() - 1 < cellArray.length)
								{
									System.out.println("Test");
									potLocation = new WordLocation(new Vector2(
											j - i, k), new Vector2((j - i)
											+ word.length(), k));

									if (canPlaceAcross(cellArray, word,
											potLocation))
									{
										potLocation.printLocation();
										return potLocation;
									}
								} else
								{
									System.out.println("fail");
								}

							}
						}

						// potentialLocations.put(potLocation, word);
					}
				}
			}
		}

		return null;
	}

	private static boolean canPlaceDown(CrossWordCell[][] cellArray,
			String word, WordLocation potLocation)
	{
		// Can't place 2 Down word back to back
				if (cellArray[potLocation.getBegining().getX()][potLocation
						.getBegining().getY()].isFinalCharDown())
				{
					return false;
				}
				int charIndex = 0;
				int col = potLocation.getBegining().getX();

				for (int i = potLocation.getBegining().getY(); i < potLocation.getEnd()
						.getY(); i++)
				{
					if (cellArray[col][i].isInitialCharDown())
					{
						return false;
					}
				}

				for (int i = potLocation.getBegining().getY(); i < potLocation.getEnd()
						.getY(); i++)
				{
					if (cellArray[col][i].isPartOfWord()
							&& (cellArray[col][i].getChar() != word.charAt(charIndex)))
					{

						return false;
					}
					charIndex++;
				}
				return true;
	
	}

	private static boolean canPlaceAcross(CrossWordCell[][] cellArray,
			String word, WordLocation potLocation)
	{
		// Can't place 2 Across word back to back
		if (cellArray[potLocation.getBegining().getX()][potLocation
				.getBegining().getY()].isFinalCharAcross())
		{
			return false;
		}
		int charIndex = 0;
		int row = potLocation.getBegining().getY();

		for (int i = potLocation.getBegining().getX(); i < potLocation.getEnd()
				.getX(); i++)
		{
			if (cellArray[i][row].isInitialCharAcross())
			{
				return false;
			}
		}

		for (int i = potLocation.getBegining().getX(); i < potLocation.getEnd()
				.getX(); i++)
		{
			if (cellArray[i][row].isPartOfWord()
					&& (cellArray[i][row].getChar() != word.charAt(charIndex)))
			{

				return false;
			}
			charIndex++;
		}
		return true;
	}

	private static boolean placeCrossWordWordAcross(String word,
			WordLocation location, CrossWordCell[][] array)
	{
		int begining = location.getBegining().getX();
		int end = location.getEnd().getX();
		int row = location.getBegining().getY();

		System.out.println(word);
		array[location.getBegining().getX()][location.getBegining().getY()]
				.setInitialCharAcross(true);
		array[location.getEnd().getX() - 1][location.getEnd().getY()]
				.setFinalCharAcross(true);

		int charIndex = 0;
		for (int i = begining; i < end; i++)
		{
			array[i][row].setChar(word.charAt(charIndex));
			charIndex++;
		}
		System.out.println();
		System.out.printf("%s has been placed at X: %d Y:%d", word, location
				.getBegining().getX(), location.getBegining().getY());
		return true;
	}

	private static boolean placeCrossWordWordDown(String word,
			WordLocation location, CrossWordCell[][] array)
	{
		int begining = location.getBegining().getY();
		int end = location.getEnd().getY();
		int col = location.getBegining().getX();
		
		array[location.getBegining().getX()][location.getBegining().getY()]
				.setInitialCharDown(true);
		array[location.getEnd().getX() - 1][location.getEnd().getY()-1]
				.setFinalCharDown(true);

		int charIndex = 0;
		for (int i = begining; i < end; i++)
		{
			array[col][i].setChar(word.charAt(charIndex));
			charIndex++;
		}
		return true;
	}
}

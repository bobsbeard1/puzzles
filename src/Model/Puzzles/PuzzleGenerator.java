package Model.Puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
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
			return generateWordSearch(size, wordList);
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
	private static WordSearch generateWordSearch(int size, WordList words)
	{
		WordSearchCell[][] wordSearchArray = new WordSearchCell[size][size];
		
		// initialize array to #s
		for (int i = 0; i < wordSearchArray.length; i++)
		{
			for (int j = 0; j < wordSearchArray[0].length; j++)
			{
				wordSearchArray[i][j] = new WordSearchCell('#');
			}
		}
		
		// add each word
		for (int i = 0; i < words.getLength(); i++)
		{
			//System.out.println("word at i = " + words.getWordAt(i) + " wordList Length = " + words.getLength());
			wordSearchArray = addWord (words.getWordAt(i), wordSearchArray);
			
		}
		
		wordSearchArray = addRandomChars (wordSearchArray);
		
		WordSearch wordSearch = new WordSearch (wordSearchArray);

		return wordSearch;
	}
	
	/**
	 * Adds the given word to the word search
	 * @param word
	 * 			The word to be added
	 * @param puzzle
	 * 			The puzzle
	 */
	private static WordSearchCell[][] addWord (String word, WordSearchCell[][] originalPuzzle)
	{
		// size int
		int size = originalPuzzle.length;
		
		// copy puzzle to newPuzzle
		WordSearchCell[][] newPuzzle = new WordSearchCell[size][size];
		
		for (int row = 0; row < size; row++)
		{
			for( int col = 0; col < size; col++)
			{
				//System.out.println("row: " + row + "  col: " + col);
				newPuzzle[row][col] = new WordSearchCell('#');
				newPuzzle[row][col].setChar(originalPuzzle[row][col].getChar());
				newPuzzle[row][col].setPartOfWord(originalPuzzle[row][col].isPartOfWord());
			}
		}
		//System.out.printf("new = " + newPuzzle + " orig = " + originalPuzzle);
		// random orientation and direction
			Random rand = new Random ();
			
			// orientation 0 -> forward
			// orientation 1 -> backward
			int orientation = rand.nextInt(100)%2;
			
			// direction 0 -> horizontal
			// direction 1 -> vertical
			// direction 2 -> diagonal up
			// direction 3 -> diagonal down
			int direction = rand.nextInt(100)%3;
			
			// word is backwards, so flip
			if (orientation == 1)
			{
				word = flipString (word);
			}
			
			// for loop to try first locations
			for (int attempt = 0; attempt < size*size; attempt++)
			{
				boolean validLocation = false;
				
				int x,y;
				do
				{
					// random first char location
					x = rand.nextInt(newPuzzle.length);
					y = rand.nextInt(newPuzzle.length);
					//System.out.println("x = " + x + " y = " + y + " x + word.length() = " + (x + word.length()));
					// test boundaries
					switch (direction)
					{
						case 0:
						{
							if (!(x + word.length() >= size))
							{
								validLocation = true;
							}
							break;
						}
						case 1:
						{
							if (!(y + word.length() >= size))
							{
								validLocation = true;
							}
							break;
						}
						case 2:
							if (!(x + word.length() >= size) && !(y - word.length() < 0))
							{
								validLocation = true;
							}
							break;
						case 3:
						{
							if (!(x + word.length() >= size) && !(y + word.length() >= size))
							{
								validLocation = true;
							}
							break;
						}
							
					}
				}
				while (!validLocation);
				
				// try to fill word. if bad intersection, get out and try a new spot
				int index;
				for (index = 0; index < word.length (); index++)
				{
					// valid cell for this char
					if (newPuzzle[x][y].getChar() == '#' || newPuzzle[x][y].getChar() == word.charAt(index))
					{
						// cell is valid, place char and increment cell
						newPuzzle[x][y].setChar (word.charAt(index));
						newPuzzle[x][y].setPartOfWord (true);
						
						switch (direction)
						{
							case 0:
								x++;
								break;
							case 1:
								y++;
								break;
							case 2:
								x++;
								y--;
								break;
							case 3:
								x++;
								y++;
								break;
						}
					}
					else
					{
						
						// word placement is bad, clean out any changes
						for (int j = index; j > 0; j--)
						{

							//System.out.println("j = " + j + " i = " + index + " x = " + x + " y  = " + y);
							// walk back through the word, depending on direction
							switch (direction)
							{
								case 0:
									x--;
									break;
								case 1:
									y--;
									break;
								case 2:
									x--;
									y++;
									break;
								case 3:
									x--;
									y--;
									break;
							}
							newPuzzle[x][y].setChar(originalPuzzle[x][y].getChar ());
							newPuzzle[x][y].setPartOfWord(false);
						}
						
						// get out and try a new spot
						break;
					} // end else
					
				} // end for
				
				// word successfully placed, return newPuzzle
				if (index >= word.length ())
				{				
					return newPuzzle;
					
				}
					
				
				
			} // end for
			
			return originalPuzzle;
			
		
	}
	
	
	public static WordSearchCell[][] addRandomChars (WordSearchCell[][] puzzle)
	{
		int size = puzzle.length;
		// fill with random chars
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (puzzle[i][j].getChar () == '#')
				{
					puzzle[i][j].setChar(RandomHelper.getRandomChar ());
				}
			}
		}
		
		return puzzle;
	}
	
	/**
	 * 
	 * @param word
	 * 			String to be reversed
	 * @return
	 */
	private static String flipString (String word)
	{
		StringBuilder flippedString = new StringBuilder ();

		for (int i = word.length () - 1; i >= 0; i--)
		{
			flippedString.append(word.charAt(i));
		}
		
		return flippedString.toString();
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
		// placeCrossWordWord(list.getWordAt(0), wordMap, array);
		int count = 0;
		for (String word : list)
		{
			if(placeCrossWordWord(word, wordMap, array))
			{
				count++;
			}
		}
		//System.out.println(count);

	}

	private static boolean placeCrossWordWord(String word,
			HashMap<String, WordLocation> wordMap, CrossWordCell[][] array)
	{
		int length = word.length();
		WordLocation location;
		if (wordMap.isEmpty())
		{
			// Test down/across
			//location = new WordLocation(19, 0, 19, length);
			
			Random rand = new Random ();
			System.out.println(word + " " + length);
			int seedX = rand.nextInt(20-length);
			int seedY = rand.nextInt(20);
			
			location = new WordLocation(seedX, seedY, seedX+length, seedY);
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
						// System.out.println(word.charAt(i) + " "
						// + cellArray[j][k].getChar());
						WordLocation potLocation;
						// Make sure across/down check is in bounds
						/*
						 * if (j + 1 < cellArray[0].length || (j + 1 ==
						 * cellArray[0].length && i == word .length() - 1)) {
						 * 
						 * // Check if placing across or down. If this cell is
						 * // part of a word it can only be down. if ((!(j + 1
						 * == cellArray[0].length && i == word .length() - 1))
						 * && cellArray[j + 1][k].isPartOfWord() == true) { if
						 * (k - i >= 0 && k - i + word.length() - 1 <
						 * cellArray.length) {
						 */
						try
						{
							potLocation = new WordLocation(
									new Vector2(j, k - i), new Vector2(j,
											(k - i) + word.length()));
							if (canPlaceDown(cellArray, word, potLocation))
							{
								return potLocation;
							}
							// }

							// }

							// Across
							/*
							 * else { if (j - i >= 0 && j - i + word.length() -
							 * 1 < cellArray.length) {
							 * System.out.println("Test");
							 */
							
						} catch (Exception e)
						{
						}
						try
						{

							// }

							// }

							// Across
							/*
							 * else { if (j - i >= 0 && j - i + word.length() -
							 * 1 < cellArray.length) {
							 * System.out.println("Test");
							 */
							potLocation = new WordLocation(
									new Vector2(j - i, k), new Vector2((j - i)
											+ word.length(), k));

							if (canPlaceAcross(cellArray, word, potLocation))
							{

								return potLocation;
							}
						} catch (Exception e)
						{
						}
						/*
						 * } else { System.out.println("fail"); }
						 * 
						 * } }
						 */

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

		// Can't have words next to each other
		try
		{
			if (potLocation.getEnd().getY() + 1 < cellArray.length)
			{
				if (cellArray[potLocation.getEnd().getX()][potLocation.getEnd()
						.getY() + 1].isPartOfDownWord())
				{
					return false;
				}
			}
			if (cellArray[potLocation.getBegining().getX()][potLocation
					.getBegining().getY() - 1].isPartOfDownWord())
			{
				return false;
			}
		} catch (Exception e)
		{
		}

		for (int i = potLocation.getBegining().getY(); i < potLocation.getEnd()
				.getY(); i++)
		{
			if (cellArray[col][i].isInitialCharDown())
			{
				return false;
			}
			try
			{
				if (col - 1 >= 0)
				{
					if (cellArray[col - 1][i].isPartOfDownWord())
					{
						return false;
					}
				}
				if (cellArray[col + 1][i].isPartOfDownWord())
				{
					return false;
				}
			} catch (Exception e)
			{
				// TODO: handle exception
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
		// return false;
		if(word.length() >= cellArray.length)
		{
			return false;
		}
		if(potLocation.getBegining().getX() < 0 || potLocation.getEnd().getX() > cellArray.length ||
				potLocation.getBegining().getY() < 0 || potLocation.getEnd().getY() > cellArray.length)
		{return false;}

		// Can't place 2 Across words sharing the last/initial letter
		if (cellArray[potLocation.getBegining().getX()][potLocation
				.getBegining().getY()].isFinalCharAcross())
		{
			return false;
		}
		// Can't have words next to each other
		if (cellArray[potLocation.getEnd().getX() + 1][potLocation.getEnd()
				.getY()].isPartOfWord())
		{
			return false;
		}
		if (cellArray[potLocation.getBegining().getX() - 1][potLocation
				.getBegining().getY()].isPartOfWord())
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
			try
			{
				if (row + 1 < cellArray.length)
				{
					if (cellArray[i][row + 1].isPartOfAcrossWord())
					{
						return false;
					}

				}
				if (cellArray[i][row - 1].isPartOfAcrossWord())
				{
					return false;
				}
			} catch (Exception e)
			{
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

		
		array[location.getBegining().getX()][location.getBegining().getY()]
				.setInitialCharAcross(true);
		if (location.getEnd().getX() - 1 > 0)
		{

			array[location.getEnd().getX() - 1][location.getEnd().getY()]
					.setFinalCharAcross(true);
		}

		int charIndex = 0;
		for (int i = begining; i < end; i++)
		{
			array[i][row].setChar(word.charAt(charIndex));
			array[i][row].setPartOfAcrossWord(true);
			charIndex++;
		}
		//System.out.println();
		//System.out.printf("%s has been placed at X: %d Y:%d", word, location
				//.getBegining().getX(), location.getBegining().getY());
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
		array[location.getEnd().getX()][location.getEnd().getY() - 1]
				.setFinalCharDown(true);

		int charIndex = 0;
		for (int i = begining; i < end; i++)
		{
			array[col][i].setChar(word.charAt(charIndex));
			array[col][i].setPartOfDownWord(true);
			charIndex++;
		}
		//.out.println();
		//System.out.printf("%s has been placed at X: %d Y:%d", word, location
				//.getBegining().getX(), location.getBegining().getY());
		return true;
	}
}

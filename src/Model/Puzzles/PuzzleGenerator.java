package Model.Puzzles;

import Model.Puzzles.Parts.*;
import Utility.RandomHelper;



public class PuzzleGenerator 
{
	public static Puzzle generatePuzzle(PuzzleType type, int size)
	{
		switch (type)
		{
		case CrossWord:
			return generateCrossWord(size);
		case WordSearch:
			return generateWordSearch(size);
		}
		return null;
		
	}
	private static WordSearch generateWordSearch(int size)
	{

		WordSearch wordSearch = new WordSearch (size);
		WordSearchCell[][] wordsearchArray = new WordSearchCell[size][size];
		
		for (int i = 0; i < wordsearchArray.length; i++)
		{
			for (int j = 0; j < wordsearchArray[0].length; j++)
			{
				wordsearchArray[i][j] = new WordSearchCell(RandomHelper.getRandomChar());
			}
		}
		
		wordSearch = new WordSearch (wordsearchArray);
		
		return wordSearch;
	}
	private static CrossWord generateCrossWord(int size)
	{

		CrossWordCell[][] crosswordArray = new CrossWordCell[size][size];
		
		for (int i = 0; i < crosswordArray.length; i++)
		{
			for (int j = 0; j < crosswordArray[0].length; j++)
			{
				crosswordArray[i][j] = new CrossWordCell(RandomHelper.getRandomChar());
			}
		}
		
		crosswordArray[0][0].setChar('#');
		crosswordArray[0][1].setChar('#');
		crosswordArray[0][2].setChar('#');
		crosswordArray[0][3].setChar('#');
		crosswordArray[1][3].setChar('#');
		crosswordArray[5][5].setChar('#');
		crosswordArray[2][2].setChar('#');
		
		return new CrossWord(crosswordArray);
		
	}
}

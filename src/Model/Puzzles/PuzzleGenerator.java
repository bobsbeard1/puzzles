package Model.Puzzles;

import Model.Puzzles.Parts.CrossWordCell;
import Utility.RandomHelper;



public class PuzzleGenerator 
{
	public static Puzzle  generatePuzzle(PuzzleType type)
	{
		switch (type)
		{
		case CrossWord:
			
			CrossWordCell[][] cellArray = new CrossWordCell[20][20];
			
			for (int i = 0; i < cellArray.length; i++)
			{
				for (int j = 0; j < cellArray[0].length; j++)
				{
					cellArray[i][j] = new CrossWordCell(RandomHelper.getRandomChar());
				}
			}
			
			cellArray[0][0].setChar('#');
			cellArray[0][1].setChar('#');
			cellArray[0][2].setChar('#');
			cellArray[0][3].setChar('#');
			cellArray[1][3].setChar('#');
			cellArray[5][5].setChar('#');
			cellArray[2][2].setChar('#');
			
			return new CrossWord(cellArray);
			
		case WordSearch:
			//Add WordSearch Generation code here
			return new WordSearch();
		
		}
		return null;
		
	}
}

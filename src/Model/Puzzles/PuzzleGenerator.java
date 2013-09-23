package Model.Puzzles;

import Model.Puzzles.Parts.CrossWordCell;



public class PuzzleGenerator 
{
	public static Puzzle  generatePuzzle(PuzzleType type)
	{
		switch (type)
		{
		case CrossWord:
			
			CrossWordCell[][] cellArray = new CrossWordCell[6][6];
			
			for (int i = 0; i < cellArray.length; i++)
			{
				for (int j = 0; j < cellArray[0].length; j++)
				{
					cellArray[i][j] = new CrossWordCell('a');
				}
			}
			return new CrossWord(cellArray);
			
		case WordSearch:
			//Add WordSearch Generation code here
			return new WordSearch();
		
		}
		return null;
		
	}
}

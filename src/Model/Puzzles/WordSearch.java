package Model.Puzzles;

import java.awt.Dimension;

import Model.Puzzles.Parts.*;

public class WordSearch extends Puzzle
{

	public WordSearch (int size)
	{
		cellArray = new WordSearchCell[size][size];
	}
	public WordSearch (WordSearchCell[][] inputArray)
	{
		cellArray = inputArray;
	}
	
	@Override
	public char charAt(int x, int y)
	{
		return (Character)cellArray[x][y];
	}
	
	public WordSearchCell getCell(int x, int y)
	{
		return (WordSearchCell)cellArray[x][y];
	}
	
	public WordSearchCell[][] getCellArray()
	{
		return (WordSearchCell[][])cellArray;
	}

	@Override
	public boolean addWord(String word, WordLocation location)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWord(String word, WordLocation location)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	public void printWordSearch()
	{
		
		System.out.println("\nWord Search:");
		for (int i = 0; i < cellArray.length; i++)
		{
			for (int j = 0; j < cellArray[0].length; j++)
			{
				System.out.print(((WordSearchCell)cellArray[i][j]).getChar());
				System.out.print(' ');
			}
			System.out.println();
		}
		
	}
	
}

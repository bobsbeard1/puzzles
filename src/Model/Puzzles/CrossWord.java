package Model.Puzzles;

import Model.Puzzles.Parts.*;
import java.awt.Dimension;
import java.util.*;

public class CrossWord extends Puzzle
{

	public CrossWord(CrossWordCell[][] puzzleArray)
	{
		cellArray = puzzleArray;
	}
	
	public HashMap<String,WordLocation>  getWordMap()
	{
		return wordMap;
	}
	
	public void setWordMap(HashMap<String,WordLocation> map)
	{
		wordMap = map;
	}
	@Override
	public char charAt(int x, int y)
	{
		return ((CrossWordCell)cellArray[x][y]).getChar();
	}
	
	public CrossWordCell getCell(int x, int y)
	{
		return (CrossWordCell)cellArray[x][y];
	}
	
	public CrossWordCell[][] getCellArray()
	{
		return (CrossWordCell[][])cellArray;
	}
	
	@Override
	public boolean addWord(String word, WordLocation location)
	{
		return true;
	}
	@Override
	public boolean deleteWord(String word, WordLocation location)
	{	

		return true;
	}

	public void printCrossWord()
	{
		for (int i = 0; i < cellArray.length; i++)
		{
			for (int j = 0; j < cellArray[0].length; j++)
			{
				System.out.print(((CrossWordCell)cellArray[i][j]).getChar());
				System.out.print(' ');
			}
			System.out.println();
		}
		
	}
	
	
}

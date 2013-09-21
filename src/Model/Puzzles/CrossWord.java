package Model.Puzzles;

import Model.Puzzles.Parts.*;

import java.awt.Dimension;
import java.util.*;

public class CrossWord extends Puzzle
{
	HashMap<String,WordLocation> wordMap;
	
	CrossWordCell[][] cellArray;
	
	@Override
	public char charAt(Dimension dim)
	{
		return cellArray[dim.width][dim.height].getChar();
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
}

package Model;

import java.io.IOException;
import java.util.HashMap;

import Model.Puzzles.CrossWord;
import Model.Puzzles.PuzzleGenerator;
import Model.Puzzles.PuzzleType;
import Model.Puzzles.WordSearch;
import Model.Puzzles.Parts.WordLocation;
import Utility.FileManager;

public class GameModel 
{
	WordList wordList;
	String path;
	CrossWord crossWord;
	WordSearch wordSearch;
	int size;
	
	
	public GameModel() throws IOException
	{
		size = 20;
		crossWord = (CrossWord)PuzzleGenerator.generatePuzzle(PuzzleType.CrossWord, size);
		wordSearch = (WordSearch)PuzzleGenerator.generatePuzzle (PuzzleType.WordSearch, size);
		path = "moby_list.txt";
		wordList = new WordList(FileManager.getSubWordListFromFile(path, 100));
	}
	
	public WordSearch getWordSearch()
	{
		return wordSearch;
	}
	
	public CrossWord getCrossWord()
	{
		return crossWord;
	}
	
	

	
	
}

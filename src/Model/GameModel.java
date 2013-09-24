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
		path = "words.txt";
		if(path.endsWith("txt"))
		{
			WordList wordList = new WordList(FileManager.getWordListFromFile(path));
			//WordList wordList = new WordList(FileManager.getSubWordListFromFile(path,50));
			wordList.printList();
			System.out.println(wordList.getLength());
		}
		else
		{
			//WordList wordList = new WordList(FileManager.getSubWordListFromFile(path,50));
			WordList wordList = new WordList(FileManager.getWordListFromFile(path));
			wordList.printList();
			System.out.println(wordList.getLength());
		}
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

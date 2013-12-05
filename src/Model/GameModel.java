package Model;

import java.io.IOException;
import java.util.HashMap;

import Model.Puzzles.CrossWord;
import Model.Puzzles.PuzzleGenerator;
import Model.Puzzles.PuzzleType;
import Model.Puzzles.WordSearch;
import Model.Puzzles.Parts.WordLocation;
import Utility.FileManager;

/**
 * Class to represent the puzzles and word list. 
 * @author tom
 *
 */
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
		
		path = "goodwords.txt";
		//wordList = new WordList(FileManager.getWordListFromFile(path));
		
		//path = "goodwords.txt";
		wordList = new WordList(FileManager.getWordListFromFile(path));
		//wordList = new WordList(path);
		wordList.sortByLength();
		
		
		
		//wordList.printList();
		generatePuzzles ();
	}

	public WordSearch getWordSearch()
	{
		return wordSearch;
	}

	public CrossWord getCrossWord()
	{
		return crossWord;
	}
	
	public WordList getWordList ()
	{
		return wordList;
	}
	
	public void generatePuzzles ()
	{
		
		wordList.printList();
		
		crossWord = (CrossWord) PuzzleGenerator.generatePuzzle(
				PuzzleType.CrossWord, size, wordList);
		
		wordSearch = (WordSearch) PuzzleGenerator.generatePuzzle(
				PuzzleType.WordSearch, size, wordList);
	}
	

}

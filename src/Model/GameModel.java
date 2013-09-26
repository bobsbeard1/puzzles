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
		
		//path = "words.txt";
		//wordList = new WordList(FileManager.getWordListFromFile(path));
		
		path = "moby_list.txt";
		wordList = new WordList(FileManager.getSubWordListFromFile(path, 4000));
		wordList.sortByLength();
		
		//wordList.printList();
		crossWord = (CrossWord) PuzzleGenerator.generatePuzzle(
				PuzzleType.CrossWord, size, wordList);
		wordSearch = (WordSearch) PuzzleGenerator.generatePuzzle(
				PuzzleType.WordSearch, size, wordList);
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

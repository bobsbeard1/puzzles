package Control;

import java.io.IOException;
import java.util.HashMap;

import Utility.FileManager;
import View.GUI;
import Model.WordList;
import Model.Puzzles.*;
import Model.Puzzles.Parts.WordLocation;

import javax.swing.*;

public class Main
{
	//Currently acting as controller
	public static void main(String[] args) throws IOException
	{
		final GUI gui = new GUI();
		//54
		String path = "moby_list.txt";
		WordList wordList = new WordList(FileManager.getSubWordListFromFile(path,50));
		wordList.printList();
		System.out.println(wordList.getLength());
		
		
		int size = 20;
		
		CrossWord word = (CrossWord)PuzzleGenerator.generatePuzzle(PuzzleType.CrossWord, size);
		CrossWord word2 = (CrossWord)PuzzleGenerator.generatePuzzle(PuzzleType.CrossWord, size);
		
		WordSearch search = (WordSearch)PuzzleGenerator.generatePuzzle (PuzzleType.WordSearch, size);
		
		HashMap<String,WordLocation> map1 = new HashMap<String,WordLocation>();
		HashMap<String,WordLocation> map2 = new HashMap<String,WordLocation>();
		
		map1.put("One", new WordLocation(1,2));
		map2.put("Two",new WordLocation(2,1));
		map2.put("Three",new WordLocation(2,1));
		
		word.printCrossWord();
		search.printWordSearch();
		
		word.setWordMap(map1);
		
		word2.setWordMap(map2);
		
		gui.getPuzzleArea().setActivePuzzle(search);
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				
				gui.draw();
			
			}
		});

	}

}

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
		
		String path = "moby_list.txt";
		WordList wordList = new WordList(FileManager.readFile(path));
		
		wordList.printList();
		
		
		CrossWord word = (CrossWord)PuzzleGenerator.generatePuzzle(PuzzleType.CrossWord);
		CrossWord word2 = (CrossWord)PuzzleGenerator.generatePuzzle(PuzzleType.CrossWord);
		
		HashMap<String,WordLocation> map1 = new HashMap<String,WordLocation>();
		HashMap<String,WordLocation> map2 = new HashMap<String,WordLocation>();
		
		map1.put("One", new WordLocation(1,2));
		map2.put("Two",new WordLocation(2,1));
		map2.put("Three",new WordLocation(2,1));
		
		word.printCrossWord();
		
		word.setWordMap(map1);
		System.out.println(word.getWordMap().size());
		word2.setWordMap(map2);
		
		System.out.println(word.getWordMap().size());
		System.out.println(word2.getWordMap().size());
		
		
		
		gui.getPuzzleArea().setActivePuzzle(word);
		

		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				
				gui.draw();
			
			}
		});

	}

}

package Control;

import java.io.IOException;
import java.util.HashMap;

import Utility.FileManager;
import View.GUI;
import Model.GameModel;
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
		
		GameModel model = new GameModel();
		
		
		
		gui.getPuzzleArea().setActivePuzzle(model.getCrossWord());
		

		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				
				gui.draw();
			
			}
		});

	}

}

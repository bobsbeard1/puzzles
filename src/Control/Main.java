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
	// Currently acting as controller
	public static void main(String[] args) throws IOException
	{
		Controller controller = new Controller();
		controller.run();
	}
}
package Control;

import java.io.IOException;

import javax.swing.SwingUtilities;

import Model.GameModel;
import View.GUI;

public class Controller
{
	GameModel model;
	 GUI gui;
	

	public Controller() throws IOException
	{
		gui = new GUI(this);
		model = new GameModel();
	}
	
	public void run()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				
				gui.draw();
			
			}
		});
	}
	
	public GameModel getModel()
	{
		return model;
	}
	public GUI getGUI()
	{
		return gui;
	}
	

	

}




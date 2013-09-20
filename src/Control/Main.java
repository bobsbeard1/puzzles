package Control;

import View.GUI;
import javax.swing.*;
import javax.swing.text.*;

public class Main
{

	public static void main(String[] args)
	{

		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				GUI gui = new GUI();
				gui.draw();
				System.out.println("Test");
			}
		});

	}

}

package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import View.Components.*;

public class GUI extends JFrame
{
	

	public GUI()
	{
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		mainPanel.setPreferredSize(new Dimension(1200,1200));	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocationRelativeTo(null);
		
		
		PuzzleArea puzzleArea = new PuzzleArea();
		ToolBar toolbar = new ToolBar();
		WordListArea wordListArea = new WordListArea();
		
		mainPanel.add(toolbar,BorderLayout.WEST);
		mainPanel.add(wordListArea,BorderLayout.EAST);
		mainPanel.add(puzzleArea);
		
		add(mainPanel);


	}

	

	public void draw()
	{
		setVisible(true);
	}

}

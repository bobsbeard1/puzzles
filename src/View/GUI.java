package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import View.Components.*;

public class GUI extends JFrame
{
	PuzzleArea puzzleArea;
	ToolBar toolbar;
	WordListArea wordListArea;
	
	
	public GUI()
	{
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		mainPanel.setPreferredSize(new Dimension(1200,1200));	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocationRelativeTo(null);
		
		
		puzzleArea = new PuzzleArea();
		toolbar = new ToolBar();
		wordListArea = new WordListArea();
		
		mainPanel.add(toolbar,BorderLayout.WEST);
		mainPanel.add(wordListArea,BorderLayout.EAST);
		mainPanel.add(puzzleArea);
		
		add(mainPanel);


	}
	
	public PuzzleArea getPuzzleArea()
	{
		return puzzleArea;
	}

	

	public void draw()
	{
		setVisible(true);
	}

}

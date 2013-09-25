package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import View.Components.*;

public class GUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	PuzzleArea puzzleArea;
	ToolBar toolbar;
	WordListArea wordListArea;
	
	CrosswordTab crossTab;
	WordSearchTab wsTab;
	int height, width;
	
	public GUI()
	{
		/*JPanel mainPanel = new JPanel(new BorderLayout());
		
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
		
		add(mainPanel);*/
		setTitle("WORD PUZZLES!");
		setSize(1250,900);
		height = getSize().height;
		width = getSize().width;
		wsTab = new WordSearchTab();
		crossTab = new CrosswordTab();
		
		JTabbedPane tab = new JTabbedPane();
		add(tab);
		tab.addTab("Word Search", wsTab);
		tab.addTab("Crossword",crossTab);

		

	}
	
	class WordSearchTab extends JPanel{

		private static final long serialVersionUID = 1L;

		public WordSearchTab(){
			puzzleArea = new PuzzleArea();
			wordListArea = new WordListArea(height);
			toolbar = new ToolBar(height);
			
			add(toolbar, BorderLayout.WEST);
			add(puzzleArea);
			add(wordListArea,BorderLayout.EAST);
			revalidate();
			repaint();
		}
		
	}
	class CrosswordTab extends JPanel{

		private static final long serialVersionUID = 1L;

		public CrosswordTab(){		
			puzzleArea = new PuzzleArea();
			wordListArea = new WordListArea(height);
			toolbar = new ToolBar(height);
			
			add(toolbar, BorderLayout.WEST);
			add(puzzleArea);
			add(wordListArea,BorderLayout.EAST);
			revalidate();
			repaint();
		}
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

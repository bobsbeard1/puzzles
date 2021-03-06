package View.Components;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import Control.Controller;
import Model.GameModel;
import Model.IOManager;
import Model.Puzzles.CrossWord;
import Model.Puzzles.PuzzleType;
import Model.Puzzles.WordSearch;

public class ToolBar extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton generateButton;
	JButton rearrangeButton;
	JButton saveButton;
	JButton loadButton;
	Controller controlRef;
	IOManager ioMan;
	PuzzleType puzType;
	JButton showWords;
	
	public ToolBar(final Controller control, PuzzleType type)
	{
		puzType = type;
		ioMan = new IOManager();
		controlRef = control;
		Dimension size = new Dimension();
		size.width = 200;
		generateButton = new JButton("Generate Puzzle");
		rearrangeButton = new JButton("Rearrange");
		saveButton = new JButton("Save Puzzle");
		loadButton = new JButton("Load Puzzle");
		showWords = new JButton("Show Words");

		setPreferredSize(size);
	//	this.setBackground(Color.orange);
		
		
		generateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				control.getModel().generatePuzzles ();
				control.getGUI().refreshGUI();
				
				control.getGUI().revalidate();
				control.getGUI().repaint();
				
			}
		});
		
		
		rearrangeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(puzType == PuzzleType.WordSearch)
			{
				WordSearch wordSearch = control.getModel().getWordSearch();
				for (int i = 0; i < wordSearch.getCellArray().length; i++) {
					for (int j = 0; j < wordSearch.getCellArray().length; j++) {
						
						System.out.print(wordSearch.getCell(j, i).getChar());
						System.out.print(' ');
					}
					System.out.println();
					
				}
				ioMan.WriteToCSV(control.getModel().getWordSearch(),PuzzleType.WordSearch);
				ioMan.WriteToHTML(control.getModel().getWordSearch(), PuzzleType.WordSearch);
			}
				else {
					CrossWord crossWord = control.getModel().getCrossWord();
					for (int i = 0; i < crossWord.getCellArray().length; i++) {
						for (int j = 0; j < crossWord.getCellArray().length; j++) {
							
							System.out.print(crossWord.getCell(j, i).getChar());
							System.out.print(' ');
						}
						System.out.println();
						
					}
					ioMan.WriteToCSV(control.getModel().getCrossWord(),PuzzleType.CrossWord);
					ioMan.WriteToHTML(control.getModel().getCrossWord(), PuzzleType.CrossWord);
					
				}
				
			}
		});
		
		showWords.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println (control.getGUI().getShowWords());
				if (control.getGUI().getShowWords())
				{
					showWords.setText("ShowWords");
					control.getGUI().setShowWords(false);
				}
				else
				{
					showWords.setText("HideWords");
					control.getGUI().setShowWords(true);
				}
				
				control.getGUI().revalidate();
				control.getGUI().repaint();
				
			}
		});

		
		
		
		loadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.anchor = GridBagConstraints.FIRST_LINE_START;
		constraint.insets = new Insets(1, 1, 5, 5);
		
		constraint.weighty = .1;
		constraint.gridx = 0;
		constraint.gridy = 0;
		add(generateButton, constraint);
		constraint.gridx = 0;
		constraint.gridy = 1;
		//add(rearrangeButton, constraint);
		add(showWords, constraint);
		constraint.gridx = 0;
		constraint.gridy = 2;
		add(saveButton, constraint);
		constraint.weighty = 10;
		constraint.gridx = 0;
		constraint.gridy = 3;
		add(loadButton, constraint);

		
	}
	public void actionPerformed(ActionEvent arg0){
	}
	
}

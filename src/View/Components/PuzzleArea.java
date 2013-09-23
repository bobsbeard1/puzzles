package View.Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Model.Puzzles.*;
import Model.Puzzles.Puzzle;
import Model.Puzzles.PuzzleType;
import Model.Puzzles.Parts.CrossWordCell;

public class PuzzleArea extends JPanel
{
	private static final int CELL_SIZE = 30;
	Puzzle activePuzzle;
	

	public PuzzleArea()
	{
		setPreferredSize(new Dimension(100, 100));
		this.setBackground(Color.blue);
	}

	public void drawPuzzle(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		if (activePuzzle instanceof CrossWord)
		{
			drawCrossWord(g2d);
		}

		if (activePuzzle instanceof WordSearch)
		{
			drawWordSearch(g2d);
		}

	}

	public void drawCrossWord(Graphics2D g2d)
	{
		CrossWordCell[][] array = ((CrossWord)activePuzzle).getCellArray();
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[0].length; j++)
			{
				drawCrossWordCell((i *CELL_SIZE),(j * CELL_SIZE),array[i][j],g2d);
			}
		}
		
		
	
	}

	public void drawCrossWordCell(int x, int y, CrossWordCell cell,
			Graphics2D g2d)
	{
		if (cell.getChar() != CrossWordCell.EMPTY_CELL)
		{
			g2d.setColor(Color.white);
		} else
		{
			g2d.setColor(Color.black);
		}
		g2d.drawRect(x, y, CELL_SIZE, CELL_SIZE);
		g2d.fillRect(x, y, CELL_SIZE, CELL_SIZE);
	}

	public void drawWordSearch(Graphics2D g2d)
	{

	}
	
	public void setActivePuzzle(Puzzle puzzle)
	{
		activePuzzle = puzzle;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawPuzzle(g);
	}

}

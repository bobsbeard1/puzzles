package View.Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import Model.Puzzles.*;
import Model.Puzzles.Parts.*;

public class PuzzleArea extends JPanel
{
	private static final int CELL_SIZE = 40;
	Puzzle activePuzzle;

	public PuzzleArea()
	{
		setPreferredSize(new Dimension(CELL_SIZE * 20, CELL_SIZE * 20));
	//	this.setBackground(Color.blue);
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
		drawCrossWordCells(g2d);
		drawCrossWordCharacters(g2d);

	}

	public void drawCrossWordCells(Graphics2D g2d)
	{
		CrossWordCell[][] array = ((CrossWord) activePuzzle).getCellArray();

		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[0].length; j++)
			{
				CrossWordCell cell = array[i][j];

				if (cell.getChar() != CrossWordCell.EMPTY_CELL)
				{
					g2d.setColor(Color.white);

				} else
				{
					g2d.setColor(Color.gray);
				}

				g2d.fillRect((i * CELL_SIZE), (j * CELL_SIZE), CELL_SIZE,
						CELL_SIZE);

				// Draw Border
				g2d.setColor(Color.black);
				g2d.drawRect((i * CELL_SIZE), (j * CELL_SIZE), CELL_SIZE,
						CELL_SIZE);

			}
		}

	}

	public void drawCrossWordCharacters(Graphics2D g2d)
	{
		// Set up the graphics device for rendering text nicely.
		RenderingHints hints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(hints);

		Font font = new Font("URW Chancery L", Font.BOLD, 21);
		g2d.setFont(font);

		FontMetrics metrics = g2d.getFontMetrics(font);

		CrossWordCell[][] array = ((CrossWord) activePuzzle).getCellArray();
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[0].length; j++)
			{
				CrossWordCell cell = array[i][j];
				if (cell.getChar() != CrossWordCell.EMPTY_CELL)
				{
					// This is all to center the character in the cell
					int charWidth = metrics.charWidth(cell.getChar());
					int charHeight = metrics.getHeight();
					
					String wides = "wm";
					String smalls = "jlfi";
					
					int xOff;
					
					if (smalls.indexOf(cell.getChar()) != -1)
					{
						xOff = (i * CELL_SIZE) + charWidth + (60 / charWidth);
					} else if (wides.indexOf(cell.getChar()) != -1)
					{
						xOff = (i * CELL_SIZE) + charWidth / 2;
					}
					else {
						xOff = (i * CELL_SIZE) + charWidth + (20 / charWidth);
					}

					int yOff = (j * CELL_SIZE)
							+ (metrics.getAscent() + (CELL_SIZE - (metrics
									.getAscent() + metrics.getDescent())) / 2);

					g2d.drawChars(new char[]
					{ cell.getChar() }, 0, 1, xOff, yOff);

				}

			}
		}

	}

	public void drawWordSearch(Graphics2D g2d)
	{
		drawWordSearchCells (g2d);
		drawWordSearchCharacters (g2d);
	}
	
	public void drawWordSearchCells (Graphics2D g2d)
	{
		WordSearchCell[][] array = ((WordSearch) activePuzzle).getCellArray();

		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[0].length; j++)
			{
				WordSearchCell cell = array[i][j];

				if (cell.getChar() != WordSearchCell.EMPTY_CELL)
				{
					g2d.setColor(Color.white);

				} else
				{
					g2d.setColor(Color.black);
				}

				g2d.fillRect((i * CELL_SIZE), (j * CELL_SIZE), CELL_SIZE,
						CELL_SIZE);

				// Draw Border
				g2d.setColor(Color.black);
				g2d.drawRect((i * CELL_SIZE), (j * CELL_SIZE), CELL_SIZE,
						CELL_SIZE);

			}
		}
		
	}
	
	public void drawWordSearchCharacters(Graphics2D g2d)
	{
		// Set up the graphics device for rendering text nicely.
		RenderingHints hints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(hints);

		Font font = new Font("URW Chancery L", Font.BOLD, 21);
		g2d.setFont(font);

		FontMetrics metrics = g2d.getFontMetrics(font);

		WordSearchCell[][] array = ((WordSearch) activePuzzle).getCellArray();
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[0].length; j++)
			{
				WordSearchCell cell = array[i][j];
				if (cell.getChar() != WordSearchCell.EMPTY_CELL)
				{
					// This is all to center the character in the cell
					int charWidth = metrics.charWidth(cell.getChar());
					int charHeight = metrics.getHeight();
					
					String wides = "wm";
					String smalls = "jlfi";
					
					int xOff;
					
					if (smalls.indexOf(cell.getChar()) != -1)
					{
						xOff = (i * CELL_SIZE) + charWidth + (60 / charWidth);
					} else if (wides.indexOf(cell.getChar()) != -1)
					{
						xOff = (i * CELL_SIZE) + charWidth / 2;
					}
					else {
						xOff = (i * CELL_SIZE) + charWidth + (20 / charWidth);
					}

					int yOff = (j * CELL_SIZE)
							+ (metrics.getAscent() + (CELL_SIZE - (metrics
									.getAscent() + metrics.getDescent())) / 2);

					g2d.drawChars(new char[]
					{ cell.getChar() }, 0, 1, xOff, yOff);

				}

			}
		}

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

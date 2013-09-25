package Model.Puzzles.Parts;



/**
 * Base class for representing arbitrary cells in a puzzle.
 * @author tom
 *
 */
public abstract class PuzzleCell 
{
	public abstract char getChar();
	
	public abstract void setChar(char value);
	public abstract boolean isPartOfWord();

}

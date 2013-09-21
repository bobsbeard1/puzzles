package Model.Puzzles.Parts;



public class CrossWordCell extends PuzzleCell
{
	public static final char EMPTY_CELL = '#';
	private char charValue;
	
	public CrossWordCell(char value )
	{
		charValue = value; 
	}
	@Override
	public char getChar()
	{
		return charValue;
	}

	@Override
	public void setChar(char value)
	{
		charValue = value;
	}
	
}

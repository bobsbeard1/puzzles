package Model.Puzzles.Parts;



public class CrossWordCell extends PuzzleCell
{
	public static final char EMPTY_CELL = '#';
	private char charValue;
	private boolean partOfWord;
	private int number;
	
	public CrossWordCell(char value )
	{
		charValue = value; 
		partOfWord = true;
	}
	
	public CrossWordCell()
	{
		partOfWord = false;
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
		partOfWord = true;
	}
	
	public void setBlank()
	{
		charValue = EMPTY_CELL;
	}

	
	@Override
	public boolean isPartOfWord()
	{
		return partOfWord;
	}
	
	public void setNumber(int num)
	{
		number = num;
	}
	public int getNumber()
	{
		return number;
	}
	
}

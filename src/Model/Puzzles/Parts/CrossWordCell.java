package Model.Puzzles.Parts;



public class CrossWordCell extends PuzzleCell
{
	public static final char EMPTY_CELL = '#';
	private char charValue;
	private boolean isPartOfDownWord = false;
	private boolean isPartOfAcrossWord = false;
	private boolean isPartOfWord;
	private int number;
	private boolean isFinalCharAcross = false;
	private boolean isInitialCharAcross = false;
	private boolean isFinalCharDown = false;
	private boolean isInitialCharDown = false;
	
	public CrossWordCell(char value )
	{
		charValue = value; 
		isPartOfWord = true;
		
	}
	
	public CrossWordCell()
	{
		isPartOfWord = false;
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
		isPartOfWord = true;
	}
	public void setInitialCharDown(boolean value)
	{
		isInitialCharDown = value;
	}
	public boolean isInitialCharDown()
	{
		return isInitialCharDown;
	}
	public void setFinalCharDown(boolean value)
	{
		isFinalCharDown = value;
	}
	public boolean isFinalCharDown()
	{
		return isFinalCharDown;
	}
	
	public void setInitialCharAcross(boolean value)
	{
		isInitialCharAcross = value;
	}
	public boolean isInitialCharAcross()
	{
		return isInitialCharAcross;
	}
	public void setFinalCharAcross(boolean value)
	{
		isFinalCharAcross = value;
	}
	public boolean isFinalCharAcross()
	{
		return isFinalCharAcross;
	}
	
	public void setBlank()
	{
		charValue = EMPTY_CELL;
	}

	
	@Override
	public boolean isPartOfWord()
	{
		return isPartOfWord;
	}
	
	public boolean isPartOfAcrossWord()
	{
		return isPartOfAcrossWord;
	}
	public boolean isPartOfDownWord()
	{
		return isPartOfDownWord;
	}
	
	public void setPartOfAcrossWord(boolean value)
	{
		isPartOfAcrossWord = value;
	}
	public void setPartOfDownWord(boolean value)
	{
		isPartOfDownWord = value;
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

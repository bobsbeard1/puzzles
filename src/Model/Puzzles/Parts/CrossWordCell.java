package Model.Puzzles.Parts;



public class CrossWordCell extends PuzzleCell
{
	public static final char EMPTY_CELL = '#';
	private char charValue;
	private boolean partOfWord;
	private int number;
	private boolean isFinalCharAcross = false;
	private boolean isInitialCharAcross = false;
	private boolean isFinalCharDown = false;
	private boolean isInitialCharDown = false;
	
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

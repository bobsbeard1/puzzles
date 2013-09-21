package Model.Puzzles.Parts;



public class WordLocation 
{
	int begining;
	int end;
	public WordLocation(int beginingOfWord, int endOfWord)
	{
		begining = beginingOfWord;
		end = endOfWord;
	}
	
	public int getBegining()
	{
		return begining;
		
	}
	
	public int getEnd()
	{
		return end;
	}
}

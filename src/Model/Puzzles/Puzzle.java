package Model.Puzzles;
import java.awt.Dimension;
import java.util.HashMap;

import Model.Puzzles.Parts.*;

/**
 * Represents a basic puzzle.
 * @author tom
 *
 */
public abstract class Puzzle<T>
{
	protected HashMap<String,WordLocation> wordMap;
	
	protected T[][] cellArray;
	
	public abstract char charAt(Dimension dim);
	
	public abstract boolean addWord(String word, WordLocation location);
	
	public abstract boolean deleteWord (String word, WordLocation location);

}

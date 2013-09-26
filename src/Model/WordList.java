package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WordList implements Iterable<String>
{

	private static ArrayList<String> list = new ArrayList<String>();

	/**
	 * Creates a WordList from the given file. Words must be on their own line.
	 * 
	 * @param fileName
	 */
	public WordList(String fileName)
	{

		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String next;

			while ((next = reader.readLine()) != null)
			{
				list.add(next);
			}

			reader.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public WordList(ArrayList<String> stringList)
	{
		list = stringList;
	}
	

	/**
	 * Prints list of words
	 */
	public void printList()
	{

		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}
	
	public int getLength()
	{
		return list.size();
	}

	/**
	 * Adds specified word to the end of the list
	 * 
	 * @param word
	 */
	public void addWord(String word)
	{
		list.add(word);
		System.out.println(word + " added!");
	}

	/**
	 * Checks for the given word, and deletes it from the list if it is present
	 * 
	 * @param word
	 */
	public void deleteWord(String word)
	{
		if (list.indexOf(word) != -1)
		{
			list.remove(word);
			System.out.println(word + " removed");
		} else
		{
			System.out.print(word + " wasn't in the list!");
		}
	}
	public String getWordAt(int index)
	{
		return list.get(index);
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	/**
	 * Returns whether the given word is in the list
	 * 
	 * @param word
	 * @return
	 */
	public boolean hasWord(String word)
	{
		if (list.indexOf(word) != -1)
		{
			System.out.println(word + " is in the list!");
			return true;

		}
		System.out.println(word + " is not in the list!");
		return false;
	}

	@Override
	public Iterator<String> iterator()
	{
		
		return list.iterator();
	}
}
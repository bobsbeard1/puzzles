package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager
{

	/**
	 * Reads a wordList from a text file
	 * 
	 * @param path
	 *            The path to the .txt file.
	 * @return List of strings
	 * @throws IOException
	 *             File Not found
	 */
	public static ArrayList<String> getWordListFromFile(String path)
			throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(path));

		ArrayList<String> stringList = new ArrayList<String>();
		String line;
		while ((line = reader.readLine()) != null)
		{

			stringList.add(line);
		}

		return stringList;

	}

	public static ArrayList<String> getSubWordListFromFile(String path, int size)
			throws IOException
	{
		

		ArrayList<String> stringList = new ArrayList<String>();
		String line;

		while (stringList.size() < size)
		{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			while (((line = reader.readLine()) != null))
			{
				if (RandomHelper.rand.nextInt(160000 / size) == 1)
				{
					if (stringList.size()< size)
					{
						stringList.add(line);
					}
					
				}

			}

		
		}

		return stringList;

	}
}

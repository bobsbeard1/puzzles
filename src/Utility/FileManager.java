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
	 * @param path The path to the .txt file.
	 * @return List of strings
	 * @throws IOException File Not found
	 */
	public static  ArrayList<String> readFile(String path)throws IOException
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
}

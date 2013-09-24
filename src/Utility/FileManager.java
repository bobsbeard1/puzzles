package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager
{

	/**
	 * Reads a wordList from a text or csv file
	 * 
	 * @param path
	 *            The path to the .txt\csv file.
	 * @return List of strings
	 * @throws IOException
	 *             File Not found
	 */
	public static ArrayList<String> getWordListFromFile(String path)
			throws IOException
	{
		if(path.endsWith("txt"))
		{
			System.out.println("txt");
			System.out.println("");
			BufferedReader reader = new BufferedReader(new FileReader(path));

			ArrayList<String> stringList = new ArrayList<String>();
			String line;
			while ((line = reader.readLine()) != null)
			{
				stringList.add(line);
			}
			reader.close();
			return stringList;
		}
		else if(path.endsWith("csv"))
		{
			System.out.println("csv");
			System.out.println("");
			 BufferedReader CSVFile = new BufferedReader(new FileReader(path));
	
			 String dataRow = CSVFile.readLine();
			 ArrayList<String> stringList = new ArrayList<String>();
			 while (dataRow != null)
			 {
				   String[] dataArray = dataRow.split(", ");
				   for (String item:dataArray) 
				   { 
					   stringList.add(item);
				   }
				   dataRow = CSVFile.readLine();
			 }
			  
			 CSVFile.close();
			 return stringList;
		}
		else
		{
			System.out.println("File: '" + path + "' is not a .txt or .csv file!");
			return null;
		}
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

			reader.close();
		}
		return stringList;

	}
}

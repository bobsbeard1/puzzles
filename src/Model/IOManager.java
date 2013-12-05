package Model;

import Model.Puzzles.CrossWord;
import Model.Puzzles.Puzzle;
import Model.Puzzles.PuzzleType;
import Model.Puzzles.WordSearch;
import Model.Puzzles.Parts.CrossWordCell;
import Model.Puzzles.Parts.WordSearchCell;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.*;


/**
 * A Class for reading/writing files
 * 
 * @author trhlavat
 *
 */
public class IOManager {

	public boolean WriteToHTML(Puzzle puzzle, PuzzleType type)
	{
		String answer = new String();
		if (type == PuzzleType.WordSearch) {
			WordSearch puzz = (WordSearch)puzzle;
			answer+="<html> <table> ";
			
			for (int i = 0; i < puzz.getCellArray().length; i++) {
				answer+= "<tr>";
				for (int j = 0; j < puzz.getCellArray().length; j++) {
					answer+="<td>";
					answer+=puzz.charAt(j, i);
					answer += "</td>";
				}
				answer += "</tr>";
			}
			
			answer+= "</table> </html>";
			
			 PrintWriter printWriter = null;
		        try {
		           
		            printWriter = new PrintWriter(
		                    "C:/Users/trhlavat/git/puzzle2/puzzleHTML.html",
		                    "UTF-8");
		            
		            printWriter.print(answer);
		           
						
					
		     
		        } catch (FileNotFoundException fileNotFoundException) {
		            fileNotFoundException.printStackTrace();
		            return false;
		        } catch (UnsupportedEncodingException unsupportedEncodingException) {
		            unsupportedEncodingException.printStackTrace();
		            return false;
		        } finally {
		            printWriter.close();
		
		           
		        }
			return true;
			
			
		}
		else {
			CrossWord puzz = (CrossWord)puzzle;
			answer+="<html> <table> ";
			
			for (int i = 0; i < puzz.getCellArray().length; i++) {
				answer+= "<tr>";
				for (int j = 0; j < puzz.getCellArray().length; j++) {
					answer+="<td>";
					answer+=puzz.charAt(j, i);
					answer += "</td>";
				}
				answer += "</tr>";
			}
			
			answer+= "</table> </html>";
			
			 PrintWriter printWriter = null;
		        try {
		           
		            printWriter = new PrintWriter(
		                    "C:/Users/trhlavat/git/puzzle2/puzzleHTML.html",
		                    "UTF-8");
		            
		            printWriter.print(answer);
		           
						
					
		     
		        } catch (FileNotFoundException fileNotFoundException) {
		            fileNotFoundException.printStackTrace();
		            return false;
		        } catch (UnsupportedEncodingException unsupportedEncodingException) {
		            unsupportedEncodingException.printStackTrace();
		            return false;
		        } finally {
		            printWriter.close();
		
		           
		        }
			return true;
			
		}
	
	}
	public boolean WriteToCSV(Puzzle puzzle,PuzzleType type)
	{
		 PrintWriter printWriter = null;
	        try {
	           
	            printWriter = new PrintWriter(
	                    System.getProperty("user.home")+"\\Desktop\\puzzleCSV.csv",
	                    "UTF-8");
	            
	            WordSearchCell[][] wsArray;
	            CrossWordCell[][] cwArray;
	            
	            switch (type) {
				case WordSearch:
					wsArray =((WordSearch)puzzle).getCellArray();
					
					for (int i = 0; i < wsArray.length; i++) {
						for (int j = 0; j < wsArray.length; j++) {
						printWriter.print(wsArray[j][i].getChar());
						if (j < wsArray.length -1) {
							printWriter.print(",");
						}
						
						}
						printWriter.println("");
					}
					JOptionPane.showMessageDialog(null, "Save Successful!");
					break;
				case CrossWord:
					cwArray =((CrossWord)puzzle).getCellArray();
					
					for (int i = 0; i < cwArray.length; i++) {
						for (int j = 0; j < cwArray.length; j++) {
						printWriter.print(cwArray[j][i].getChar());
						if (j < cwArray.length -1) {
							printWriter.print(",");
						}
						
						}
						printWriter.println("");
					}
					JOptionPane.showMessageDialog(null, "Save Successful!");
					break;

				default:
					break;
				}
	     
	        } catch (FileNotFoundException fileNotFoundException) {
	            fileNotFoundException.printStackTrace();
	            return false;
	        } catch (UnsupportedEncodingException unsupportedEncodingException) {
	            unsupportedEncodingException.printStackTrace();
	            return false;
	        } finally {
	            printWriter.close();
	
	           
	        }
	        return true;

		
	}
}

package Utility;

import java.util.Random;

/**
 * A utility class for generating random data.
 * @author tom
 *
 */
public class RandomHelper
{	
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public static Random rand = new Random();
	
	public static char getRandomChar()
	{
		return alphabet.charAt(rand.nextInt(alphabet.length() -1));
	}
}

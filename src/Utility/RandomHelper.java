package Utility;

import java.util.Random;

/**
 * A utility class for generating random data.
 * @author tom
 *
 */
public class RandomHelper
{	
	private static final String alphabetLowercase = "abcdefghijklmnopqrstuvwxyz";
	private static final String alphabetUppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static Random rand = new Random();
	
	public static char getRandomChar()
	{
		return alphabetLowercase.charAt(rand.nextInt(alphabetLowercase.length() -1));
	}
}

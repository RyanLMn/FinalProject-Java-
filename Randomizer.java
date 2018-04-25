package EMSSystem;

import java.util.Random;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class Randomizer {
	public static Random rgen = new Random(); //creates a new random variable called rgen
	
	public static int getRgen(int i) {
		return rgen.nextInt(i);  //returns the next integer of the variable rgen
	}
}

package EMSSystem;

import java.util.Random;

/**
 * 
 * @author Ryan Morgan
 *
 */

public class Randomizer {
	public static Random rgen = new Random();
	
	public static int getRgen(int i) {
		return rgen.nextInt(i);
	}
}

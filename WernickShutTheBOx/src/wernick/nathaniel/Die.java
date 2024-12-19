package wernick.nathaniel;

import java.util.Random;
/**
 * create a die which players can roll for a random int
 */
public class Die {
	private int value;
	private int numSides;
	/**
	 * create a die with six sides
	 */
	Die (){
		numSides = 6;
		value = roll();
	}
	/**
	 * create a die with n number of sides
	 * @param n
	 */
	Die(int n){
		numSides = n;
		value = roll();
	}
	/**
	 * get a random number for a dice with any number of sides
	 * @return value 
	 */
	public int roll() {
		Random rand = new Random();
		value = rand.nextInt(1, numSides+1);
		return value;
	}
	/**
	 * change the number of sides on a die
	 * @param n
	 */
	public void setSides(int n) {
		numSides = n;
	}
}

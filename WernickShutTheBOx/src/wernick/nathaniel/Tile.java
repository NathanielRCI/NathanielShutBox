package wernick.nathaniel;
/**
 * track tiles which is up and down and what number
 */
public class Tile {
	private int value;
	private boolean isUp;
	/**
	 * create a tile with a number that starts up
	 * @param n
	 */
	Tile(int n){
		value = n;
		isUp = true;
	}
	/**
	 * return value on tile
	 * @return value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * return if tile is up
	 * @return isUp
	 */
	public boolean isUp() {
		return isUp;
	}
	/**
	 * put tile down
	 */
	public void putDown() {
		isUp = false;
	}


	
	@Override
	public String toString() {
		String response = "";
		if (isUp) {
			response = "" + value + " : UP ";
		}
		else {
			response = "" + value + " : DOWN ";			
		}
		return response;
	}
}

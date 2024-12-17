package wernick.nathaniel;

public class Tile {
	private int value;
	private boolean isUp;
	
	Tile(int n){
		value = n;
		isUp = true;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isUp() {
		return isUp;
	}
	
	public void putDown() {
		isUp = false;
	}
	
	public void isOver() {
		
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

package wernick.nathaniel;

public class Round {
	private int round; 
	private int p1;
	private int p2;
	private boolean p1Turn;
	
	Round(){
		p1 = 0;
		p2 = 0;
		p1Turn = true;
	}
	
	public void  addScoreP1(int a) {
		p1 += a;
	}
	public void  addScoreP2(int a) {
		p2 += a;
	}
	
	public int getScore1() {
		return p1;
	}
	
	public int getScore2() {
		return p2;
	}
	
	public int getRound() {
		return round;
	}
	public void next() {
		round += 1;
	}
	public boolean getP1Turn() {
		return p1Turn;
	}
	public void setP1Turn(boolean turn) {
		p1Turn = turn;
	}

}

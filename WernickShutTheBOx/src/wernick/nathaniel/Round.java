package wernick.nathaniel;

/**
 * track the scores and rounds
 */
public class Round {
	private int round; 
	private int p1;
	private int p2;
	private boolean p1Turn;
	/**
	 * scores = 0 and it starts with player 1
	 */
	Round(){
		p1 = 0;
		p2 = 0;
		p1Turn = true;
	}
	/**
	 * add number a to player 1 score
	 * @param a
	 */
	public void  addScoreP1(int a) {
		p1 += a;
	}
	
	/**
	 * add number a to player 2 score
	 * @param a
	 */
	public void  addScoreP2(int a) {
		p2 += a;
	}
	/**
	 * return score of player 1 p1
	 * @return p1 
	 */
	public int getScore1() {
		return p1;
	}
	
	/**
	 * return score of player 2 p2 
	 * @return p2
	 */
	public int getScore2() {
		return p2;
	}
	/**
	 * round number
	 * @return round 
	 */
	public int getRound() {
		return round;
	}
	
	/**
	 * got to next round
	 */
	public void next() {
		round += 1;
	}
	
	/**
	 * return if it is player one score
	 * @return
	 */
	public boolean getP1Turn() {
		return p1Turn;
	}
	/**
	 * set which turn it is
	 * @param turn
	 */
	public void setP1Turn(boolean turn) {
		p1Turn = turn;
	}

}

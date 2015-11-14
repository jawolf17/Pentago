package models;

public class Player {
	private int color;
	private String name;
	private boolean isTurn;
	private boolean placed;
	private boolean rotated;
	public Player(int c,String n){
		color = c;
		name = n;
		isTurn = false;
		placed = false;
		rotated = false;
	}
	public void turn(){
		isTurn = true;
		placed = false;
		rotated = false;
	}
	
	//Getters / Setters
	
	/**
	 * 
	 * @return 1 for white, 2 for black
	 */
	public int getColor(){
		return color;
	}
	
	/**
	 * 
	 * @return the name of the player
	 */
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @return true if it is currently this player's turn.
	 */
	public boolean getTurn(){
		return isTurn;
	}
	
	/**
	 * 
	 * @param turn = true if it is this player's turn, false otherwise.
	 */
	public void setTurn(boolean turn){
		isTurn=turn;
	}
	public boolean getPlaced(){
		return placed;
	}
	public void setPlaced(boolean place){
		placed = place;
	}
	public boolean getRotated(){
		return rotated;
	}
	public void setRotated(boolean rotate){
		rotated = rotate;
	}
}

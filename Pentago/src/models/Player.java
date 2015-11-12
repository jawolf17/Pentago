package models;

public class Player {
	private int color;
	private String name;
	private boolean isTurn;
	public Player(int c,String n){
		color = c;
		name = n;
		isTurn = false;
	}
	public void turn(){
		isTurn = true;
	}
}

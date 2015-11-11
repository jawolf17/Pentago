package models;

public class Player {
	int color;
	String name;
	boolean isTurn;
	public Player(int c,String n){
		color = c;
		name = n;
		isTurn = false;
	}
	public void turn(){
		isTurn = true;
		
	}
}

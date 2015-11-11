package models;

public class Player {
	String color;
	String name;
	boolean isTurn;
	public Player(String c,String n){
		color = c;
		name = n;
		isTurn = false;
	}
	public void turn(){
		isTurn = true;
		
	}
}

package controller;

import models.Board;

public class Controller {
	private Board b;
	public Controller(){
		b=null;
	}
	public void place(int row, int col,int c){
		b.place(row, col, c);
	}
	public void rotate(char q,boolean r){
		b.rotate(q, r);
	}
	public void update(){
		//update gui
	}
	
	//Methods for launch screen
	
	/**
	 * Calls on the GUI to launch the menu for player selection.
	 */
	public void launchMenu(){
		//TODO: Add method call
	}
	
	/**
	 * 
	 * @param name1 - the name of player 1
	 * @param name2 - the name of player 2
	 */
	public void createGame(String name1, String name2){
		new models.Game(name1,name2,this);
	}
	
	//Getters / Setters
	
	public void setBoard(models.Board board){
		b=board;
	}
}

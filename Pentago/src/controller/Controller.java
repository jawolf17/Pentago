package controller;

import models.Board;
import models.Game;
import models.Player;
import views.Menu;
import views.Gui;

public class Controller {
	private Board b;
	private String PlayerOneName;
	private String PlayerTwoName;
	private Gui GUI;
	private Game game;
	public Controller(){
		b=null;
	}
	public void place(int row, int col,int c){
		b.place(row, col, c);
		
	}
	public void rotate(char q,boolean r){
		b.rotate(q, r);
		game.upCheck();
	}
	public void update(){
		GUI.update(b.getBigBoard());
	}
	
	//Methods for launch screen
	
	/**
	 * Calls on the GUI to launch the menu for player selection.
	 */
	public void launchMenu(){
		new Menu(this);
	}
	
	/**
	 * 
	 * @param name1 - the name of player 1
	 * @param name2 - the name of player 2
	 */
	public void createGame(String name1, String name2){
		PlayerOneName = name1;
		PlayerTwoName = name2;
		game = new Game(name1,name2,this);
		GUI = new Gui(this);

	}
	
	//Getters / Setters
	public Player getCurrentPlayer(){
		return game.getCurPlayer();
	}
	
	public void setBoard(models.Board board){
		b=board;
	}
	public String getPlayerOneName(){
		return PlayerOneName;
	}
	public String getPlayerTwoName(){
		return PlayerTwoName;
	}
}

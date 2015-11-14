package models;

import ai.AI;
import controller.Controller;

public class Game {
	private Player _p1;
	private Player _p2;
	private Player _currentp;
	private Board _board;
	private Controller _controller;
	
	/**
	 * Constructor for the Game class.
	 * Initializes players and board.
	 * Sets current player to p1.
	 */
	public Game(String name1, String name2, Controller c){
		_controller = c;
		_board = new Board(_controller);
		_controller.setBoard(_board);
		_p1 = new Player(1,name1);
		if(name2.equals("CPU")){
			_p2 = new AI(2,name2,_board,_controller);
		}
		else{
			_p2 = new Player(2,name2);
		}
	
		_currentp = _p1;
		
	}
	
	/**
	 * Responsible for the actual flow of game play (sends the control of the game to the correct player).
	 * Terminates when someone has won.
	 * 
	 * @param none
	 * @return none
	 */
	public void upCheck(){
		//May need more body here as project continues
		
		if(!_board.isWon()){
			//Needs to give control to GUI...somehow
			
			if(_currentp.equals(_p1) && _p1.getPlaced() && _p1.getRotated()){
				_currentp = _p2;
			}
			else if(_currentp.equals(_p2) && _p2.getPlaced() && _p2.getRotated()){
				_currentp=_p1;
			}
			_currentp.setTurn(true);
			_currentp.turn();
		    //_currentp.setTurn(false);
		}
		else{
			_controller.endGame();
		}
		
	}
	
	//Getter & Setters
	
	/**
	 * @return The current player
	 */
	public Player getCurPlayer(){
		return _currentp;
	}
	
	/**
	 * @return the class of the current board.
	 */
	public Board getBoard(){
		return _board;
	}
}

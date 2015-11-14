package models;

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
		_p1 = new Player(1,name1);
		if(name2.equals("CPU")){
			//TODO: add constructor for non-human player, for now just creates another human
			_p2 = new Player(2,name2);
		}
		else{
			_p2 = new Player(2,name2);
		}
	
		_currentp = _p1;
		_controller = c;
		_board = new Board(_controller);
		_controller.setBoard(_board);
		
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

			_currentp.setTurn(false);
			if(_currentp.equals(_p1) && _p1.getPlaced() && _p1.getRotated()){
				_currentp = _p2;
				_p2.turn();
			}
			else if(_currentp.equals(_p2) && _p2.getPlaced() && _p2.getRotated()){
				_currentp=_p1;
				_p1.turn();
			}
			_currentp.setTurn(true);
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

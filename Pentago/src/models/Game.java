package models;

public class Game {
	private Player _p1;
	private Player _p2;
	private Player _currentp;
	private Board _board;
	
	/**
	 * Constructor for the Game class.
	 * Initializes players and board.
	 * Sets current player to p1.
	 */
	public Game(String name1, String name2){
		_p1 = new Player(0,name1);
		_p2 = new Player(1,name2);
		_currentp = _p1;
		_board = new Board();
	}
	
	/**
	 * Responsible for the actual flow of game play (sends the control of the game to the correct player).
	 * Terminates when someone has won.
	 * 
	 * @param none
	 * @return none
	 */
	public void play(){
		//May need more body here as project continues
		
		while(!_board.isWon()){
			_currentp.turn();
			
			if(_currentp.equals(_p1)){
				_currentp = _p2;
			}
			else if(_currentp.equals(_p2)){
				_currentp=_p1;
			}
		}
		
	}
	
	//Getter & Setters
	
	/**
	 * @return The current player
	 */
	Player getCurPlayer(){
		return _currentp;
	}
	
	/**
	 * @return the class of the current board.
	 */
	Board getBoard(){
		return _board;
	}
}

/**
 * The AI class. It is responsible for making decisions for non-human players during
 * their turn. It utilizes the AiBoard class.   
 *
 */

package ai;

import models.Board;
import models.Player;
import controller.Controller;

public class AI extends Player {

	private AiBoard _test_board;
	private Board _board_actual;
	
	public AI(int c, String n ,Board b, Controller cont) {
		super(c, n);
		_test_board= new AiBoard(b,cont);
		_test_board.dummyUpdate();
		_board_actual = b;
	}
	
	/**
	 * Takes the turn for the AI, currently places at the first available space, does not rotate.
	 */
	public void turn(){
		super.turn();
		_test_board.dummyUpdate();
		int row=0;
		int col =0;
		while(row<6&&col<6&&!getPlaced()){
			if(_test_board.checkPlacement(row,col)){
				_board_actual.place(row, col, getColor());
				setRotated(true);
				setPlaced(true);
			}
		}
	}
}

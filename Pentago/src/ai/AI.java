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
	private Controller _con;
	private String _diff;
	
	public AI(int c, String n ,Board b, Controller cont) {
		super(c, n);
		_diff = n.substring(4);
		_board_actual = b;
		_con = cont;
		_test_board= new AiBoard(b,cont);
		_test_board.dummyUpdate();
	}
	
	/**
	 * Takes the turn for the AI, currently places at the first available space, does not rotate.
	 */
	public void turn(){
		super.turn();
		_test_board.dummyUpdate();
		switch(_diff){
			case "easy": turnEasy();
			break;
			case "medium":
			case "hard":
			default: turnEasy(); 
			}
		}
	
	private void turnEasy(){
		int row=0;
		int col =0;
		while(row<6&&col<6&&!getPlaced()){
			if(_test_board.checkPlacement(row,col)){
				_con.place(row, col, getColor());
				setRotated(true);
				_con.dummyRotate();
				
			}
			col++;
			if(col==6){
				col=0;
				row++;
			}
		}
	}
}

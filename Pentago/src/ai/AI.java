/**
 * The AI class. It is responsible for making decisions for non-human players during
 * their turn. It utilizes the AiBoard class.   
 *
 */

package ai;

import models.Board;
import models.Player;

import java.util.Random;

import controller.Controller;
import util.Maneuver;

public class AI extends Player {

	private AiBoard _test_board;
	private Board _board_actual;
	private Controller _con;
	private String _diff;
	
	public AI(int c, String n ,Board b, Controller cont) {
		super(c, n);
		_diff = n.substring(4).toLowerCase();
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
		setRotated(true);
		setPlaced(true);
		}
	
	private void turnEasy(){
		Boolean turnTaken = false;
		Maneuver win_result = _test_board.canWin();
		//Winning placement check
		if(win_result.column!=-1&&win_result.column!=-1){
			_con.place(win_result.row,win_result.column,getColor());
			if(win_result.quad!='z'){
				 _con.rotate(win_result.quad, win_result.dir);
			}
			else{
				_con.dummyRotate();
			}
			turnTaken=true;
		}
		//Prevent D
		if(!turnTaken){
			Maneuver loss_prevent = _test_board.canLose();
			if(loss_prevent.row!=-1&&loss_prevent.column!=-1){
				_con.place(loss_prevent.row, loss_prevent.column, getColor());
				if(loss_prevent.quad !='z'){
					_con.rotate( loss_prevent.quad, loss_prevent.dir);
				}
				else{
					_con.dummyRotate();
				}
				setRotated(true);
				setPlaced(true);
				turnTaken = true;
			}
		}
		//Random Placement
		if(!turnTaken){
			Random r = new Random();
			while(!turnTaken){
				int row = r.nextInt(6);
				int col = r.nextInt(6);
				if(!_board_actual.isOccupied(row, col)){
					_con.place(row, col, getColor());
					turnTaken=true;
				}
				if(!_board_actual.isNeutral()){
					int quad_int = r.nextInt(4);
					int quadr_dir = r.nextInt(2);
					char quad_char='a';
					switch(quad_int){
						case 0: quad_char = 'a';
						break;
						case 1: quad_char = 'b';
						break;
						case 2: quad_char = 'c';
						break;
						case 3: quad_char = 'd';
						break;
					}
						if(quadr_dir==0){
							_con.rotate(quad_char, false);
						}
						else{
							_con.rotate(quad_char,true);
						}
				}
			}
		}
	}
	
//		int row=0;
//		int col =0;
//		while(row<6&&col<6&&!getPlaced()){
//			if(_test_board.checkPlacement(row,col)){
//				_con.place(row, col, getColor());
//				_con.dummyRotate();
//				
//			}
//			col++;
//			if(col==6){
//				col=0;
//				row++;
//			}
//		}
}


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
import java.util.Timer;
import java.util.TimerTask;

public class AI extends Player {

	private AiBoard _test_board;
	private Board _board_actual;
	private Controller _con;
	private String _diff;
	
	public AI(int c, String n ,Board b, Controller cont) {
		super(c, n);
		_diff = n.substring(3).toLowerCase();
		_board_actual = b;
		_con = cont;
		_test_board= new AiBoard(b,cont);
		_test_board.dummyUpdate();
	}
	
	/**
	 * Takes the turn for the AI, currently places at the first available space, does not rotate.
	 */
	public void turn(){
		Timer t = new Timer();
		long delay = 500;
		super.turn();
		_test_board.dummyUpdate();
		TimerTask task = new TimerTask(){
			@Override
			public void run(){
				switch(_diff){ 
		    		case "easy": turnEasy();
		    		break;
		    		case "medium": turnMed();
		    		break;
		    		case "hard":
		    		default: turnEasy();
				}
			}
	     };
	     t.schedule(task, delay);
		}
	
	
	private void  turnEasy(){
		System.out.println("Turn Easy");
		Boolean turnTaken = false;
		Maneuver win_result = _test_board.canWinorLose(getColor());
		//Winning placement check
		if(win_result.row>-1&&win_result.column>-1){
			System.out.println("Win");
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
			System.out.println("Loss");
			int op;
			if(getColor() == 1){
				op = 2;
			}
			else{
				op = 1;
			}
			Maneuver loss_prevent = _test_board.canWinorLose(op);
			if(loss_prevent.row>-1&&loss_prevent.column>-1){
				_con.place(loss_prevent.row, loss_prevent.column, getColor());
				if(loss_prevent.quad !='z'){
					_con.rotate( loss_prevent.quad, loss_prevent.dir);
				}
				else{
					_con.dummyRotate();
				}
				turnTaken = true;
			}
		}
		//Random Placement
		if(!turnTaken){
			System.out.println("Random");
			Random r = new Random();
			while(!turnTaken){
				int row = r.nextInt(6);
				int col = r.nextInt(6);
				if(!_board_actual.isOccupied(row, col)){
					_con.place(row, col, getColor());
					turnTaken=true;
				}
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
				else{
					_con.dummyRotate();
				}
			}
		}
	private void  turnMed(){
		System.out.println("Turn MED");
		Boolean turnTaken = false;
		Maneuver win_result = _test_board.canWinorLose(getColor());
		//Winning placement check
		if(win_result.row>-1&&win_result.column>-1){
			System.out.println("Win");
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
			int op;
			if(getColor() == 1){
				op = 2;
			}
			else{
				op = 1;
			}
			System.out.println("Loss");
			Maneuver loss_prevent = _test_board.canWinorLose(op);
			if(loss_prevent.row>-1&&loss_prevent.column>-1){
				_con.place(loss_prevent.row, loss_prevent.column, getColor());
				if(loss_prevent.quad !='z'){
					_con.rotate( loss_prevent.quad, loss_prevent.dir);
				}
				else{
					_con.dummyRotate();
				}
				turnTaken = true;
			}
		}
		if(!turnTaken){
			System.out.println("Plan");
			int op;
			if(getColor() == 1){
				op = 2;
			}
			else{
				op = 1;
			}
			Maneuver lose_plan = _test_board.plan(op);
			if(lose_plan.row>-1&&lose_plan.column>-1){
				_con.place(lose_plan.row, lose_plan.column, getColor());
				if(lose_plan.quad !='z'){
					_con.rotate(lose_plan.quad,lose_plan.dir);
				}
				else{
					_con.dummyRotate();
				}
				turnTaken = true;
			}
		}
		if(!turnTaken){
			System.out.println("Plan");
			Maneuver win_plan = _test_board.plan(getColor());
			if(win_plan.row>-1&&win_plan.column>-1){
				_con.place(win_plan.row, win_plan.column, getColor());
				if(win_plan.quad !='z'){
					_con.rotate(win_plan.quad,win_plan.dir);
				}
				else{
					_con.dummyRotate();
				}
				turnTaken = true;
			}
		}
		//Random Placement
		if(!turnTaken){
			System.out.println("Random");
			Random r = new Random();
			while(!turnTaken){
				int row = r.nextInt(6);
				int col = r.nextInt(6);
				if(!_board_actual.isOccupied(row, col)){
					_con.place(row, col, getColor());
					turnTaken=true;
				}
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
				else{
					_con.dummyRotate();
				}
			}
		}
	}
	
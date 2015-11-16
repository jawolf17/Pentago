/**
 * A test board for the AI to manipulate without changing the current game state.
 * Extends board to provide already implemented board manipulation methods. 
 * *****At the moment the functionality of this class is not much more than the original Board. 
 * 		The extension is just to better encapsulate board.*****
 */
package ai;

import java.util.ArrayList;

import controller.Controller;
import models.Board;
import util.Pair;

public class AiBoard extends Board {

	private Board _cur_board;
	
	
	public AiBoard(Board curBoard,Controller controller) {
		super(controller);
		_cur_board = curBoard;
	}
	
	/**
	 * Checks to see if position at row column will result in "preferred placement" (define that later)
	 * Intended to check all possible scenarios of a position
	 * @param row the row of the board.
	 * @param col the column of the board.
	 * @return True if placement is valid.
	 */
	 public Boolean checkPlacement(int row, int col){
		return !isOccupied(row,col);
	}
	 public Pair canLose(){
		 Pair p = new Pair();
		 int[][] big = _cur_board.getBigBoard();
		 for(int i = 0;i<big[0].length;i++){
			 for(int j = 0;j<big.length;j++){
				 if(!_cur_board.isOccupied(i,j)){
					 
				 }
			 }
		 }
		 return p;
	 }
	 public Pair canWin(){
		 Pair p = new Pair();
		 return p;
	 }
	 
	 /**
	  * Updates the AIBoard to match the current state of the game Board
	  */
	 public void dummyUpdate(){
	     ArrayList<int[][]> copies = _cur_board.getDeepCopies();
	     setA(copies.get(0));
	     setB(copies.get(1));
	     setC(copies.get(2));
	     setD(copies.get(3));
	     setBigBoard(copies.get(4));	     
	 }		
	

}

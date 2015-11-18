
/**
 * A test board for the AI to manipulate without changing the current game state.
 * Extends board to provide already implemented board manipulation methods. 
 * *****At the moment the functionality of this class is not much more than the original Board. 
 * 		The extension is just to better encapsulate board.*****
 */
package ai;

import java.util.ArrayList;
import java.util.Arrays;

import controller.Controller;
import models.Board;
import util.Maneuver;

public class AiBoard{
	private Board board;
	private int[][] bigBoard;
	private int[][] a;
	private int[][] b;
	private int[][] c;
	private int[][] d;
	private Controller control;
	private boolean neutral_a;
	private boolean neutral_b;
	private boolean neutral_c;
	private boolean neutral_d;
	
	
	public AiBoard(Board curBoard,Controller controller) {
		board = curBoard;
		control = controller;
		bigBoard = new int[6][6];
		a = new int[3][3];
		b = new int[3][3];
		c = new int[3][3];
		d = new int[3][3];
	}
	/**
	 * Used to place pieces on the board.
	 * @param int row, int col, int p(0,1,or 2 1 representing white, 2 representing black)
	 * @return boolean
	 */
	public boolean place(int row, int col,int p){
		if(row <= 2 && col <= 2){
			if(row!=1&&col!=1&&neutral_a){
				neutral_a=false;
			}
			a[row][col] = p;
			update('a');
		}
		else if(row <= 2 && col >= 3){
			if(row!=1&&col!=4&&neutral_b){
				neutral_b=false;
			}
			b[row][col-3] = p;
			update('b');
		}
		else if(row >=3 && col <= 2){
			if(row!=4&&col!=1&&neutral_c){
				neutral_c=false;
			}
			c[row-3][col] = p;
			update('c');
		}
		else if(row >=3 && col >= 3){
			if(row!=4&&col!=4&&neutral_d){
				neutral_d=false;
			}
			d[row-3][col-3] = p;
			update('d');
		}
		return true;
	}
	/**
	 * rotate is used to rotate one quadrant a quarter turn.
	 * 
	 * @param char q(representing quadrant) boolean r(true is ccw, false is cw)
	 * @return none
	 */
	public void rotate(char q,boolean r){
		if(q=='a'){
			if(r == false){
				a = clockwise(a);
			}
			else if(r == true){
				a = counterclockwise(a);
			}
			update('a');
		}
		else if(q =='b'){
			if(r == false){
				b = clockwise(b);
			}
			else if(r == true){
				b = counterclockwise(b);
			}
			update('b');
		}
		else if(q == 'c'){
			if(r == false){
				c = clockwise(c);
			}
			else if(r == true){
				c = counterclockwise(c);
			}
			update('c');
		}
		else if(q == 'd'){
			if(r == false){
				d = clockwise(d);
			}
			else if(r == true){
				d = counterclockwise(d);
			}
			update('d');
		}
	}
	//hard coded for now, didnt bother figuring out math behind it
	private int[][] clockwise(int[][] quad){
		int[][] temp = new int[3][3];
		temp[0][0] = quad[2][0];
		temp[0][1] = quad[1][0];
		temp[0][2] = quad[0][0];
		temp[1][0] = quad[2][1];
		temp[1][1] = quad[1][1];
		temp[1][2] = quad[0][1];
		temp[2][0] = quad[2][2];
		temp[2][1] = quad[1][2];
		temp[2][2] = quad[0][2];
		return temp;
	}
	private int[][] counterclockwise(int[][] quad){
		int[][] temp = new int[3][3];
		temp[2][0] = quad[0][0];
		temp[1][0] = quad[0][1];
		temp[0][0] = quad[0][2];
		temp[2][1] = quad[1][0];
		temp[1][1] = quad[1][1];
		temp[0][1] = quad[1][2];
		temp[2][2] = quad[2][0];
		temp[1][2] = quad[2][1];
		temp[0][2] = quad[2][2];
		return temp;
		
	}
	/**
	 * isOccupied returns true if the space given has a token in it already.
	 * 
	 * @param int row int col
	 * @return boolean
	 */
	public boolean isOccupied(int row, int col){
		if(bigBoard[row][col] == 0){
			return false;
		}
		else{
			return true;
		}
	}
	public boolean isNeutral(){
		
		return neutral_a || neutral_b || neutral_c || neutral_d;
	}
	/**
	 * isWon returns true is there is a winning grouping of 5 on the board.
	 * 
	 * @param none
	 * @return boolean
	 */
	public int isWon(){
		int org = 0;
		for(int i=0;i<bigBoard[0].length;i++){
			for(int j=0;j<bigBoard.length;j++){
				if(bigBoard[i][j] == 1 || bigBoard[i][j] == 2){
					org = bigBoard[i][j];
					int next = i+1;
					int next3 = j+1;
					int next4 = j-1;
					if(next3<6 && bigBoard[i][next3] == org){
						next3 = next3 +1;
						if(next3<6 && bigBoard[i][next3] == org){
							next3 = next3 +1;
							if(next3<6 && bigBoard[i][next3] == org){
								next3 = next3 +1;
								if(next3<6 && bigBoard[i][next3] == org){
									return org;
								}
							}
						}
					}
					if(next<6 && bigBoard[next][j] == org){
						next = next+1;
						if(next<6 && bigBoard[next][j] == org){
							next = next+1;
							if(next<6 && bigBoard[next][j] == org){
								next = next+1;
								if(next<6 && bigBoard[next][j] == org){
									return org;
								}
							}
						}
					}
					next = i+1;
					next3 = j+1;
					next4 = j-1;
					if((next3<6 && next <6) && bigBoard[next][next3] == org){
						next3 = next3 +1;
						next = next +1;
						if((next3<6 && next <6) && bigBoard[next][next3] == org){
							next3 = next3 +1;
							next = next +1;
							if((next3<6 && next <6) && bigBoard[next][next3] == org){
								next3 = next3 +1;
								next = next +1;
								if((next3<6 && next <6) && bigBoard[next][next3] == org){
									return org;
								}
							}
						}
					}
					next = i+1;
					if((next4>0 && next <6) && bigBoard[next][next4] == org){
						next4 = next4 -1;
						next = next +1;
						if((next4>0 && next <6) && bigBoard[next][next4] == org){
							next4 = next4 -1;
							next = next +1;
							if((next4>0 && next <6) && bigBoard[next][next4] == org){
								next4 = next4 -1;
								next = next +1;
								if((next4>0 && next <6) && bigBoard[next][next4] == org){
									return org;
								}
							}
						}
					}
					
					
				
					
				}
			}
		}
		return 0;
	}
	private void update(){
		for(int i = 0;i<a[0].length;i++){
			for(int j = 0;j<a.length;j++){
				bigBoard[i][j] = a[i][j];
			}
		}
		for(int k=0;k<b[0].length;k++){
			for(int l = 0;l<b.length;l++){
				bigBoard[k][l+3] = b[k][l];
			}
		}
		for(int q=0;q<c[0].length;q++){
			for(int w = 0;w<c.length;w++){
				bigBoard[q+3][w] = b[q][w];
			}
		}
		for(int e=0;e<d[0].length;e++){
			for(int r = 0;r<d.length;r++){
				bigBoard[e+3][r+3] = b[e][r];
			}
		}
		
	}
	private void update(char q){
		switch(q){
			case 'a':
				for(int i = 0;i<a[0].length;i++){
					for(int j = 0;j<a.length;j++){
						bigBoard[i][j] = a[i][j];
					}
				}
				break;
			case 'b':
				for(int k=0;k<b[0].length;k++){
					for(int l = 0;l<b.length;l++){
						bigBoard[k][l+3] = b[k][l];
					}
				}
				break;
			case 'c':
				for(int u=0;u<c[0].length;u++){
					for(int w = 0;w<c.length;w++){
						bigBoard[u+3][w] = c[u][w];
					}
				}
				break;
			case 'd':
				for(int e=0;e<d[0].length;e++){
					for(int r = 0;r<d.length;r++){
						bigBoard[e+3][r+3] = d[e][r];
					}
				}
				break;
		}
	}
	private char quadCheck(int row, int col){
		if(row <= 2 && col <= 2){
			return 'a';
		}
		else if(row <= 2 && col >= 3){
			return 'b';
		}
		else if(row >=3 && col <= 2){
			return 'c';
		}
		else if(row >=3 && col >= 3){
			return 'd';
		}
		return 'z';
		
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
	 public Maneuver canLose(){
		 int op;
		 if(control.getCurrentPlayer().getColor() == 1){
			 op = 2;
		 }
		 else{
			 op = 1;
		 }
		 Maneuver p = new Maneuver();
		 for(int i = 0;i<bigBoard[0].length;i++){
			 for(int j = 0;j<bigBoard.length;j++){
				 if(!isOccupied(i,j)){
					 place(i,j,op);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = quadCheck(i,j);
						 rotate(p.quad,true);
						 if(isWon() == op){
							 p.dir = false;
						 }
						 else{
							 p.dir = true;
						 }
						 return p;
					 }
					 rotate('a',true);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'a';
						 p.dir = true;
						 return p;
						 
					 }
					 rotate('a',false);
					 rotate('a',false);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'a';
						 p.dir = false;
						 return p;
					 }
					 rotate('a',true);
					 rotate('b',true);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'b';
						 p.dir = true;
						 return p;
					 }
					 rotate('b',false);
					 rotate('b',false);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'b';
						 p.dir = false;
						 return p;
					 }
					 rotate('b',true);
					 rotate('c',true);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'c';
						 p.dir = true;
						 return p;
					 }
					 rotate('c',false);
					 rotate('c',false);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'c';
						 p.dir = false;
						 return p;
					 }
					 rotate('c',true);
					 rotate('d',true);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'd';
						 p.dir = true;
						 return p;
					 }
					 rotate('d',false);
					 rotate('d',false);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'd';
						 p.dir = false;
						 return p;
					 }
					 rotate('d',true);
					 
				 }
				 dummyUpdate();
				 System.out.println(Arrays.deepToString(bigBoard));
			 }
		 }
		 return p;
	 }
	 public Maneuver canWin(){
		 int op;
		 if(control.getCurrentPlayer().getColor() == 1){
			 op = 1;
		 }
		 else{
			 op = 2;
		 }
		 Maneuver p = new Maneuver();
		 for(int i = 0;i<bigBoard[0].length;i++){
			 for(int j = 0;j<bigBoard.length;j++){
				 if(!isOccupied(i,j)){
					 place(i,j,op);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 return p;
					 }
					 rotate('a',true);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'a';
						 p.dir = true;
						 return p;
						 
					 }
					 rotate('a',false);
					 rotate('a',false);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'a';
						 p.dir = false;
						 return p;
					 }
					 rotate('a',true);
					 rotate('b',true);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'b';
						 p.dir = true;
						 return p;
					 }
					 rotate('b',false);
					 rotate('b',false);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'b';
						 p.dir = false;
						 return p;
					 }
					 rotate('b',true);
					 rotate('c',true);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'c';
						 p.dir = true;
						 return p;
					 }
					 rotate('c',false);
					 rotate('c',false);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'c';
						 p.dir = false;
						 return p;
					 }
					 rotate('c',true);
					 rotate('d',true);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'd';
						 p.dir = true;
						 return p;
					 }
					 rotate('d',false);
					 rotate('d',false);
					 if(isWon() == op){
						 p.row = i;
						 p.column = j;
						 p.quad = 'd';
						 p.dir = false;
						 return p;
					 }
					 rotate('d',true);

				 }
				 System.out.println(Arrays.deepToString(bigBoard));
				 dummyUpdate();
			 }
		 }
		 return p;
	 }
	 
	 /**
	  * Updates the AIBoard to match the current state of the game Board
	  */
	 public void dummyUpdate(){
		 for(int row = 0;row<bigBoard[0].length;row++){
			 for(int col = 0;col<bigBoard.length;col++){
				int value = board.getBigBoard()[row][col];
				bigBoard[row][col] = value;
				if(row<=2 && col <=2){
					a[row][col]=value;
				}
				if(row <= 2 && col >= 3){
					b[row][col-3] = value;
				}
				if(row >=3 && col <= 2){
					c[row-3][col] = value;
				}
				if(row >=3 && col >= 3){
					d[row-3][col-3] = value;
				}
			 }
		 }
	 }
	public Maneuver winPlan() {
		 int op;
		 if(control.getCurrentPlayer().getColor() == 1){
			 op = 1;
		 }
		 else{
			 op = 2;
		 }
		 Maneuver p = new Maneuver();
		 for(int i = 0;i<bigBoard[0].length;i++){
			 for(int j = 0;j<bigBoard.length;j++){
				 if(!isOccupied(i,j)){
					 place(i,j,op);
					 for(int k = 0;k<bigBoard[0].length;k++){
						 for(int l = 0;l<bigBoard[0].length;l++){
							 if(!isOccupied(k,l)){
								 place(k,l,op);
								 if(isWon() == op){
									 p.row = k;
									 p.column = l;
									 return p;
								 }
								 rotate('a',true);
								 if(isWon() == op){
									 p.row = k;
									 p.column = l;
									 p.quad = 'a';
									 p.dir = true;
									 return p;
									 
								 }
								 rotate('a',false);
								 rotate('a',false);
								 if(isWon() == op){
									 p.row = k;
									 p.column = l;
									 p.quad = 'a';
									 p.dir = false;
									 return p;
								 }
								 rotate('a',true);
								 rotate('b',true);
								 if(isWon() == op){
									 p.row = k;
									 p.column = l;
									 p.quad = 'b';
									 p.dir = true;
									 return p;
								 }
								 rotate('b',false);
								 rotate('b',false);
								 if(isWon() == op){
									 p.row = k;
									 p.column = l;
									 p.quad = 'b';
									 p.dir = false;
									 return p;
								 }
								 rotate('b',true);
								 rotate('c',true);
								 if(isWon() == op){
									 p.row = k;
									 p.column = l;
									 p.quad = 'c';
									 p.dir = true;
									 return p;
								 }
								 rotate('c',false);
								 rotate('c',false);
								 if(isWon() == op){
									 p.row = k;
									 p.column = l;
									 p.quad = 'c';
									 p.dir = false;
									 return p;
								 }
								 rotate('c',true);
								 rotate('d',true);
								 if(isWon() == op){
									 p.row = k;
									 p.column = l;
									 p.quad = 'd';
									 p.dir = true;
									 return p;
								 }
								 rotate('d',false);
								 rotate('d',false);
								 if(isWon() == op){
									 p.row = k;
									 p.column = l;
									 p.quad = 'd';
									 p.dir = false;
									 return p;
								 }
								 rotate('d',true);
								 place(k,l,0);

							 }
							 }
						 }
							 
						 }
					 }
					 
				 System.out.println(Arrays.deepToString(bigBoard));
				 dummyUpdate();
			 }
		 
		 return p;

	}		
	
}

package models;

import java.util.ArrayList;
import java.util.Arrays;

import controller.Controller;

public class Board {
	private int[][] bigBoard;
	private Controller control;
	private int[][] a; 
	private int[][] b;
	private int[][] c;
	private int[][] d;
	private boolean neutral_a;
	private boolean neutral_b;
	private boolean neutral_c;
	private boolean neutral_d;
	
	public Board(Controller controller) {
		bigBoard = new int[6][6];
		a = new int[3][3];
		b = new int[3][3];
		c = new int[3][3];
		d = new int[3][3];
		control = controller;
		neutral_a = true;
		neutral_b = true;
		neutral_c = true;
		neutral_d= true;
		
	}
	/**
	 * Used to place pieces on the board.
	 * @param int row, int col, int p(0,1,or 2 1 representing white, 2 representing black)
	 * @return boolean
	 */
	public boolean place(int row, int col,int p){
		if((row > 5 || col > 5) || (p<=0 || p>3)|| isOccupied(row,col)){
			return false;	
		}
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
		return org;
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
		control.update();
		
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
		control.update();
	}
	/**
	 * getBigBoard
	 * 
	 * @param none
	 * @return int[][]
	 */
	public int[][] getBigBoard(){
		return bigBoard;
	}
	
	/**
	 * Creates a copy of all boards, that if changed will not affect the game state.
	 * @return a deep copy of all matrices on the board. Pos 0-3 are quadrants, 4 is BigBoard.
	 */
	public ArrayList<int[][]> getDeepCopies(){
		ArrayList<int[][]> matricies = new ArrayList<int[][]>(4); 
		ArrayList<int[][]> quadrants = new ArrayList<int[][]>(Arrays.asList(a,b,c,d));
		
		//Creates copy of all Quadrants
		for(int i=0;i<quadrants.size();i++){
			int[][] new_quad = new int[3][3];
			int[][] cur = quadrants.get(i);
			for(int j=0; j<2;j++){
				int[] col = cur[j];
				new_quad[j] = col.clone(); 
			}
			matricies.add(new_quad);
		}
		//Creates Copy of bigBoard
		int[][] bigCopy = new int[6][6];
		for(int i=0;i<bigBoard[0].length;i++){
			bigCopy[i] = bigBoard[i].clone();
		}
		matricies.add(bigCopy);
		
		return matricies;
	}
	
    
	/**
	 * Protected means that only classes inside the package and subclasses can call this
	 * If we really want these methods to never be accessed board and AiBoard can be moved to a separate package
	 */
	protected void setBigBoard(int [][] board){
		bigBoard = board;
	}
	
	protected void setA(int[][] a_prime){
		a = a_prime;
	}
	
	protected void setB(int[][] b_prime){
		b = b_prime;
	}
	
	protected void setC(int[][] c_prime){
		c = c_prime;
	}
	
	protected void setD(int[][] d_prime){
		d = d_prime;
	}
}

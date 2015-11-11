package models;

public class Board {
	int[][] bigBoard;
	int[][] a;
	int[][] b;
	int[][] c;
	int[][] d;
	
	public Board() {
		bigBoard = new int[8][8];
		a = new int[2][2];
		b = new int[2][2];
		c = new int[2][2];
		d = new int[2][2];
		
	}
	public boolean place(int row, int col,player p){
		if()
		
		
		return false;
	}
	public void rotate(char q,boolean d){
		if(q=='a'){
			if(d == false){
				clockwise(a);
			}
			else if(d == true){
				counterclockwise(a);
			}
		}
		else if(q =='b'){
			if(d == false){
				clockwise(b);
			}
			else if(d == true){
				counterclockwise(b);
			}
		}
		else if(q == 'c'){
			if(d == false){
				clockwise(c);
			}
			else if(d == true){
				counterclockwise(c);
			}
		}
		else if(q == 'd'){
			if(d == false){
				clockwise(d);
			}
			else if(d == true){
				counterclockwise(d);
			}
		}
	}
	//hard coded for now, didnt bother figuring out math behind it
	private void clockwise(int[][] quad){
		int[][] temp = new int[2][2];
		temp[0][0] = quad[2][0];
		temp[0][1] = quad[1][0];
		temp[0][2] = quad[0][0];
		temp[1][0] = quad[2][1];
		temp[1][1] = quad[1][1];
		temp[1][2] = quad[0][1];
		temp[2][0] = quad[2][2];
		temp[2][1] = quad[1][2];
		temp[2][2] = quad[0][2];
	}
	private void counterclockwise(int[][] quad){
		int[][] temp = new int[2][2];
		temp[2][0] = quad[0][0];
		temp[1][0] = quad[0][1];
		temp[0][0] = quad[0][2];
		temp[2][1] = quad[1][0];
		temp[1][1] = quad[1][1];
		temp[0][1] = quad[1][2];
		temp[2][2] = quad[2][0];
		temp[1][2] = quad[2][1];
		temp[0][2] = quad[2][2];
		
	}
	public boolean isOccupied(int row, int col){
		return false;
	}
	public boolean isWon(){
		return false;
	}
	

}

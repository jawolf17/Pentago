package models;

public class Board {
	int[][] bigBoard;
	int[][] a;
	int[][] b;
	int[][] c;
	int[][] d;
	
	public Board() {
		bigBoard = int[8][8];
		a = int[3][3];
		b = int[3][3];
		c = int[3][3];
		d = int[3][3];
		
	}
	public boolean place(int row, int col,player p){
		return false;
	}
	public void rotate(char q,boolean d){
		
	}
	public boolean isOccupied(int row, int col){
		return false;
	}
	public boolean isWon(){
		return false;
	}
	

}

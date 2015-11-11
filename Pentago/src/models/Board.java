package models;

public class Board {
	int[][] bigBoard;
	int[][] a;
	int[][] b;
	int[][] c;
	int[][] d;
	
	public Board() {
		bigBoard = new int[5][5];
		a = new int[2][2];
		b = new int[2][2];
		c = new int[2][2];
		d = new int[2][2];
		
	}
	public boolean place(int row, int col,int c){
		if((row >5 || col > 5) || !(c<=0 && c>3){
			return false;
		}
		 
		if(row <= 2 && col <= 2){
			a[row][col] = c;
			update('a');
		}
		else if(row <= 2 && col >= 3){
			b[row][col-3] = c;
			update('b');
		}
		else if(row >=3 && col <= 2){
			c[row-3][col] = c;
			update('c');
		}
		else if(row >=3 && col >= 3){
			d[row-3][col-3] = c;
			update('d');
		}
		
		
		return true;
	}
	public void rotate(char q,boolean d){
		if(q=='a'){
			if(d == false){
				clockwise(a);
			}
			else if(d == true){
				counterclockwise(a);
			}
			update('a');
		}
		else if(q =='b'){
			if(d == false){
				clockwise(b);
			}
			else if(d == true){
				counterclockwise(b);
			}
			update('b');
		}
		else if(q == 'c'){
			if(d == false){
				clockwise(c);
			}
			else if(d == true){
				counterclockwise(c);
			}
			update('c');
		}
		else if(q == 'd'){
			if(d == false){
				clockwise(d);
			}
			else if(d == true){
				counterclockwise(d);
			}
			update('d');
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
		if(bigBoad[row][col] == 0){
			return false;
		}
		else{
			return true;
		}
	}
	public boolean isWon(){
		return false;
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
				for(int q=0;q<c[0].length;q++){
					for(int w = 0;w<c.length;w++){
						bigBoard[q+3][w] = b[q][w];
					}
				}
				break;
			case 'd':
				for(int e=0;e<d[0].length;e++){
					for(int r = 0;r<d.length;r++){
						bigBoard[e+3][r+3] = b[e][r];
					}
				}
				break;
		}
	}
	

}

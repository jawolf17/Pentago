package models;

import java.util.Arrays;

public class Board {
	int[][] bigBoard;
	int[][] a;
	int[][] b;
	int[][] c;
	int[][] d;
	
	public Board() {
		bigBoard = new int[6][6];
		a = new int[3][3];
		b = new int[3][3];
		c = new int[3][3];
		d = new int[3][3];
		
	}
	public boolean place(int row, int col,int p){
		if((row > 5 || col > 5) || (p<=0 || p>3)){
			System.out.println(Arrays.deepToString(a));
			return false;
		}
		 
		if(row <= 2 && col <= 2){
			a[row][col] = p;
			update('a');
			System.out.println(Arrays.deepToString(a));
		}
		else if(row <= 2 && col >= 3){
			b[row][col-3] = p;
			update('b');
		}
		else if(row >=3 && col <= 2){
			c[row-3][col] = p;
			update('c');
		}
		else if(row >=3 && col >= 3){
			d[row-3][col-3] = p;
			update('d');
		}
		
		
		return true;
	}
	public void rotate(char q,boolean r){
		if(q=='a'){
			if(r == false){
				clockwise(a);
			}
			else if(r == true){
				counterclockwise(a);
			}
			update('a');
		}
		else if(q =='b'){
			if(r == false){
				clockwise(b);
			}
			else if(r == true){
				counterclockwise(b);
			}
			update('b');
		}
		else if(q == 'c'){
			if(r == false){
				clockwise(c);
			}
			else if(r == true){
				counterclockwise(c);
			}
			update('c');
		}
		else if(q == 'd'){
			if(r == false){
				clockwise(d);
			}
			else if(r == true){
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
		if(bigBoard[row][col] == 0){
			return false;
		}
		else{
			return true;
		}
	}
	//will only need to check forwards, down, down right, and down left.
	public boolean isWon(){
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
									return true;
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
									return true;
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
									return true;
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
									return true;
								}
							}
						}
					}
					
					
				
					
				}
			}
		}
		System.out.println(Arrays.deepToString(bigBoard));
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
				for(int u=0;u<c[0].length;u++){
					for(int w = 0;w<c.length;w++){
						bigBoard[u+3][w] = b[u][w];
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

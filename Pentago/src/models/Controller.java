package models;
public class Controller {
	private Board b;
	public Controller(Board board){
		b = board;
	}
	public void place(int row, int col,int c){
		b.place(row, col, c);
	}
	public void rotate(char q,boolean r){
		b.rotate(q, r);
	}
	public void update(){
		//update gui
	}
}

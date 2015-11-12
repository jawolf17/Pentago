package models;

public class Test {

	public static void main(String[] args) {
		Board test = new Board();
		test.place(0,0,1);
		test.place(1,0,1);
		test.place(2,0,1);
		test.place(0,3,1);
		test.place(0,4,1);
		test.rotate('a',false);
		System.out.println(test.isWon());
		// TODO Auto-generated method stub

	}

}

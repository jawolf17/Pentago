package models;

public class Test {

	public static void main(String[] args) {
		Board test = new Board();
		test.place(0,0,1);
		test.place(0,1,1);
		test.place(0,2,1);
		test.place(0,5,1);
		test.place(1,5,1);
		test.rotate('b',true);
		System.out.println(test.isWon());
		// TODO Auto-generated method stub

	}

}

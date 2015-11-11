package models;

public class Test {

	public static void main(String[] args) {
		Board test = new Board();
		test.place(0,0,1);
		test.place(1,0,1);
		test.place(2,0,1);
		test.place(3,0,1);
		test.place(4,0,1);
		System.out.println(test.isWon());
		// TODO Auto-generated method stub

	}

}

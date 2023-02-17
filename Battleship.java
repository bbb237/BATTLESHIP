/* 
Name: Kalea Sastra

11/4/2021

Battleship game recreation
*/
import java.util.Scanner;

public class Battleship {

		static final int SHIP_SIZE = 4; // constant for the size of the ship 
		static final int DIMENSION = 10; // constant for the size of the board (square) 
						// create the board
						// randomly place the ship. Use Math.random() to return an int
						// random numbers 
						// display the board 

		//[rows - numbers][columns - letters]
		static String[][] gameboard = new String[DIMENSION][DIMENSION]; 
		static String[][] shipPosition = new String[DIMENSION][DIMENSION]; 

		//board pieces
		static final String MISS = "#";
		static final String HIT = "X";
		static final String HOLDER = " ";
		static final String SHIP = "@";

	public static void main(String[] args) {

		//Board layout
		System.out.println("   A   B   C   D   E   F   G   H   I   J  ");

		//Initializing the board
		for (int i = 0; i < DIMENSION; i++) {

			for (int j = 0; j < DIMENSION; j++){
				gameboard[i][j] = HOLDER;
				shipPosition[i][j] = HOLDER;	
		}}

		for (int i = 0; i < DIMENSION; i++) {

			rowSeperator();
			columnSeperator(i);
		}

		//Last row border
		rowSeperator();

		//Random location of the ship
		positionRandonmizer();

		Scanner input = new Scanner(System.in);
		int shipParts = 4;
		int attempts = 0;

		while (shipParts > 0) {

			System.out.print("Enter coordinate to target (e.g. A1): ");
			String player = input.next();
			System.out.print("\n");

			while ((player.length() > 2) || !((65 <= (int) player.charAt(0) && (int) player.charAt(0) <= 74)) || 
				!((48 <= (int) player.charAt(1) && (int) player.charAt(1) <= 57))) {

				System.out.print("That is not a valid coordinate.\n");
				System.out.print("Enter coordinate to target (e.g. A1): ");
				player = input.next();
				System.out.print("\n");
			}

			if (playerGuess(player)) {

				gameboard[(player.charAt(1) - '0')][player.charAt(0) - 'A'] = HIT;
				shipParts -= 1;
				attempts += 1;
			}

			else {

				gameboard[(player.charAt(1) - '0')][player.charAt(0) - 'A'] = MISS;
				attempts += 1;
			}

			//Reprinting gameboard
			System.out.println("   A   B   C   D   E   F   G   H   I   J  ");
			for (int i = 0; i < DIMENSION; i++) {

				rowSeperator();
				columnSeperator(i);
			}

			//Last row border
			rowSeperator();
		}

		//printing out results of the game
		System.out.println("\nYou won the game with " + attempts + " attempts");
	}

	public static void rowSeperator() {

		System.out.print(" ");

		for (int i = 0; i < DIMENSION; i++) {

			System.out.print("+---");
		}

		System.out.println("+");
	}

	public static void columnSeperator(int row) {

		System.out.print(row);

		for (int i = 0; i < DIMENSION; i++) {

			System.out.print("| " + gameboard[row][i] + " ");
		}

		System.out.print("|\n");		
	}

	public static void positionRandonmizer() {

		int rowShip = (int) (Math.random() * 10);
		int columnShip = (int) (Math.random() * 10);
		int orientation = (int) (Math.random() * 4);

		//less than or equal to 1 is horizontal
		if (orientation <= 1) {

			//ship extends to the right of the first block
			if (columnShip <= 6) {

				for (int i = columnShip; i < columnShip + 4; i++)
					shipPosition[rowShip][i] = SHIP;
			}

			//ship extends to the left of the first block
			else {

				for (int i = columnShip; i > columnShip - 4; i--)
					shipPosition[rowShip][i] = SHIP;
		}}

		//greater than 1 is vertical
		else {

			//ship extends down of the first block
			if (rowShip <= 6) {

				for (int i = rowShip; i < columnShip + 4; i++)
					shipPosition[i][columnShip] = SHIP;
			}

			//ship extends up of the first block
			else {

				for (int i = rowShip; i > columnShip - 4; i--) 
					shipPosition[i][columnShip] = SHIP;
	}}}

	public static boolean playerGuess(String a) {

		int columnPlayer = (int) a.charAt(0) - 'A';
		int rowPlayer = (int) a.charAt(1) - '0';

		if (shipPosition[rowPlayer][columnPlayer].equals("@")) {
			return true;
		}
		
		else {

			return false;
	}}

}



















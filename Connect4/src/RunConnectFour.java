import java.util.Scanner;

public class RunConnectFour {

	public static void main(String[] args) {
		char[][] grid = new char[6][7];
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				grid[i][j] = '_';
			}
		}
		
		//Variables
		Scanner keyboard = new Scanner(System.in);
		
		int win = 0; //0 = still playing; 1 = player1 win; 2 = player2 win;
		int turn = 1; //1 = player1 turn; 2 = player2 turn;
		int position = -1;
		int position2 = -1;
		String keyboardInput;
		int numOfTurns = 0;
		int whileNum = 0; //made just for while loops
		
		System.out.println("Welcome to Connect 4!");
		System.out.println("Player 1 uses X pieces");
		System.out.println("Player 2 uses O pieces");
		
		while (win == 0) {
			if (turn == 1) {
				displayGrid(grid);
				System.out.println("Player 1, where do you put your piece?:");

				//Checking if valid input
				while (whileNum == 0) {
					keyboardInput = keyboard.next();
					for (int i=0; i<7; i++) {
						position = keyboardInput.indexOf(Integer.toString(i));
						if (position != -1) {
							position = i;
							break;
						}
					}
					if (position >= 0 && position < grid[0].length && grid[0][position] == '_') {
						whileNum = 1;
					}else {
						System.out.println("That's not a valid spot to place your piece, try again:");
					}
				}
				
				//Putting in slot
				if (grid[5][position] == '_') {
					grid[5][position] = 'X';
					position2 = 5;
				}else {
					for (int i=0; i < grid.length; i++) {
						if (grid[i][position] != '_') {
							grid[i-1][position] = 'X';
							position2 = i-1;
							break;
						}
					}
				}
				whileNum = 0;
				//Check for win
				if (checkWin(grid, position2, position, 'X') == 1) {
					displayGrid(grid);
					System.out.println("Alright you win Player 1");
					break;
				}
				turn = 2;
				numOfTurns += 1;
			}else if (turn == 2) {
				displayGrid(grid);
				System.out.println("Player 2, where do you put your piece?:");

				//Checking if valid input
				while (whileNum == 0) {
					keyboardInput = keyboard.next();
					for (int i=0; i<7; i++) {
						position = keyboardInput.indexOf(Integer.toString(i));
						if (position != -1) {
							position = i;
							break;
						}
					}
					if (position >= 0 && position < grid[0].length && grid[0][position] == '_') {
						whileNum = 1;
					}else {
						System.out.println("That's not a valid spot to place your piece, try again:");
					}
				}
				
				//Putting in slot
				if (grid[5][position] == '_') {
					grid[5][position] = 'O';
					position2 = 5;
				}else {
					for (int i=0; i < grid.length; i++) {
						if (grid[i][position] != '_') {
							grid[i-1][position] = 'O';
							position2 = i-1;
							break;
						}
					}
				}
				whileNum = 0;
				//Check for win
				if (checkWin(grid, position2, position, 'O') == 2) {
					displayGrid(grid);
					System.out.println("Alright you win Player 2");
					break;
				}
				turn = 1;
				numOfTurns += 1;
			}
			if (numOfTurns >= (grid.length*grid[0].length)) {
				displayGrid(grid);
				System.out.println("Dude, you guys tied. That was a lame game");
				break;
			}

		}
	}
	
	public static void displayGrid(char[][] grid) {
		System.out.println("The Board:");
		System.out.println(" 0 1 2 3 4 5 6 ");
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
				System.out.print("|"+grid[i][j]);
			}
			System.out.print("|");
			System.out.println();
		}
	}
	
	public static int checkWin(char[][] grid, int position2, int position, char XorO) {
		//Checking left to right
		int x = 0;
		for(int i=0; i<4; i++) {
			if (position+i < grid[0].length) {
				if (grid[position2][position+i] == XorO) {
					x += 1;
				}else {
					break;
				}
			}
		}
		for(int i=1; i<4; i++) { //i=1 here so it doesn't count itself twice
			if (position-i >= 0) {
				if (grid[position2][position-i] == XorO) {
					x += 1;
				}else {
					break;
				}
			}
		}
		if (x >= 4) {
			if (XorO == 'X'){
				return(1);
			}else if (XorO == 'O'){
				return(2);
			}
		}
		//up/down
		x = 0;
		for(int i=0; i<4; i++) {
			if (position2+i < grid.length) {
				if (grid[position2+i][position] == XorO) {
					x += 1;
				}else {
					break;
				}
			}
		}
		for(int i=1; i<4; i++) {//i=1 here so it doesn't count itself twice
			if (position2-i >= 0) {
				if (grid[position2-i][position] == XorO) {
					x += 1;
				}else {
					break;
				}
			}
		}
		if (x >= 4) {
			if (XorO == 'X'){
				return(1);
			}else if (XorO == 'O'){
				return(2);
			}
		}
		//left top/ right bottom
		x = 0;

		for(int i=0; i<4; i++) {
			if (position2+i < grid.length && position+i < grid[0].length) {
				if (grid[position2+i][position+i] == XorO) {
					x += 1;
				}else {
					break;
				}
			}
		}
		for(int i=1; i<4; i++) {
			if (position2-i >= 0 && position-i >= 0) {
				if (grid[position2-i][position-i] == XorO) {
					x += 1;
				}else {
					break;
				}
			}
		}
		if (x >= 4) {
			if (XorO == 'X'){
				return(1);
			}else if (XorO == 'O'){
				return(2);
			}
		}
		//left bottom/ right top
		x = 0;
		for(int i=0; i<4; i++) {
			if (position2-i >= 0 && position+i < grid[0].length) {
				if (grid[position2-i][position+i] == XorO) {
					x += 1;
				}else {
					break;
				}
			}
		}
		for(int i=1; i<4; i++) {
			if (position2+i < grid.length && position-i >= 0) {
				if (grid[position2+i][position-i] == XorO) {
					x += 1;
				}else {
					break;
				}
			}
		}
		if (x >= 4) {
			if (XorO == 'X'){
				return(1);
			}else if (XorO == 'O'){
				return(2);
			}
		}
		return(0);
	}

}

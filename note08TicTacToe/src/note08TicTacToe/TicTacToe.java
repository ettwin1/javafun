package note08TicTacToe;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		//Setting up input stuff
		Scanner keyboard = new Scanner(System.in);
		
		//filling double array with blanks
		char[][] board;
		board = new char[3][3];
		for (int i=0; i<3; i++) {
			for(int y=0; y<3; y++) {
				board[i][y] = ' ';
			}
		}
		String line1 = "A "+board[0][0]+" | "+board[1][0]+" | "+board[2][0]+" ";
		String line2 = "B "+board[0][1]+" | "+board[1][1]+" | "+board[2][1]+" ";
		String line3 = "C "+board[0][2]+" | "+board[1][2]+" | "+board[2][2]+" ";
		
		//Making variables
		char charRow;
		int row = 0;
		char charCol;
		int col = 0;
		int turn = 1; //1 = player 1; 2 = player 2
		int win  = 0; //0 = playing; 1 = player1 win; 2 = player2 win; 3 = tie
		int blanks = 0;//amount of blanks in board
		//Making display board function
		
		
		System.out.println("Welcome... to TicTacToe!");
		System.out.println("  0   1   2 ");
		System.out.println("A   |   |   ");
		System.out.println(" -----------");
		System.out.println("B   |   |   ");
		System.out.println(" -----------");
		System.out.println("C   |   |   ");
		
		while(win == 0) {
		if (turn == 1) {
			//Character Input Rows and Columns
			int validInput = 0;
			while(validInput == 0) {
				System.out.print("Player 1 Enter Row: ");
				charRow = keyboard.next().charAt(0);
				if (charRow == 'a' || charRow == 'A') {
					row = 0;
					validInput = 1;
				}
				else if (charRow == 'b' || charRow == 'B') {
					row = 1;
					validInput = 1;
				}
				else if (charRow == 'c' || charRow == 'C') {
					row = 2;
					validInput = 1;
				}
				else System.out.println("Invalid input, try again");
			}
			
			while(validInput == 1) {
				System.out.print("Player 1 Enter Col: ");
				charCol = keyboard.next().charAt(0);
				if (charCol == '0') {
					validInput = 2;
					col = Character.getNumericValue(charCol);
				}
				else if (charCol == '1') {
					validInput = 2;
					col = Character.getNumericValue(charCol);
				}
				else if (charCol == '2') {
					validInput = 2;
					col = Character.getNumericValue(charCol);
				}
				else System.out.println("Invalid input, try again");
			}
			
			//Adding input to array
			if (board[col][row]==' ') {
				board[col][row] = 'X';
				turn = 2;
			}else {
				System.out.println("Hey, that's cheating! You can't put it there! Your turn is skipped.");
				turn = 2;
			}	
		}else if (turn == 2) {
			//Character Input Rows and Columns
			int validInput = 0;
			while(validInput == 0) {
				System.out.print("Player 2 Enter Row: ");
				charRow = keyboard.next().charAt(0);
				if (charRow == 'a' || charRow == 'A') {
					row = 0;
					validInput = 1;
				}
				else if (charRow == 'b' || charRow == 'B') {
					row = 1;
					validInput = 1;
				}
				else if (charRow == 'c' || charRow == 'C') {
					row = 2;
					validInput = 1;
				}
				else System.out.println("Invalid input, try again");
			}
			
			while(validInput == 1) {
				System.out.print("Player 2 Enter Col: ");
				col = keyboard.nextInt();
				if (col == 0) validInput = 2;
				else if (col == 1) validInput = 2;
				else if (col == 2) validInput = 2;
				else System.out.println("Invalid input, try again");
			}
			
			//Adding input to array
			if (board[col][row]==' ') {
				board[col][row] = 'O';
				turn = 1;
			}else {
				System.out.println("Hey, that's cheating! You can't put it there! Your turn is skipped.");
				turn = 1;
			}	
		}
		//Displaying board
		line1 = "A "+board[0][0]+" | "+board[1][0]+" | "+board[2][0]+" ";
		line2 = "B "+board[0][1]+" | "+board[1][1]+" | "+board[2][1]+" ";
		line3 = "C "+board[0][2]+" | "+board[1][2]+" | "+board[2][2]+" ";
		System.out.println("  0   1   2 ");
		System.out.println(line1);
		System.out.println(" -----------");
		System.out.println(line2);
		System.out.println(" -----------");
		System.out.println(line3);
		
		//Checking if player1 win
		if (board[0][0] == 'X') {
			if(board[0][1] == 'X') {
				if(board[0][2] == 'X') win = 1;
			}else if(board[1][0] == 'X') {
				if(board[2][0] == 'X') win = 1;
			}else if(board[1][1] == 'X') {
				if(board[2][2] == 'X') win = 1;
			}
		}else if(board[1][0] == 'X') {
			if(board[1][1] == 'X') {
				if(board[1][2] == 'X') win = 1;
			}
		}else if(board[2][0] == 'X') {
			if(board[1][1] == 'X') {
				if(board[0][2] == 'X') win = 1;
			}else if(board[2][1] == 'X') {
				if(board[2][2] == 'X') win = 1;
			}
		}else if(board[0][1] == 'X') {
			if(board[1][1] == 'X') {
				if(board[2][1] == 'X') win = 1;
			}
		}else if(board[0][2] == 'X') {
			if(board[1][2] == 'X') {
				if(board[2][2] == 'X') win = 1;
			}
		}
		
		//Checking if player2 win
		if (board[0][0] == 'O') {
			if(board[0][1] == 'O') {
				if(board[0][2] == 'O') win = 2;
			}else if(board[1][0] == 'O') {
				if(board[2][0] == 'O') win = 2;
			}else if(board[1][1] == 'O') {
				if(board[2][2] == 'O') win = 2;
			}
		}else if(board[1][0] == 'O') {
			if(board[1][1] == 'O') {
				if(board[1][2] == 'O') win = 2;
			}
		}else if(board[2][0] == 'O') {
			if(board[1][1] == 'O') {
				if(board[0][2] == 'O') win = 2;
			}else if(board[2][1] == 'O') {
				if(board[2][2] == 'O') win = 2;
			}
		}else if(board[0][1] == 'O') {
			if(board[1][1] == 'O') {
				if(board[2][1] == 'O') win = 2;
			}
		}else if(board[0][2] == 'O') {
			if(board[1][2] == 'O') {
				if(board[2][2] == 'O') win = 2;
			}
		}
		
		//Checking if tie
		blanks = 0;
		for(int i=0; i<3; i++) {
			for(int y=0; y<3; y++) {
				if (board[i][y]==' ') {
					blanks += 1;
				}
			}
		}
		if(blanks == 0) {
			win = 3;
		}
		
		}//end while loop
		
		
		
		//CONCLUSION
		if (win == 1) {
			System.out.println("PLAYER 1 WINS!");
		}else if (win == 2) {
			System.out.println("PLAYER 2 WINS!");
		}else if (win == 3) {
			System.out.println("Come on guys... you TIED?! You can do better than this!");
		}
	}

}

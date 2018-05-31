package note07Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Hangman {

	public static void main(String[] args) throws FileNotFoundException {
		//Reading file
		String filename = JOptionPane.showInputDialog("Enter the file name: ");
		Scanner file = new Scanner(new File("/home/student/Desktop/"+filename));//labxx.dat
		Scanner keyboard = new Scanner(System.in);
		Random random = new Random();
		
		int size = file.nextInt();
		file.nextLine();
		String[] words;
		words = new String[size];
		for(int i=0; i<size; i++) {
			words[i] = file.nextLine();
		}
		
		//Start
		String secretWord = words[random.nextInt(words.length)];
		int wrongGuesses = 0;
		char[] letters;
		letters = new char[secretWord.length()+6];
		String blanks = "";
		for(int i=0; i<secretWord.length(); i++) {
			if(i == secretWord.length()-1) {
				blanks += "_";
			}else {
				blanks += "_ ";
			}
		}
		StringBuilder knownWord = new StringBuilder(blanks);
		//filling spaces for blanks
		for (int i=0; i<secretWord.length(); i++) {
			if (' ' == secretWord.charAt(i)) {
				knownWord.setCharAt(i*2, ' ');
			}
		}
		char currentLetter;
		int finish = 0;//0 = playing; 1 = lose; 2 = win
		
		System.out.println("Welcome to... HANGMAN");
		System.out.println("You only have 6 wrong guesses");
		System.out.println("The word has "+secretWord.length()+" letters");
		System.out.println(knownWord);
		JOptionPane.showMessageDialog(null, "Welcome to... HANGMAN\nYou only have 6 wrong guesses\nThe word has "+secretWord.length()+" letters, all are lowercase\n"+knownWord);
		
		while(finish == 0) {
			int goodword = 0;
			System.out.println("");
			System.out.print("Guess a letter: ");
			////currentLetter = keyboard.next().charAt(0);
			currentLetter = JOptionPane.showInputDialog("Guess a letter: ").charAt(0);
			for (int i = 0; i<letters.length; i++) {
				if (currentLetter == letters[i]){
					goodword = 1;
					System.out.println("You already guessed that bro");
					JOptionPane.showMessageDialog(null, "You already guessed that bro");
					break;
				}
			}
			if (goodword==0) {goodword=2;}
			if (goodword==1) {goodword=0;}
			while(goodword == 0) {
				System.out.println("");
				System.out.print("Guess a letter: ");
				////currentLetter = keyboard.next().charAt(0);
				currentLetter = JOptionPane.showInputDialog("Guess a letter: ").charAt(0);
				for (int i=0; i<letters.length; i++) {
					if (currentLetter == letters[i]){
						goodword = 1;
						System.out.println("You already guessed that bro");
						JOptionPane.showMessageDialog(null, "You already guessed that bro");
						break;
					}
				}
				if (goodword==0) {goodword=2;}
				if (goodword==1) {goodword=0;}
			}
			
			//Checking for matches / filling blanks
			int matches = 0;
			for (int i=0; i<secretWord.length(); i++) {
				if (currentLetter == secretWord.charAt(i)) {
					knownWord.setCharAt(i*2, currentLetter);
					matches += 1;
				}
			}
			//Displaying the matches
			if (matches == 0) {
				wrongGuesses += 1;
				System.out.println("There is no '"+currentLetter+"'. "+wrongGuesses+" wrong guesses.");
				String display = new String(knownWord);
				System.out.println(display);
				JOptionPane.showMessageDialog(null, "There is no '"+currentLetter+"'. "+wrongGuesses+" wrong guesses.\n"+display);
			}else if (matches == 1) {
				System.out.println("There is 1 '"+currentLetter+"'");
				String display = new String(knownWord);
				System.out.println(display);
				JOptionPane.showMessageDialog(null, "There is 1 '"+currentLetter+"'\n"+display);
			}else if (matches > 1) {
				System.out.println("There are "+matches+" '"+currentLetter+"'");
				String display = new String(knownWord);
				System.out.println(display);
				JOptionPane.showMessageDialog(null, "There are "+matches+" '"+currentLetter+"'\n"+display);
			}
			for (int i=0; i<letters.length; i++) {
				if (letters[i] == '\u0000') {
					letters[i] = currentLetter;
					break;
				}
			}
			//Checking if win
			for(int i=0; i<knownWord.length(); i++) {
				if (knownWord.charAt(i)=='_') {
					finish = 1;
					break;
				}
			}
			if (finish==0) {finish=2;}
			if (finish==1) {finish=0;}
			//Checking if lose
			if (wrongGuesses == 6) {
				System.out.println("YOU LOSE HAHAHAHAHAHAHAHAHAHA");
				JOptionPane.showMessageDialog(null, "YOU LOSE HAHAHAHAHHAAHHAAHHA");
				finish = 1;
			}
		}
		if (finish == 2) {
			System.out.println("YOU WIN!!!");
			JOptionPane.showMessageDialog(null, "YOU WIN!!!");
		}

	}

}

import java.util.Random;
import java.util.Scanner;
public class Game {

	public static void main(String[] args) {
		//Construct a match and play the game
		Match game1 = new Match();

	}

}

class Match {
	Match(){
		System.out.println("Creating a playable game.");
		Secret sec = new Secret();
		Guess gues = new Guess();
		
		while (gues.getAttempts() < gues.getMaxAttempts() && gues.getNumber() != sec.getSecretNum()){
			//calling player input
			gues.getGuess();
			
			//Writes the code that compared and prints result
			if (gues.getNumber()>sec.getSecretNum()) {
				System.out.println("Lower");	
			}else if (gues.getNumber()<sec.getSecretNum()) {
				System.out.println("Higher");
			}else {
				System.out.println("You got it!");
			}
		}
		System.out.println("YOU LOST! HAHAHAHA");
	}
}

class Secret {
	private int number = 0;
	
	Secret(){
		System.out.println("Create a Secret number.");
		Random rand = new Random();
		this.number = rand.nextInt(99) + 1;
		System.out.println("SECRET IS: " + number);
	}
	
	int getSecretNum() {
		return(this.number);
	}
}

class Guess {
	private int number = 0;
	private int attempts = 0;
	private int maxAttempts = 10;
	Scanner keybd;
	Guess(){
		System.out.println("Guess function started");
		keybd = new Scanner(System.in);
	}
	
	int getNumber(){
		return(this.number);
	}
	int getAttempts() {
		return(this.attempts);
	}
	int getMaxAttempts() {
		return(this.maxAttempts);
	}
	
	void getGuess() {
		System.out.println("Time to Guess! Attempt "+(this.attempts+1));	
		this.number = keybd.nextInt();
		attempts += 1;
	}
}
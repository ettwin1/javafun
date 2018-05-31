
public class StringLoops {

	public static void main(String[] args) {
		String word = "lophone";
		String message = "Alright that word is okay";
		
		for (int i=0; i < word.length(); i++) {
			if (word.charAt(i) == 'z' || word.charAt(i) == 'y' || word.charAt(i) == 'x') {
				message = "TOO COMPLICATED!";
			}
		}
		System.out.print(message);
		
	}

}

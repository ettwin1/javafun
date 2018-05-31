
public class StringChecks {

	public static void main(String[] args) {
		String word = "ldiked";
		String message;
		
		if (word.charAt(word.length()-1)=='d' && word.charAt(word.length()-2)=='e') {
			message = "Go ahead and use that word for the worksheet!";
		}else {
			message = "That word isn't in past tense, choose another word.";
		}
		System.out.println(message);

	}

}

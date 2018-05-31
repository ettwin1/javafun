import javax.swing.JOptionPane;

public class Caesar {

	public static void main(String[] args) {
		Cipher myCipher = new Cipher();
		myCipher.setAlpha("abcdefghijklmnopqrstuvwxyz");
		int theMove;
		boolean end = false;
		
		while(end == false) {
		String choose[] = {"Encode", "Decode", "Exit"};
		String youChose = (String) JOptionPane.showInputDialog(null,"Choose", "Which would you like to do?",JOptionPane.QUESTION_MESSAGE,null,choose,choose[0]);
		
		if (youChose == "Encode") {
		
		//Encode
		String encodeWord = JOptionPane.showInputDialog("Enter the word you would like to encode: ");
		
		String choices[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26"};
		String theMovestring = (String) JOptionPane.showInputDialog(null, "Choose","How much do you want to move in the key?",JOptionPane.QUESTION_MESSAGE,null,choices,choices[0]);
		theMove = Integer.valueOf(theMovestring);
		
		String cool = myCipher.encode(encodeWord,theMove);
		System.out.println(cool);
		JOptionPane.showMessageDialog(null, "This is the encoded word: "+cool);
		
		}else if (youChose == "Decode") {
		
		//Decode
		String decodeWord = JOptionPane.showInputDialog("Enter the code you would like to decode: ");
		
		String choices2[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26"};
		String theMovestring2 = (String) JOptionPane.showInputDialog(null, "Choose","How much do you want to move in the key?",JOptionPane.QUESTION_MESSAGE,null,choices2,choices2[0]);
		theMove = Integer.valueOf(theMovestring2);
		
		String cool2 = myCipher.decode(decodeWord,theMove);
		System.out.println(cool2);
		JOptionPane.showMessageDialog(null, "This is the encoded word: "+cool2);
		
		}else if (youChose == "Exit") {
			end = true;
		}
		}
	
	}
	

}

class Cipher {
	char[] code2 = {};
	String alph;
	public Cipher() {
		
	}
	
	public String encode(String word, int move) {
		int i = 0;
		StringBuilder word2 = new StringBuilder(word);
		while(i < word2.length()) {
			int index = 0;
			for (int y = 0; y < alph.length(); y++) {
				if (word2.charAt(i)==code2[y]) {
					index = y;
				}
			}
			if ((index+move) > alph.length()-1) {
				if (word2.charAt(i) != ' ') {
					word2.setCharAt(i, code2[move-alph.substring(index).length()]);}
			}else {
				if (word2.charAt(i) != ' ') {
					word2.setCharAt(i, code2[index+move]);} //word.substring(0,i)+code2[i+move]+word.substring(i+1);
			}
			i++;
		}
		String word3 = new String(word2);
		return(word3);
	}
	
	public String decode(String word, int move) {
		int i = 0;
		StringBuilder word2 = new StringBuilder(word);
		while(i < word2.length()) {
			int index = 0;
			for (int y = 0; y < alph.length(); y++) {
				if (word2.charAt(i)==code2[y]) {
					index = y;
				}
			}
			if ((index-move) < 0) {
				if (word2.charAt(i) != ' ') {
					word2.setCharAt(i, code2[((move-index)-alph.length())*-1]);}
			}else {
				if (word2.charAt(i) != ' ') {
					word2.setCharAt(i, code2[index-move]);} //word.substring(0,i)+code2[i+move]+word.substring(i+1);
			}
			i++;
		}
		String word3 = new String(word2);
		return(word3);
	}
	
	void setAlpha(String alphabet) {
		char[] code = alphabet.toCharArray();
		code2 = code;
		alph = alphabet;
	}
}


public class Strings {

	public static void main(String[] args) {
		int age = 22;
		String message = "";
		
		if (age >= 21) {
			message = "You can DEFINITELY watch this movie";
		}else if (age < 21 && age >= 13) {
			message = "Go ahead, you're old enough to watch the movie";
		}else {
			message = "Sorry bro, you're too young to watch this movie";
		}
		System.out.print(message);
	}

}

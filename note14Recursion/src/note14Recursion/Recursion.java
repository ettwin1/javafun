package note14Recursion;

public class Recursion {

	public static void main(String[] args) {
		System.out.println("Result: "+factoral(4));
		System.out.println(alphabet((int)('n'))); //forcing ASCII character into an int
		System.out.println(bitCount(100));
		
	}
	
	private static int factoral(int num) {
		System.out.println("Process Factoral: " + num);
		int result = 0;
		if (num != 1) {
			System.out.println(" Recurse: "+(num - 1));
			result = num * factoral(num -1);
		}else {
			result = 1;
		}
		System.out.println("returning: "+result);
		return(result);
	}
	
	//return all characters after the letter specified by the parameter
	public static String alphabet(int code) {
		String result;
		if (code < 122) {
			result = (char)(code) + alphabet(code+1);
		}else {
			result = "z";
		}
		return(result);
	}
	
	public static int bitCount(int number) {
		int bits = 1;
		if (number / 2 >= 1) {
			bits = bitCount(number/2) + 1;
		}
		else {
			return(1);
		}
		return(bits);
	}

}

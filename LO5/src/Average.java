import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Average {

	public static void main(String[] args) {
		String numbers = "100 90 95 98 100 97";
		String integer = "";
		int num = 0;
		double sum = 0;
		for (int i = 0; i < numbers.length(); i ++) {
			if (Character.isDigit(numbers.charAt(i))) {
				integer += numbers.charAt(i);
			}else if (integer != ""){
				sum += Integer.parseInt(integer);
				num += 1;
				integer = "";
			}
		}
		if (Character.isDigit(numbers.charAt(numbers.length()-1))) {
			sum += Integer.parseInt(integer);
			num += 1;
		}
		DecimalFormat myFormat;
		myFormat = new DecimalFormat("###,###.###");
		System.out.println(myFormat.format(sum/num));
	}
	

}

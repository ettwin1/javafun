import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LargestFromFile {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("/home/student/Desktop/labxx2.dat"));
		int size = file.nextInt();
		//string.toInteger
		file.nextLine(); //buffer clearing code
		
		for(int i=0; i<size; i++) {
			String line = file.nextLine();
			int nums = 1;
			int l = 0;
			int y = 0;
			int maxNum = 0;
			int num = 0;
			while (l < line.length()) {
				if(line.charAt(l)==' ') {
					nums += 1;
				}
				l++; 
			}
			System.out.println(nums);
			
			while(y < nums) {
				/*num = file.nextInt();
				
				if (num > maxNum) {
					maxNum = num;
				}
				*/
				y += 1;
			}
			
		}

	}

}

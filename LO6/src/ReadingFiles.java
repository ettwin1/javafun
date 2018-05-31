import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class ReadingFiles {

	public static void main(String[] args) throws FileNotFoundException {
		// Get a filename from the user
		String filename = JOptionPane.showInputDialog("Enter the file name: ");
		Scanner file = new Scanner(new File("/home/student/Desktop/"+filename));//labxx.dat
		int size = file.nextInt();
		
		file.nextLine(); //buffer clearing code
		
		for(int i=0; i<size; i++) {
			int num = file.nextInt();
			if (num%2==0) {
				System.out.println(num+" is even.");
			}else {
				System.out.println(num+" is odd.");
			}
		}

	}

}

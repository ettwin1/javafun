package note17Search;

public class BruteForce {

	public static void main(String[] args) {
		//Brute Force Method
		int[] sample = {5,33,77,12,0,-4,16};
		int key = 12;
		for (int value : sample) {
			if (value == key) {
				System.out.println("Found the key");
				break;
			}
			System.out.println(value);
		}
		//Binary Search Method
		int[] sample2 = {-4,0,5,12,16,33,77};
		key = 1;
		int times = 0;
		int lowIndex = 0;
		int highIndex = sample2.length-1;
		while (lowIndex <= highIndex) {
			times += 1;
			if (key > sample2[lowIndex + (highIndex/2)]) {
				lowIndex = (lowIndex + highIndex)/2;
			}else if (key < sample2[lowIndex + (highIndex/2)]) {
				highIndex = (lowIndex + highIndex)/2;
			}else{
				System.out.println("Hey you found it!");
				break;
			}
			
		}
	}
}

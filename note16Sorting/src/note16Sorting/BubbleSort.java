package note16Sorting;

import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {
		int[] unsorted = new int[10];
		Random random = new Random();
		
		for (int i=0; i<10; i++) {
			unsorted[i] = random.nextInt(10);
			System.out.print(unsorted[i]+" ");
		}
		System.out.println("Sorted: ");
		int[] sorted = sort(unsorted);
		for (int i=0; i<10; i++) {
			System.out.print(sorted[i] + " ");
		}

	}
	
	public static int[] sort(int[] unsorted) {
		int current = unsorted[0];
		for (int i=0; i<unsorted.length; i++) {
			for (int j=i; j<unsorted.length; j++) {
				if (unsorted[i] > unsorted[j]) {
					current = unsorted[i];
					unsorted[i] = unsorted[j];
					unsorted[j] = current;
				}
			}
		}
		return(unsorted);
	}

}

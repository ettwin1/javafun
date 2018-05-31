package lists;

import java.util.ArrayList;

public class ListTest {

	public static void main(String[] args) {
		welcome();
		
		/*
		 Arrays:
		 	-fixed size
		 	-uses [] to access data
		 ArrayList:
		 	-dynamic size
		 	-uses methods to access data
		 	-only holds classes
		 */
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3); //adds 3 to the end of the list
		numbers.add(0, 2); //adds 2 to the beggining of the list (index 0)
		numbers.add(15);
		numbers.set(1, 200); //sets number at index 1 to 200
		System.out.println(numbers);
		
		numbers.remove(2); //removes  the number at index 2
		numbers.remove(new Integer(2)); //looks for 2 in the list and deletes it
		System.out.println(numbers);
		
		Integer hi = numbers.get(0); //gets the number at index 0 in the list
		System.out.println(hi);
		
		
		numbers.add(7);
		numbers.add(93834);
		numbers.add(0);
		
		for (int i=0; i<numbers.size(); i++) { //looping through a list
			System.out.print(numbers.get(i)+" ");
		}
		System.out.println("");//next line
		System.out.println("Average: "+average(numbers)); //My own function that gets average
		System.out.println("Smallest: "+smallest(numbers)); //My own function that gets smallest
		System.out.println("Duplicates: "+areDups(numbers)); //My own function that gets smallest
	}
	
	private static void welcome() {
		System.out.println("HELLO BROTHER");
	}
	
	//returns average of all numbers in a list
	private static double average(ArrayList<Integer> list) {
		double av = 0.0;
		for (int i=0; i<list.size(); i++) {
			av += list.get(i);
		}
		av = av/list.size();
		return(av);
	}
	
	//returns smallest of all numbers in a list
	private static Integer smallest(ArrayList<Integer> list) {
		Integer smallest = list.get(0);
		for (int i=0; i<list.size(); i++) {
			if (smallest > list.get(i)) {
				smallest = list.get(i);
			}
		}
		
		return(smallest);
	}
	
	//returns true if list contains duplicate numbers
	private static boolean areDups(ArrayList<Integer> list) {
		for(int i=0; i<list.size(); i++) {
			for(int y=0; y<list.size(); y++) {
				if (list.get(i) == list.get(y)) {
					if (i != y) {
						return(true);
					}
				}
			}
		}
		return(false);
	}

}

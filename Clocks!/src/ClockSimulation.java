import java.util.ArrayList;

public class ClockSimulation {

	public static void main(String[] args) {
		long day = 86400;
		long week = 604800;
		long month = 2592000;
		long year = 31536000;
		
		long[] time = {day, week, month, year};
		String[] name = {"day", "week", "month", "year"};
		
		ArrayList<Clock> clock_list = new ArrayList<Clock>();
		clock_list.add(new Sundial());
		clock_list.add(new GrandfatherClock());
		clock_list.add(new CuckooClock());
		clock_list.add(new WristWatch());
		clock_list.add(new AtomicClock());
		
		System.out.println("Times before start:");
		for (Clock clock_class : clock_list) {
			Clock clock__class = (Clock) clock_class;
			clock_class.display();
		}
		
		for(int i=0; i<time.length; i++) {
			System.out.println();
			System.out.println("After one "+name[i]+":");
			for (Clock clock_class : clock_list) {
				Clock clock__class = (Clock) clock_class;
				for(int j=0; j<time[i]; j++) {
					clock_class.tick();
				}
				clock_class.display();
				clock_class.reset();
			}
		}
		
	}

}

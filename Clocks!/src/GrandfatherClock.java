
public class GrandfatherClock extends Clock{
	public GrandfatherClock() {
		super(ClockType.MECHANICAL, 0.000347222);
	}
	
	public void display() {
		System.out.println("mechanical, grandfather clock, time ["+time.hour()+":"+time.minute()+":"+time.second()+"], total drift = "+(double)time.getTotalDrift());
	}
}

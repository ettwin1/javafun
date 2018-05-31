
public class CuckooClock extends Clock{
	public CuckooClock() {
		super(ClockType.MECHANICAL, 0.0006944444);
	}
	
	public void display() {
		System.out.println("mechanical, cuckoo clock, time ["+time.hour()+":"+time.minute()+":"+time.second()+"], total drift = "+String.format("%.2f",time.getTotalDrift()));
	}
}

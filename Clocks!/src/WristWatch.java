
public class WristWatch extends Clock{
	public WristWatch() {
		super(ClockType.DIGITAL, 0.000034722);
	}
	
	public void display() {
		System.out.println("digital, wrist watch, time ["+time.hour()+":"+time.minute()+":"+time.second()+"], total drift = "+(double)time.getTotalDrift());
	}
}


public class Sundial extends Clock{
	public Sundial() {
		super(ClockType.NATURAL, 0.00);
	}
	
	public void display() {
		System.out.println("natural, sun dial, time ["+time.hour()+":"+time.minute()+":"+time.second()+"], total drift = "+ (double)time.getTotalDrift());
	}
}

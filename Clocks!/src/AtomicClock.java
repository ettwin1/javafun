
public class AtomicClock extends Clock{
	public AtomicClock() {
		super(ClockType.QUANTUM, 0.0);
	}
	
	public void display() {
		System.out.println("quatum, atomic clock, time ["+time.hour()+":"+time.minute()+":"+time.second()+"], total drift = "+String.format("%.2f",time.getTotalDrift()));
	}
}

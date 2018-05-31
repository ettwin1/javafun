
public abstract class Clock implements TimePiece{
	public enum ClockType {
		NATURAL, MECHANICAL, DIGITAL, QUANTUM
	}
	
	protected Time time;
	private ClockType clockType;
	
	public Clock(ClockType type, double drift) {
		clockType = type;
		time = new Time(0,0,0,drift);
	}
	public ClockType getClockType() {
		return(clockType);
	}
	public void setClockType(ClockType type) {
		clockType = type;
	}
	
	public void reset() {
		time.resetToStartTime();
	}
	public void tick() {
		time.incrementTime();
	}
	
	public abstract void display();
}

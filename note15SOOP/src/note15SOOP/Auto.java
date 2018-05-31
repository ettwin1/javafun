package note15SOOP;

public abstract class Auto implements Vehicle {
	public enum FuelType { //FuelType is like an int or boolean, it can hold GAS, DIESEL, etc.
		GAS, DIESEL, ELECTRIC, HYBRID
	}
	public int numWheels = 4;
	public FuelType fuelKind;
	public Auto() {
		System.out.println("Creating an Auto...");
	}
	
	public int getWheelCount() {
		return(numWheels);
	}
	
	public abstract float getMaxSpeed();
	public abstract void drive(int distance);
	public abstract VehicleClassType vehicleKind();
}

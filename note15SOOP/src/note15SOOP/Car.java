package note15SOOP;

public class Car extends Auto implements Ford{
	private float maxSpeed = (float)109.2;
	private float trunkSize = (float)25.76;
	
	public Car() {
		System.out.println("Creating a car...");
		//set the fuel kind class variable
		super.fuelKind = FuelType.GAS;
	}
	
	public float getTrunkSize() {
		return(trunkSize);
	}
	
	public float getMaxSpeed() {
		return(maxSpeed);
	}
	public VehicleClassType vehicleKind() {
		return(VehicleClassType.CAR);
	}
	
	public boolean onStarTest(Ford.ModelNames model) {
		System.out.println("Ford model: " + model);
		return(false);
	}
	
	public void drive(int distance) {
		System.out.println("Simulating driving a car for "+distance+" miles");;
	}
}

package note15SOOP;

import note15SOOP.Vehicle.VehicleClassType;

public class Truck extends Auto{
	float maxSpeed = (float)102.4;
	double bedSize = 10.3;
	public Truck() {
		
	}
	
	public double getBedSize() {
		return(bedSize);
	}
	
	public float getMaxSpeed() {
		return(maxSpeed);
	}
	public VehicleClassType vehicleKind() {
		return(VehicleClassType.TRUCK);
	}
	public void drive(int distance) {
		System.out.println("Simulating driving a car for "+distance+" miles");
	}
}

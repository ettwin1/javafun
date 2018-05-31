package note15SOOP;

import java.util.ArrayList;

import note15SOOP.Vehicle.VehicleClassType;

public class Simulator {

	public static void main(String[] args) {
		System.out.println("A vehicle Simulation.");
		
		//Array list to keep a list of vehicles to simulate
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		vehicles.add(new Car());
		
		for (Vehicle device : vehicles) {//goes through each vehicle in the array, and referenced as device
			int distance = (int)(device.getMaxSpeed() * 4);
			//Simulate driving the device for the distance
			device.drive(distance);
			
			if (device.vehicleKind() == VehicleClassType.CAR) {
				Car specVehicle = (Car) device;
				System.out.println("Trunk size: "+specVehicle.getTrunkSize());
				System.out.println("The On Star Test returned: " + specVehicle.onStarTest(Ford.ModelNames.FOCUS));
			}else if (device.vehicleKind() == VehicleClassType.TRUCK){
				Truck specVehicle = (Truck) device;
				System.out.println("Bed size: "+specVehicle.getBedSize());
			}
		}

	}

}

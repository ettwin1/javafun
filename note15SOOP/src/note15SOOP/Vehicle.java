package note15SOOP;


/*Interface = Contract
	No code!
	method definitions only
	no 'new', objects, instantiation
*/
public interface Vehicle{
	enum VehicleClassType {CAR, TRUCK};
	public float getMaxSpeed();
	public void drive(int distance);
	public VehicleClassType vehicleKind();
}

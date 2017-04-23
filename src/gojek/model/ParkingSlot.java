package gojek.model;

public class ParkingSlot {
	private Vehicle vehicle;
	private int slotNumber;

	public ParkingSlot(Vehicle vehicle, int slotNumber) {
		this.vehicle = vehicle;
		this.slotNumber = slotNumber;
	}

	public boolean isAvailable() {
		return vehicle == null;
	}

	public boolean park(Vehicle v) {
		boolean isParked = isAvailable();
		if (isParked) {
			vehicle = v;
		}
		return isParked;
	}

	public void vacantSlot() {
		vehicle = null;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public int getSlotNumber() {
		return slotNumber;
	}
}

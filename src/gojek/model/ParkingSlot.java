package gojek.model;

public class ParkingSlot {
	private Vehical vehical;
	private int slotNumber;

	public ParkingSlot(Vehical vehical, int slotNumber) {
		this.vehical = vehical;
		this.slotNumber = slotNumber;
	}

	public boolean isAvailable() {
		return vehical == null;
	}

	public boolean park(Vehical v) {
		boolean isParked = isAvailable();
		if (isParked) {
			vehical = v;
		}
		return isParked;
	}

	public void vacantSlot() {
		vehical = null;
	}

	public Vehical getVehical() {
		return vehical;
	}

	public int getSlotNumber() {
		return slotNumber;
	}
}

package gojek.model;

public class ParkingSpot {
	private Vehical vehical;
	private int spotNumber;

	public ParkingSpot(Vehical vehical, int spotNumber) {
		this.vehical = vehical;
		this.spotNumber = spotNumber;
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

	public void vacantSpot() {
		vehical = null;
	}

	public Vehical getVehical() {
		return vehical;
	}

	public int getSpotNumber() {
		return spotNumber;
	}
}

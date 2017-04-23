package gojek.model;

import java.util.SortedSet;
import java.util.TreeSet;

public class ParkingLot {
	private ParkingSpot[] spots;
	private SortedSet<Integer> availableSpots = new TreeSet<>();
	private static boolean isCreated = false;
	private ParkingLot parkingLot = null;

	public ParkingLot(int availableSpot) {
		spots = new ParkingSpot[availableSpot];
		while (availableSpot > 0) {
			availableSpots.add(availableSpot);
			availableSpot--;
		}
	}

	public int getAvailableSpot() {
		return availableSpots.size();
	}

	public boolean parkVehical(Vehical vehical) {
		if (availableSpots.size() == 0) {
			return false;
		}
		int nearestSpot = availableSpots.first();
		ParkingSpot parkingSpot = new ParkingSpot(vehical, nearestSpot);
		spots[nearestSpot] = parkingSpot;
		return true;
	}

	public static String createParkingLot(int size)
			throws IllegalAccessException {
		boolean flag = false;
		if (!isCreated) {
			synchronized (ParkingLot.class) {
				if (!isCreated) {
					parkingLot = new ParkingLot(size);
					parkingLotCreated = true;
					flag = true;
					return "Created a parking lot with " + size + " slots";
				}
			}
		}
		if (!flag) {
			throw new IllegalAccessException(
					"Parking lot can be created only once");
		}
		return null;
	}

	public static ParkingLot getParkingLot() {
		if (!parkingLotCreated) {
			synchronized (ParkingLot.class) {
				if (!parkingLotCreated) {
					throw new IllegalStateException(
							"Parking lot must be created before using it");
				}
			}
		}
		return parkingLot;
	}
}

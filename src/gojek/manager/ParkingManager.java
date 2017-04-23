package gojek.manager;

import gojek.model.ParkingLot;
import gojek.model.Vehical;

public class ParkingManager {

	public String createParkingLot(int size) throws IllegalAccessException {
		return ParkingLot.createParkingLot(size);
	}

	public static String parkVehical(Vehical v) {
		ParkingLot pLot = ParkingLot.getParkingLot();
		return pLot.parkVehical(v);

	}

	public static String releaseVehical(int id) {
		ParkingLot pLot = ParkingLot.getParkingLot();
		return pLot.releaseVehical(id);
	}
}

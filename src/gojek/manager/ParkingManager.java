package gojek.manager;

import gojek.model.ParkingLot;
import gojek.model.Vehicle;
import gojek.util.ParkingUtil;

public class ParkingManager {

	public String createParkingLot(int size) throws IllegalAccessException {
		return ParkingLot.createParkingLot(size);
	}

	public static String parkVehicle(Vehicle v) {
		ParkingLot pLot = ParkingLot.getParkingLot();
		return pLot.parkVehicle(v);

	}

	public static String releaseVehicle(int id) {
		ParkingLot pLot = ParkingLot.getParkingLot();
		return pLot.releaseVehicle(id);
	}

	public static String getSlotIdByVehicleNo(String vehicleNo) {
		String slot = ParkingUtil.getSlotNobyVehicle(vehicleNo);
		if (slot == null) {
			slot = "Not found";
		}
		return slot;
	}

}

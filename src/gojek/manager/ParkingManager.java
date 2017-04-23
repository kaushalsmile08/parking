package gojek.manager;

import gojek.model.ParkingSpot;
import gojek.model.Vehical;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
	private static Map<String, List<Vehical>> colorToVehiclesMap = new HashMap<>();
	private static Map<String, ParkingSpot> registrationNumberToVehicleMap = new HashMap<>();

}

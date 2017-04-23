package gojek.util;

import gojek.model.Vehical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParkingUtil {

	private static Map<String, List<String>> colorToVehiclesMap = new HashMap<>();
	private static Map<String, Integer> registrationNumberToVehicleMap = new HashMap<>();

	public static void addVehicalDetails(Vehical v, int spot) {
		List<String> vehicalList = colorToVehiclesMap.get(v.getColor());
		if (Objects.isNull(vehicalList)) {
			vehicalList = new ArrayList<String>();
		}
		vehicalList.add(v.getNumber());
		colorToVehiclesMap.put(v.getColor(), vehicalList);
		registrationNumberToVehicleMap.put(v.getNumber(), spot);
	}

	public static void removeVehicalDetails(Vehical v, int spot) {

	}
}

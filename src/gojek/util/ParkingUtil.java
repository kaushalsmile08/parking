package gojek.util;

import gojek.model.ParkingSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParkingUtil {

	private static Map<String, List<ParkingSlot>> colorToVehiclesMap = new HashMap<>();
	private static Map<String, String> registrationNumberToSlotMap = new HashMap<>();

	public static void addVehicleDetails(ParkingSlot slot) {
		List<ParkingSlot> slotList = colorToVehiclesMap.get(slot.getVehicle()
				.getColor());
		if (Objects.isNull(slotList)) {
			slotList = new ArrayList<ParkingSlot>();
		}
		slotList.add(slot);
		colorToVehiclesMap.put(slot.getVehicle().getColor(), slotList);
		registrationNumberToSlotMap.put(slot.getVehicle().getNumber(),
				String.valueOf(slot.getSlotNumber()));
	}

	public static void removeVehicalDetails(ParkingSlot slot) {
		registrationNumberToSlotMap.remove(slot.getSlotNumber());
		List<ParkingSlot> slotList = colorToVehiclesMap.get(slot.getVehicle()
				.getColor());
		slotList.remove(slot);
		colorToVehiclesMap.put(slot.getVehicle().getColor(), slotList);
	}

	public static String getVehicleNoByColor(String color) {
		StringBuilder sb = new StringBuilder();
		List<ParkingSlot> slotList = colorToVehiclesMap.get(color);
		for (ParkingSlot s : slotList) {
			sb.append(s.getVehicle().getColor());
			sb.append(", ");
		}
		return removeLastChar(sb.toString());
	}

	public static String getSlotNoByColor(String color) {
		StringBuilder sb = new StringBuilder();
		List<ParkingSlot> slotList = colorToVehiclesMap.get(color);
		for (ParkingSlot s : slotList) {
			sb.append(s.getSlotNumber());
			sb.append(", ");
		}
		return removeLastChar(sb.toString());
	}

	public static String removeLastChar(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		s = s.trim();
		return s.substring(0, s.length() - 1);
	}

	public static String getSlotNobyVehicle(String vehicleNo) {
		return registrationNumberToSlotMap.get(vehicleNo);
	}
}

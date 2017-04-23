package gojek.model;

import gojek.util.ParkingUtil;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class ParkingLot {
	private ParkingSlot[] slots;
	private SortedSet<Integer> availableSlots = new TreeSet<>();
	private static ParkingLot parkingLot = null;

	private ParkingLot(int availableslot) {
		slots = new ParkingSlot[availableslot + 1];
		while (availableslot > 0) {
			availableSlots.add(availableslot);
			availableslot--;
		}
	}

	public int getAvailableslot() {
		return availableSlots.size();
	}

	public String parkVehicle(Vehicle vehicle) {
		if (availableSlots.size() == 0) {
			return "Sorry, parking lot is full";
		}
		int nearestSlot = availableSlots.first();
		availableSlots.remove(nearestSlot);
		ParkingSlot parkingslot = new ParkingSlot(vehicle, nearestSlot);
		slots[nearestSlot] = parkingslot;
		ParkingUtil.addVehicleDetails(parkingslot);
		return "Allocated slot number: " + nearestSlot;
	}

	public String releaseVehicle(int slotId) {
		if (availableSlots.contains(slotId)) {
			return "Slot number " + slotId + " is already free";
		} else {
			ParkingUtil.removeVehicalDetails(slots[slotId]);
			slots[slotId].vacantSlot();
			slots[slotId] = null;
			availableSlots.add(slotId);
			return "Slot number " + slotId + " is free";
		}
	}

	public static String createParkingLot(int size)
			throws IllegalAccessException {
		boolean flag = false;
		if (Objects.isNull(parkingLot)) {
			synchronized (ParkingLot.class) {
				if (Objects.isNull(parkingLot)) {
					parkingLot = new ParkingLot(size);
					flag = true;
				}
			}
		}
		if (!flag) {
			throw new IllegalAccessException(
					"Parking lot can be created only once");
		}
		return "Created a parking lot with " + size + " slots";
	}

	public static ParkingLot getParkingLot() {
		if (Objects.isNull(parkingLot)) {
			throw new IllegalStateException(
					"Parking lot must be created before using it");
		}
		return parkingLot;
	}

	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append("Slot No.\tRegistration No\tColour");
		for (int i=0;i<slots.length;i++) {
			if(slots[i] != null) {
				sb.append("\n");
				sb.append(i);
				sb.append("\t");
				sb.append(slots[i].getVehicle().getNumber());
				sb.append("\t");
				sb.append(slots[i].getVehicle().getColor());

			}
		}
		return sb.toString();
	}
}

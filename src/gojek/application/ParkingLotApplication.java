package gojek.application;

import gojek.manager.ParkingManager;
import gojek.model.ParkingLot;
import gojek.model.Vehicle;
import gojek.util.ParkingUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class ParkingLotApplication {

	public static void main(String[] args) {
		try {
			String fileName;
			BufferedReader br;
			if (args.length > 0 && Objects.nonNull(fileName = args[0])
					&& fileName.length() != 0) {
				br = new BufferedReader(new InputStreamReader(
						(new FileInputStream(fileName))));
			} else {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
			handleInput(br);
		} catch (Exception e) {
			System.out.println("Error while handling error "
					+ Arrays.toString(e.getStackTrace()));
		}
	}

	private static void handleInput(BufferedReader br) throws Exception {
		String inputLine;
		while (Objects.nonNull(inputLine = br.readLine())) {

			String[] inputArray = inputLine.split(" ");
			if (inputArray.length > 0) {

				switch (inputArray[0]) {
				case "create_parking_lot":
					System.out.println(ParkingLot.createParkingLot(Integer
							.parseInt(inputArray[1])));
					break;

				case "park":
					System.out.println(ParkingManager.parkVehicle(new Vehicle(
							inputArray[2], inputArray[1])));
					break;

				case "leave":
					System.out.println(ParkingManager.releaseVehicle(Integer
							.parseInt(inputArray[1])));
					break;

				case "status":
					// ParkingManager.generateStatus();
					break;

				case "registration_numbers_for_cars_with_colour":
					System.out.println(ParkingUtil
							.getVehicleNoByColor(inputArray[1]));
					break;

				case "slot_numbers_for_cars_with_colour":
					System.out.println(ParkingUtil
							.getSlotNoByColor((inputArray[1])));
					break;

				case "slot_number_for_registration_number":
					System.out.println(ParkingManager
							.getSlotIdByVehicleNo(inputArray[1]));
					break;

				default:
					System.out.println("Parking application is exiting");
					System.exit(0);
				}
			}
		}
	}
}

package gojek.model;

public class Vehicle {
	private String color;
	private String number;

	public Vehicle(String color, String number) {
		this.color = color;
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public String getNumber() {
		return number;
	}
}

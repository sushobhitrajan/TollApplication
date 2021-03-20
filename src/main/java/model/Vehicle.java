package model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	private String number;
	private List<Trip> tripsList;

	public Vehicle(String number) {
		this.number = number;
		this.tripsList = new ArrayList<>();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<Trip> getTripsList() {
		return tripsList;
	}

	public void setTripsList(List<Trip> tripsList) {
		this.tripsList = tripsList;
	}

	@Override
	public String toString() {
		return "Vehicle{" +
			"number='" + number + '\'' +
			", tripsList=" + tripsList +
			'}';
	}

	public static class Trip {
		String source;
		String destination;
		private PassType passType;
		Double price;

		public Trip(String source, String destination, PassType passType, Double price) {
			this.source = source;
			this.destination = destination;
			this.passType = passType;
			this.price = price;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public PassType getPassType() {
			return passType;
		}

		public void setPassType(PassType passType) {
			this.passType = passType;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Trips{" +
				"source='" + source + '\'' +
				", destination='" + destination + '\'' +
				", passType=" + passType +
				", price=" + price +
				'}';
		}
	}
}

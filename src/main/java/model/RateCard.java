package model;

import java.util.List;

public class RateCard {

	String source;
	String destination;
	List<Types> typesList;

	public RateCard(String source, String destination, List<Types> typesList) {
		this.source = source;
		this.destination = destination;
		this.typesList = typesList;
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

	public List<Types> getTypesList() {
		return typesList;
	}

	public void setTypesList(List<Types> typesList) {
		this.typesList = typesList;
	}

	@Override
	public String toString() {
		return "RateCard{" +
			"source='" + source + '\'' +
			", destination='" + destination + '\'' +
			", typesList=" + typesList +
			'}';
	}

	public static class Types {
		PassType passType;
		Double price;

		public Types(PassType passType, Double price) {
			this.passType = passType;
			this.price = price;
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
			return "Types{" +
				"passType=" + passType +
				", price=" + price +
				'}';
		}
	}
}

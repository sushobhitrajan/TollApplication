package model;

import java.util.ArrayList;
import java.util.List;

public class Toll {
	String tollName;
	Integer tollID;
	RateCard rateCard;
	List<Booth> boothList;

	public Toll(String tollName, Integer tollID) {
		this.tollName = tollName;
		this.tollID = tollID;
		this.boothList = new ArrayList<>();
	}

	public List<Booth> getBoothList() {
		return boothList;
	}

	public void setBoothList(List<Booth> boothList) {
		this.boothList = boothList;
	}

	public String getTollName() {
		return tollName;
	}

	public void setTollName(String tollName) {
		this.tollName = tollName;
	}

	public Integer getTollID() {
		return tollID;
	}

	public void setTollID(Integer tollID) {
		this.tollID = tollID;
	}

	public RateCard getRateCard() {
		return rateCard;
	}

	public void setRateCard(RateCard rateCard) {
		this.rateCard = rateCard;
	}

	@Override
	public String toString() {
		return "Toll{" +
			"tollName='" + tollName + '\'' +
			", tollID=" + tollID +
			", rateCard=" + rateCard +
			", boothList=" + boothList +
			'}';
	}

	public void getBoothView() {
		getBoothList().stream().forEach(booth -> {
			System.out.println(booth.toString());
		});
	}

	public static class Booth {
		String boothId;
		RateCard rateCard;

		public Booth(String boothId, RateCard rateCard) {
			this.boothId = boothId;
			this.rateCard = rateCard;
		}

		public String getBoothId() {
			return boothId;
		}

		public void setBoothId(String boothId) {
			this.boothId = boothId;
		}

		public RateCard getRateCard() {
			return rateCard;
		}

		public void setRateCard(RateCard rateCard) {
			this.rateCard = rateCard;
		}

		@Override
		public String toString() {
			return "Booth{" +
				"boothId='" + boothId + '\'' +
				", rateCard=" + rateCard +
				'}';
		}
	}
}

package service;

import com.clearspring.analytics.util.Lists;
import java.util.ArrayList;
import java.util.List;
import model.Toll;
import model.Vehicle;

public class TollManager {

	private List<Toll> tollList;

	public TollManager() {
		this.tollList = new ArrayList<>();
	}

	public void save(Toll toll) {
		this.tollList.add(toll);
	}

	public List<Toll> getTollList() {
		return tollList;
	}

	public Toll getTollById(Integer id) {
		return tollList.stream().filter(toll -> toll.getTollID() == id).findFirst().get();
	}

	public List<Vehicle> getActiveVehiclesByTollId(Integer id) {
		return Lists.newArrayList();
	}
}

package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Vehicle;

public class VehicleManager {

	List<Vehicle> vehicleList;

	public VehicleManager() {
		this.vehicleList = new ArrayList<>();
	}

	public void save(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}

	public void getVehicleViewByNumber(String number) {
		Optional<Vehicle> vehicleOptional = vehicleList.stream().filter(vehicle -> vehicle.getNumber().equalsIgnoreCase(number)).findFirst();
		vehicleOptional.ifPresent(vehicle -> System.out.println(vehicle.toString()));
	}

	public Vehicle getVehicleByNumber(String number) {
		Optional<Vehicle> vehicleOptional = vehicleList.stream().filter(vehicle -> vehicle.getNumber().equalsIgnoreCase(number)).findFirst();
		return vehicleOptional.orElse(null);
	}

	public boolean isChargeable(List<Vehicle> vehicleList, String vehicleNumber) {
		Optional<Vehicle> first = vehicleList.stream().filter(vehicle -> vehicle.getNumber().equalsIgnoreCase(vehicleNumber)).findFirst();
		return first.filter(this::validation).isPresent();
	}

	private boolean validation(Vehicle vehicle) {
		return true;
	}
}

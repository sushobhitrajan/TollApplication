package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Toll;

public class RegisterToll implements Register<Toll, Boolean> {

	private List<Toll> tollList;

	public RegisterToll() {
		this.tollList = new ArrayList<>();
	}

	@Override
	public Boolean create(Toll toll) {
		// TODO - Validation
		Optional<Toll> any = tollList.stream().filter(t -> t.getTollID() == toll.getTollID()).findAny();
		if (any.isPresent()) {
			System.out.println("Duplicate Toll Creation Request !");
			return false;
		}

		tollList.add(toll);
		return true;
	}
}

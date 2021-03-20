package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import model.Toll;

public class Leaderboard {

	TollManager tollManager;

	public Leaderboard(TollManager tollManager) {
		this.tollManager = tollManager;
	}

	public void getView() {
		tollManager.getTollList();
		tollManager.getTollList().forEach(toll -> {
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("Toll Name: " + toll.getTollName());
			System.out.println("Toll ID: " + toll.getTollID());
			System.out.println(toll.getRateCard().toString());
			toll.getBoothList().forEach(booth -> {
				System.out.println(booth.toString());
			});
			System.out.println();
		});
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<END>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

	}

	public void getViewByTollId(Integer id) {
		Optional<Toll> toll = tollManager.getTollList().stream().filter(t -> t.getTollID() == id).findFirst();
		if (toll.isPresent()) {
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("Toll Name: " + toll.get().getTollName());
			System.out.println("Toll ID: " + toll.get().getTollID());
			System.out.println(toll.get().getRateCard());
			toll.get().getBoothList().forEach(booth -> {
				System.out.println(booth.toString());
			});		}
	}
}

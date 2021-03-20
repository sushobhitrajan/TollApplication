import com.clearspring.analytics.util.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import model.PassType;
import model.RateCard;
import model.RateCard.Types;
import model.Toll;
import model.Toll.Booth;
import model.Vehicle;
import model.Vehicle.Trip;
import service.Leaderboard;
import service.Register;
//import service.RegisterBooth;
import service.RegisterBooth;
import service.RegisterToll;
import service.TollManager;
import service.VehicleManager;

public class Main {

	private static Register register = new RegisterToll();;
	private Register registerBooth = new RegisterBooth();;
	private static TollManager tollManager = new TollManager();
	private static VehicleManager vehicleManager = new VehicleManager();
	private static Leaderboard leaderboard = new Leaderboard(tollManager);

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			System.out.println("1. Register Toll");
			System.out.println("2. Cross TollBooth");
			System.out.println("3. Leaderboard");
			System.out.println("4. Thanks You !");
			String option = reader.readLine();

			switch (option) {
				case "1":
					Toll toll = new Toll("T1", 1);
					if (!(Boolean) register.create(toll)) break;

					System.out.println("Want to Create a Common Rate Card for Toll? Y/N");

					Types ty1 = new Types(PassType.SINGLE, 10.00);
					Types ty2 = new Types(PassType.RETURN, 20.00);
					Types ty3 = new Types(PassType.WEEK_PASS, 50.00);
					RateCard rateCard = new RateCard("Pune", "Mumbai", Arrays.asList(ty1, ty2, ty3));

					toll.setRateCard(rateCard);
					System.out.println("Create Booth");

					System.out.println("Do you want your own Rate Card? Y/N");

					toll.getBoothList().add(new Booth("B1", rateCard));
					toll.getBoothList().add(new Booth("B2", rateCard));
					toll.getBoothList().add(new Booth("B3", rateCard));

					tollManager.save(toll);
					break;

				case "2":
					System.out.println("Enter Toll Number !");
					System.out.println(1);
					System.out.println("Enter Vehicle Number !");
					System.out.println("V1");
					List<Vehicle> activeVehiclesByTollId = tollManager.getActiveVehiclesByTollId(1);
					boolean chargeVehicle = vehicleManager.isChargeable(activeVehiclesByTollId,"V1");

					if (chargeVehicle) {
						System.out.println("Open Gate");
					} else {

						Vehicle vehicle = new Vehicle("V1");

						Toll tollV = tollManager.getTollById(1);
						System.out.println("Which Booth You Want to Take");
						tollV.getBoothView();

						System.out.println("B1");
						Booth b1 = tollV.getBoothList().stream().filter(booth -> booth.getBoothId().equalsIgnoreCase("B1")).findFirst().get();

						System.out.println("Select Pass");
						System.out.println("Show Rate Card !");

						System.out.println(b1.getRateCard().toString());

						System.out.println("Select Pass");
						Trip trip = new Trip("Mumbai", "Pune",
							b1.getRateCard().getTypesList().get(0).getPassType(),
							b1.getRateCard().getTypesList().get(0).getPrice());

						vehicle.getTripsList().add(trip);

						vehicleManager.save(vehicle);
					}
					break;
				case "3":
					System.out.println("Toll View !");
					leaderboard.getView();

					System.out.println("\nToll View By Toll-Id!");
					leaderboard.getViewByTollId(1);

					System.out.println("Toll View !");
					vehicleManager.getVehicleViewByNumber("V1");
					break;
				case "4":
					System.exit(1);
					break;
				default:
					System.out.println("Not A Valid Option !");

			}
		}

	}
}

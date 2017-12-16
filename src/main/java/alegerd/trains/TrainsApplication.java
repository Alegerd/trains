package alegerd.trains;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainsApplication{

	public static void main(String[] args) {
		SpringApplication.run(TrainsApplication.class, args);
	}

	/*
	@Override
	public void run(String... strings) throws Exception {
		while (true){
			try {
				System.out.println("Command");
				Scanner scan = new Scanner(System.in);
				String input = scan.next();
				if (input.equals("show")) {
					showAll();
				} else if (input.equals("addTrain")) {
					String[] line = scan.next().split("/");
					Integer num = Integer.parseInt(line[0]);
					String route = line[1];
					String station = line[2];
					TrainDto newTrain = new TrainDto(num, route, station);
					service.addNewTrain(newTrain);
				} else if (input.equals("addStation")) {
					String[] line = scan.next().split("/");
					String name = line[0];
					Long route = Long.parseLong(line[1]);
					StationDto newStation = new StationDto(name, route);
					service.addNewStation(newStation);
				}
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void showAll(){
		System.out.println("All trains");
		List<TrainDto> trainDTOS = service.getAllTrains();
		for (TrainDto train :
				trainDTOS) {
			System.out.println(train.toString() + "\n");
		}

		System.out.println("All stations");
		List<StationDto> stations = service.getAllStations();
		for (StationDto station :
				stations) {
			System.out.println(station.toString() + "\n");
		}


		System.out.println("All routes");
		List<RouteDto> routes = service.getAllRoutes();
		for (RouteDto route :
				routes) {
			System.out.println(route.toString() + "\n");
		}
	}
	*/
}

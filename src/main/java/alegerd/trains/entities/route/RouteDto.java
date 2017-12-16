package alegerd.trains.entities.route;

import alegerd.trains.entities.station.StationDto;
import alegerd.trains.entities.train.TrainDto;

import java.util.List;

public class RouteDto {
    String routeName;
    List<TrainDto> trains;
    List<StationDto> stations;

    public RouteDto(String routeName, List<TrainDto> trains, List<StationDto> stations){
        this.routeName = routeName;
        this.stations = stations;
        this.trains = trains;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Route: Name " + routeName + "\n " +
                "      Trains: \n");

        for (TrainDto train : trains) {
             sb.append(train.toString() + "\n");
        }
        sb.append("       Stations: \n");

        for (StationDto station : stations) {
            sb.append(station.toString() + "\n");
        }
        return sb.toString();
    }
}

package alegerd.trains.entities.station;

import alegerd.trains.entities.train.TrainDto;

import java.util.ArrayList;
import java.util.List;

public class StationDto {
    String name;
    List<TrainDto> trains = new ArrayList<>();
    Long routeId;

    public StationDto(String name, List<TrainDto> trains){
        this.name = name;
        this.trains = trains;
    }

    public StationDto(String name, Long routeId){
        this.name = name;
        this.trains = trains;
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "Station: Name  " + name;
    }

    public String getName() {
        return name;
    }

    public List<TrainDto> getTrains() {
        return trains;
    }

    public Long getRouteId() {
        return routeId;
    }
}

package alegerd.trains.entities.station;

import alegerd.trains.entities.train.TrainDto;

import java.util.ArrayList;
import java.util.List;

public class StationDto {
    String name;
    List<TrainDto> trains = new ArrayList<>();
    String routeName;

    public StationDto(){

    }

    public StationDto(String name, List<TrainDto> trains, String routeName){
        this.name = name;
        this.trains = trains;
        this.routeName = routeName;
    }

    public StationDto(String name, String routeName){
        this.name = name;
        this.routeName = routeName;
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

    public String getRouteName() {
        return routeName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrains(List<TrainDto> trains) {
        this.trains = trains;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}

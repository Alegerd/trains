package alegerd.trains.entities.train;

public class TrainDto {
    Integer number;
    String routeName;
    String stationName;

    public TrainDto(Integer number, String routeName, String stationName){
        this.number = number;
        this.routeName = routeName;
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "Train: Number " + number;
    }

    public Integer getNumber() {
        return number;
    }

    public String getRouteName() {
        return routeName;
    }

    public String getStationName() {
        return stationName;
    }
}

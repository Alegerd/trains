package alegerd.trains.entities.train;

import alegerd.trains.entities.route.RoutesEntity;
import alegerd.trains.entities.station.StationsEntity;
import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Trains")
public class TrainsEntity {
    private Long trainId;
    private int number;
    private StationsEntity station;
    private RoutesEntity route;

    public TrainsEntity(){

    }

    public TrainsEntity(Integer number){
        this.number = number;
    }

    public TrainsEntity(Integer number, RoutesEntity route){
        this.number = number;
        this.route = route;
    }

    public TrainsEntity(Integer number, RoutesEntity route, StationsEntity station){
        this.number = number;
        this.route = route;
        this.station = station;
    }

    @Id
    @Column(name = "Train_id")
    @GeneratedValue
    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    @Column(name = "Number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @ManyToOne
    @JoinColumn(name = "Route", referencedColumnName = "Route_id")
    public RoutesEntity getRoute() {
        return route;
    }

    public void setRoute(RoutesEntity route) {
        this.route = route;
    }

    @ManyToOne
    @JoinColumn(name = "Station", referencedColumnName = "Station_id")
    public StationsEntity getStation() {
        return station;
    }

    public void setStation(StationsEntity station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainsEntity that = (TrainsEntity) o;
        return trainId == that.trainId &&
                number == that.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(trainId, number);
    }
}

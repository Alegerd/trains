package alegerd.trains.entities.station;

import alegerd.trains.entities.train.TrainsEntity;
import alegerd.trains.entities.route.RoutesEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Stations")
public class StationsEntity {
    private Long stationId;
    private String name;
    private RoutesEntity route;
    private List<TrainsEntity> trains = new ArrayList<>();

    public StationsEntity(){

    }

    public StationsEntity(String name){
        this.name = name;
    }

    public StationsEntity(String name, RoutesEntity route){
        this.route = route;
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "Station_id")
    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "Route", referencedColumnName = "Route_id")
    public RoutesEntity getRoute(){
        return route;
    }

    public void setRoute(RoutesEntity route){
        this.route = route;
    }

    @OneToMany(mappedBy = "station")
    public List<TrainsEntity> getTrains() {
        return trains;
    }

    public void setTrains(List<TrainsEntity> trains) {
        this.trains = trains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationsEntity that = (StationsEntity) o;
        return stationId == that.stationId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stationId, name);
    }
}

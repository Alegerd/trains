package alegerd.trains.entities.route;

import alegerd.trains.entities.station.StationsEntity;
import alegerd.trains.entities.train.TrainsEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Routes")
public class RoutesEntity {
    private Long routeId;
    private String name;
    private List<TrainsEntity> trains = new ArrayList<>();
    private List<StationsEntity> stations = new ArrayList<>();

    @Id
    @Column(name = "Route_id")
    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "route")
    public List<StationsEntity> getStations() {
        return stations;
    }

    public void setStations(List<StationsEntity> stations) {
        this.stations = stations;
    }

    @OneToMany(mappedBy = "route")
    public List<TrainsEntity> getTrains() {
        return trains;
    }

    public void setTrains(List<TrainsEntity> trains) {
        this.trains = trains;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutesEntity that = (RoutesEntity) o;
        return routeId == that.routeId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(routeId, name);
    }
}

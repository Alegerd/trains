package alegerd.trains.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StationsOnRoutesEntityPK implements Serializable {

    private RouteEntity route;

    private StationEntity station;

    public StationsOnRoutesEntityPK() {
    }

    @ManyToOne
    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }

    @ManyToOne
    public StationEntity getStation() {
        return station;
    }

    public void setStation(StationEntity station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationsOnRoutesEntityPK that = (StationsOnRoutesEntityPK) o;
        return route == that.route &&
                station == that.station;
    }

    @Override
    public int hashCode() {

        return Objects.hash(route, station);
    }
}

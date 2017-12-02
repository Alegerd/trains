package alegerd.trains.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Stations_on_Routes")
@AssociationOverrides({
        @AssociationOverride(name = "pk.route",
                joinColumns = @JoinColumn(name = "Route")),
        @AssociationOverride(name = "pk.station",
                joinColumns = @JoinColumn(name = "Station")) })
public class StationsOnRoutesEntity implements Serializable{

    private StationsOnRoutesEntityPK pk = new StationsOnRoutesEntityPK();

    public StationsOnRoutesEntity(){

    }

    @EmbeddedId
    public StationsOnRoutesEntityPK getPk() {
        return pk;
    }

    public void setPk(StationsOnRoutesEntityPK pk){
        this.pk = pk;
    }

    @Transient
    public RouteEntity getRoute(){
        return getPk().getRoute();
    }

    public void setRoute(RouteEntity route){
        getPk().setRoute(route);
    }

    @Transient
    public StationEntity getStation(){
        return getPk().getStation();
    }

    public void setStation(StationEntity station){
        getPk().setStation(station);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationsOnRoutesEntity that = (StationsOnRoutesEntity) o;
        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}

package alegerd.trains.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Route")
public class RouteEntity implements Serializable{
    private Integer id;
    private String name;
    private Set<StationsOnRoutesEntity> stationsOnRoutesEntities = new HashSet<>();
    private Set<TrainEntity> trains = new HashSet<>();

    public RouteEntity(){

    }

    public RouteEntity(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public RouteEntity(Integer id, String name, Set<StationsOnRoutesEntity> stationsOnRoutesEntities){
        this.id = id;
        this.name = name;
        this.stationsOnRoutesEntities = stationsOnRoutesEntities;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "Name")
    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private Set<TrainEntity> getTrains(){
        return this.trains;
    }

    public void setTrains(Set<TrainEntity> trains){
        this.trains = trains;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.route")
    private Set<StationsOnRoutesEntity> getStationOnRoutes() {
        return this.stationsOnRoutesEntities;
    }

    public void setStationOnRoutes(Set<StationsOnRoutesEntity> entity){
        this.stationsOnRoutesEntities = entity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteEntity that = (RouteEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}

package alegerd.trains.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Station")
public class StationEntity {
    private Integer id;
    private String name;
    private Set<StationsOnRoutesEntity> stationsOnRoutesEntities = new HashSet<>(0);
    private Set<TimetableEntity> timetable = new HashSet<>(0);

    public StationEntity(){

    }

    public StationEntity(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public StationEntity(Integer id, String name, Set<StationsOnRoutesEntity> stationsOnRoutesEntities){
        this.stationsOnRoutesEntities = stationsOnRoutesEntities;
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.station")
    public Set<StationsOnRoutesEntity> getStationsOnRoutesEntities() {
        return this.stationsOnRoutesEntities;
    }

    public void setStationsOnRoutesEntities(Set<StationsOnRoutesEntity> entities){
        this.stationsOnRoutesEntities = entities;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.station")
    public Set<TimetableEntity> getTimetable() {
        return this.timetable;
    }

    public void setTimetable(Set<TimetableEntity> entities){
        this.timetable = entities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationEntity that = (StationEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}

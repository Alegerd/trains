package alegerd.trains.entities.train;

import alegerd.trains.entities.route.RouteEntity;
import alegerd.trains.entities.timetable.TimetableEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Train")
public class TrainEntity implements Serializable{


    private Long number;
    private RouteEntity route;
    private Set<TimetableEntity> timetable = new HashSet<>(0);

    public TrainEntity(){

    }

    public TrainEntity(Long number, Set<TimetableEntity> timetable) {
        this.number = number;
        this.timetable = timetable;
    }

    public TrainEntity(Long number){
        this.number = number;
    }

    @Id
    @Column(name = "Number")
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Route", nullable = false)
    public RouteEntity getRoute(){
        return route;
    }

    public void setRoute(RouteEntity route){
        this.route = route;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.train")
    public Set<TimetableEntity> getTimetable(){
        return this.timetable;
    }

    public void setTimetable(Set<TimetableEntity> timetable){
        this.timetable = timetable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainEntity that = (TrainEntity) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

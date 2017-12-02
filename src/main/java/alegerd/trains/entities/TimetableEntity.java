package alegerd.trains.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Timetable")
@AssociationOverrides({
        @AssociationOverride(name = "pk.train",
                joinColumns = @JoinColumn(name = "Train")),
        @AssociationOverride(name = "pk.station",
                joinColumns = @JoinColumn(name = "Station")) })
public class TimetableEntity {
    private Date arrivalTime;
    private Date departureTime;
    private TimetableEntityPK timePK = new TimetableEntityPK();

    @EmbeddedId
    public TimetableEntityPK getPk() {
        return timePK;
    }

    public void setPk(TimetableEntityPK timePK){
        this.timePK = timePK;
    }

    @Transient
    public StationEntity getStation(){
        return getPk().getStation();
    }

    public void setStation(StationEntity station){
        getPk().setStation(station);
    }

    @Transient
    public TrainEntity getTrain(){
        return getPk().getTrain();
    }

    public void setTrain(TrainEntity train){
        getPk().setTrain(train);
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "Arrival_time")
    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "Departure_time")
    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimetableEntity that = (TimetableEntity) o;
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

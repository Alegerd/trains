package alegerd.trains.entities.timetable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Timetable")
@IdClass(TimetableEntityPK.class)
public class TimetableEntity {
    private Long stationId;
    private Long trainId;
    private Timestamp arrivalTime;
    private Timestamp departureTime;

    @Id
    @Column(name = "Station_id")
    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    @Id
    @Column(name = "Train_id")
    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "ArrivalTime")
    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "DepartureTime")
    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimetableEntity that = (TimetableEntity) o;
        return stationId == that.stationId &&
                trainId == that.trainId &&
                Objects.equals(arrivalTime, that.arrivalTime) &&
                Objects.equals(departureTime, that.departureTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stationId, trainId, arrivalTime, departureTime);
    }
}

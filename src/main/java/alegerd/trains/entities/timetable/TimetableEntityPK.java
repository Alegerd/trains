package alegerd.trains.entities.timetable;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TimetableEntityPK implements Serializable {
    private Long stationId;
    private Long trainId;

    @Column(name = "Station_id")
    @Id
    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    @Column(name = "Train_id")
    @Id
    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimetableEntityPK that = (TimetableEntityPK) o;
        return stationId == that.stationId &&
                trainId == that.trainId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(stationId, trainId);
    }
}

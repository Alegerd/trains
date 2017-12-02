package alegerd.trains.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TimetableEntityPK implements Serializable {

    protected StationEntity station;

    protected TrainEntity train;

    public TimetableEntityPK() {
    }

    @ManyToOne
    public StationEntity getStation() {
        return station;
    }

    public void setStation(StationEntity station) {
        this.station = station;
    }

    @ManyToOne
    public TrainEntity getTrain() {
        return train;
    }

    public void setTrain(TrainEntity train) {
        this.train = train;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimetableEntityPK that = (TimetableEntityPK) o;
        return station == that.station &&
                train == that.train;
    }

    @Override
    public int hashCode() {

        return Objects.hash(station, train);
    }
}

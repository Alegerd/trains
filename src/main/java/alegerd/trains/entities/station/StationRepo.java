package alegerd.trains.entities.station;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepo extends CrudRepository<StationsEntity, Long>{

    StationsEntity findStationsEntityByStationId(Long stationId);

    StationsEntity findStationsEntityByName(String stationName);

}

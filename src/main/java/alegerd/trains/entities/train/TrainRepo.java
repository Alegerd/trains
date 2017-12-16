package alegerd.trains.entities.train;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends CrudRepository<TrainsEntity, Long>{

}

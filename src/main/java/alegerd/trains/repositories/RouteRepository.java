package alegerd.trains.repositories;

import alegerd.trains.entities.RouteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepository extends CrudRepository<RouteEntity, Long>{

    List<RouteEntity> findById(long id);

    List<RouteEntity> findByIdLessThanEqual(long id);
}

package alegerd.trains.repositories;

import alegerd.trains.entities.route.RouteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepository extends CrudRepository<RouteEntity, Long>{

    RouteEntity findRouteEntityById(Long id);

    List<RouteEntity> findByIdLessThanEqual(Long id);
}

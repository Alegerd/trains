package alegerd.trains.entities.route;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends CrudRepository<RoutesEntity, Long>{
    RoutesEntity findRoutesEntityByRouteId(Long routeId);

    RoutesEntity findRoutesEntityByName(String name);
}

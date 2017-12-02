package alegerd.trains.service;

import alegerd.trains.entities.RouteEntity;
import alegerd.trains.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<RouteEntity> getAllRoutes(){
        List<RouteEntity> routes = new LinkedList<>();
        routeRepository.findAll().forEach(routes::add);
        return routes;
    }

    public List<RouteEntity> getRouteById(Integer id){
        List<RouteEntity> routes = new LinkedList<>();
        routeRepository.findById(id).forEach(routes::add);
        return routes;
    }
}

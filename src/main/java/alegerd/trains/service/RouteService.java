package alegerd.trains.service;

import alegerd.trains.entities.other.EntityToDto;
import alegerd.trains.entities.route.RouteDto;
import alegerd.trains.entities.route.RouteEntity;
import alegerd.trains.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<RouteDto> getAllRoutes(){
        List<RouteDto> routes = new LinkedList<>();
        routeRepository.findAll().forEach(route -> routes.add(EntityToDto.getDto(route)));
        return routes;
    }

    public RouteDto getRouteById(Long id){
        return EntityToDto.getDto(routeRepository.findRouteEntityById(id));
    }
}

package alegerd.trains.controllers;

import alegerd.trains.entities.route.RouteDto;
import alegerd.trains.entities.route.RouteEntity;
import alegerd.trains.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class helloController {

    @Autowired
    private RouteService routeService;

    @RequestMapping(value = "/routes/all", method = RequestMethod.GET)
    public @ResponseBody List<RouteDto> getAllRoutes(){
        return routeService.getAllRoutes();
    }

    @RequestMapping(value = "/routes/{id}", method = RequestMethod.GET)
    public @ResponseBody RouteDto getRouteById(@PathVariable Long id){
        return routeService.getRouteById(id);
    }
}

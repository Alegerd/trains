package alegerd.trains.controllers;

import alegerd.trains.entities.RouteEntity;
import alegerd.trains.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class helloController {

    @Autowired
    private RouteService routeService;

    @RequestMapping(value = "/routes/all", method = RequestMethod.GET)
    public @ResponseBody List<RouteEntity> getAllRoutes(){
        return routeService.getAllRoutes();
    }

    @RequestMapping(value = "/routes/{id}", method = RequestMethod.GET)
    public @ResponseBody List<RouteEntity> getRouteById(@PathVariable Integer id){
        return routeService.getRouteById(id);
    }
}

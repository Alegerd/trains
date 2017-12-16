package alegerd.trains.entities.controllers;

import alegerd.trains.MainService;
import alegerd.trains.entities.route.RouteDto;
import alegerd.trains.entities.station.StationDto;
import alegerd.trains.entities.train.TrainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private MainService service;

    @GetMapping(value = "/index")
    public String getIndexPage(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        if(name == null){
            name = "world";
        }
        model.addAttribute("name", new String("Hello," + name));
        return "hello";
    }

    @GetMapping(value = "/trains/all")
    List<TrainDto> getAllTrains(){
        List<TrainDto> trainDtos = service.getAllTrains();
        return trainDtos;
    }

    @GetMapping(value = "/stations/all")
    List<StationDto> getAllStations(){
        List<StationDto> stationDtos = service.getAllStations();
        return stationDtos;
    }

    @GetMapping(value = "/route/all")
    List<RouteDto> getAllRoutes(){
        List<RouteDto> routeDtos = service.getAllRoutes();
        return routeDtos;
    }
}

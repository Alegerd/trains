package alegerd.trains.entities.controllers;

import alegerd.trains.MainService;
import alegerd.trains.entities.route.RouteDto;
import alegerd.trains.entities.station.StationDto;
import alegerd.trains.entities.train.TrainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private MainService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndexPage(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        if(name == null){
            name = "world";
        }
        model.addAttribute("name", new String("Hello," + name));
        return "hello";
    }

    @RequestMapping(value = "/trains/all", method = RequestMethod.GET)
    public String getAllTrains(Model model){
        List<TrainDto> trainDtos = service.getAllTrains();
        model.addAttribute("trainList", trainDtos);
        return "trains :: trainsTable";
    }

    @RequestMapping(value = "/stations/all", method = RequestMethod.GET)
    public String getAllStations(Model model){
        List<StationDto> stationDtos = service.getAllStations();
        model.addAttribute("stationList", stationDtos);
        return "trains :: stationsTable";
    }

    @GetMapping("/stationForm")
    public String getStationForm(Model model){
        model.addAttribute("station", new StationDto());
        return "trains :: stationForm";
    }

    @RequestMapping( value = "/station/new", method = RequestMethod.POST)
    public String addNewStation(@ModelAttribute StationDto station){
        try {
            service.addNewStation(station);
        }catch (Exception e){

        }
        return "redirect:/index";
    }

    @RequestMapping(value = "/route/all", method = RequestMethod.GET)
    List<RouteDto> getAllRoutes(){
        List<RouteDto> routeDtos = service.getAllRoutes();
        return routeDtos;
    }
}

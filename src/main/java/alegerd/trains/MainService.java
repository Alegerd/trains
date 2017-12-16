package alegerd.trains;

import alegerd.trains.entities.route.RouteDto;
import alegerd.trains.entities.route.RouteRepo;
import alegerd.trains.entities.route.RoutesEntity;
import alegerd.trains.entities.station.StationDto;
import alegerd.trains.entities.station.StationRepo;
import alegerd.trains.entities.station.StationsEntity;
import alegerd.trains.entities.train.TrainDto;
import alegerd.trains.entities.train.TrainRepo;
import alegerd.trains.entities.train.TrainsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    @Autowired
    private TrainRepo trainRepo;

    @Autowired
    private RouteRepo routeRepo;

    @Autowired
    private StationRepo stationRepo;

    @Transactional
    public List<TrainDto> getAllTrains(){
        List<TrainDto> trainDtos = new ArrayList<>();
        trainRepo.findAll().forEach((trainsEntity -> trainDtos.add(toDto(trainsEntity))));
        return trainDtos;
    }

    @Transactional
    public List<RouteDto> getAllRoutes(){
        List<RouteDto> routeDtos = new ArrayList<>();
        routeRepo.findAll().forEach((routesEntity -> routeDtos.add(toDto(routesEntity))));
        return routeDtos;
    }

    @Transactional
    public List<StationDto> getAllStations(){
        List<StationDto> stationDtos = new ArrayList<>();
        stationRepo.findAll().forEach((stationsEntity -> stationDtos.add(toDto(stationsEntity))));
        return stationDtos;
    }

    @Transactional
    public void addNewTrain(TrainDto trainDto) throws Exception{
        trainRepo.save(toEntity(trainDto));
    }

    @Transactional
    public void addNewStation(StationDto stationDto) throws Exception{
        if(isStationExist(stationDto)) throw new Exception("station with this name already exists");
        stationRepo.save(toEntity(stationDto));
    }

    private boolean isStationExist(StationDto stationDto){
        boolean result = false;
        for (StationsEntity station :
                stationRepo.findAll()) {
            if(station.getName().equals(stationDto.getName())) result = true;
        }
        return result;
    }

    public TrainsEntity toEntity(TrainDto trainDto) throws Exception{
        TrainsEntity trainsEntity = new TrainsEntity(trainDto.getNumber());
        StationsEntity station = stationRepo.findStationsEntityByName(trainDto.getStationName());
        RoutesEntity route = routeRepo.findRoutesEntityByName(trainDto.getRouteName());
        List<StationsEntity> stationList = route.getStations();
        boolean isStationOnRoute = false;
        for (StationsEntity stat :
                stationList) {
            if(station.getName().equals(station.getName())){
                isStationOnRoute = true;
            }
        }
        if (!isStationOnRoute) throw new Exception("No such station on this route");
        trainsEntity.setStation(station);
        trainsEntity.setRoute(route);
        return trainsEntity;
    }

    public StationsEntity toEntity(StationDto stationDto) throws Exception{
        List<TrainsEntity> trains = new ArrayList<>();
        for (TrainDto train:
                stationDto.getTrains()) {
            trains.add(toEntity(train));
        }
        StationsEntity se = new StationsEntity(stationDto.getName());
        se.setTrains(trains);

        RoutesEntity route = routeRepo.findRoutesEntityByName(stationDto.getRouteName());
        se.setRoute(route);
        return se;
    }

    public TrainDto toDto(TrainsEntity trainsEntity){
        String station = trainsEntity.getStation().getName();
        String route = trainsEntity.getRoute().getName();
        return new TrainDto(trainsEntity.getNumber(), route, station);
    }

    public StationDto toDto(StationsEntity stationsEntity){
        List<TrainsEntity> trainsEntities = stationsEntity.getTrains();
        List<TrainDto> trainDtos = new ArrayList<>();
        for (TrainsEntity train :
                trainsEntities) {
            trainDtos.add(toDto(train));
        }
        return new StationDto(stationsEntity.getName(), trainDtos, stationsEntity.getRoute().getName());
    }

    public RouteDto toDto(RoutesEntity routesEntity){
        List<TrainDto> trainDtos = new ArrayList<>();
        List<StationDto> stationDtos = new ArrayList<>();
        for ( StationsEntity stationsEntity:routesEntity.getStations()) {
            stationDtos.add(toDto(stationsEntity));
        }
        for ( TrainsEntity trainsEntity:routesEntity.getTrains()) {
            trainDtos.add(toDto(trainsEntity));
        }
        return new RouteDto(routesEntity.getName(), trainDtos, stationDtos);
    }
}

package alegerd.trains.entities.other;

import alegerd.trains.entities.route.RouteDto;
import alegerd.trains.entities.route.RouteEntity;

public class EntityToDto {

    public static RouteDto getDto(RouteEntity entity){
        return new RouteDto(entity.getId(),
                            entity.getName());
    }
}

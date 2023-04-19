package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.iti.model.dto.ActorDto;
import org.iti.services.ActorServices;

import java.util.List;

@WebService
public class ActorWebServices {

    ActorServices services = new ActorServices();

    public List<ActorDto> getActors(){
        return services.getActors();
    }


    public String createActor(ActorDto actorDto){
        ActorDto newActor = services.addActor(actorDto);
        if (newActor == null)   return "failed";
        return "success";
    }

    public ActorDto getActor(@WebParam(name = "id") int id){
        ActorDto actorDto = services.getActorById(id);
        return actorDto;
    }

    public String updateActor(@WebParam(name = "id") int id,ActorDto actorDto) {
        ActorDto dto = services.updateActor(id,actorDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }

}

package org.iti.services;

import jakarta.ws.rs.POST;
import org.iti.model.dto.ActorDto;
import org.iti.model.entities.Actor;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.Instant;
import java.util.List;


public class ActorServices {

    static RepositoryImpl<Actor> repo = new RepositoryImpl<>(Actor.class);


    public ActorDto addActor(ActorDto actorDto){
        actorDto.setLastUpdate(Instant.now());
        Actor actor = new ModelMapper().map(actorDto,Actor.class);
        if(repo.create(actor) == null){
            return null;
        }
        return actorDto;
    }

    public ActorDto getActorById(int id){
        Actor actor = repo.findById(id);
        if (actor == null) return null;
        return new ModelMapper().map(actor,ActorDto.class);
    }

    public List<ActorDto> getActors(){
        List<Actor> actors = repo.findAll();
        return new ModelMapper().map(actors,new TypeToken<List<ActorDto>>(){}.getType());
    }

    public boolean removeActor(int id){
        Actor actor = repo.findById(id);
        return repo.remove(actor);
    }

    public ActorDto updateActor(int id ,ActorDto actorDto){

        Actor actor = repo.findById(id);
        actor.setFirstName(actorDto.getFirstName());
        actor.setLastName(actorDto.getLastName());
        actor.setLastUpdate(actorDto.getLastUpdate());
        Actor newActor = repo.update(actor);
        return new ModelMapper().map(newActor,ActorDto.class);
    }
}

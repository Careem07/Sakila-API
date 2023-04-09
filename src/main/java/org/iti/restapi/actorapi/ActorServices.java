package org.iti.restapi.actorapi;

import org.iti.dto.ActorDto;
import org.iti.entities.Actor;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;


public class ActorServices {

    static RepositoryImpl<Actor> repo = new RepositoryImpl<>(Actor.class);

    public ActorDto addActor(ActorDto actorDto){

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

    public ActorDto updateActor(ActorDto actorDto){
        Actor actor = repo.update(new ModelMapper().map(actorDto , Actor.class));
        return new ModelMapper().map(actor,ActorDto.class);
    }
}

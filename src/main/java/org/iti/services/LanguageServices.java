package org.iti.services;

import org.iti.model.entities.Language;
import org.iti.model.dto.LanguageDto;
import org.iti.repositories.RepositoryImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.time.Instant;
import java.util.List;

public class LanguageServices {

    RepositoryImpl<Language> repository = new RepositoryImpl<>(Language.class);

    public LanguageDto createLanguage(LanguageDto languageDto){
        languageDto.setLastUpdate(Instant.now());
        Language language = new ModelMapper().map(languageDto,Language.class);
        if(repository.create(language) == null){
            return null;
        }
        return languageDto;
    }

    public LanguageDto getLanguageById(int id){
        Language language = repository.findById(id);
        if (language == null) return null;
        return new ModelMapper().map(language,LanguageDto.class);
    }

    public List<LanguageDto> getLanguages(){
        List<Language> languages = repository.findAll();
        return new ModelMapper().map(languages,new TypeToken<List<LanguageDto>>(){}.getType());
    }

    public boolean removeLanguage(int id){
        Language language = repository.findById(id);
        return repository.remove(language);
    }

    public LanguageDto updateLanguage(int id , LanguageDto languageDto){
        Language language = repository.findById(id);
        language.setName(languageDto.getName());
        Language newLanguage = repository.update(language);
        return new ModelMapper().map(newLanguage, LanguageDto.class);
    }
}

package org.iti.api.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.iti.model.dto.LanguageDto;
import org.iti.services.LanguageServices;

import java.util.List;

@WebService
public class LanguageWs {

    LanguageServices services = new LanguageServices();

    public List<LanguageDto> getLanguages(){
        return services.getLanguages();
    }


    public String createLanguage(LanguageDto languageDto){
        LanguageDto newLanguage = services.createLanguage(languageDto);
        if (newLanguage == null)   return "failed";
        return "success";
    }

    public LanguageDto getLanguage(@WebParam(name = "id") int id){
        LanguageDto inventoryById = services.getLanguageById(id);
        return inventoryById;
    }

    public String updateLanguage(@WebParam(name = "id") int id,LanguageDto languageDto) {
        LanguageDto dto = services.updateLanguage(id,languageDto);
        if(dto == null){
            return "failed to update";
        }
        return "updated";
    }




}

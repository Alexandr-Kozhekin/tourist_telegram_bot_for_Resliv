package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import telegram_bot.core.requests.DeleteCityByNameRequest;
import telegram_bot.core.services.validators.DeleteCityByNameValidator;

import telegram_bot.core.databases.*;
import telegram_bot.core.responses.*;

import java.util.*;

@Component
@Transactional
public class DeleteCityByNameService {

    @Autowired private CityRepository cityRepository;

    @Autowired private DeleteCityByNameValidator validator;

    public DeleteCityByNameResponse execute(DeleteCityByNameRequest request){

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new DeleteCityByNameResponse(errors);
        }

        return new DeleteCityByNameResponse(cityRepository.deleteCityByName(request.getCityName()));
    }
}

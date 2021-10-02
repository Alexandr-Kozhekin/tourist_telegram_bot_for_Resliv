package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import telegram_bot.core.domain.City;
import telegram_bot.core.requests.DeleteCityByNameRequest;
import telegram_bot.core.services.validators.DeleteCityByNameValidator;

import telegram_bot.core.databases.*;
import telegram_bot.core.responses.*;

import java.util.*;

@Component
@Transactional
public class DeleteCityByNameService {

    @Autowired private CityRepository cityRepository;

    @Autowired private InfoRepository infoRepository;

    @Autowired private DeleteCityByNameValidator validator;

    public DeleteCityByNameResponse execute(DeleteCityByNameRequest request){

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new DeleteCityByNameResponse(errors);
        }

        Optional<City> city = cityRepository.fiendCityByName(request.getCityName());

        if(city.isPresent()){

            infoRepository.deleteAllInfoAboutCity(city.get().getCityId());

            return new DeleteCityByNameResponse(cityRepository.deleteCityByName(request.getCityName()));

        } else {

            return new DeleteCityByNameResponse(false);
        }
    }
}

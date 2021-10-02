package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import telegram_bot.core.domain.City;
import telegram_bot.core.requests.DeleteInfoAboutCityRequest;
import telegram_bot.core.services.validators.DeleteInfoAboutCityValidator;

import telegram_bot.core.databases.*;
import telegram_bot.core.responses.*;

import java.util.*;

@Component
@Transactional
public class DeleteInfoAboutCityService {

    @Autowired private CityRepository cityRepository;

    @Autowired private InfoRepository infoRepository;

    @Autowired private DeleteInfoAboutCityValidator validator;

    public DeleteInfoAboutCityResponse execute(DeleteInfoAboutCityRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new DeleteInfoAboutCityResponse(errors);
        }

        Optional <City> city = cityRepository.fiendCityByName(request.getCityName());

        return city.map(value -> new DeleteInfoAboutCityResponse(infoRepository
                .deleteInfoAboutCity(value.getCityId(), request.getInfoId())))
                .orElseGet(() -> new DeleteInfoAboutCityResponse(false));
    }
}

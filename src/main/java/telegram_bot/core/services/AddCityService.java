package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.requests.AddCityRequest;
import telegram_bot.core.services.validators.AddCityValidator;

import telegram_bot.core.responses.*;

import java.util.List;

@Component
@Transactional
public class AddCityService {

    @Autowired private CityRepository cityRepository;

    @Autowired private AddCityValidator validator;

    public AddCityResponse execute(AddCityRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new AddCityResponse(errors);
        }

        City city = new City(request.getName());

        cityRepository.addCity(new City(request.getName()));

        return new AddCityResponse(city);
    }
}

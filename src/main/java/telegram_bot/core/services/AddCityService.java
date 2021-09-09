package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.requests.AddCityRequest;
import telegram_bot.core.responses.AddCityResponse;

@Component
@Transactional
public class AddCityService {

    @Autowired private CityRepository cityRepository;

    public AddCityResponse execute(AddCityRequest request) {

        City city = new City(request.getName());

        cityRepository.addCity(city);

        return new AddCityResponse(city);
    }
}

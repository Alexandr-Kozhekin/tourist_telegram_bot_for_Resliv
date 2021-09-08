package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityDatabaseImpl;
import telegram_bot.core.domain.City;
import telegram_bot.core.requests.AddCityRequest;
import telegram_bot.core.responses.AddCityResponse;

@Component
@Transactional
public class AddCityService {

    @Autowired private CityDatabaseImpl cityDatabase;

    public AddCityResponse execute(AddCityRequest request) {

        City city = new City(request.getName());

        cityDatabase.addCity(city);

        return new AddCityResponse(city);
    }
}

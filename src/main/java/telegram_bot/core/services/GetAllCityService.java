package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.responses.GetAllCityResponse;

import java.util.List;

@Component
@Transactional
public class GetAllCityService {

    @Autowired CityRepository cityRepository;

    public GetAllCityResponse execute() {

        List<City> city = cityRepository.getAllCity();

        return new GetAllCityResponse(city);
    }

}

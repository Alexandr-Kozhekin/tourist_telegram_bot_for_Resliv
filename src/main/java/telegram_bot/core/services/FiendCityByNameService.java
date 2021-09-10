package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.requests.FiendCityByNameRequest;
import telegram_bot.core.responses.FiendCityByNameResponse;

import java.util.Optional;

@Component
@Transactional
public class FiendCityByNameService {

    @Autowired private CityRepository cityRepository;

    public FiendCityByNameResponse execute(FiendCityByNameRequest request){

        Optional<City> city = cityRepository.fiendCityByName(request.getCityName());

        return new FiendCityByNameResponse(city.get());
    }
}

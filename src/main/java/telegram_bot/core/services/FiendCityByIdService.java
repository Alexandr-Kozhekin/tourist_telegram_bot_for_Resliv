package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.requests.FiendCityByIdRequest;
import telegram_bot.core.responses.FiendCityByIdResponse;

import java.util.Optional;

@Component
@Transactional
public class FiendCityByIdService {

    @Autowired private CityRepository cityRepository;

    public FiendCityByIdResponse execute(FiendCityByIdRequest request){

        Optional<City> city = cityRepository.fiendCityById(request.getCityId());

        return new FiendCityByIdResponse(city.get());
    }
}

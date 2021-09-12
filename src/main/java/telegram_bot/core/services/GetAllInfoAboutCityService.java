package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.requests.GetAllInfoAboutCityRequest;
import telegram_bot.core.responses.GetAllInfoAboutCityResponse;

import java.util.Optional;

@Component
@Transactional
public class GetAllInfoAboutCityService {

    @Autowired private InfoRepository infoRepository;

    @Autowired private CityRepository cityRepository;

    public GetAllInfoAboutCityResponse execute(GetAllInfoAboutCityRequest request) {

        Optional<City> city = cityRepository.fiendCityByName(request.getCityName());

        return new GetAllInfoAboutCityResponse(infoRepository.getAllInfoAboutCity(city.get().getCityId()));
    }
}

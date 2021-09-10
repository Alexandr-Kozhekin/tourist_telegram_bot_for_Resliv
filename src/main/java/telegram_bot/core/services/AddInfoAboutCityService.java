package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.domain.Info;
import telegram_bot.core.requests.AddInfoAboutCityRequest;
import telegram_bot.core.responses.AddInfoAboutCityResponse;

import java.util.Optional;

@Component
@Transactional
public class AddInfoAboutCityService {

    @Autowired CityRepository cityRepository;

    @Autowired InfoRepository infoRepository;

    public AddInfoAboutCityResponse execute(AddInfoAboutCityRequest request) {

        Optional<City> city = cityRepository.fiendCityByName(request.getCityName());

        city.ifPresent(value -> infoRepository.addInfoAboutCity(value, request.getCityInfo()));

        Info info = new Info(request.getCityInfo());

        return new AddInfoAboutCityResponse(info);
    }

}

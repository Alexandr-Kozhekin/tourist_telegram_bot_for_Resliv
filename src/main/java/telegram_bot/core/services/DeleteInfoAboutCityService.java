package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.requests.DeleteInfoAboutCityRequest;
import telegram_bot.core.responses.DeleteInfoAboutCityResponse;

import java.util.Optional;

@Component
@Transactional
public class DeleteInfoAboutCityService {

    @Autowired InfoRepository infoRepository;

    @Autowired CityRepository cityRepository;

    public DeleteInfoAboutCityResponse execute(DeleteInfoAboutCityRequest request) {

        boolean deleted = false;

        Optional<City> city = cityRepository.fiendCityByName(request.getCityName());

        if(city.isPresent()) {
            deleted = infoRepository.deleteInfoAboutCity(request.getInfoId(), city.get().getCityId());
        }

        return new DeleteInfoAboutCityResponse(deleted);
    }
}

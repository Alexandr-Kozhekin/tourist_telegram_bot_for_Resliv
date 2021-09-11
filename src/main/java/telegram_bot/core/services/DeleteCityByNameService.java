package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.requests.DeleteCityByNameRequest;
import telegram_bot.core.responses.DeleteCityByNameResponse;

import java.util.Optional;

@Component
@Transactional
public class DeleteCityByNameService {

    @Autowired private CityRepository cityRepository;

    @Autowired private InfoRepository infoRepository;

    public DeleteCityByNameResponse execute(DeleteCityByNameRequest request){

        Optional<City> city = cityRepository.fiendCityByName(request.getCityName());

        infoRepository.deleteAllInfoAboutCity(city.get().getCityId());

        boolean deleted = cityRepository.deleteCityByName(request.getCityName());

        return new DeleteCityByNameResponse(deleted);
    }
}

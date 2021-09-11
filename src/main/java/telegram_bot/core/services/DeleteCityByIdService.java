package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.requests.DeleteCityByIdRequest;
import telegram_bot.core.responses.DeleteCityByIdResponse;


@Component
@Transactional
public class DeleteCityByIdService {

    @Autowired private CityRepository cityRepository;

    @Autowired private InfoRepository infoRepository;

    public DeleteCityByIdResponse execute(DeleteCityByIdRequest request){

        infoRepository.deleteAllInfoAboutCity(request.getId());

        boolean deleted = cityRepository.deleteCityById(request.getId());

        return new DeleteCityByIdResponse(deleted);
    }
}

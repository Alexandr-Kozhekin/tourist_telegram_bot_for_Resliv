package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.requests.DeleteCityByIdRequest;
import telegram_bot.core.responses.DeleteCityByIdResponse;


@Component
@Transactional
public class DeleteCityByIdService {

    @Autowired CityRepository cityRepository;

    public DeleteCityByIdResponse execute(DeleteCityByIdRequest request){

        boolean deleted = cityRepository.deleteCityById(request.getId());

        return new DeleteCityByIdResponse(deleted);
    }
}

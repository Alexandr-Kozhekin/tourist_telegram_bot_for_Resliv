package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.requests.DeleteCityByNameRequest;
import telegram_bot.core.responses.DeleteCityByNameResponse;

@Component
@Transactional
public class DeleteCityByNameService {

    @Autowired CityRepository cityRepository;

    public DeleteCityByNameResponse execute(DeleteCityByNameRequest request){

        boolean deleted = cityRepository.deleteCityByName(request.getCity_name());

        return new DeleteCityByNameResponse(deleted);
    }
}

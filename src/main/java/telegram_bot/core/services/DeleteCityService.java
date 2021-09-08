package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.CityDatabaseImpl;
import telegram_bot.core.requests.DeleteCityRequest;
import telegram_bot.core.responses.DeleteCityResponse;


@Component
@Transactional
public class DeleteCityService {

    @Autowired CityDatabaseImpl cityDatabase;

    public DeleteCityResponse execute(DeleteCityRequest request){

        boolean deleted = cityDatabase.deleteCity(request.getId());

        return new DeleteCityResponse(deleted);
    }
}

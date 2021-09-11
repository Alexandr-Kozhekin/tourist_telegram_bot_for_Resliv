package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.requests.DeleteAllInfoAboutCityRequest;
import telegram_bot.core.responses.DeleteAllInfoAboutCityResponse;

@Component
@Transactional
public class DeleteAllInfoAboutCityService {

    @Autowired private InfoRepository infoRepository;

    public DeleteAllInfoAboutCityResponse execute(DeleteAllInfoAboutCityRequest request) {

        boolean deleted = infoRepository.deleteAllInfoAboutCity(request.getCityId());

        return new DeleteAllInfoAboutCityResponse(deleted);
    }
}

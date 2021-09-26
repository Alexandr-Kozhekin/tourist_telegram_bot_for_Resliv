package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.requests.DeleteAllInfoAboutCityRequest;
import telegram_bot.core.services.validators.DeleteAllInfoAboutCityValidator;

import telegram_bot.core.responses.*;

import java.util.List;

@Component
@Transactional
public class DeleteAllInfoAboutCityService {

    @Autowired private InfoRepository infoRepository;

    @Autowired private DeleteAllInfoAboutCityValidator validator;

    public DeleteAllInfoAboutCityResponse execute(DeleteAllInfoAboutCityRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new DeleteAllInfoAboutCityResponse(errors);
        }

        boolean deleted = infoRepository.deleteAllInfoAboutCity(request.getCityId());

        return new DeleteAllInfoAboutCityResponse(deleted);
    }
}

package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.requests.AddInfoAboutCityRequest;
import telegram_bot.core.services.validators.AddInfoAboutCityValidator;

import telegram_bot.core.responses.*;

import java.util.List;

@Component
@Transactional
public class AddInfoAboutCityService {

    @Autowired private InfoRepository infoRepository;

    @Autowired private AddInfoAboutCityValidator validator;

    public AddInfoAboutCityResponse execute(AddInfoAboutCityRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new AddInfoAboutCityResponse(errors);
        }

        infoRepository.addInfoAboutCity(request.getCityId(), request.getInfo());

        return new AddInfoAboutCityResponse(request.getInfo());
    }
}

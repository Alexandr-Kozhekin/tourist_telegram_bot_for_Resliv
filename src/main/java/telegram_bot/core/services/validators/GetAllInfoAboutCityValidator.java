package telegram_bot.core.services.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telegram_bot.core.requests.GetAllInfoAboutCityRequest;
import telegram_bot.core.responses.CoreError;

import telegram_bot.core.databases.*;

import java.util.*;

@Component
public class GetAllInfoAboutCityValidator {

    @Autowired private InfoRepository infoRepository;

    public CoreError validate(GetAllInfoAboutCityRequest request) {

        return validateInfoInDatabases(request).get();
    }

    public Optional<CoreError> validateInfoInDatabases(GetAllInfoAboutCityRequest request) {

        if (infoRepository.getAllInfoAboutCity(request.getCityName()).stream()
                .findFirst()
                .isEmpty()) {

            return Optional.of(new CoreError("info", "Not found!"));
        } else {
            return Optional.empty();
        }
    }
}

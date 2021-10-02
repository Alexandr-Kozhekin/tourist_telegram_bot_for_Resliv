package telegram_bot.core.services.validators;

import org.springframework.beans.factory.annotation.Autowired;

import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.requests.GetAllInfoAboutCityRequest;
import telegram_bot.core.responses.CoreError;

import java.util.*;

public class GetAllInfoAboutCityValidator {

    @Autowired private InfoRepository repository;

    public CoreError validate(GetAllInfoAboutCityRequest request) {

        return validateInfoInDatabases(request).isPresent() ?
                validateInfoInDatabases(request).get() : validateInfoInDatabases(request).orElseThrow();
    }

    public Optional<CoreError> validateInfoInDatabases(GetAllInfoAboutCityRequest request) {
        if (repository.getAllInfoAboutCity(request.getCityName()).stream().findFirst().isEmpty()) {

            return Optional.of(new CoreError("info", "Not found!"));
        } else {
            return Optional.empty();
        }
    }
}

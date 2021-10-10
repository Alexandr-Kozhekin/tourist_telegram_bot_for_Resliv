package telegram_bot.core.services.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.requests.DeleteCityByNameRequest;
import telegram_bot.core.responses.CoreError;

import java.util.*;

@Component
public class DeleteCityByNameValidator {

    @Autowired private CityRepository repository;

    public List<CoreError> validate(DeleteCityByNameRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateInputCityName(request).ifPresent(errors::add);
        validateCityInDatabases(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateInputCityName(DeleteCityByNameRequest request) {
        return (request.getCityName() == null || request.getCityName().isEmpty())
                ? Optional.of(new CoreError("city name", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateCityInDatabases(DeleteCityByNameRequest request) {
        if (repository.getAllCity().stream()
                .filter(city -> city.getCityName().equals(request.getCityName())).findFirst().isEmpty()) {

            return Optional.of(new CoreError("city", "Not found!"));
        } else {
            return Optional.empty();
        }
    }
}

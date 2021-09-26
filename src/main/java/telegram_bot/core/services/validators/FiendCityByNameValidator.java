package telegram_bot.core.services.validators;

import org.springframework.beans.factory.annotation.Autowired;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.requests.FiendCityByNameRequest;
import telegram_bot.core.responses.CoreError;

import java.util.*;

public class FiendCityByNameValidator {

    @Autowired private CityRepository repository;

    public List<CoreError> validate(FiendCityByNameRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateInputCityName(request).ifPresent(errors::add);
        validateCityInDatabases(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateInputCityName(FiendCityByNameRequest request) {
        return (request.getCityName() == null || request.getCityName().isEmpty())
                ? Optional.of(new CoreError("city name", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateCityInDatabases(FiendCityByNameRequest request) {
        if (repository.getAllCity().stream()
                .filter(city -> city.getCityName().equals(request.getCityName())).findFirst().isEmpty()) {

            return Optional.of(new CoreError("city", "Not found!"));
        } else {
            return Optional.empty();
        }
    }
}

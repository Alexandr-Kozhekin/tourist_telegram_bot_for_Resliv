package telegram_bot.core.services.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.requests.FiendCityByIdRequest;
import telegram_bot.core.responses.CoreError;

import java.util.*;

@Component
public class FiendCityByIdValidator {

    @Autowired private CityRepository repository;

    public List<CoreError> validate(FiendCityByIdRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateInputCityId(request).ifPresent(errors::add);
        validateCityInDatabases(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateInputCityId(FiendCityByIdRequest request) {
        return (request.getCityId() == null || request.getCityId() <= 0L)
                ? Optional.of(new CoreError("city id", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateCityInDatabases(FiendCityByIdRequest request) {
        if (repository.getAllCity().stream()
                .filter(city -> city.getCityId().equals(request.getCityId()))
                .findFirst()
                .isEmpty()) {

            return Optional.of(new CoreError("city", "Not found!"));
        } else {
            return Optional.empty();
        }
    }
}

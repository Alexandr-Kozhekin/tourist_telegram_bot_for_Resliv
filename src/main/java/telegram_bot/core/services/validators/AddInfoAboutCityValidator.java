package telegram_bot.core.services.validators;

import org.springframework.beans.factory.annotation.Autowired;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.requests.AddInfoAboutCityRequest;
import telegram_bot.core.responses.CoreError;

import java.util.*;

public class AddInfoAboutCityValidator {

    @Autowired private CityRepository repository;

    public List<CoreError> validate(AddInfoAboutCityRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateInfo(request).ifPresent(errors::add);
        validateInputCityId(request).ifPresent(errors::add);
        validateCityInDatabases(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateInfo(AddInfoAboutCityRequest request) {
        return (request.getInfo() == null)
                ? Optional.of(new CoreError("info", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateInputCityId(AddInfoAboutCityRequest request) {
        return (request.getCityId() == null)
                ? Optional.of(new CoreError("city id", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateCityInDatabases(AddInfoAboutCityRequest request) {
        if (repository.getAllCity().stream()
                .filter(city -> city.getCityId().equals(request.getCityId())).findFirst().isEmpty()) {

            return Optional.of(new CoreError("city", "Not found!"));
        } else {
            return Optional.empty();
        }
    }
}

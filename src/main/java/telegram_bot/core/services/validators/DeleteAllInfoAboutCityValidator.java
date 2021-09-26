package telegram_bot.core.services.validators;

import org.springframework.beans.factory.annotation.Autowired;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.requests.DeleteAllInfoAboutCityRequest;
import telegram_bot.core.responses.CoreError;

import java.util.*;

public class DeleteAllInfoAboutCityValidator {

    @Autowired private CityRepository repository;

    public List<CoreError> validate(DeleteAllInfoAboutCityRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateInputCityId(request).ifPresent(errors::add);
        validateCityInDatabases(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateInputCityId(DeleteAllInfoAboutCityRequest request) {
        return (request.getCityId() == null)
                ? Optional.of(new CoreError("city id", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateCityInDatabases(DeleteAllInfoAboutCityRequest request) {
        if (repository.getAllCity().stream()
                .filter(city -> city.getCityId().equals(request.getCityId())).findFirst().isEmpty()) {

            return Optional.of(new CoreError("city", "Not found!"));
        } else {
            return Optional.empty();
        }
    }
}

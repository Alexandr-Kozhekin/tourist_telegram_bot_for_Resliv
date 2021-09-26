package telegram_bot.core.services.validators;

import org.springframework.beans.factory.annotation.Autowired;
import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.requests.DeleteInfoAboutCityRequest;
import telegram_bot.core.responses.CoreError;

import java.util.*;

public class DeleteInfoAboutCityValidator {

    @Autowired private CityRepository repository;

    public List<CoreError> validate(DeleteInfoAboutCityRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateInputInfoId(request).ifPresent(errors::add);
        validateInputCityName(request).ifPresent(errors::add);
        validateCityInDatabases(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateInputInfoId(DeleteInfoAboutCityRequest request) {
        return (request.getInfoId() == null)
                ? Optional.of(new CoreError("info id", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateInputCityName(DeleteInfoAboutCityRequest request) {
        return (request.getCityName() == null || request.getCityName().isEmpty())
                ? Optional.of(new CoreError("city name", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateCityInDatabases(DeleteInfoAboutCityRequest request) {
        if (repository.getAllCity().stream()
                .filter(city -> city.getCityName().equals(request.getCityName())).findFirst().isEmpty()) {

            return Optional.of(new CoreError("city", "Not found!"));
        } else {
            return Optional.empty();
        }
    }
}

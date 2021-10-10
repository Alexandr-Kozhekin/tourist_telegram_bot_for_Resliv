package telegram_bot.core.services.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.requests.DeleteInfoAboutCityRequest;
import telegram_bot.core.responses.CoreError;

import java.util.*;

@Component
public class DeleteInfoAboutCityValidator {

    @Autowired private CityRepository cityRepository;

    public List<CoreError> validate(DeleteInfoAboutCityRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateInputInfoId(request).ifPresent(errors::add);
        validateInputCityName(request).ifPresent(errors::add);
        validateCityInDatabases(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateInputInfoId(DeleteInfoAboutCityRequest request) {
        return (request.getInfoId() == null || request.getCityId() <= 0L)
                ? Optional.of(new CoreError("info id", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateInputCityName(DeleteInfoAboutCityRequest request) {
        return (request.getCityId() == null || request.getCityId() <= 0L)
                ? Optional.of(new CoreError("city id", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateCityInDatabases(DeleteInfoAboutCityRequest request) {
        if (cityRepository.getAllCity().stream()
                .filter(city -> city.getCityId().equals(request.getCityId()))
                .findFirst()
                .isEmpty()) {

            return Optional.of(new CoreError("city", "Not found!"));
        } else {
            return Optional.empty();
        }
    }
}

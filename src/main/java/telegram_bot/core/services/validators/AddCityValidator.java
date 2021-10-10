package telegram_bot.core.services.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.requests.AddCityRequest;
import telegram_bot.core.responses.CoreError;

import java.util.*;

@Component
public class AddCityValidator {

    @Autowired private CityRepository repository;

    public List<CoreError> validate(AddCityRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateInputName(request).ifPresent(errors::add);
        checkCityInDatabase(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateInputName(AddCityRequest request) {
        return (request.getName() == null || request.getName().isEmpty())
                ? Optional.of(new CoreError("name", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> checkCityInDatabase(AddCityRequest request) {
        if(repository.getAllCity().stream()
                .anyMatch(city -> city.getCityName().equals(request.getName()))) {

            return Optional.of(new CoreError("city", "Such a city has already been added!"));
        } else {
            return Optional.empty();
        }
    }
}

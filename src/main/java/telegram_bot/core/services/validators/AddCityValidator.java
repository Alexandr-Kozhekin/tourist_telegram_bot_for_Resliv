package telegram_bot.core.services.validators;

import telegram_bot.core.requests.AddCityRequest;
import telegram_bot.core.responses.CoreError;

import java.util.*;

public class AddCityValidator {

    public List<CoreError> validate(AddCityRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateInputName(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateInputName(AddCityRequest request) {
        return (request.getName() == null || request.getName().isEmpty())
                ? Optional.of(new CoreError("name", "Must not be empty!"))
                : Optional.empty();
    }
}

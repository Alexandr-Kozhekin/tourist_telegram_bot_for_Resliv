package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import telegram_bot.core.requests.DeleteCityByIdRequest;
import telegram_bot.core.services.validators.DeleteCityByIdValidator;

import telegram_bot.core.databases.*;
import telegram_bot.core.responses.*;

import java.util.List;


@Component
@Transactional
public class DeleteCityByIdService {

    @Autowired private CityRepository cityRepository;

    @Autowired private DeleteCityByIdValidator validator;

    public DeleteCityByIdResponse execute(DeleteCityByIdRequest request){

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new DeleteCityByIdResponse(errors);
        }

        return new DeleteCityByIdResponse(cityRepository.deleteCityById(request.getId()));
    }
}

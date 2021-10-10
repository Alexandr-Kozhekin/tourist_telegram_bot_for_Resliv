package telegram_bot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import telegram_bot.core.databases.*;

import telegram_bot.core.requests.GetAllInfoAboutCityRequest;
import telegram_bot.core.services.validators.GetAllInfoAboutCityValidator;

import telegram_bot.core.responses.*;

@Component
@Transactional
public class GetAllInfoAboutCityService {

    @Autowired private InfoRepository infoRepository;

    @Autowired private GetAllInfoAboutCityValidator validator;

    public GetAllInfoAboutCityResponse execute(GetAllInfoAboutCityRequest request) {

        return new GetAllInfoAboutCityResponse(infoRepository.getAllInfoAboutCity(request.getCityName()));
    }
}

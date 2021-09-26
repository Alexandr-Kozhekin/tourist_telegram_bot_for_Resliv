package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.domain.Info;
import telegram_bot.core.requests.AddInfoAboutCityRequest;
import telegram_bot.core.responses.AddInfoAboutCityResponse;
import telegram_bot.core.services.AddInfoAboutCityService;
import telegram_bot.core.services.validators.AddInfoAboutCityValidator;

@RunWith(MockitoJUnitRunner.class)
public class AddInfoAboutCityServiceTest {

    @Mock private InfoRepository repository;

    @Mock private AddInfoAboutCityValidator validator;

    @InjectMocks private AddInfoAboutCityService service;

    @Test
    public void shouldInteractWithDBInCaseOfAllValidEntries() {

        AddInfoAboutCityRequest request = new AddInfoAboutCityRequest(1L, new Info("test test test"));

        AddInfoAboutCityResponse response = service.execute(request);

        Mockito.verify(repository).addInfoAboutCity(request.getCityId(), request.getInfo());
    }
}

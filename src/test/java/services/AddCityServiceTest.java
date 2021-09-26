package services;

import static org.mockito.ArgumentMatchers.argThat;

import matchers.CityMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.requests.AddCityRequest;
import telegram_bot.core.responses.AddCityResponse;
import telegram_bot.core.services.AddCityService;
import telegram_bot.core.services.validators.AddCityValidator;

@RunWith(MockitoJUnitRunner.class)
public class AddCityServiceTest {

    @Mock private CityRepository repository;

    @Mock private AddCityValidator validator;

    @InjectMocks private AddCityService service;

    @Test
    public void shouldInteractWithDBInCaseOfAllValidEntries() {

        AddCityRequest request = new AddCityRequest("Minsk");

        AddCityResponse response = service.execute(request);

        Mockito.verify(repository).addCity(argThat(new CityMatchers("Minsk")));
    }
}

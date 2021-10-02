package services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;

import matchers.CityMatchers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import org.mockito.*;

import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.requests.AddCityRequest;
import telegram_bot.core.services.AddCityService;
import telegram_bot.core.services.validators.AddCityValidator;

import telegram_bot.core.responses.*;

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

        assertThat(response.hasErrors()).isFalse();
        assertThat(response.getCity()).isEqualTo(new City("Minsk"));
    }

    @Test
    public void shouldReturnErrorWhenNameNull() {

        AddCityRequest request = new AddCityRequest(null);

        List<CoreError> expected = new ArrayList<>() {{
            add(new CoreError("name", "Must not be empty!"));
        }};

        Mockito.when(validator.validate(request)).thenReturn(expected);

        AddCityResponse response = service.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);

        Mockito.verifyNoInteractions(repository);
    }
}

package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.*;

import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.requests.FiendCityByNameRequest;
import telegram_bot.core.services.FiendCityByNameService;
import telegram_bot.core.services.validators.FiendCityByNameValidator;

import telegram_bot.core.responses.*;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FiendCityByNameTest {

    @Mock
    private CityRepository repository;

    @Mock private FiendCityByNameValidator validator;

    @InjectMocks private FiendCityByNameService service;

    @Test
    public void shouldInteractWithDBInCaseOfAllValidEntries() {

        Optional<City> city = Optional.of(new City("Test"));

        FiendCityByNameRequest request = new FiendCityByNameRequest("Test");

        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of());

        Mockito.lenient().when(repository.fiendCityByName("Test")).thenReturn(city);

        FiendCityByNameResponse response = service.execute(request);

        assertThat(response.hasErrors()).isFalse();
        assertEquals(response.getCity().getCityName(), "Test");
    }

    @Test
    public void shouldReturnErrorWhenCityIdNull() {

        FiendCityByNameRequest request = new FiendCityByNameRequest("Test");

        List<CoreError> expected = List.of(
                new CoreError("city name", "Must not be empty!"));

        Mockito.when(validator.validate(request)).thenReturn(expected);

        FiendCityByNameResponse response = service.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);

        Mockito.verifyNoInteractions(repository);
    }
}

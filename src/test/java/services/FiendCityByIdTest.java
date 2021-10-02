package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.*;

import telegram_bot.core.databases.CityRepository;
import telegram_bot.core.domain.City;
import telegram_bot.core.requests.FiendCityByIdRequest;
import telegram_bot.core.services.FiendCityByIdService;
import telegram_bot.core.services.validators.FiendCityByIdValidator;

import telegram_bot.core.responses.*;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FiendCityByIdTest {

    @Mock private CityRepository repository;

    @Mock private FiendCityByIdValidator validator;

    @InjectMocks private FiendCityByIdService service;

    @Test
    public void shouldInteractWithDBInCaseOfAllValidEntries() {

        Optional <City> city = Optional.of(new City("Test"));

        FiendCityByIdRequest request = new FiendCityByIdRequest(0L);

        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of());

        Mockito.lenient().when(repository.fiendCityById(0L)).thenReturn(city);

        FiendCityByIdResponse response = service.execute(request);

        assertThat(response.hasErrors()).isFalse();
        assertEquals(response.getCity().getCityName(), "Test");
    }

    @Test
    public void shouldReturnErrorWhenCityIdNull() {

        FiendCityByIdRequest request = new FiendCityByIdRequest(0L);

        List<CoreError> expected = List.of(
                new CoreError("city id", "Must not be empty!"));

        Mockito.when(validator.validate(request)).thenReturn(expected);

        FiendCityByIdResponse response = service.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);

        Mockito.verifyNoInteractions(repository);
    }
}

package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.*;

import telegram_bot.core.domain.City;
import telegram_bot.core.requests.DeleteCityByNameRequest;
import telegram_bot.core.services.DeleteCityByNameService;
import telegram_bot.core.services.validators.DeleteCityByNameValidator;

import telegram_bot.core.databases.*;
import telegram_bot.core.responses.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DeleteCityByNameTest {

    @Mock private CityRepository cityRepository;

    @Mock private InfoRepository infoRepository;

    @Mock private DeleteCityByNameValidator validator;

    @InjectMocks private DeleteCityByNameService service;

    @Test
    public void shouldInteractWithDBInCaseOfAllValidEntries() {

        City city = new City("Test");

        DeleteCityByNameRequest request = new DeleteCityByNameRequest("Test");

        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of());

        Mockito.lenient().when(cityRepository.deleteCityByName("Test")).thenReturn(true);

        DeleteCityByNameResponse response = service.execute(request);

        assertThat(response.hasErrors()).isFalse();
    }

    @Test
    public void shouldReturnErrorWhenCityIdNull() {

        DeleteCityByNameRequest request = new DeleteCityByNameRequest(null);

        List<CoreError> expected = List.of(
                new CoreError("city name", "Must not be empty!"));

        Mockito.when(validator.validate(request)).thenReturn(expected);

        DeleteCityByNameResponse response = service.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);

        Mockito.verifyNoInteractions(cityRepository);
    }
}

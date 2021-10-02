package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.*;

import telegram_bot.core.domain.City;
import telegram_bot.core.requests.DeleteCityByIdRequest;
import telegram_bot.core.services.DeleteCityByIdService;
import telegram_bot.core.services.validators.DeleteCityByIdValidator;

import telegram_bot.core.databases.*;
import telegram_bot.core.responses.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DeleteCityByIdTest {

    @Mock private CityRepository cityRepository;

    @Mock private InfoRepository infoRepository;

    @Mock private DeleteCityByIdValidator validator;

    @InjectMocks private DeleteCityByIdService service;

    @Test
    public void shouldInteractWithDBInCaseOfAllValidEntries() {

        City city = new City("Test");

        DeleteCityByIdRequest request = new DeleteCityByIdRequest(1L);

        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of());

        Mockito.lenient().when(infoRepository.deleteAllInfoAboutCity(0L)).thenReturn(true);

        DeleteCityByIdResponse response = service.execute(request);

        assertThat(response.hasErrors()).isFalse();
    }

    @Test
    public void shouldReturnErrorWhenCityIdNull() {

        DeleteCityByIdRequest request = new DeleteCityByIdRequest(null);

        List<CoreError> expected = List.of(
                new CoreError("city id", "Must not be empty!"));

        Mockito.when(validator.validate(request)).thenReturn(expected);

        DeleteCityByIdResponse response = service.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);

        Mockito.verifyNoInteractions(cityRepository);
    }
}

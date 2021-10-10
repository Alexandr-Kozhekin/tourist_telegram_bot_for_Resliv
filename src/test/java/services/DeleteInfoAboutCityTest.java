package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.*;

import telegram_bot.core.requests.DeleteInfoAboutCityRequest;
import telegram_bot.core.services.DeleteInfoAboutCityService;
import telegram_bot.core.services.validators.DeleteInfoAboutCityValidator;

import telegram_bot.core.domain.*;
import telegram_bot.core.databases.*;
import telegram_bot.core.responses.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DeleteInfoAboutCityTest {

    @Mock private InfoRepository infoRepository;

    @Mock private DeleteInfoAboutCityValidator validator;

    @InjectMocks private DeleteInfoAboutCityService service;

    @Test
    public void shouldInteractWithDBInCaseOfAllValidEntries() {

        City city = new City("Test");

        Set<Info> infoSet = new HashSet<>();
        infoSet.add(new Info("Test"));
        infoSet.add(new Info("Test Test"));
        infoSet.add(new Info("Test Test Test"));

        city.setCityInfo(infoSet);

        DeleteInfoAboutCityRequest request = new DeleteInfoAboutCityRequest(0L, 0L);

        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of());

        Mockito.lenient().when(infoRepository.deleteInfoAboutCity(0L, 0L)).thenReturn(true);
        Mockito.lenient().when(infoRepository.deleteInfoAboutCity(0L, 1L)).thenReturn(true);
        Mockito.lenient().when(infoRepository.deleteInfoAboutCity(0L, 2L)).thenReturn(true);

        DeleteInfoAboutCityResponse response = service.execute(request);

        assertThat(response.hasErrors()).isFalse();
    }

    @Test
    public void shouldReturnErrorWhenCityNameNull() {

        DeleteInfoAboutCityRequest request = new DeleteInfoAboutCityRequest(null, 1L);

        List<CoreError> expected = List.of(
                new CoreError("city id", "Must not be empty!"));

        Mockito.when(validator.validate(request)).thenReturn(expected);

        DeleteInfoAboutCityResponse response = service.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);
    }

    @Test
    public void shouldReturnErrorWhenAllFieldNull() {

        DeleteInfoAboutCityRequest request = new DeleteInfoAboutCityRequest(null, null);

        List<CoreError> expected = List.of(
                new CoreError("city id", "Must not be empty!"),
                new CoreError("info id", "Must not be empty!"));

        Mockito.when(validator.validate(request)).thenReturn(expected);

        DeleteInfoAboutCityResponse response = service.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 2).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);
    }
}

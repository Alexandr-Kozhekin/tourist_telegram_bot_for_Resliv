package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.*;

import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.requests.DeleteAllInfoAboutCityRequest;
import telegram_bot.core.services.DeleteAllInfoAboutCityService;
import telegram_bot.core.services.validators.DeleteAllInfoAboutCityValidator;

import telegram_bot.core.domain.*;
import telegram_bot.core.responses.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DeleteAllInfoAboutCityTest {

    @Mock private InfoRepository repository;

    @Mock private DeleteAllInfoAboutCityValidator validator;

    @InjectMocks private DeleteAllInfoAboutCityService service;

    @Test
    public void shouldInteractWithDBInCaseOfAllValidEntries() {

        City city = new City("Test");;

        Set<Info> infoSet = new HashSet<>();
        infoSet.add(new Info("Test"));
        infoSet.add(new Info("Test Test"));
        infoSet.add(new Info("Test Test Test"));

        city.setCityInfo(infoSet);

        DeleteAllInfoAboutCityRequest request = new DeleteAllInfoAboutCityRequest(1L);

        Mockito.lenient().when(validator.validate(request)).thenReturn(List.of());

        Mockito.lenient().when(repository.deleteAllInfoAboutCity(0L)).thenReturn(true);

        DeleteAllInfoAboutCityResponse response = service.execute(request);

        assertThat(response.hasErrors()).isFalse();
    }

    @Test
    public void shouldReturnErrorWhenCityIdNull() {

        DeleteAllInfoAboutCityRequest request = new DeleteAllInfoAboutCityRequest(1L);

        List<CoreError> expected = List.of(
                new CoreError("city id", "Must not be empty!"));

        Mockito.when(validator.validate(request)).thenReturn(expected);

        DeleteAllInfoAboutCityResponse response = service.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);

        Mockito.verifyNoInteractions(repository);
    }
}
